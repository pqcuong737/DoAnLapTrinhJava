/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import GUI.ChuyenDoi;
import GUI.thongbao;
import java.sql.ResultSet;

/**
 *
 * @author ADMIN
 */
public class DAO_Luong {

    public static ResultSet LayLuong() {
        String sql = "SELECT * FROM [dbo].[Luong]";
        return connection.Getdata(sql);
    }

    public static ResultSet LayLuongTheoMa(String maluong) {
        String sql = "SELECT  * FROM [dbo].[Luong] where MaLuong=N'" + maluong + "'";
        return connection.Getdata(sql);
    }

    public static void Them(DTO.DTO_Luong L) {
        String sql = "INSERT INTO [dbo].[Luong] "
                + "           ([MaLuong] "
                + "           ,[LuongTheoGio] "
                + "           ,[SoGioLam] "
                + "           ,[GhiChu]) "
                + "     VALUES "
                + "           (N'" + L.getMaluong() + "' "
                + "           ," + ChuyenDoi.ChuyenSangSo(L.getLuonggio()) + " "
                + "           ," + L.getSogiolam() + " "
                + "           ,N'" + L.getGhichu() + "')";
        int kq = connection.ExecuteTruyVan(sql);
        if (kq > 0) {
            thongbao.thongbao("Thêm thành công", "");
        } else {
            thongbao.thongbao("Thêm  không thành công", "");
        }
    }

    public static void Sua(DTO.DTO_Luong L) {
        String sql = "UPDATE [dbo].[Luong] "
                + "   SET [MaLuong] = N'"+L.getMaluong()+"' "
                + "      ,[LuongTheoGio] = "+ChuyenDoi.ChuyenSangSo(L.getLuonggio())+" "
                + "      ,[SoGioLam] = "+L.getSogiolam()+" "
                + "      ,[GhiChu] = N'"+L.getGhichu()+"' "
                + " WHERE MaLuong=N'"+L.getMaluong()+"'";
         int kq = connection.ExecuteTruyVan(sql);
        if (kq > 0) {
            thongbao.thongbao("Sửa thành công", "");
        } else {
            thongbao.thongbao("Sửa không thành công", "");
        }
    }
    public static void Xoa(String maluong){
    String sql="DELETE FROM [dbo].[Luong] WHERE MaLuong=N'"+maluong+"'";
        connection.ExecuteTruyVan(sql);
    }
}
