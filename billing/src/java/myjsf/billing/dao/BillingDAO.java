/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myjsf.billing.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import myjsf.billing.bean.Billing;
import myjsf.billing.bean.Product;
import myjsf.billing.utill.DBConnection;

/**
 *
 * @author ADMIN
 */
public class BillingDAO {
    
    int prodid;
    String pname;
    int price;
    int discount;
    String category;
    
     public List<Billing> listDetails(String prodname)
    {
        List<Billing> blist=new ArrayList<Billing>();
        
        try {
            
            Connection conn=DBConnection.getConnection();
            String query="select * from Product where prodname='"+prodname+"'";
            System.out.println("query : "+query);
            Statement stmt=conn.createStatement();
            ResultSet rs=stmt.executeQuery(query);
            
            while(rs.next())
            {System.out.println("rs has elements");
                Billing p=new Billing();
                p.setProductID(rs.getInt(1));
                p.setProductName(rs.getString(2));
                p.setPrice(rs.getInt(3));
                p.setDiscount(rs.getInt(4));
                p.setCategory(rs.getString(5));
             
             blist.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return blist;
    }

    /**
     *
     * @return
     */
    public List<String> listProductName()
    {
        List<String> blist=new ArrayList<>();
        try
        {
        Connection conn=DBConnection.getConnection();
            String query="select * from Product";
            Statement stmt=conn.createStatement();
            ResultSet rs=stmt.executeQuery(query);
            while(rs.next())
            {       
                String p=rs.getString("prodname");
             blist.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return blist;
    }
}
