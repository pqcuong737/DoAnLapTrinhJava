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
public class DTO_NhanLuong {

    String MaChiTietLuong, MaNhanVien,NgayNhanLuong;

    public String getNgayNhanLuong() {
        return NgayNhanLuong;
    }

    public void setNgayNhanLuong(String NgayNhanLuong) {
        this.NgayNhanLuong = NgayNhanLuong;
    }
    int SoNgayNghi, SoNgayLam;

    public String getMaChiTietLuong() {
        return MaChiTietLuong;
    }

    public void setMaChiTietLuong(String MaChiTietLuong) {
        this.MaChiTietLuong = MaChiTietLuong;
    }

    public String getMaNhanVien() {
        return MaNhanVien;
    }

    public void setMaNhanVien(String MaNhanVien) {
        this.MaNhanVien = MaNhanVien;
    }

    public int getSoNgayNghi() {
        return SoNgayNghi;
    }

    public void setSoNgayNghi(int SoNgayNghi) {
        this.SoNgayNghi = SoNgayNghi;
    }

    public int getSoNgayLam() {
        return SoNgayLam;
    }

    public void setSoNgayLam(int SoNgayLam) {
        this.SoNgayLam = SoNgayLam;
    }

    public double getTongNhan() {
        return TongNhan;
    }

    public void setTongNhan(double TongNhan) {
        this.TongNhan = TongNhan;
    }
    double TongNhan;
}
