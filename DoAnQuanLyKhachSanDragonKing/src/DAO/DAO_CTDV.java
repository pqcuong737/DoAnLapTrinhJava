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
public class DAO_CTDV {

    public static ResultSet LayCTDV(String MaDP) {
        String sql = "SELECT * FROM [dbo].[ChiTietDichVu] where MaDatPhong =" + MaDP + "";
        return connection.Getdata(sql);
    }

    public static void Them(DTO.DTO_CTDV ctdv) {
        String sql = "INSERT INTO [dbo].[ChiTietDichVu] "
                + "           ([MaDatPhong] "
                + "           ,[MaDichVu] "
                + "           ,[DonGia] "
                + "           ,[SoLuong] "
                + "           ,[ThanhTien]) "
                + "     VALUES "
                + "           ("+ctdv.getMaDP()+" "
                + "           ,N'"+ctdv.getMaDV()+"' "
                + "           ,"+ctdv.getDonGia()+" "
                + "           ,"+ctdv.getSoLuong()+" "
                + "           ,"+ctdv.getThanhTien()+")";
         int kq = connection.ExecuteTruyVan(sql);
        if (kq > 0) {
//            thongbao.thongbao("Thêm thành công", "");
        } else {
            thongbao.thongbao("Thêm  không thành công", "");
        }
    }
    public static  void Xoa(String MaCTDV){
    String sql="DELETE FROM [dbo].[ChiTietDichVu] WHERE MaCTDV="+MaCTDV+"";
    connection.ExecuteTruyVan(sql);
    }
    public static ResultSet LayTatCa(){
    String sql="SELECT * FROM [dbo].[ChiTietDichVu]";
    return connection.Getdata(sql);
    }
}
