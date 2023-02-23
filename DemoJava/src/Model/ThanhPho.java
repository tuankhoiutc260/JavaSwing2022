/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author TuanKhoi
 */
public class ThanhPho {
    private String MaTP;
    private String TenTP;

    public ThanhPho(String MaTP, String TenTP) {
        this.MaTP = MaTP;
        this.TenTP = TenTP;
    }

    public ThanhPho() {
    }

    @Override
    public String toString() {
        return "ThanhPho{" + "MaTP=" + MaTP + ", TenTP=" + TenTP + '}';
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
}
