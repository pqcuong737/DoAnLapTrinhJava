/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import GUI.thongbao;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author ADMIN
 */
public class DAO_ThuePhong {

    public static ResultSet Lay() {//lấy đặt phòng chưa thanh toán
        String sql = "SELECT * FROM [dbo].[DatPhong] where TinhTrang like N'Chưa thanh toán'";
        return connection.Getdata(sql);
    }

    public static ResultSet LayTheoMa(String MaDP) {
        String sql = "SELECT * FROM [dbo].[DatPhong] where MaDatPhong=" + MaDP + "";
        return connection.Getdata(sql);
    }

    public static void Them(DTO.DTO_ThuePhong add) {
        String sql = "set dateformat dmy "
                + "INSERT INTO [dbo].[DatPhong] "
                + "           ([MaKhachHang] "
                + "           ,[MaPhong] "
                + "           ,[LoaiHinhThue] "
                + "           ,[NgayThue] "
                + "           ,[NgayRaDuKien] "
                + "           ,[SoNguoi] "
                + ",[TienDatCoc]"
                + "           ,[TenUser]) "
                + "     VALUES "
                + "           (N'" + add.getMaKH() + "' "
                + "           ,N'" + add.getMaPhong() + "' "
                + "           ,'" + add.isLoaiHinhThue() + "' "
                + "           ,'" + add.getNgayThue() + "' "
                + "           ,'" + add.getNgayRaDuKien() + "' "
                + "           ," + add.getSoNguoi() + " "
                + "," + add.getTienCoc() + " "
                + "           ,N'" + add.getTenUser() + "')";
        int kq = connection.ExecuteTruyVan(sql);
        if (kq > 0) {
            //sau khi thuê sẽ cập nhật phòng đó thành 'sudung'
            DAO.DAO_Phong.Update(add.getMaPhong());
            thongbao.thongbao("Thuê thành công", "");
        } else {
            thongbao.thongbao("Thuê  không thành công", "");
        }
    }

    public static void DatTruocPhong(DTO.DTO_ThuePhong add) {
        String sql = "set dateformat dmy "
                + "INSERT INTO [dbo].[DatPhong] "
                + "           ([MaKhachHang] "
                + "           ,[MaPhong] "
                + "           ,[LoaiHinhThue] "
                + "           ,[NgayThue] "
                + "           ,[NgayRaDuKien] "
                + "           ,[SoNguoi] "
                + "           ,[TenUser] "
                + "           ,[TinhTrang] "
                + "           ,[TienDatCoc]) "
                + "     VALUES "
                + "           (N'" + add.getMaKH() + "' "
                + "           ,N'" + add.getMaPhong() + "' "
                + "           ,'" + add.isLoaiHinhThue() + "' "
                + "           ,'" + add.getNgayThue() + "' "
                + "           ,'" + add.getNgayRaDuKien() + "' "
                + "           ," + add.getSoNguoi() + " "
                + "           ,N'" + add.getTenUser() + "' "
                + "           ,N'dattruoc' "
                + "           ," + add.getTienCoc() + ")";
        int kq = connection.ExecuteTruyVan(sql);
        if (kq > 0) {
            //sau khi đặt trước phòng sẽ đặt trạng thái phòng thành 'dattruoc'
            DAO.DAO_Phong.UpdateDatTruoc(add.getMaPhong());
            thongbao.thongbao("Đặt thành công", "");
        } else {
            thongbao.thongbao("Đặt  không thành công", "");
        }
    }

    public static void UpdateDatTruocThanhThue(String trangthai, String MaPhong) {
        String sql = "UPDATE [dbo].[DatPhong] SET [TinhTrang] = N'" + trangthai + "' WHERE MaPhong=N'" + MaPhong + "' and TinhTrang=N'dattruoc'";
        int kq = connection.ExecuteTruyVan(sql);
        if (kq > 0) {
            //sau khi thuê sẽ cập nhật phòng đó thành 'sudung'
            if (trangthai.equals("Chưa thanh toán")) {
                DAO.DAO_Phong.Update(MaPhong);
                thongbao.thongbao("Thuê thành công", "");
            }

        } else {
            thongbao.thongbao("Không thành công", "");
        }
    }

    public static void UpdateNgayThue(String MaPhong) {
        Date d = new Date();
        SimpleDateFormat s = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String ngaythue=s.format(d);
        System.out.println("ngày thuê"+ngaythue);
        String sql="UPDATE [dbo].[DatPhong] SET [NgayThue] = '"+ngaythue+"' WHERE MaPhong=N'"+MaPhong+"' and TinhTrang=N'dattruoc'";
        connection.ExecuteTruyVan(sql);
    }

    public static void Sua(int songuoi, String MaDP) {
        String sql = "UPDATE [dbo].[DatPhong] SET [SoNguoi] = " + songuoi + " WHERE MaDatPhong=" + MaDP + "";
        int kq = connection.ExecuteTruyVan(sql);
        if (kq > 0) {
            thongbao.thongbao("sửa thành công", "");
        } else {
            thongbao.thongbao("sửa  không thành công", "");
        }
    }

    public static ResultSet LayTienGio(String MaDP) {
        String sql = "SELECT LoaiPhong.GiaTheoGio,LoaiPhong.GiaTheoNgay FROM DatPhong,Phong,LoaiPhong where DatPhong.MaPhong=Phong.MaPhong and Phong.MaLoaiPhong=LoaiPhong.MaLoaiPhong and DatPhong.MaDatPhong=" + MaDP + "";
        return connection.Getdata(sql);
    }

    public static void TraPhong(String MaDP) {
        String sql = "UPDATE [dbo].[DatPhong] SET [TinhTrang] = N'Đã thanh toán' WHERE MaDatPhong=" + MaDP + "";
        connection.ExecuteTruyVan(sql);
    }
    
    public static ResultSet LayTatCa(){
    String sql="SELECT * FROM [dbo].[DatPhong]";
    return connection.Getdata(sql);
    }
}
