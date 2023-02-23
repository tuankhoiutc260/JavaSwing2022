/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author TuanKhoi
 */
public class Search {
    private String MaDK, HoTen, NgaySinh, SDT, CCCD, SoTheBHYT, DiaChi, TenVaccine, NgayTiem, TenDD;
    private int GioiTinh;

    public Search(String MaDK, String HoTen, String NgaySinh, String SDT, String CCCD, String SoTheBHYT, String DiaChi, String TenVaccine, String NgayTiem, String TenDD, int GioiTinh) {
        this.MaDK = MaDK; 
        this.HoTen = HoTen;
        this.NgaySinh = NgaySinh;
        this.SDT = SDT;
        this.CCCD = CCCD;
        this.SoTheBHYT = SoTheBHYT;
        this.DiaChi = DiaChi;
        this.TenVaccine = TenVaccine;
        this.NgayTiem = NgayTiem;
        this.TenDD = TenDD;
        this.GioiTinh = GioiTinh;
    }

    public Search() {
    }
    
   public String getMaDK() {
        return MaDK;
    }

    public void setMaDK(String MaDK) {
        this.MaDK = MaDK;
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

    public String getTenVaccine() {
        return TenVaccine;
    }

    public void setTenVaccine(String TenVaccine) {
        this.TenVaccine = TenVaccine;
    }

    public String getNgayTiem() {
        return NgayTiem;
    }

    public void setNgayTiem(String NgayTiem) {
        this.NgayTiem = NgayTiem;
    }

    public String getTenDD() {
        return TenDD;
    }

    public void setTenDD(String TenDD) {
        this.TenDD = TenDD;
    }

    public int getGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(int GioiTinh) {
        this.GioiTinh = GioiTinh;
    }
    
    
}
