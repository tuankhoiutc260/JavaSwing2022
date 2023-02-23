/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import helper.DatabaseHelper;
import java.sql.Connection;
import java.sql.PreparedStatement;
/**
 *
 * @author TuanKhoi
 */
public class ThongTinDKTiemDao {
        public boolean insertInf(Model.ThongTinDangKyTiem TTDK)throws Exception{
        String sql = "INSERT INTO ThongTinDangKyTiem(MaDangKy, MaVaccine,  NgayTiem, MaDD) "
                + "VALUES(?, ?, ?, ?)";
        try(
                Connection con = DatabaseHelper.openConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);
            ){
            pstmt.setString(1, TTDK.getMaDangKy());
            pstmt.setString(2, TTDK.getMaVaccine());
            pstmt.setString(3, TTDK.getNgayTiem());
            pstmt.setString(4, TTDK.getMaDD());
            
            return pstmt.executeUpdate() > 0;
            }
        }    
}
