/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author TuanKhoi
 */
public class Vaccine {
    private String MaVaccine;
    private String TenVaccine;

    public Vaccine(String MaVaccine, String TenVaccine) {
        this.MaVaccine = MaVaccine;
        this.TenVaccine = TenVaccine;
    }

    public Vaccine() {
    }

    @Override
    public String toString() {
        return "Vaccine{" + "MaVaccine=" + MaVaccine + ", TenVaccine=" + TenVaccine + '}';
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
}
