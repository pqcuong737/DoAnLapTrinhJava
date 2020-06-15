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
public class DAO_CungCapDichVu {

    public static ResultSet LayDV() {
        String sql = "SELECT * FROM [dbo].[DichVu]";
        return connection.Getdata(sql);
    }

    public static void Them(DTO.DTO_DichVu dv) {
        String sql = "INSERT INTO [dbo].[DichVu] "
                + "           ([MaDichVu] "
                + "           ,[TenDichVu] "
                + "           ,[DonVi] "
                + "           ,[DonGia] "
                + "           ,[GhiChu]) "
                + "     VALUES "
                + "           (N'" + dv.getMaDV() + "' "
                + "           ,N'" + dv.getTenDV() + "' "
                + "           ,N'" + dv.getDonVi() + "' "
                + "           ," + ChuyenDoi.ChuyenSangSo(dv.getDonGia()) + " "
                + "           ,N'" + dv.getGhiChu() + "')";
        int kq = connection.ExecuteTruyVan(sql);
        if (kq > 0) {
            thongbao.thongbao("Thêm thành công", "");
        } else {
            thongbao.thongbao("Thêm  không thành công", "");
        }
    }

    public static ResultSet LayDVTheoMa(String MaDV) {
        String sql = "SELECT * FROM [dbo].[DichVu] where MaDichVu=N'" + MaDV + "'";
        return connection.Getdata(sql);
    }

    public static void Xoa(String MaDV) {
        String sql = "DELETE FROM [dbo].[DichVu] WHERE MaDichVu=N'" + MaDV + "'";
        connection.ExecuteTruyVan(sql);
    }

    public static void Sua(DTO.DTO_DichVu dv) {
        String sql = "UPDATE [dbo].[DichVu] "
                + "   SET [MaDichVu] = N'" + dv.getMaDV() + "' "
                + "      ,[TenDichVu] = N'" + dv.getTenDV() + "' "
                + "      ,[DonVi] = N'" + dv.getDonVi() + "' "
                + "      ,[DonGia] = " + ChuyenDoi.ChuyenSangSo(dv.getDonGia()) + " "
                + "      ,[GhiChu] = N'" + dv.getGhiChu() + "' "
                + " WHERE MaDichVu =N'" + dv.getMaDV() + "'";
        int kq = connection.ExecuteTruyVan(sql);
        if (kq > 0) {
            thongbao.thongbao("SỬa thành công", "");
        } else {
            thongbao.thongbao("Sửa  không thành công", "");
        }
    }

    public static ResultSet TimKiem(String tukhoa) {
        String sql = "SELECT * FROM [dbo].[DichVu] where TenDichVu like N'%" + tukhoa + "%'";
        return connection.Getdata(sql);
    }
}
