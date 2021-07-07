package com.hit.dm;

public class Product {
    private long id;
    private  String name;
    private int price;
    private int weight;

    public Product(){}
    public Product(long id, String name, int price, int weight){
        this.id = id;
        this.name = name;
        this.price = price;
        this.weight = weight;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }










}
