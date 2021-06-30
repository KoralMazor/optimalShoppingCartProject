package com.hit.dm;

import java.util.ArrayList;

public class CartObject {

    private ArrayList<Product>  products;
    private int totalPrice;
    private String buyingOptionAlgo;

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getBuyingOptionAlgo() {
        return buyingOptionAlgo;
    }

    public void setBuyingOptionAlgo(String buyingOptionAlgo) {
        this.buyingOptionAlgo = buyingOptionAlgo;
    }


}
