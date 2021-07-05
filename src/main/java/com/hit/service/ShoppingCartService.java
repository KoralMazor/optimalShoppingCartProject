package com.hit.service;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.net.URISyntaxException;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.Collection;

import com.google.gson.Gson;
import com.hit.algo.IAlgoKnapsack;
import com.hit.dao.DaoFileImpl;
import com.hit.dao.IDao;
import com.hit.dm.CartObject;
import com.hit.dm.Product;
import com.hit.server.Server;
import com.hit.utils.JsonHandler;

public class ShoppingCartService implements Serializable {
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
        Server server = new Server();
        server.run();
        /*
        JsonHandler js = new JsonHandler();
        ShoppingCartService shoppingCartService = new ShoppingCartService();
        CartObject array = shoppingCartService.buildOptimalShoppingCart();
        for(int i = 0 ;i<array.getProducts().size();i++){
            //System.out.println(array.getProducts().get(i).getName());


        }
         */

        //System.out.println(js.OptimalToJSON(array));
        //daoFile.write(array,"1");
       // ShoppingCartService shoppingCartService = new ShoppingCartService();
       // CartObject itemsForShoppingCart = shoppingCartService.buildOptimalShoppingCart();

    }

}

