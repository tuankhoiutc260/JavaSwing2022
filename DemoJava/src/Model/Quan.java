/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author TuanKhoi
 */
public class Quan {
    private String MaTP;
    private String MaQuan;
    private String TenQuan;

    public String getTenTP() {
        return TenTP;
    }

    public void setTenTP(String TenTP) {
        this.TenTP = TenTP;
    }
    private String TenTP;
    

//    public Quan(String MaTP, String MaQuan, String TenQuan) {
//        this.MaTP = MaTP;
//        this.MaQuan = MaQuan;
//        this.TenQuan = TenQuan;
//    }
    
        public Quan(String MaTP, String MaQuan, String TenQuan, String TenTP) {
        this.MaTP = MaTP;
        this.MaQuan = MaQuan;
        this.TenQuan = TenQuan;
        this.TenTP = TenTP;
    }
    
    

    public Quan() {
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

    public String getTenQuan() {
        return TenQuan;
    }

    public void setTenQuan(String TenQuan) {
        this.TenQuan = TenQuan;
    }
}


