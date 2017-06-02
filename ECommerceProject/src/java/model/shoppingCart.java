/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.*;

/**
 *
 * @author User
 */
public class shoppingCart {
    private ArrayList<pro> products;
    private double total;
    public shoppingCart() {
        products = new ArrayList<>();
        total = 0;
    }
    
    
    
    public void addProduct(pro product) {
        this.total += product.getPrice();
        this.products.add(product);
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public ArrayList<pro> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<pro> products) {
        this.products = products;
    }
    
 
    
    
}
