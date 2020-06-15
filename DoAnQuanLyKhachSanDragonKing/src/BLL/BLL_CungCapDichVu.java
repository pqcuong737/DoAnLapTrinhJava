/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import GUI.ChuyenDoi;
import GUI.thongbao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ADMIN
 */
public class BLL_CungCapDichVu {

    public static void DoDuLieuBangDichVu(JTable tbl) {
        DefaultTableModel tblModel = (DefaultTableModel) tbl.getModel();
        tblModel.setRowCount(0);
        Object obj[] = new Object[4];
        ResultSet rs = DAO.DAO_CungCapDichVu.LayDV();
        try {
            while (rs.next()) {
                obj[0] = rs.getString("MaDichVu");
                obj[1] = rs.getString("TenDichVu");
                obj[2] = rs.getString("DonVi");
                obj[3] = ChuyenDoi.DinhDangSo(rs.getDouble("DonGia"));
                tblModel.addRow(obj);
            }
        } catch (SQLException ex) {

        }
    }

    public static void Load_cbbDonVi(JComboBox cbb) {
        DefaultComboBoxModel cbbModel = (DefaultComboBoxModel) cbb.getModel();
        cbbModel.addElement("lon");
        cbbModel.addElement("chai");
        cbbModel.addElement("cái");
        cbbModel.addElement("phần");
        cbbModel.addElement("kg");

    }

    public static boolean KT_Them(DTO.DTO_DichVu dv) {
        ResultSet rs = DAO.DAO_CungCapDichVu.LayDV();
        String kt2 = "[0-9]{1,99}|[0-9]{1,99}[.][0-9]{1,99}";
        if (dv.getMaDV().trim().equals("") || dv.getTenDV().trim().equals("") || dv.getDonGia().trim().equals("")) {
            thongbao.thongbao("KHông bỏ trống dữ liệu", "");
            return false;
        }
        if (!dv.getDonGia().matches(kt2)) {
            thongbao.thongbao("Nhập số vào đơn giá", "");
            return false;
        }

        try {
            while (rs.next()) {
                if (rs.getString("MaDichVu").matches(dv.getMaDV())) {
                    thongbao.thongbao("Mã dịch vụ bị trùng", "");
                    return false;
                }
            }
        } catch (SQLException ex) {

        }
        return true;
    }

    public static boolean KT_Sua(DTO.DTO_DichVu dv) {
        String kt2 = "[0-9]{1,99}|[0-9]{1,99}[.][0-9]{1,99}";
        if (dv.getMaDV().trim().equals("") || dv.getTenDV().trim().equals("") || dv.getDonGia().trim().equals("")) {
            thongbao.thongbao("KHông bỏ trống dữ liệu", "");
            return false;
        }
        if (!dv.getDonGia().matches(kt2)) {
            thongbao.thongbao("Nhập số vào đơn giá", "");
            return false;
        }
        return true;
    }

    public static boolean KT_Xoa(String MaDV) {
        ResultSet rs = DAO.DAO_CTDV.LayTatCa();
        try {
            while (rs.next()) {// Kiểm tra dịch vụ có đang tồn tại trong Chi tiết DV
                if (rs.getString("MaDichVu").equals(MaDV)) {
                    thongbao.thongbao("Dịch vụ này đang tồn tại để tính tiền hóa đơn", "");
                    return false;
                }
            }
        } catch (SQLException ex) {

        }
return true;
    }
}
