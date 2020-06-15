/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import GUI.thongbao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ADMIN
 */
public class BLL_LoaiKH {

    public static void DoDuLieuBang(JTable tbl) {
        DefaultTableModel tblModel = (DefaultTableModel) tbl.getModel();
        tblModel.setRowCount(0);
        Object obj[] = new Object[4];
        ResultSet rs = DAO.DAO_LoaiKH.LayLoaiKH();
        try {
            while (rs.next()) {
                obj[0] = rs.getString("MaLoaiKH");
                obj[1] = rs.getString("TenLoaiKH");
                obj[2] = rs.getInt("TienGiam");
                obj[3] = rs.getString("MoTa");
                tblModel.addRow(obj);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public static boolean KT_Them(DTO.DTO_LoaiKH Loai) {
        System.out.println(Loai.getTienGiam());
        ResultSet rs = DAO.DAO_LoaiKH.LayLoaiKH();
        try {
            while (rs.next()) {
                if (rs.getString("MaLoaiKH").matches(Loai.getMaLoaiKH())) {
                    thongbao.thongbao("Mã loại đã dùng", "");
                    return false;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(BLL_LoaiKH.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (Loai.getMaLoaiKH().trim().equals("") || Loai.getTenLoaiKH().trim().equals("")) {
            thongbao.thongbao("Không để trống thông tin", "");
            return false;
        }
        if (Loai.getTienGiam() > 100) {
            thongbao.thongbao("Tiền giảm sai", "");
            return false;
        }
        return true;
    }

    public static boolean KT_Sua(DTO.DTO_LoaiKH Loai) {
        if (Loai.getMaLoaiKH().trim().equals("") || Loai.getTenLoaiKH().trim().equals("")) {
            thongbao.thongbao("Không để trống thông tin", "");
            return false;
        }
 if (Loai.getTienGiam() > 100) {
            thongbao.thongbao("Tiền giảm sai", "");
            return false;
        }
        return true;
    }

    public static boolean KT_Xoa(String MaLoaiKH) {
        ResultSet rs = DAO.DAO_KhachHang.LayKH();
        try {
            while (rs.next()) {
                if (rs.getString("MaLoaiKH").matches(MaLoaiKH)) {
                    thongbao.thongbao("Có khách hàng đang có mã loại này", "");
                    return false;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(BLL_LoaiKH.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }
}
