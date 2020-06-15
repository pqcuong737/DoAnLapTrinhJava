/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAO.connection;
import GUI.ChuyenDoi;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ADMIN
 */
public class BLL_DichVu {

    public static void DoDuLieuBangDatPhong(JTable tbl) {
          SimpleDateFormat D = new SimpleDateFormat("dd/MM/yyyy");
        DefaultTableModel tblModel = (DefaultTableModel) tbl.getModel();
        tblModel.setRowCount(0);
        Object obj[] = new Object[8];
        ResultSet rs = DAO.DAO_ThuePhong.Lay();
        try {
            while (rs.next()) {
                obj[0] = rs.getInt("MaDatPhong");
                String MaKH = rs.getString("MaKhachHang");
                ResultSet kh = DAO.DAO_KhachHang.LayKHMa(MaKH);
                if (kh.next()) {
                    obj[1] = kh.getString("TenKhachHang");
                }
                obj[2] = rs.getString("MaPhong");
                if (rs.getBoolean("LoaiHinhThue")) {
                    obj[3] = "Giờ";
                } else {
                    obj[3] = "Ngày";
                }
                obj[4] = D.format(rs.getDate("NgayThue"));
//                obj[5]=rs.getDate("NgayRaDuKien");
//                obj[6]=rs.getInt("SoNguoi");
//                obj[7]=rs.getString("TenUser");
                tblModel.addRow(obj);
            }
        } catch (SQLException ex) {

        }
    }

    public static void DoDuLieuDichVu(JTable tbl, String MaDP) {
        DefaultTableModel tblModel = (DefaultTableModel) tbl.getModel();
        tblModel.setRowCount(0);
        Object obj[] = new Object[5];
        ResultSet rs = DAO.DAO_CTDV.LayCTDV(MaDP);
        try {
            while(rs.next()){
                obj[0]=rs.getInt("MaCTDV");
                String MaDV=rs.getString("MaDichVu");
//                System.out.println("mã dv "+MaDV);
                ResultSet dv=DAO.DAO_CungCapDichVu.LayDVTheoMa(MaDV);
                if (dv.next()) {
                    obj[1]=dv.getString("TenDichVu");
                }

                obj[2]=ChuyenDoi.DinhDangSo(rs.getDouble("DonGia"));
                obj[3]=rs.getInt("SoLuong");
                obj[4]=ChuyenDoi.DinhDangSo(rs.getDouble("ThanhTien"));
                tblModel.addRow(obj);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BLL_DichVu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
