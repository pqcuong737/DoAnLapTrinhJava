/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import GUI.thongbao;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author ADMIN
 */
public class DAO_KhachHang {

    public static ResultSet LayKH() {
        String sql = "SELECT * FROM [dbo].[KhachHang]";
        return connection.Getdata(sql);
    }

    public static ResultSet LayKHMa(String MaKH) {
        String sql = "SELECT * FROM [dbo].[KhachHang] where MaKhachHang =N'" + MaKH + "'";
        return connection.Getdata(sql);
    }

    public static void Them(DTO.DTO_KH KH) {
        String sql = "INSERT INTO [dbo].[KhachHang] "
                + "           ([MaKhachHang] "
                + "           ,[MaLoaiKH] "
                + "           ,[TenKhachHang] "
                + "           ,[Tuoi] "
                + "           ,[GioiTinh] "
                + "           ,[SoDienThoai] "
                + "           ,[SoCMND]) "
                + "     VALUES "
                + "           (N'" + KH.getMaKH() + "' "
                + "           ,N'" + KH.getMaLoaiKH() + "' "
                + "           ,N'" + KH.getTenKH() + "' "
                + "           ," + KH.getTuoi() + " "
                + "           ,'" + KH.isGioiTinh() + "' "
                + "           ,N'" + KH.getSDT() + "' "
                + "           ,N'" + KH.getCMND() + "')";
        int kq = connection.ExecuteTruyVan(sql);
        if (kq > 0) {
            thongbao.thongbao("Thêm thành công", "");
        } else {
            thongbao.thongbao("Thêm  không thành công", "");
        }
    }

    public static void Xoa(String MaKH) {
        String sql = "DELETE FROM [dbo].[KhachHang] WHERE MaKhachHang=N'" + MaKH + "'";
        connection.ExecuteTruyVan(sql);
    }

    public static void Sua(DTO.DTO_KH KH) {
        String sql = "UPDATE [dbo].[KhachHang] "
                + "   SET [MaKhachHang] = N'"+KH.getMaKH()+"' "
                + "      ,[MaLoaiKH] ="+KH.getMaLoaiKH()+" "
                + "      ,[TenKhachHang] =N'"+KH.getTenKH()+"' "
                + "      ,[Tuoi] = "+KH.getTuoi()+" "
                + "      ,[GioiTinh] = '"+KH.isGioiTinh()+"' "
                + "      ,[SoDienThoai] = '"+KH.getSDT()+"' "
                + "      ,[SoCMND] = '"+KH.getCMND()+"' "
                + " WHERE MaKhachHang=N'"+KH.getMaKH()+"'";
        if (connection.ExecuteTruyVan(sql) > 0) {
            thongbao.thongbao("Sửa thành công", "");
        } else {
            thongbao.thongbao("Sửa không thành công", "");
        }
    }
    public static ResultSet TimKiem(String tukhoa){
    String sql="select *from KhachHang where TenKhachHang like N'%"+tukhoa+"%' or SoDienThoai like N'%"+tukhoa+"%' or SoCMND like N'%"+tukhoa+"%'";
    return connection.Getdata(sql);
    }
}
