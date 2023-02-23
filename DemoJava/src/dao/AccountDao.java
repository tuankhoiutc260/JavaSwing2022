/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import Model.Account;
import helper.DatabaseHelper;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
/**
 *
 * @author TuanKhoi
 */
public class AccountDao {
    public Account checkLogin(String UserName, String Password)
    throws Exception{       
        String sql = "Select UserName, [Password] from Account Where UserName = ? and Password = ?";
        try(
                Connection con = DatabaseHelper.openConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);
                ){
            pstmt.setString(1, UserName);
            pstmt.setString(2, Password);
            
            try(ResultSet rs = pstmt.executeQuery();){
                if(rs.next()){
                    Account ac = new Account();
                    ac.setUserName(UserName);

                    return ac;                            
                }
            }
        }
        return null;            
        
    }
}
