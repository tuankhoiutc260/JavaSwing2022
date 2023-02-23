/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import java.sql.*;
import java.sql.DriverManager;


/**
 *
 * @author TuanKhoi
 */
public class DataConnection {

    public static Connection openConnection() throws Exception{
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String connectionUrl = "jdbc:sqlserver://localhost;database=DEMO_JAVA_2022:";
        String userName = "sa";
        String passwork = "123";
        Connection con = DriverManager.getConnection(connectionUrl, userName, passwork);
        
        return con;
    }
}
