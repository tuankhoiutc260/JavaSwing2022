/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author TuanKhoi
 */
public class ThongTinTiemChung {
    private String MaDangKy;
    private String MaVaccine;

    public ThongTinTiemChung(String MaDangKy, String MaVaccine) {
        this.MaDangKy = MaDangKy;
        this.MaVaccine = MaVaccine;
    }

    public ThongTinTiemChung() {
    }

    @Override
    public String toString() {
        return "ThongTinTiemChung{" + "MaDangKy=" + MaDangKy + ", MaVaccine=" + MaVaccine + '}';
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
}
