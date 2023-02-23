package dao;

import Model.DiaDiemTiem;

import helper.DatabaseHelper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author TuanKhoi
 */
public class DiaDiemTiemDao {
    public DiaDiemTiem findByID(String MaDD) throws Exception{
        String sql = "select * from DiaDiemTiem where MaDD =?";
        try(
            Connection con = DatabaseHelper.openConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
            ){
            pstmt.setString(1, MaDD);
            try(ResultSet rs = pstmt.executeQuery();){
               
                if (rs.next()){
                    DiaDiemTiem ddt = new DiaDiemTiem();
                    ddt.setMaDD(rs.getString("MaDD"));
                    ddt.setTenDD(rs.getNString("TenDD"));
                    return ddt;
                }
            }
            return null;
        }
    }
    
    
    public DiaDiemTiem findByName(String TenDD) throws Exception{
        String sql = "select * from DiaDiemTiem where TenDD =?";
        try(
            Connection con = DatabaseHelper.openConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
            ){
            pstmt.setNString(1, TenDD);
            try(ResultSet rs = pstmt.executeQuery();){
               
                if (rs.next()){
                    DiaDiemTiem ddt = new DiaDiemTiem();
                    ddt.setMaDD(rs.getString("MaDD"));
                    ddt.setTenDD(rs.getNString("TenDD"));
                    return ddt;
                }
            }
            return null;
        }
    }
    
    public List<DiaDiemTiem> findByQuanCode(String MaQuan) throws Exception{
        String sql = "select * from DiaDiemTiem where MaQuan =?";
        try(
            Connection con = DatabaseHelper.openConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
            ){
            pstmt.setNString(1, MaQuan);
            try(ResultSet rs = pstmt.executeQuery();){
                List<DiaDiemTiem> list = new ArrayList<>();
                while (rs.next()){
                    //JTable tb = new JTable();
                    DiaDiemTiem ddt = new DiaDiemTiem();
                   // Q.setMaTP(rs.getString("MaTP"));
                    ddt.setMaDD(rs.getString("MaDD"));
                    ddt.setTenDD(rs.getNString("TenDD"));
                    //ThanhPho TP = new ThanhPho();
                    //TP.setTenTP(rs.getNString("TenTP"));
                    list.add(ddt);
                    //list.add(TP);
                }
                return list;
            }
        }
    }
    
    public List<DiaDiemTiem> findByVaccineCode(String MaVaccine) throws Exception{
        String sql = "select * from DiaDiemTiem where MaQuan =?";
        try(
            Connection con = DatabaseHelper.openConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
            ){
            pstmt.setNString(1, MaVaccine);
            try(ResultSet rs = pstmt.executeQuery();){
                List<DiaDiemTiem> list = new ArrayList<>();
                while (rs.next()){
                    //JTable tb = new JTable();
                    DiaDiemTiem ddt = new DiaDiemTiem();
                   // Q.setMaTP(rs.getString("MaTP"));
                    ddt.setMaDD(rs.getString("MaDD"));
                    ddt.setTenDD(rs.getNString("TenDD"));
                    //ThanhPho TP = new ThanhPho();
                    //TP.setTenTP(rs.getNString("TenTP"));
                    list.add(ddt);
                    //list.add(TP);
                }
                return list;
            }
        }
    }
    
    public List<DiaDiemTiem> findByCityCode(String MaTP) throws Exception{
        String sql = "select * from DiaDiemTiem where MaTP =?";
        try(
            Connection con = DatabaseHelper.openConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
            ){
            pstmt.setNString(1, MaTP);
            try(ResultSet rs = pstmt.executeQuery();){
                List<DiaDiemTiem> list = new ArrayList<>();
                while (rs.next()){
                    //JTable tb = new JTable();
                    DiaDiemTiem ddt = new DiaDiemTiem();
                   // Q.setMaTP(rs.getString("MaTP"));
                    ddt.setMaDD(rs.getString("MaDD"));
                    ddt.setTenDD(rs.getNString("TenDD"));
                    //ThanhPho TP = new ThanhPho();
                    //TP.setTenTP(rs.getNString("TenTP"));
                    list.add(ddt);
                    //list.add(TP);
                }
                return list;
            }
        }
    }
    
   
    
 public List<DiaDiemTiem> findAll() throws Exception{
        String sql = "select MaDD, TenDD, Quan.TenQuan, ThanhPho.TenTP, Vaccine.TenVaccine from diadiemtiem, quan,thanhpho, vaccine where quan.MaQuan = diadiemtiem.MaQuan and thanhpho.MaTP = diadiemtiem.MaTP and vaccine.MaVaccine = diadiemtiem.MaVaccine";

        try(
            Connection con = DatabaseHelper.openConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
            ){
            try(ResultSet rs = pstmt.executeQuery();){
                List<DiaDiemTiem> list = new ArrayList<>();
                while (rs.next()){
                    //JTable tb = new JTable();
                    DiaDiemTiem ddt = new DiaDiemTiem();
                   // Q.setMaTP(rs.getString("MaTP"));
                    ddt.setMaDD(rs.getString("MaDD"));
                    ddt.setTenDD(rs.getNString("TenDD"));
                    ddt.setTenQuan(rs.getString("TenQuan"));
                    ddt.setTenTP(rs.getNString("TenTP"));
                    ddt.setTenVaccine(rs.getNString("TenVaccine"));
                    //ThanhPho TP = new ThanhPho();
                    //TP.setTenTP(rs.getNString("TenTP"));
                    list.add(ddt);
                    //list.add(TP);
                }
                return list;
            }
        }
    }

        public boolean insertInfDDTiem(DiaDiemTiem ddt)throws Exception{
          String sql = "insert into DiaDiemTiem values(?, ?, ?, ?, ?)";
          try(
                  Connection con = DatabaseHelper.openConnection();
                  PreparedStatement pstmt = con.prepareStatement(sql);
              ){
              pstmt.setString(5, ddt.getMaQuan());
              pstmt.setString(1, ddt.getMaDD());
              pstmt.setString(2, ddt.getTenDD());
              pstmt.setString(4, ddt.getMaTP());
              pstmt.setString(3, ddt.getMaVaccine());
              
              return pstmt.executeUpdate() > 0;  
          }
        }
      
        public boolean updateInfDDTiem(DiaDiemTiem ddt)throws Exception{
        String sql = "update DiaDiemTiem set TenDD = ? where MaDD = ?";
        try(
                Connection con = DatabaseHelper.openConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);
            ){
            pstmt.setString(2, ddt.getMaDD());
            pstmt.setString(1, ddt.getTenDD());
    
            return pstmt.executeUpdate() > 0;  
        }
        }
        
        public boolean DeleteInfDDTiem(String ddt)throws Exception{
          String sql = "delete from DiaDiemTiem where MaDD = ?";
          try(
                  Connection con = DatabaseHelper.openConnection();
                  PreparedStatement pstmt = con.prepareStatement(sql);
              ){
              pstmt.setString(1, ddt);

              return pstmt.executeUpdate() > 0;  
          }
        }
}