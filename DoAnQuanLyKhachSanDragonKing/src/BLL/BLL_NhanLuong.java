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

/**
 *
 * @author ADMIN
 */
public class BLL_NhanLuong {

    public static boolean KT_MaNhanLuong(DTO.DTO_NhanLuong nl) {
        ResultSet rs = DAO.DAO_NhanLuong.Lay();
        try {
            while (rs.next()) {
                if (nl.getMaChiTietLuong().equals(rs.getString("MaChiTietLuong"))) {
                    thongbao.thongbao("Nhân viên đã có lương", "");
                    return false;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(BLL_NhanLuong.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }
}
