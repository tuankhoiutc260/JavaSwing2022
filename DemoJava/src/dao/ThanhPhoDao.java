/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

/**
 *
 * @author TuanKhoi
 */
import Model.ThanhPho;
import helper.DatabaseHelper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
public class ThanhPhoDao {
    
    public ThanhPho findByID(String MaTP) throws Exception{
        String sql = "select * from ThanhPho where MaTP =?";
        try(
            Connection con = DatabaseHelper.openConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
            ){
            pstmt.setString(1, MaTP);
            try(ResultSet rs = pstmt.executeQuery();){
               
                if (rs.next()){
                    ThanhPho TP = new ThanhPho();
                    TP.setMaTP(rs.getString("MaTP"));
                    TP.setTenTP(rs.getNString("TenTP"));
                    return TP;
                }
            }
            return null;
        }
    }
    
    public ThanhPho findByName(String TenTP) throws Exception{
        String sql = "select * from ThanhPho where TenTP =?";
        try(
            Connection con = DatabaseHelper.openConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
            ){
            pstmt.setNString(1, TenTP);
            try(ResultSet rs = pstmt.executeQuery();){
               
                if (rs.next()){
                    ThanhPho TP = new ThanhPho();
                    TP.setMaTP(rs.getString("MaTP"));
                    TP.setTenTP(rs.getNString("TenTP"));
                    return TP;
                }
            }
            return null;
        }
    }
    
    public List<ThanhPho> findAll() throws Exception{
        String sql = "select * from ThanhPho";
        try(
            Connection con = DatabaseHelper.openConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
            ){
            try(ResultSet rs = pstmt.executeQuery();){
                List<ThanhPho> list = new ArrayList<>();
                while (rs.next()){
                    ThanhPho TP = new ThanhPho();
                    TP.setMaTP(rs.getString("MaTP"));
                    TP.setTenTP(rs.getNString("TenTP"));
                    list.add(TP);
                }
                return list;
            }
        }
    }
    //
//public class DisplayEmployeeList 
//{
//    public Object displayMember;
//    public Object valueMember;
//
//    public DisplayEmployeeList(Object display,Object value)
//    {
//        displayMember=display;
//        valueMember=value;
//    }
//
//    public String toString()
//    {
//        return displayMember.toString();
//    }
//} 
//
//public List<ThanhPho> findAll() throws Exception{
//        String sql = "select * from ThanhPho";
//        try(
//            Connection con = DatabaseHelper.openConnection();
//            PreparedStatement pstmt = con.prepareStatement(sql);
//            ){
//            try(ResultSet rs = pstmt.executeQuery();){
//                List<ThanhPho> list = new ArrayList<>();
//                while (rs.next()){
//                    ThanhPho TP = new ThanhPho();
//
//                    TP = new DisplayEmployeeList(list, sql);
//                }
//                return list;
//            }
//        }
//    }



//
    
        public boolean insertInfCity(Model.ThanhPho TP)throws Exception{
          String sql = "insert into ThanhPho values(?, ?)";
          try(
                  Connection con = DatabaseHelper.openConnection();
                  PreparedStatement pstmt = con.prepareStatement(sql);
              ){
              pstmt.setString(1, TP.getMaTP());
              pstmt.setString(2, TP.getTenTP());

              return pstmt.executeUpdate() > 0;  
          }
        }
      
        public boolean updateInfCity(Model.ThanhPho TP)throws Exception{
        String sql = "update ThanhPho set TenTP = ? where MaTP = ?";
        try(
                Connection con = DatabaseHelper.openConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);
            ){
            pstmt.setString(2, TP.getMaTP());
            pstmt.setString(1, TP.getTenTP());
    
            return pstmt.executeUpdate() > 0;  
        }
        }
        
        public boolean DeleteInfCity(String TP)throws Exception{
          String sql = "delete from ThanhPho where MaTP = ?";
          try(
                  Connection con = DatabaseHelper.openConnection();
                  PreparedStatement pstmt = con.prepareStatement(sql);
              ){
              pstmt.setString(1, TP);

              return pstmt.executeUpdate() > 0;  
          }
        }
}
