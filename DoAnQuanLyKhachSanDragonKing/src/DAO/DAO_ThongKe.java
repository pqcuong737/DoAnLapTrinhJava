/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.ResultSet;

/**
 *
 * @author ADMIN
 */
public class DAO_ThongKe {

    public static ResultSet LayTheoKhoangTG(String date1, String date2) {
        String sql = " set dateformat dmy "
                + " select MaHoaDon,TienPhong,TienDichVu,ThanhTien,NgayThanhToan,(PhuThuCheckin+PhuThuCheckout) as phuthu from hoadon where NgayThanhToan  between '" + date1 + "' and '" + date2 + "'";
        return connection.Getdata(sql);
    }

    public static ResultSet LayTheoKhoangTG2(String date1, String date2) {
        String sql = " select count(MaHoaDon) as SoHD, sum(thanhtien) as doanhthu,sum(TienDichVu) as dichvu, sum(TienPhong) as tienphong from hoadon where NgayThanhToan  between '" + date1 + "' and '" + date2 + "'";
        return connection.Getdata(sql);
    }

    public static ResultSet LayTatCa() {
        String sql = " select MaHoaDon,TienPhong,TienDichVu,ThanhTien,NgayThanhToan,(PhuThuCheckin+PhuThuCheckout) as phuthu from hoadon";
        return connection.Getdata(sql);
    }

    public static ResultSet LayTatCa2() {
        String sql = "select count(MaHoaDon) as SoHD, sum(thanhtien) as doanhthu,sum(TienDichVu) as dichvu, sum(TienPhong) as tienphong from hoadon";
        return connection.Getdata(sql);
    }

    //thống kê lương
    public static ResultSet LayTatCaLuong() {
        String sql = "SELECT * FROM [dbo].[ChiTietLuong]";
        return connection.Getdata(sql);
    }

    public static ResultSet LayTatCaLuong2() {
        String sql = "SELECT sum(TongNhan) as tongnhan FROM [dbo].[ChiTietLuong]";
        return connection.Getdata(sql);
    }

    public static ResultSet LayLuongTheoTG(String date1, String date2) {
        String sql = "set dateformat dmy "
                + "SELECT * FROM [dbo].[ChiTietLuong] where NgayNhanLuong between '" + date1 + "' and '" + date2 + "'";
        return connection.Getdata(sql);
    }

    public static ResultSet LayLuongTheoTG2(String date1, String date2) {
        String sql = "set dateformat dmy "
                + "SELECT sum(TongNhan) as tongnhan FROM [dbo].[ChiTietLuong] where NgayNhanLuong between '" + date1 + "' and '" + date2 + "'";
        return connection.Getdata(sql);
    }
}
