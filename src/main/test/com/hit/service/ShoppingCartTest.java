package com.hit.service;

import com.hit.algo.OneOrZeroKnapsackAlgoImpl;
import com.hit.algo.UnboundedKnapsackAlgoImpl;
import com.hit.dao.DaoFileImpl;
import com.hit.dao.IDao;
import com.hit.dm.OptimalCartObject;
import com.hit.dm.Product;
import org.junit.Before;
import org.junit.jupiter.api.*;
import org.testng.Assert;
import org.testng.AssertJUnit;
import com.hit.algo.OneOrZeroKnapsackAlgoImpl;
import com.hit.algo.UnboundedKnapsackAlgoImpl;

import java.io.IOException;
import java.util.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testng.Assert;
import org.testng.AssertJUnit;


import java.util.ArrayList;
import java.util.Collection;


public class ShoppingCartTest {

    private static OptimalCartObject optimalCartObject = new OptimalCartObject() ;
    private static ArrayList<Product> products = new ArrayList<>();
    private static Product product1 = new Product(3,"Apricots",30,120);
    private static Product product2 = new Product(2,"Banana",20,100);
    private static Product product3 = new Product(1, "Apple",10,60);
    private static Product product4 = new Product(4, "Avocado",6,30);
    private static Product product5 = new Product(5, "Pineapple",3,14);
    private static Product product6 = new Product(6, "Blueberries",4,16);
    private static Product product7 = new Product(7, "Coconut",2,9);
    private static Product product8 = new Product(8, "Grapefruit",2,5);
    private static Product product9 = new Product(9, "Guava",10,12);
    private static Product product10 = new Product(10, "Mango",10,60);
    private static Product product11 = new Product(11, "Cabbage",20,100);
    private static Product product12 = new Product(12, "Garlic",6,30);
    private static Product product13 = new Product(13, "Tomatoes",30,120);
    private static Product product14 = new Product(14, "Carrots",3,14);
    private static Product product15 = new Product(15, "Onions",17,2);
    private static Product product16 = new Product(16, "Potatoes",80,3);
    private static Product product17 = new Product(17, "Artichoke",100,10);
    private static Product product18 = new Product(18, "Arugula",2,9);
    private static Product product19 = new Product(19, "Broccoli",30,2);
    private static Product product20 = new Product(20, "Lettuce",4,16);
    private static String inputUserFile;
    private static List<Product> productList = new ArrayList<Product>();
    IDao dao = new DaoFileImpl();
    ShoppingCartService  shoppingCartService = new ShoppingCartService();

    public ShoppingCartTest() {
    }

    @BeforeAll
    public static void beforeAllTest() {
        System.out.println("Runs once at the beginning of the test");
        products.add(product1);
        products.add(product2);
        optimalCartObject.setProducts(products);
        // setup for buildOptimalShoppingCartTest
        optimalCartObject.setTotalWeights(220);
        optimalCartObject.setTotalPrice(50);
        inputUserFile = "C:\\Users\\koral\\optimalShoppingCartProject\\src\\main\\test\\com\\hit\\service\\testResources\\inputUserCart.json";
        productList.add(product1);
        productList.add(product2);
        productList.add(product3);
        productList.add(product4);
        productList.add(product5);
        productList.add(product6);
        productList.add(product7);
        productList.add(product8);
        productList.add(product9);
        productList.add(product10);
        productList.add(product11);
        productList.add(product12);
        productList.add(product13);
        productList.add(product14);
        productList.add(product15);
        productList.add(product16);
        productList.add(product17);
        productList.add(product18);
        productList.add(product19);
        productList.add(product20);

    }

    @AfterAll
    public static void afterAllTest() {
        System.out.println("Runs once at the end of the test");
    }

    @BeforeEach
    public void beforeTest() {

    }

    @AfterEach
    public void tearDown() {
        System.out.println("Running: tearDown");
        this.shoppingCartService = null;

    }

    @Test
    public void buildOptimalShoppingCartTest() throws IOException {
        //  Assert.assertEquals(optimalCartObject,this.buildOptimalShoppingCart(this.shoppingCartService,inputUserFile));
        this.buildOptimalShoppingCart(this.shoppingCartService,inputUserFile).equals(optimalCartObject);
    }

    @Test
    public void getProductsListTest() throws IOException {
        //  Assert.assertEquals(optimalCartObject,this.buildOptimalShoppingCart(this.shoppingCartService,inputUserFile));
        this.shoppingCartService.getProductsList().equals(productList);
    }

    private OptimalCartObject buildOptimalShoppingCart(ShoppingCartService shoppingCartService, String inputFile) throws IOException {
        OptimalCartObject optimalCartObject = shoppingCartService.buildOptimalShoppingCart(inputFile);
        return optimalCartObject;
    }

}


