/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myjsf.billing.bean;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Named;
import myjsf.billing.dao.ProductDAO;

/**
 *
 * @author ADMIN
 */
//@Named("product")
@ManagedBean
@RequestScoped
public class Product {

    /**
     * Creates a new instance of ProductList
     */
    int productID;
    String productName;
    int price;
    int discount;
    String Category;

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String Category) {
        this.Category = Category;
    }
    public void addProduct()
    {
        ProductDAO prod=new ProductDAO(productID,productName,price,discount,Category);
        String message=prod.addProduct();
        System.out.println("prod id : "+productID);
        System.out.println("prod name : "+productName);
        System.out.println("price : "+price);
        System.out.println(message);
    }
  //  public static List<Product> plist=ProductDAO.listProduct();
   /* public Product(int prodid, String pname, int price, int discount, String category) {
        productID=prodid;
        productName=pname;
        this.price=price;
        this.discount=discount;
        this.Category=category;
    }*/
    public Product()
    {
        
    }
    
}
