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
public class DAO_NhanVien {

    public static ResultSet LayNV() {
        String sql = "SELECT * FROM [dbo].[NhanVien]";
        return connection.Getdata(sql);
    }

    public static ResultSet LayNVTheoMa(String MaNV) {
        String sql = "SELECT * FROM [dbo].[NhanVien] where MaNhanVien =N'" + MaNV + "'";
        return connection.Getdata(sql);
    }

    public static ResultSet TimKiem(String TuKhoa) {
        String sql = "SELECT * FROM [dbo].[NhanVien] where MaNhanVien like N'%" + TuKhoa + "%' or TenNhanVien like N'%" + TuKhoa + "%' or SoDienThoai like N'%" + TuKhoa + "%' or DiaChi like N'%" + TuKhoa + "%'";
        return connection.Getdata(sql);
    }

    public static void Them(DTO.DTO_NhanVien nv) {
        String sql = "set dateformat dmy "
                + "INSERT INTO [dbo].[NhanVien] "
                + "           ([MaNhanVien] "
                + "           ,[TenNhanVien] "
                + "           ,[GioiTinh] "
                + "           ,[NgaySinh] "
                + "           ,[NgayBatDauLam]"
                + "           ,[SoDienThoai] "
                + "           ,[MaLuong] "
                + "           ,[DiaChi] "
                + "           ,[Hinh] "
                + "           ,[GhiChu]) "
                + "     VALUES "
                + "           (N'" + nv.getMaNV() + "' "
                + "           ,N'" + nv.getTenNV() + "' "
                + "           ,'" + nv.isGioiTinh() + "' "
                + "           ,'" + nv.getNgaySinh() + "' "
                + "           ,'" + nv.getNgayLam() + "'    "
                + "           ,N'" + nv.getSDT() + "' "
                + "           ,N'" + nv.getMaLuong() + "' "
                + "           ,N'" + nv.getDiaChi() + "' "
                + "           ,N'" + nv.getHinh() + "' "
                + "           ,N'" + nv.getGhiChu() + "')";
        int kq = connection.ExecuteTruyVan(sql);
        if (kq > 0) {
            thongbao.thongbao("Thêm thành công", "");
        } else {
            thongbao.thongbao("Thêm  không thành công", "");
        }
    }

    public static void Sua(DTO.DTO_NhanVien nv) {
        String sql = "set dateformat dmy "
                + "UPDATE [dbo].[NhanVien] "
                + "   SET [MaNhanVien] = N'" + nv.getMaNV() + "' "
                + "      ,[TenNhanVien] =N'" + nv.getTenNV() + "' "
                + "      ,[GioiTinh] = '" + nv.isGioiTinh() + "' "
                + "      ,[NgaySinh] = '" + nv.getNgaySinh() + "' "
                + "      ,[NgayBatDauLam]= '"+nv.getNgayLam()+"'     "
                + "      ,[SoDienThoai] = N'" + nv.getSDT() + "' "
                + "      ,[MaLuong] = N'" + nv.getMaLuong() + "' "
                + "      ,[DiaChi] = N'" + nv.getDiaChi() + "' "
                + "      ,[Hinh] = N'" + nv.getHinh() + "' "
                + "      ,[GhiChu] = N'" + nv.getGhiChu() + "' "
                + " WHERE MaNhanVien =N'" + pnl_NhanVien.MaNV + "'";
        int kq = connection.ExecuteTruyVan(sql);
        if (kq > 0) {
            thongbao.thongbao("Sửa thành công", "");
        } else {
            thongbao.thongbao("Sửa không thành công", "");
        }
    }

    public static void Xoa(String MaNV) {
        String sql = "DELETE FROM [dbo].[NhanVien] WHERE MaNhanVien=N'" + MaNV + "'";
        connection.ExecuteTruyVan(sql);
    }

}
