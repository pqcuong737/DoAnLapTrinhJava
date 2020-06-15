/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.ResultSet;
import java.util.Date;

/**
 *
 * @author ADMIN
 */
public class DAO_NhanLuong {

    public static void Them(DTO.DTO_NhanLuong nl) {
        String sql = "set dateformat dmy "
                + "INSERT INTO [dbo].[ChiTietLuong] "
                + "           ([MaChiTietLuong] "
                + "           ,[MaNhanVien] "
                + "           ,[SoNgayNghi] "
                + "           ,[SoNgayLam] "
                + "           ,[NgayNhanLuong] "
                + "           ,[TongNhan]) "
                + "     VALUES "
                + "           (N'"+nl.getMaChiTietLuong()+"' "
                + "           ,N'"+nl.getMaNhanVien()+"' "
                + "           ,"+nl.getSoNgayNghi()+" "
                + "           ,"+nl.getSoNgayLam()+" "
                + "           ,'"+nl.getNgayNhanLuong()+"' "
                + "           ,"+nl.getTongNhan()+")";
        connection.ExecuteTruyVan(sql);
    }

    public static void CapNhatNgayLam(DTO.DTO_NhanLuong nl, String ngayhientai) {
        String sql = " set dateformat dmy "
                + "UPDATE [dbo].[NhanVien] "
                + "SET [NgayBatDauLam] ='" + ngayhientai + "' "
                + "where MaNhanVien=N'" + nl.getMaNhanVien() + "'";
        connection.ExecuteTruyVan(sql);
    }

    public static ResultSet Lay() {
        String sql = "SELECT * FROM [dbo].[ChiTietLuong]";
        return connection.Getdata(sql);
    }
}
