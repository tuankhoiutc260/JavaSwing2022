/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package helper;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author TuanKhoi
 */
public class DatabaseHelper {
     public static Connection openConnection() throws Exception{
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String connectionUrl = "jdbc:sqlserver://localhost;database=DEMO_JAVA_2022;";
        String userName = "sa";
        String password = "123";
        Connection con = DriverManager.getConnection(connectionUrl, userName, password);
        
        return con;
    }
}
