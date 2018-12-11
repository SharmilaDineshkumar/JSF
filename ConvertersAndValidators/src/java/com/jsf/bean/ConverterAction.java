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
public class ConverterAction {

    /**
     * Creates a new instance of ConverterAction
     */
    
    int amount;

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
    public ConverterAction() {
    
    }
    
}
