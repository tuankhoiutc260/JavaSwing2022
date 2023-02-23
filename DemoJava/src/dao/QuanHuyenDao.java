/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import Model.Quan;
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
public class QuanHuyenDao {
    public Quan findByID(String MaQuan) throws Exception{
        String sql = "select * from Quan where MaQuan =?";
        try(
            Connection con = DatabaseHelper.openConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
            ){
            pstmt.setString(1, MaQuan);
            try(ResultSet rs = pstmt.executeQuery();){
               
                if (rs.next()){
                    Quan Q = new Quan();
                    Q.setMaQuan(rs.getString("MaQuan"));
                    Q.setTenQuan(rs.getNString("TenQuan"));
                    return Q;
                }
            }
            return null;
        }
    }
    
    
    public Quan findByName(String TenQuan) throws Exception{
        String sql = "select * from Quan where TenQuan =?";
        try(
            Connection con = DatabaseHelper.openConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
            ){
            pstmt.setNString(1, TenQuan);
            try(ResultSet rs = pstmt.executeQuery();){
               
                if (rs.next()){
                    Quan Q = new Quan();
                    Q.setMaQuan(rs.getString("MaQuan"));
                    Q.setTenQuan(rs.getNString("TenQuan"));
                    return Q;
                }
            }
            return null;
        }
    }
    
    public List<Quan> findByCityCode(String MaTP) throws Exception{
        String sql = "select * from Quan where MaTP =?";
        try(
            Connection con = DatabaseHelper.openConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
            ){
            pstmt.setNString(1, MaTP);
            try(ResultSet rs = pstmt.executeQuery();){
                List<Quan> list = new ArrayList<>();
                while (rs.next()){
                    //JTable tb = new JTable();
                    Quan Q = new Quan();
                   // Q.setMaTP(rs.getString("MaTP"));
                    Q.setMaQuan(rs.getString("MaQuan"));
                    Q.setTenQuan(rs.getNString("TenQuan"));
                    //ThanhPho TP = new ThanhPho();
                    //TP.setTenTP(rs.getNString("TenTP"));
                    list.add(Q);
                    //list.add(TP);
                }
                return list;
            }
        }
    }
    
 public List<Quan> findAll() throws Exception{
//        String sql = "select maquan, tenquan, tentp from quan, thanhpho where thanhpho.matp = quan.matp";
        String sql = "select MaQuan, TenQuan, TenTP from quan, thanhpho where thanhpho.MaTP = quan.MaTP";

        try(
            Connection con = DatabaseHelper.openConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
            ){
            try(ResultSet rs = pstmt.executeQuery();){
                List<Quan> list = new ArrayList<>();
                while (rs.next()){
                    //JTable tb = new JTable();
                    Quan Q = new Quan();
                   // Q.setMaTP(rs.getString("MaTP"));
                    Q.setMaQuan(rs.getString("MaQuan"));
                    Q.setTenQuan(rs.getNString("TenQuan"));
                    Q.setTenTP(rs.getString("TenTP"));
                    //ThanhPho TP = new ThanhPho();
                    //TP.setTenTP(rs.getNString("TenTP"));
                    list.add(Q);
                    //list.add(TP);
                }
                return list;
            }
        }
    }
    
//    public void getDataQuan() throws Exception{
//        
//        String sql = "select maquan, tenquan, tentp from quan, thanhpho where thanhpho.matp = quan.matp";
//        try(
//            Connection con = DatabaseHelper.openConnection();
//            PreparedStatement pstmt = con.prepareStatement(sql);
//            ){
//            ResultSetM
//            try(ResultSet rs = pstmt.executeQuery();){
//                ResultSetMetaData stData = rs.getMetaData();
//                while (rs.next()){
//                    Vector columnData = new Vector();
//                    for(i = 1; i<=q)
//                    JTable tb = new JTable();
//                    Quan Q = new Quan();
//                    Q.setMaQuan(rs.getString("MaQuan"));
//                    Q.setTenQuan(rs.getNString("TenQuan"));
//                    Q.setMaTP(rs.getString("MaTP"));
//                    list.add(Q);
//                }
//                return list;
//            }
//        }
//    }
    
   
    
        public boolean insertInfDistrict(Quan Q)throws Exception{
          String sql = "insert into Quan values(?, ?, ?)";
          try(
                  Connection con = DatabaseHelper.openConnection();
                  PreparedStatement pstmt = con.prepareStatement(sql);
              ){
              pstmt.setString(3, Q.getMaTP());
              pstmt.setString(1, Q.getMaQuan());
              pstmt.setString(2, Q.getTenQuan());

              return pstmt.executeUpdate() > 0;  
          }
        }
      
        public boolean updateInfDictrict(Quan Q)throws Exception{
        String sql = "update Quan set TenQuan = ? where MaQuan = ?";
        try(
                Connection con = DatabaseHelper.openConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);
            ){
            pstmt.setString(2, Q.getMaQuan());
            pstmt.setString(1, Q.getTenQuan());
    
            return pstmt.executeUpdate() > 0;  
        }
        }
        
        public boolean DeleteInfDictrict(String Q)throws Exception{
          String sql = "delete from Quan where MaQuan = ?";
          try(
                  Connection con = DatabaseHelper.openConnection();
                  PreparedStatement pstmt = con.prepareStatement(sql);
              ){
              pstmt.setString(1, Q);

              return pstmt.executeUpdate() > 0;  
          }
        }
}
