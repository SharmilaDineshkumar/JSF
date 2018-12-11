/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jsf.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author ADMIN
 */
@ManagedBean
@RequestScoped
public class PaymentDetails {

    /**
     * Creates a new instance of PaymentDetails
     */
    long cardNo;

    public long getCardNo() {
        return cardNo;
    }

    public void setCardNo(long cardNo) {
        this.cardNo = cardNo;
    }
    int cvc;
    float amount;
    String cardholder;
    String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
    public String getCardholder() {
        return cardholder;
    }

    public void setCardholder(String cardholder) {
        this.cardholder = cardholder;
    }

   

    public int getCvc() {
        return cvc;
    }

    public void setCvc(int cvc) {
        this.cvc = cvc;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }
        public String showDetails()
        {
            
            message="Hi "+cardholder+","+"\n"+"Your card number : "+cardNo+"\n"+"Your cvc code : "+cvc+"\n"+
                    "Entered amount : $"+amount;
            return "paymentoutput.xhtml";
        }
        public PaymentDetails() {
    }
    
}
