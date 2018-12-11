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
import javax.faces.bean.ManagedBean;
import myjsf.billing.bean.Product;
import myjsf.billing.utill.DBConnection;

/**
 *
 * @author ADMIN
 */
@ManagedBean(name = "productdao")
public class ProductDAO {
   // Product plist=new Product();
  public List<Product> plist=new ArrayList<Product>();
    
    int prodid;
    String pname;
    int price;
    int discount;
    String category;
public ProductDAO()
{
    
}
    public ProductDAO(int prodid, String pname, int price, int discount, String category) {
        this.prodid = prodid;
        this.pname = pname;
        this.price = price;
        this.discount = discount;
        this.category = category;
    }
     
    public List<Product> listProduct()
    {
        
        try {
            
            Connection conn=DBConnection.getConnection();
            String query="select * from Product";
            Statement stmt=conn.createStatement();
            ResultSet rs=stmt.executeQuery(query);
            while(rs.next())
            {
                Product p=new Product();
                p.setProductID(rs.getInt(1));
                p.setProductName(rs.getString(2));
                p.setPrice(rs.getInt(3));
                p.setDiscount(rs.getInt(4));
                p.setCategory(rs.getString(5));
             
             plist.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return plist;
    }
    
    public String addProduct()
    {
        
        System.out.println("Haiiiii"+prodid);
        Connection conn=DBConnection.getConnection();
        String query="insert into Product values("+prodid+",'"+pname+"',"+price+","+discount+","+"'"+category+"'"+")";
        System.out.println("query : "+query);
        try {
            Statement stmt=conn.createStatement();
            int values=stmt.executeUpdate(query);
            if(values>0)
            {
                return "record inserted successfully";
            }
            else
            {
                return "error occured";
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "record inserted successfully";
    }
}
