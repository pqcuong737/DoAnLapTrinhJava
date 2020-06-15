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
public class DAO_LoaiPhong {

    public static ResultSet LayLoaiTheoMa(String MaLoai) {
        String sql = "SELECT * FROM [dbo].[LoaiPhong] where MaLoaiPhong =N'" + MaLoai + "'";
        return connection.Getdata(sql);
    }

    public static ResultSet LayTatCa() {
        String sql = "SELECT * FROM [dbo].[LoaiPhong]";
        return connection.Getdata(sql);
    }

    public static void Them(DTO.DTO_Phong LP) {
        String sql = "INSERT INTO [dbo].[LoaiPhong] "
                + "           ([MaLoaiPhong] "
                + "           ,[TenLoaiPhong] "
                + "           ,[GiaTheoGio] "
                + "           ,[GiaTheoNgay]) "
                + "     VALUES "
                + "           (N'" + LP.getMaLoaiPhong() + "' "
                + "           ,N'" + LP.getTenLoaiPhong() + "' "
                + "           ,N'" + ChuyenDoi.ChuyenSangSo(LP.getGiaTheoGio()) + "' "
                + "           ,N'" + ChuyenDoi.ChuyenSangSo(LP.getGiaTheoNgay()) + "')";
        int kq = connection.ExecuteTruyVan(sql);
        if (kq > 0) {
            thongbao.thongbao("Thêm thành công", "");
        } else {
            thongbao.thongbao("Thêm  không thành công", "");
        }
    }

    public static void Xoa(String MaLoaiPhong) {
        String sql = "DELETE FROM [dbo].[LoaiPhong] WHERE MaLoaiPhong=N'" + MaLoaiPhong + "'";
        connection.ExecuteTruyVan(sql);
    }

    public static void Sua(DTO.DTO_Phong LP) {
        String sql = "UPDATE [dbo].[LoaiPhong] "
                + "   SET [MaLoaiPhong] = N'"+LP.getMaLoaiPhong()+"' "
                + "      ,[TenLoaiPhong] = N'"+LP.getTenLoaiPhong()+"' "
                + "      ,[GiaTheoGio] = "+ChuyenDoi.ChuyenSangSo(LP.getGiaTheoGio())+" "
                + "      ,[GiaTheoNgay] = "+ChuyenDoi.ChuyenSangSo(LP.getGiaTheoNgay())+" "
                + " WHERE MaLoaiPhong =N'"+LP.getMaLoaiPhong()+"'";
        int kq = connection.ExecuteTruyVan(sql);
         if (kq > 0) {
            thongbao.thongbao("Sửa thành công", "");
        } else {
            thongbao.thongbao("Sửa  không thành công", "");
        }
    }
}
