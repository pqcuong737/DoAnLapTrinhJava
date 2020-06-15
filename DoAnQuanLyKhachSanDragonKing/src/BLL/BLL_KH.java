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
public class BLL_KH {

    public static boolean KT_Them(DTO.DTO_KH KH) {
        ResultSet rs = DAO.DAO_KhachHang.LayKH();
        try {
            while (rs.next()) {
                if (rs.getString("MaKhachHang").matches(KH.getMaKH())) {
                    thongbao.thongbao("Mã khách hàng đã dùng", "");
                    return false;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(BLL_KH.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (KH.getMaKH().trim().equals("") || KH.getTenKH().trim().equals("") || KH.getTuoi().trim().equals("") || KH.getCMND().trim().equals("")) {
            thongbao.thongbao("Không để trống thông tin", "thông báo");
            return false;
        }
        if (KH.getCMND().length()!=10) {
            thongbao.thongbao("Nhập lại số CMND", "");
            return false;
        }
        return true;
    }

    public static void dodulieu(JTable tbl) {
        DefaultTableModel tblModel = (DefaultTableModel) tbl.getModel();
        tblModel.setRowCount(0);
        Object obj[] = new Object[2];
        ResultSet rs = DAO.DAO_KhachHang.LayKH();
        try {
            while (rs.next()) {
                obj[0] = rs.getString("MaKhachHang");
                obj[1] = rs.getString("TenKhachHang");
                tblModel.addRow(obj);
            }
        } catch (SQLException ex) {
            System.out.println("lỗi đổ table");
        }
    }
  public static void TimKiem(JTable tbl,String tukhoa) {
        DefaultTableModel tblModel = (DefaultTableModel) tbl.getModel();
        tblModel.setRowCount(0);
        Object obj[] = new Object[2];
        ResultSet rs = DAO.DAO_KhachHang.TimKiem(tukhoa);
        try {
            while (rs.next()) {
                obj[0] = rs.getString("MaKhachHang");
                obj[1] = rs.getString("TenKhachHang");
                tblModel.addRow(obj);
            }
        } catch (SQLException ex) {
            System.out.println("lỗi đổ table");
        }
    }

    public static boolean KT_Xoa(String MaKH) {
        ResultSet rs = DAO.DAO_ThuePhong.LayTatCa();
        try {
            while (rs.next()) {
                if (rs.getString("MaKhachHang").matches(MaKH)) {
                    thongbao.thongbao("Khách hàng đã hoặc đang thuê phòng", "");
                    return false;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(BLL_KH.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

    public static boolean KT_Sua(DTO.DTO_KH KH) {
        if (KH.getMaKH().trim().equals("") || KH.getTenKH().trim().equals("") || KH.getTuoi().trim().equals("") || KH.getCMND().trim().equals("")) {
            thongbao.thongbao("Không để trống thông tin", "thông báo");
            return false;
        }
        return true;
    }

}
