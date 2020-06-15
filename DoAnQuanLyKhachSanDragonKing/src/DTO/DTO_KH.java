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
public class DTO_KH {
    String MaKH,TenKH,SDT,CMND,Tuoi, MaLoaiKH;

    boolean GioiTinh;

    public String getMaKH() {
        return MaKH;
    }

    public void setMaKH(String MaKH) {
        this.MaKH = MaKH;
    }

    public String getTenKH() {
        return TenKH;
    }

    public void setTenKH(String TenKH) {
        this.TenKH = TenKH;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getCMND() {
        return CMND;
    }

    public void setCMND(String CMND) {
        this.CMND = CMND;
    }

    public String getTuoi() {
        return Tuoi;
    }

    public void setTuoi(String Tuoi) {
        this.Tuoi = Tuoi;
    }

    public String getMaLoaiKH() {
        return MaLoaiKH;
    }

    public void setMaLoaiKH(String MaLoaiKH) {
        this.MaLoaiKH = MaLoaiKH;
    }

    public boolean isGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(boolean GioiTinh) {
        this.GioiTinh = GioiTinh;
    }
}
