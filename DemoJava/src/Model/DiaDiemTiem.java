/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author TuanKhoi
 */
public class DiaDiemTiem {
    private String MaDD;
    private String TenDD;
    private String MaVaccine;
    private String TenVaccine;
    private String MaTP;
    private String TenTP;
    private String MaQuan;
    private String TenQuan;

    public DiaDiemTiem(String MaDD, String TenDD, String MaVaccine, String TenVaccine, String MaTP, String TenTP, String MaQuan, String TenQuan) {
        this.MaDD = MaDD;
        this.TenDD = TenDD;
        this.MaVaccine = MaVaccine;
        this.TenVaccine = TenVaccine;
        this.MaTP = MaTP;
        this.TenTP = TenTP;
        this.MaQuan = MaQuan;
        this.TenQuan = TenQuan;
    }

    public DiaDiemTiem() {
    }

    public String getMaDD() {
        return MaDD;
    }

    public void setMaDD(String MaDD) {
        this.MaDD = MaDD;
    }

    public String getTenDD() {
        return TenDD;
    }

    public void setTenDD(String TenDD) {
        this.TenDD = TenDD;
    }

    public String getMaVaccine() {
        return MaVaccine;
    }

    public void setMaVaccine(String MaVaccine) {
        this.MaVaccine = MaVaccine;
    }

    public String getTenVaccine() {
        return TenVaccine;
    }

    public void setTenVaccine(String TenVaccine) {
        this.TenVaccine = TenVaccine;
    }

    public String getMaTP() {
        return MaTP;
    }

    public void setMaTP(String MaTP) {
        this.MaTP = MaTP;
    }

    public String getTenTP() {
        return TenTP;
    }

    public void setTenTP(String TenTP) {
        this.TenTP = TenTP;
    }

    public String getMaQuan() {
        return MaQuan;
    }

    public void setMaQuan(String MaQuan) {
        this.MaQuan = MaQuan;
    }

    public String getTenQuan() {
        return TenQuan;
    }

    public void setTenQuan(String TenQuan) {
        this.TenQuan = TenQuan;
    }
    
    

}