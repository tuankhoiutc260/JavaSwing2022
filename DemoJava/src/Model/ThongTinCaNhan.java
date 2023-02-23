/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.Date;

/**
 *
 * @author TuanKhoi
 */
public class ThongTinCaNhan {
    private String MaDangKy;
    private String HoTen;
    private String NgaySinh;
    private int GioiTinh;
    private String SDT;
    private String CCCD;
    private String SoTheBHYT;
    private String DiaChi;
    private String MaTP;
    private String MaQuan;

    public ThongTinCaNhan() {
    }
    
    

    public ThongTinCaNhan(String MaDangKy, String HoTen, String NgaySinh, int GioiTinh, String SDT, String CCCD, String SoTheBHYT, String DiaChi, String MaTP, String MaQuan) {
        this.MaDangKy = MaDangKy;
        this.HoTen = HoTen;
        this.NgaySinh = NgaySinh;
        this.GioiTinh = GioiTinh;
        this.SDT = SDT;
        this.CCCD = CCCD;
        this.SoTheBHYT = SoTheBHYT;
        this.DiaChi = DiaChi;
        this.MaTP = MaTP;
        this.MaQuan = MaQuan;
    }

    public String getMaDangKy() {
        return MaDangKy;
    }

    public void setMaDangKy(String MaDangKy) {
        this.MaDangKy = MaDangKy;
    }

    public String getHoTen() {
        return HoTen;
    }

    public void setHoTen(String HoTen) {
        this.HoTen = HoTen;
    }

    public String getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(String NgaySinh) {
        this.NgaySinh = NgaySinh;
    }

    public int getGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(int GioiTinh) {
        this.GioiTinh = GioiTinh;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getCCCD() {
        return CCCD;
    }

    public void setCCCD(String CCCD) {
        this.CCCD = CCCD;
    }

    public String getSoTheBHYT() {
        return SoTheBHYT;
    }

    public void setSoTheBHYT(String SoTheBHYT) {
        this.SoTheBHYT = SoTheBHYT;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public String getMaTP() {
        return MaTP;
    }

    public void setMaTP(String MaTP) {
        this.MaTP = MaTP;
    }

    public String getMaQuan() {
        return MaQuan;
    }

    public void setMaQuan(String MaQuan) {
        this.MaQuan = MaQuan;
    }
}