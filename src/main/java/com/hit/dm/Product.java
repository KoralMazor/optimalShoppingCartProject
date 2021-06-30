package com.hit.dm;

public class Product {
    private String Name;
    private int Price;
    private int Weight;
    private String Type;
    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int price) {
        Price = price;
    }
    public void setType(String type) {
        Type = type;
    }
    public int getWeight() {
        return Weight;
    }
    public String getType() {
        return Type;
    }
    public void setWeight(int weight) {
        Weight = weight;
    }


}
