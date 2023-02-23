/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import Model.Search;
import helper.DatabaseHelper;
import java.sql.Connection;
import java.sql.PreparedStatement;import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author TuanKhoi
 */
public class SearchDao {
    public List<Search> findAll(Search S) throws Exception{
        String sql = """
                     SELECT ThongTinDangKyTiem.MaDangKy, HoTen, NgaySinh, GioiTinh, SDT, CCCD, SoTheBHYT, DiaChi, TenVaccine, NgayTiem, TenDD
                     FROM dbo.ThongTinCaNhan, dbo.ThongTinDangKyTiem, dbo.Vaccine, dbo.DiaDiemTiem
                     WHERE ThongTinCaNhan.MaDangKy = ThongTinDangKyTiem.MaDangKy
                     \tAND ThongTinDangKyTiem.MaVaccine = Vaccine.MaVaccine
                     \tAND DiaDiemTiem.MaDD = ThongTinDangKyTiem.MaDD
                     \tAND HoTen = ? and NgaySinh = ?""";
        try(
            Connection con = DatabaseHelper.openConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
            ){
            pstmt.setString(1, S.getHoTen()); 
            pstmt.setString(2, S.getNgaySinh()); 
            try(ResultSet rs = pstmt.executeQuery();){
                List<Search> list = new ArrayList<>();
                while (rs.next()){
                    Search s = new Search();
                    s.setMaDK(rs.getString("MaDangKy"));
                    s.setHoTen(rs.getNString("HoTen"));
                    s.setNgaySinh(rs.getString("NgaySinh"));
                    s.setGioiTinh(rs.getInt("GioiTinh"));
                    s.setSDT(rs.getString("SDT"));
                    s.setCCCD(rs.getString("CCCD")); 
                    s.setSoTheBHYT(rs.getString("SoTheBHYT"));
                    s.setDiaChi(rs.getString("DiaChi"));
                    s.setTenVaccine(rs.getString("TenVaccine"));
                    s.setNgayTiem(rs.getString("NgayTiem"));
                    s.setTenDD(rs.getNString("TenDD")); 
                    list.add(s);
                }
                return list;
            }
        }
    }    
}

//public Search findAll(String HoTen, String NgaySinh) throws Exception{
//        String sql = """
//                     SELECT ThongTinDangKyTiem.MaDangKy, HoTen, NgaySinh, GioiTinh, SDT, CCCD, SoTheBHYT, DiaChi, TenVaccine, NgayTiem, TenDD
//                     FROM dbo.ThongTinCaNhan, dbo.ThongTinDangKyTiem, dbo.Vaccine, dbo.DiaDiemTiem
//                     WHERE ThongTinCaNhan.MaDangKy = ThongTinDangKyTiem.MaDangKy
//                     AND ThongTinDangKyTiem.MaVaccine = Vaccine.MaVaccine
//                     AND DiaDiemTiem.MaDD = ThongTinDangKyTiem.MaDD
//                     AND HoTen = ? and NgaySinh = ?""";
//        try(
//            Connection con = DatabaseHelper.openConnection();
//            PreparedStatement pstmt = con.prepareStatement(sql);
//            ){
//            pstmt.setString(1, HoTen);
//            pstmt.setString(2, NgaySinh);            
//            try(ResultSet rs = pstmt.executeQuery();){
//               
//                if (rs.next()){
//                    Search s = new Search();
//                    s.setMaDK(rs.getString("MaDangKy"));
//                    s.setHoTen(rs.getNString("HoTen"));
//                    s.setNgaySinh(rs.getString("NgaySinh"));
//                    s.setGioiTinh(rs.getInt("GioiTinh"));
//                    s.setSDT(rs.getString("SDT"));
//                    s.setCCCD(rs.getString("CCCD")); 
//                    s.setSoTheBHYT(rs.getString("SoTheBHYT"));
//                    s.setDiaChi(rs.getString("DiaChi"));
//                    s.setTenVaccine(rs.getString("TenVaccine"));
//                    s.setNgayTiem(rs.getString("NgayTiem"));
//                    s.setTenDD(rs.getNString("TenDD")); 
//                    return s;
//                }
//            }
//            return null;
//        }
//}


