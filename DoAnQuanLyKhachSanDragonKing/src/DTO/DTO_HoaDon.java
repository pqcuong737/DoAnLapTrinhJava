/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author ADMIN
 */
public class DTO_HoaDon {

    int MaDP;
    double TienPhong, TienDV, ThanhTien,SoNgayThue=0, SoGioThue=0,PhuThuCheckin=0,PhuThuCheckout=0;

    String TenUser, TenKH, MaPhong,NgayThanhToan ;

    public double getPhuThuCheckin() {
        return PhuThuCheckin;
    }

    public void setPhuThuCheckin(double PhuThuCheckin) {
        this.PhuThuCheckin = PhuThuCheckin;
    }

    public double getPhuThuCheckout() {
        return PhuThuCheckout;
    }

    public void setPhuThuCheckout(double PhuThuCheckout) {
        this.PhuThuCheckout = PhuThuCheckout;
    }

    public String getNgayThanhToan() {
        return NgayThanhToan;
    }

    public void setNgayThanhToan(String NgayThanhToan) {
        this.NgayThanhToan = NgayThanhToan;
    }

    public int getMaDP() {
        return MaDP;
    }

    public void setMaDP(int MaDP) {
        this.MaDP = MaDP;
    }

    public double getTienPhong() {
        return TienPhong;
    }

    public void setTienPhong(double TienPhong) {
        this.TienPhong = TienPhong;
    }

    public double getTienDV() {
        return TienDV;
    }

    public void setTienDV(double TienDV) {
        this.TienDV = TienDV;
    }

    public double getThanhTien() {
        return ThanhTien;
    }

    public void setThanhTien(double ThanhTien) {
        this.ThanhTien = ThanhTien;
    }

    public String getTenUser() {
        return TenUser;
    }

    public void setTenUser(String TenUser) {
        this.TenUser = TenUser;
    }

    public String getTenKH() {
        return TenKH;
    }

    public void setTenKH(String TenKH) {
        this.TenKH = TenKH;
    }

    public String getMaPhong() {
        return MaPhong;
    }

    public void setMaPhong(String MaPhong) {
        this.MaPhong = MaPhong;
    }

    public double getSoNgayThue() {
        return SoNgayThue;
    }

    public void setSoNgayThue(double SoNgayThue) {
        this.SoNgayThue = SoNgayThue;
    }

    public double getSoGioThue() {
        return SoGioThue;
    }

    public void setSoGioThue(double SoGioThue) {
        this.SoGioThue = SoGioThue;
    }

    

   

}
