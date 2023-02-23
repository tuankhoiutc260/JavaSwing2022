/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import Model.ThongTinCaNhan;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author TuanKhoi
 */
import helper.DatabaseHelper;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
public class ThongTinCaNhanDAO {
    
//        public boolean insertInfDistrict(Quan Q)throws Exception{
//          String sql = "insert into Quan values(?, ?, ?)";
//          try(
//                  Connection con = DatabaseHelper.openConnection();
//                  PreparedStatement pstmt = con.prepareStatement(sql);
//              ){
//              pstmt.setString(3, Q.getMaTP());
//              pstmt.setString(1, Q.getMaQuan());
//              pstmt.setString(2, Q.getTenQuan());
//
//              return pstmt.executeUpdate() > 0;  
//          }
//        }    
    
        public boolean insertInf(Model.ThongTinCaNhan TTCN)throws Exception{
        String sql = "INSERT INTO ThongTinCaNhan(HoTen, NgaySinh,  GioiTinh, SDT, CCCD, SoTheBHYT, DiaChi, MaTP,  MaQuan) "
                + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try(
                Connection con = DatabaseHelper.openConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);
            ){
            pstmt.setString(1, TTCN.getHoTen());
            pstmt.setString(2, TTCN.getNgaySinh());
            pstmt.setInt(3, TTCN.getGioiTinh());
            pstmt.setString(4, TTCN.getSDT());
            pstmt.setString(5, TTCN.getCCCD());
            pstmt.setString(6, TTCN.getSoTheBHYT());
            pstmt.setString(7, TTCN.getDiaChi());
            pstmt.setString(8, TTCN.getMaTP());
            pstmt.setString(9, TTCN.getMaQuan());
            
            return pstmt.executeUpdate() > 0;
            }
        }
        
 public List<ThongTinCaNhan> getMaDK() throws Exception{
//        String sql = "select maquan, tenquan, tentp from quan, thanhpho where thanhpho.matp = quan.matp";
        String sql = "select top 1 madangky from thongtincanhan order by madangky desc";

        try(
            Connection con = DatabaseHelper.openConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
            ){
            try(ResultSet rs = pstmt.executeQuery();){
                List<ThongTinCaNhan> list = new ArrayList<>();
                while (rs.next()){
                    //JTable tb = new JTable();
                    ThongTinCaNhan TTCN = new ThongTinCaNhan();
                   // Q.setMaTP(rs.getString("MaTP"));
                    TTCN.setMaDangKy(rs.getString("madangky"));
                    //ThanhPho TP = new ThanhPho();
                    //TP.setTenTP(rs.getNString("TenTP"));
                    list.add(TTCN);
                    //list.add(TP);
                }
                return list;
            }
        }
    }
 
 public List<ThongTinCaNhan> findAll() throws Exception{
        String sql = "select MaDangKy, HoTen, NgaySinh, GioiTinh, SDT, CCCD, SoTheBHYT, DiaChi from ThongTinCaNhan";

        try(
            Connection con = DatabaseHelper.openConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
            ){
            try(ResultSet rs = pstmt.executeQuery();){
                List<ThongTinCaNhan> list = new ArrayList<>();
                while (rs.next()){
                    
                    ThongTinCaNhan ttcn = new ThongTinCaNhan();
                   
                    ttcn.setMaDangKy(rs.getString("MaDangKy"));
                    ttcn.setHoTen(rs.getNString("HoTen"));
                    ttcn.setNgaySinh(rs.getString("NgaySinh"));
                    ttcn.setGioiTinh(rs.getInt("GioiTinh"));
                    ttcn.setSDT(rs.getString("SDT"));
                    ttcn.setCCCD(rs.getString("CCCD"));
                    ttcn.setSoTheBHYT(rs.getString("SoTheBHYT"));
                    ttcn.setDiaChi(rs.getString("DiaChi"));
                    
                    list.add(ttcn);
                }
                return list;
            }
        }
    }
        
//    public String getMaDK() throws Exception{
//        String sql = "select top 1 madangky from thongtincanhan order by madangky desc";
//        try(
//            Connection con = DatabaseHelper.openConnection();
//            PreparedStatement pstmt = con.prepareStatement(sql);
//            ){
//            String MaDK = null;
//            try(ResultSet rs = pstmt.executeQuery();){
//               
//                while (rs.next()){
//                    MaDK = rs.getString("madangky");
//                }
//                return MaDK;
//            }
//        }
//    }
    }
   
//    public Model.ThongTinCaNhan getInf(String MaDangKy, String HoTen, Date NgaySinh, int GioiTinh, String SDT, String CCCD, String SoTheBHYT, String DiaChi, String MaTP, String MaQuan){
//        Model.ThongTinCaNhan TTCN = null;
//        try{
//            String sql = "SELECT * FROM ThongTinCaNhan";
//            PreparedStatement pre = 
//        }
//        return TTCN;
//    }
    
  

