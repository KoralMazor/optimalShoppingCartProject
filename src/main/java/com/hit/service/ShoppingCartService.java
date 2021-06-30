package com.hit.service;

import java.io.IOException;
import java.net.URISyntaxException;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.Collection;

import com.hit.algo.IAlgoKnapsack;
import com.hit.dao.DaoFileImpl;
import com.hit.dao.IDao;
import com.hit.dm.CartObject;
import com.hit.dm.Product;

public class ShoppingCartService {
    private IAlgoKnapsack algoKnapsack;
    private IDao dao;

    ShoppingCartService(){}

    ShoppingCartService(IAlgoKnapsack algoKnapsack) {
        this.algoKnapsack = algoKnapsack;
    }

    public IAlgoKnapsack getAlgoKnapsack() {
        return algoKnapsack;
    }

    public void setAlgoKnapsack(IAlgoKnapsack algoKnapsack) {
        this.algoKnapsack = algoKnapsack;
    }

    public IDao getDao() {
        return dao;
    }

    public void setDao(IDao dao) {
        this.dao = dao;
    }

    public CartObject buildOptimalShoppingCart() throws URISyntaxException, IOException {
        int [] productsForOptimalCart;
        DaoFileImpl daoFile = new DaoFileImpl();
        CartObject inputShoppingCart = daoFile.read("inputShoppingCartOptions.json");
        parseCartObjectToAlgoParams(inputShoppingCart);
       // productsForOptimalCart = algoKnapsack.buildShoppingCart()
        return inputShoppingCart;

    }

    public void parseCartObjectToAlgoParams(CartObject cartObject)
    {
        int totalPrice;
        String buyingOption;
        String buyingOptionAlgo;

        int productsLength = cartObject.getProducts().size(), i = 0 ;
        int [] prices = new int[productsLength] ;
        int [] weights = new int[productsLength] ;

            for (Product productItem : cartObject.getProducts()) {
                prices[i] = productItem.getPrice();
                weights[i] = productItem.getWeight();
                i++;
            }
            totalPrice = cartObject.getTotalPrice();
            buyingOption = cartObject.getBuyingOptionAlgo();

        }
//
//        for(int i = 0; i < productsLength; i++){
            //            int j = 0;
//            cartObject.getProducts().forEach((item) -> {
//                item.getPrice();
//            });



    public static void main(String[] args) throws URISyntaxException, IOException {
        ShoppingCartService shoppingCartService = new ShoppingCartService();
        CartObject itemsForShoppingCart = shoppingCartService.buildOptimalShoppingCart();
    }

}

