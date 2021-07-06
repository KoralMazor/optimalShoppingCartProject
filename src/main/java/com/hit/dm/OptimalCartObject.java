package com.hit.dm;

import java.util.ArrayList;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OptimalCartObject)) return false;
        OptimalCartObject that = (OptimalCartObject) o;
        return totalPrice == that.totalPrice && totalWeights == that.totalWeights && Objects.equals(products, that.products);
    }

    @Override
    public int hashCode() {
        return Objects.hash(products, totalPrice, totalWeights);
    }
}
