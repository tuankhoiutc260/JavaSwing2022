
package dao;

import Model.ThanhPho;
import Model.Vaccine;
import helper.DatabaseHelper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
public class VacineDao {
    public Vaccine findByID(String MaVaccine) throws Exception{
        String sql = "select * from Vaccine where MaVaccine =?";
        try(
            Connection con = DatabaseHelper.openConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
            ){
            pstmt.setString(1, MaVaccine);
            try(ResultSet rs = pstmt.executeQuery();){
               
                if (rs.next()){
                    Vaccine VC = new Vaccine();
                    VC.setMaVaccine(rs.getString("MaVaccine"));
                    VC.setTenVaccine(rs.getNString("TenVaccine"));
                    return VC;
                }
            }
            return null;
        }
    }
    
    public List<Vaccine> findAll() throws Exception{
        String sql = "select * from Vaccine";
        try(
            Connection con = DatabaseHelper.openConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
            ){
            try(ResultSet rs = pstmt.executeQuery();){
                List<Vaccine> list = new ArrayList<>();
                while (rs.next()){
                    Vaccine VC = new Vaccine();
                    VC.setMaVaccine(rs.getString("MaVaccine"));
                    VC.setTenVaccine(rs.getNString("TenVaccine"));
                    list.add(VC);
                }
                return list;
            }
        }
    }
    
        public boolean insertInfVaccine(Model.Vaccine VC)throws Exception{
          String sql = "insert into Vaccine values(?, ?)";
          try(
                  Connection con = DatabaseHelper.openConnection();
                  PreparedStatement pstmt = con.prepareStatement(sql);
              ){
              pstmt.setString(1, VC.getMaVaccine());
              pstmt.setString(2, VC.getTenVaccine());

              return pstmt.executeUpdate() > 0;  
          }
        }

    public Vaccine findByName(String TenVaccine) throws Exception{
        String sql = "select * from Vaccine where TenVaccine =?";
        try(
            Connection con = DatabaseHelper.openConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
            ){
            pstmt.setNString(1, TenVaccine);
            try(ResultSet rs = pstmt.executeQuery();){
               
                if (rs.next()){
                    Vaccine vc = new Vaccine();
                    vc.setMaVaccine(rs.getString("MaVaccine"));
                    vc.setTenVaccine(rs.getNString("TenVaccine"));
                    return vc;
                }
            }
            return null;
        }
    }        
        
        public boolean updateInfVaccine(Model.Vaccine VC)throws Exception{
        String sql = "update Vaccine set TenVaccine = ? where MaVaccine = ?";
        try(
                Connection con = DatabaseHelper.openConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);
            ){
            pstmt.setString(2, VC.getMaVaccine());
            pstmt.setString(1, VC.getTenVaccine());
    
            return pstmt.executeUpdate() > 0;  
        }
        }
        
        public boolean DeleteInfVaccine(String VC)throws Exception{
          String sql = "delete from Vaccine where MaVaccine = ?";
          try(
                  Connection con = DatabaseHelper.openConnection();
                  PreparedStatement pstmt = con.prepareStatement(sql);
              ){
              pstmt.setString(1, VC);

              return pstmt.executeUpdate() > 0;  
          }
        }
}
