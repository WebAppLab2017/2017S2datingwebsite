/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author User
 */
public class pro {
    private int ID_product;
    private String name;
    private Double price;
    private int quantity;
    private int buy;
    private String url;
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    
    public pro(int ID_product, String name, Double price, int quantity) {
        this.ID_product = ID_product;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public pro() {
    }

    public int getID_product() {
        return ID_product;
    }

    public void setID_product(int ID_product) {
        this.ID_product = ID_product;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBuy() {
        return buy;
    }

    public void setBuy(int buy) {
        this.buy = buy;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    
    
}
