/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

/**
 *
 * @author ADMIN
 */
public class DAO_HoaDon {

    public static void ThemHD(DTO.DTO_HoaDon HD) {
        String sql = "set dateformat dmy "
                + "INSERT INTO [dbo].[HoaDon] "
                + "           ([MaDatPhong] "
                + "           ,[TenUser] "
                + "           ,[TenKhachHang] "
                + "           ,[MaPhong] "
                + "           ,[SoNgayThue] "
                + "           ,[SoGioThue] "
                + "           ,[TienPhong] "
                + "           ,[PhuThuCheckin] "
                + "           ,[PhuThuCheckout] "
                + "           ,[TienDichVu] "
                + "           ,[ThanhTien] "
                + "           ,[NgayThanhToan]) "
                + "     VALUES "
                + "           ("+HD.getMaDP()+" "
                + "           ,N'"+HD.getTenUser()+"' "
                + "           ,N'"+HD.getTenKH()+"' "
                + "           ,N'"+HD.getMaPhong()+"' "
                + "           ,"+HD.getSoNgayThue()+" "
                + "           ,"+HD.getSoGioThue()+" "
                + "           ,"+HD.getTienPhong()+" "
                + "           ,"+HD.getPhuThuCheckin()+" "
                + "           ,"+HD.getPhuThuCheckout()+" "
                + "           ,"+HD.getTienDV()+" "
                + "           ,"+HD.getThanhTien()+" "
                + "           ,'"+HD.getNgayThanhToan()+"')";
        connection.ExecuteTruyVan(sql);
    }
}
