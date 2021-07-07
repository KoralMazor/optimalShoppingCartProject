package com.hit.service;

import com.hit.dm.CartObject;
import com.hit.dm.Product;
import com.hit.server.Request;

import java.util.Collection;
import java.util.List;

public class ShoppingCartController <T> {

    private CartObject cartObject;
    private Request<CartObject> buildOptimalShoppingCartRequest;
    private final ShoppingCartService shoppingCartService;

    public ShoppingCartController(ShoppingCartService shoppingCartService) {
        this.shoppingCartService = shoppingCartService;
    }

    public ShoppingCartController() {

        shoppingCartService = null;
    }


    public static List<Product> requestTypeGet() {
        return null;
    }

    public CartObject requestTypeCreate(Request<CartObject> buildOptimalShoppingCartRequest, boolean status){
    return null;
    }
}
