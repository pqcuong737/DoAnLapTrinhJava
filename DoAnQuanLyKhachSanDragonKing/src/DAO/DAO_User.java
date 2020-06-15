/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import GUI.pnl_NhanVien;
import GUI.thongbao;
import java.sql.ResultSet;

/**
 *
 * @author ADMIN
 */
public class DAO_User {

    public static ResultSet LayTKTheoMaNV(String MaNV) {
        String sql = "SELECT * FROM [dbo].[User] where MaNhanVien =N'" + MaNV + "'";
        return connection.Getdata(sql);
    }

    public static ResultSet LayTatCa() {
        String sql = "SELECT * FROM [dbo].[User]";
        return connection.Getdata(sql);
    }

    public static void Them(DTO.DTO_User u) {
        String sql = "INSERT INTO [dbo].[User] "
                + "           ([TenUser] "
                + "           ,[MatKhau] "
                + " "
                + "           ,[MaQuyen] "
                + "  "
                + "           ,[MaNhanVien]) "
                + "     VALUES "
                + "           (N'" + u.getTenUser() + "' "
                + "           ,N'" + u.getMK() + "' "
                + "   "
                + "           ,N'" + u.isQuyen() + "' "
                + "   "
                + "           ,N'" + pnl_NhanVien.MaNV + "')";
        int kq = connection.ExecuteTruyVan(sql);
        if (kq > 0) {
            thongbao.thongbao("Thêm thành công", "");
        } else {
            thongbao.thongbao("Thêm  không thành công", "");
        }
    }

    public static void Xoa() {
        String sql = "DELETE FROM [dbo].[User] WHERE MaNhanVien=N'" + pnl_NhanVien.MaNV + "'";
        int kq = connection.ExecuteTruyVan(sql);
        if (kq > 0) {
            thongbao.thongbao("Xóa thành công", "");
        } else {
            thongbao.thongbao("Xóa không thành công", "");
        }
    }

    public static void Sua(DTO.DTO_User sua) {
        String sql = "UPDATE [dbo].[User]   SET       [MatKhau] = N'" + sua.getMK() + "',[MaQuyen] = N'" + sua.isQuyen() + "'         WHERE TenUser=N'" + sua.getTenUser() + "'";
        if (connection.ExecuteTruyVan(sql) > 0) {
            thongbao.thongbao("Sủa thành công", "");
        } else {
            thongbao.thongbao("Sửa không thành công", "");
        }
    }

    public static void SuaMK(String MK, String TenUser) {
        String sql = "UPDATE [dbo].[User] SET  "
                + "[MatKhau] =N'" + MK + "' "
                + " "
                + " WHERE TenUser=N'" + TenUser + "'";
        int kq = connection.ExecuteTruyVan(sql);
        if (kq > 0) {
            thongbao.thongbao("Thành công", "");

        } else {
            thongbao.thongbao("Thất bại", "");
        }

    }
}
