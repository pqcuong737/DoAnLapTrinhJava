/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import GUI.thongbao;
import java.sql.ResultSet;

/**
 *
 * @author ADMIN
 */
public class DAO_LoaiKH {

    public static ResultSet LayLoaiKH() {
        String sql = "SELECT * FROM [dbo].[LoaiKhachHang]";
        return connection.Getdata(sql);
    }

    public static ResultSet LayTHeoMa(String MaLoai) {
        String sql = "SELECT * FROM [dbo].[LoaiKhachHang] where MaLoaiKH=N'" + MaLoai + "'";
        return connection.Getdata(sql);
    }

    public static void Them(DTO.DTO_LoaiKH Loai) {
        String sql = "INSERT INTO [dbo].[LoaiKhachHang] "
                + "           ([MaLoaiKH] "
                + "           ,[TenLoaiKH] "
                + "           ,[TienGiam] "
                + "           ,[MoTa]) "
                + "     VALUES "
                + "           (N'" + Loai.getMaLoaiKH() + "' "
                + "           ,N'" + Loai.getTenLoaiKH() + "' "
                + "           ," + Loai.getTienGiam() + " "
                + "           ,N'" + Loai.getMoTa() + "')";
        int kq = connection.ExecuteTruyVan(sql);
        if (kq > 0) {
            thongbao.thongbao("Thêm thành công", "");
        } else {
            thongbao.thongbao("Thêm  không thành công", "");
        }
    }

    public static void Sua(DTO.DTO_LoaiKH Loai) {
        String sql = "UPDATE [dbo].[LoaiKhachHang] "
                + "   SET [MaLoaiKH] = N'" + Loai.getMaLoaiKH() + "' "
                + "      ,[TenLoaiKH] = N'" + Loai.getTenLoaiKH() + "' "
                + "      ,[TienGiam] = " + Loai.getTienGiam() + " "
                + "      ,[MoTa] = N'" + Loai.getMoTa() + "' "
                + " WHERE MaLoaiKH=N'" + Loai.getMaLoaiKH() + "'";
        int kq = connection.ExecuteTruyVan(sql);
        if (kq > 0) {
            thongbao.thongbao("Sửa thành công", "");
        } else {
            thongbao.thongbao("Sửa  không thành công", "");
        }
    }

    public static void Xoa(String MaLoaiKH) {
        String sql = "DELETE FROM [dbo].[LoaiKhachHang] WHERE MaLoaiKH =N'" + MaLoaiKH + "'";
        connection.ExecuteTruyVan(sql);
    }

}
