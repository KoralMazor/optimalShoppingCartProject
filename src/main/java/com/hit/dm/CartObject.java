package com.hit.dm;

import java.util.ArrayList;
import java.util.List;

public class CartObject {

    private List<Product> products;
    private int totalPrice;
    private String buyingOptionAlgo;

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
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
