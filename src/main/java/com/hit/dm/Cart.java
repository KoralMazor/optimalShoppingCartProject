package com.hit.dm;

import java.io.Serializable;

public class Cart implements Serializable {
    String name;
    String type;

    public  Cart(String Name,String Type){
        this.name = name;
        this.type = Type;
    }
}
