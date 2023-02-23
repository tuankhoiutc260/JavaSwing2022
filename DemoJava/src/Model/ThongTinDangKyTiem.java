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
public class ThongTinDangKyTiem {
    private String MaDangKy;
    private String MaVaccine;
    private String NgayTiem;
    private String MaDD;
    private String TrangThaiDangKy;
    private String TrangThaiTiem;

    public ThongTinDangKyTiem(String MaDangKy, String MaVaccine, String NgayTiem, String MaDD, String TrangThaiDangKy, String TrangThaiTiem) {
        this.MaDangKy = MaDangKy;
        this.MaVaccine = MaVaccine;
        this.NgayTiem = NgayTiem;
        this.MaDD = MaDD;
        this.TrangThaiDangKy = TrangThaiDangKy;
        this.TrangThaiTiem = TrangThaiTiem;
    }

    public ThongTinDangKyTiem() {
    }

    @Override
    public String toString() {
        return "ThongTinDangKyTiem{" + "MaDangKy=" + MaDangKy + ", MaVaccine=" + MaVaccine + ", NgayTiem=" + NgayTiem + ", MaDD=" + MaDD + ", TrangThaiDangKy=" + TrangThaiDangKy + ", TrangThaiTiem=" + TrangThaiTiem + '}';
    }

    public String getMaDangKy() {
        return MaDangKy;
    }

    public void setMaDangKy(String MaDangKy) {
        this.MaDangKy = MaDangKy;
    }

    public String getMaVaccine() {
        return MaVaccine;
    }

    public void setMaVaccine(String MaVaccine) {
        this.MaVaccine = MaVaccine;
    }

    public String getNgayTiem() {
        return NgayTiem;
    }

    public void setNgayTiem(String NgayTiem) {
        this.NgayTiem = NgayTiem;
    }

    public String getMaDD() {
        return MaDD;
    }

    public void setMaDD(String MaDD) {
        this.MaDD = MaDD;
    }

    public String getTrangThaiDangKy() {
        return TrangThaiDangKy;
    }

    public void setTrangThaiDangKy(String TrangThaiDangKy) {
        this.TrangThaiDangKy = TrangThaiDangKy;
    }

    public String getTrangThaiTiem() {
        return TrangThaiTiem;
    }

    public void setTrangThaiTiem(String TrangThaiTiem) {
        this.TrangThaiTiem = TrangThaiTiem;
    }
}
