package com.hit.dm;

import java.util.ArrayList;

public class OptimalCartObject {

    private ArrayList<Product>  products;
    private int totalPrice;
    private int totalWeights;

    public int getTotalWeights() {
        return totalWeights;
    }

    public void setTotalWeights(int totalWeights) {
        this.totalWeights = totalWeights;
    }

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


}
