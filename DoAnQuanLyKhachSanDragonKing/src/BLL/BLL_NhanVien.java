/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import GUI.ChuyenDoi;
import GUI.mycombobox;
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
public class BLL_NhanVien {

    public static void loadData_Luong(JComboBox cbb) {
        DefaultComboBoxModel cbbModel = (DefaultComboBoxModel) cbb.getModel();
        cbbModel.removeAllElements();
        ResultSet rs = DAO.DAO_Luong.LayLuong();
        try {
            while (rs.next()) {
                Object MaLuong = rs.getString("MaLuong");
                Object LuongTheoGio = ChuyenDoi.DinhDangSo(rs.getDouble("LuongTheoGio"));
                mycombobox mb = new mycombobox(MaLuong, LuongTheoGio);
                cbbModel.addElement(mb);
            }
        } catch (SQLException ex) {
            System.out.println("lỗi đổ cbb_LoaiKhachHang");
        }
    }

    public static void DoDuLieuBang(JTable tbl) {
        DefaultTableModel tblModel = (DefaultTableModel) tbl.getModel();
        tblModel.setRowCount(0);
        Object obj[] = new Object[7];
        ResultSet rs = DAO.DAO_NhanVien.LayNV();
        try {
            while (rs.next()) {
                obj[0] = rs.getString("MaNhanVien");
                obj[1] = rs.getString("TenNhanVien");
                boolean gt = rs.getBoolean("GioiTinh");
                if (gt) {
                    obj[2] = "Nam";
                } else {
                    obj[2] = "Nữ";
                }
                obj[3] = rs.getDate("NgaySinh");
                obj[4] = rs.getString("SoDienThoai");
                obj[5] = rs.getString("DiaChi");
                tblModel.addRow(obj);
            }
        } catch (SQLException ex) {
            System.out.println("lỗi đổ table");

        }
    }

    public static void DoDuLieuTimKiem(JTable tbl, String TuKhoa) {
        DefaultTableModel tblModel = (DefaultTableModel) tbl.getModel();
        tblModel.setRowCount(0);
        Object obj[] = new Object[7];
        ResultSet rs = DAO.DAO_NhanVien.TimKiem(TuKhoa);
        try {
            while (rs.next()) {
                obj[0] = rs.getString("MaNhanVien");
                obj[1] = rs.getString("TenNhanVien");
                boolean gt = rs.getBoolean("GioiTinh");
                if (gt) {
                    obj[2] = "Nam";
                } else {
                    obj[2] = "Nữ";
                }
                obj[3] = rs.getDate("NgaySinh");
                obj[4] = rs.getString("SoDienThoai");
                obj[5] = rs.getString("DiaChi");
                tblModel.addRow(obj);
            }
        } catch (SQLException ex) {
            System.out.println("lỗi đổ table");

        }
    }

    public static boolean KT_Them(DTO.DTO_NhanVien nv) {
        ResultSet rs = DAO.DAO_NhanVien.LayNV();
        try {
            while (rs.next()) {
                if (nv.getMaNV().equals(rs.getString("MaNhanVien"))) {
                    thongbao.thongbao("Mã nhân viên đã dùng", "");
                    return false;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(BLL_NhanVien.class.getName()).log(Level.SEVERE, null, ex);

        }

        if (nv.getMaNV().trim().equals("") || nv.getTenNV().trim().equals("")) {
            thongbao.thongbao("Không bỏ trống thông tin", "");
            return false;
        }
        if (nv.getSDT().length() != 10) {
            thongbao.thongbao("Nhập số điện thoại", "");
            return false;
        }

        return true;
    }
public static boolean KT_Sua(DTO.DTO_NhanVien nv){
if (nv.getMaNV().trim().equals("") || nv.getTenNV().trim().equals("")) {
            thongbao.thongbao("Không bỏ trống thông tin", "");
            return false;
        }
        if (nv.getSDT().length() != 10) {
            thongbao.thongbao("Nhập số điện thoại", "");
            return false;
        }

        return true;
}
//    public static boolean KT_Xoa(String MaNV){
//        
//    }
    public static boolean XemTK(String MaNV) {
        ResultSet rs = DAO.DAO_User.LayTKTheoMaNV(MaNV);
        try {
            if (rs.next()) {
                if (rs.getString("MaNhanVien").equals(MaNV)) {
                    return true;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(BLL_NhanVien.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public static boolean KT_Xoa(String manhanvien) {
        ResultSet rs = DAO.DAO_User.LayTatCa();
        try {
            while (rs.next()) {
                if (rs.getString("MaNhanVien").equals(manhanvien)) {
                    thongbao.thongbao("Nhân viên đang có tài khoản", "");
                    return false;
                }
            }
        } catch (SQLException ex) {

        }
        return true;
    }

}
