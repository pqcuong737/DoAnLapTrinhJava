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
public class DTO_LoaiKH {
    String MaLoaiKH,TenLoaiKH,MoTa;
    double TienGiam;

    public String getMaLoaiKH() {
        return MaLoaiKH;
    }

    public void setMaLoaiKH(String MaLoaiKH) {
        this.MaLoaiKH = MaLoaiKH;
    }

    public String getTenLoaiKH() {
        return TenLoaiKH;
    }

    public void setTenLoaiKH(String TenLoaiKH) {
        this.TenLoaiKH = TenLoaiKH;
    }

    public double getTienGiam() {
        return TienGiam;
    }

    public void setTienGiam(double TienGiam) {
        this.TienGiam = TienGiam;
    }

    public String getMoTa() {
        return MoTa;
    }

    public void setMoTa(String MoTa) {
        this.MoTa = MoTa;
    }
}
