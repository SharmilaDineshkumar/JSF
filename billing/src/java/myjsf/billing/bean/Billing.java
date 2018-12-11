/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myjsf.billing.bean;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.swing.text.html.HTMLDocument;
import myjsf.billing.dao.BillingDAO;

/**
 *
 * @author ADMIN
 */
@ManagedBean
@RequestScoped
public class Billing {

    /**
     * Creates a new instance of Billing
     */
    int productID;
    String productName;
    int price;
    int discount;
    int qty;

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }
    String Category;
    int tax;
    int total;

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

    public int getTax() {
        return tax;
    }

    public void setTax(int tax) {
        this.tax = tax;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
    public List<Billing> showDetails()
    {
        System.out.println("coming inside show details");
        List<Billing> blist=new ArrayList<Billing>();
        BillingDAO bdao=new BillingDAO();
        blist=bdao.listDetails(productName);
        System.out.println("blist.isEmpty() : "+blist.isEmpty());
        if(blist.isEmpty()!=true)
        {
            System.out.println("list is not empty");
            Iterator itr=blist.iterator();  
            while(itr.hasNext()){  
    Billing bl=(Billing)itr.next(); 
    this.productID=bl.productID;
    this.productName=bl.productName;
    this.price=bl.price;
    this.discount=bl.discount;
    this.Category=bl.Category;
            }
            
        }
        return blist;
    }
    public List<String> getProducts()
    {
        List<String> blist=new ArrayList<String>();
        BillingDAO bdao=new BillingDAO();
        blist=bdao.listProductName();
        return blist;
    }
    public Billing() {
    }
    
}
