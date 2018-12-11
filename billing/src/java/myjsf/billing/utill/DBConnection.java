/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myjsf.billing.utill;

import java.sql.Connection;
import java.sql.DriverManager;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ADMIN
 */
public class DBConnection {
 
    public static Connection getConnection()
    {
        Connection conn=null;
        try {
            String dbURL = "jdbc:sqlserver://localhost:1433;instanceName=MSSQLSERVER;databaseName=Billing;user=sa;password=sa@123";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(dbURL);
            if(conn!=null)
            {
                System.out.println("Connection Successfull");
                return conn;
            }
            else
            {
                System.out.println("Connection failed");
                return conn;
            }
        } catch (Exception ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conn;
    }
}
