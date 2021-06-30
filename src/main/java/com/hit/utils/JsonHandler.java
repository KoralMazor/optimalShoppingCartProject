package com.hit.utils;

import com.hit.dm.CartObject;
import com.hit.dm.Product;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class JsonHandler {

    // Where we stores our parsed json.
    static ArrayList<CartObject> CartArray = new ArrayList<>();

    // This function reads the json file from resources and then parsers it to an Cart Object.
    public static  CartObject parseJsonToCartObjectShoppingCartOptions(String file) {
        CartObject cartObject = new CartObject();
        try {
            JSONObject tmpObj;

            JSONObject jsonObj = new JSONObject(file);
            ArrayList<Product> products = new ArrayList<>();

            JSONArray fruits = jsonObj.getJSONArray("fruits");
            JSONArray totalPrice = jsonObj.getJSONArray("totalPrice");
            JSONArray buyingOptionAlgo = jsonObj.getJSONArray("buyingOptionAlgo");

            for(int i = 0; i < fruits.length(); i++){
                Product product = new Product();
                product.setName(fruits.getJSONObject(i).get("name").toString());
                product.setPrice(fruits.getJSONObject(i).getInt("price"));
                product.setWeight(fruits.getJSONObject(i).getInt("weight"));
                products.add(product);
            }
            cartObject.setProducts(products);
            cartObject.setTotalPrice(totalPrice.getJSONObject(0).getInt("price"));
            cartObject.setBuyingOptionAlgo(buyingOptionAlgo.getJSONObject(0).get("buyingOptionAlgo").toString());
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return cartObject ;
    }

    // This function reads the json file from resources and then parsers it to an Cart Object.
//    public static  ArrayList<CartObject> parseJsonToCartObject(String file) {
//
//        try {
//            JSONObject jsonObj = new JSONObject(file);
//            JSONArray fruits = jsonObj.getJSONArray("fruits");
//            JSONArray vegetables = jsonObj.getJSONArray("totalPrice");
//            JSONObject tmpObj;
//            CartObject cartObject;
//
//            System.out.println("fruits:\n");
//            for (int i = 0; i < fruits.length(); i++) {
//                cartObject = new CartObject();
//                cartObject.Name = fruits.getJSONObject(i).get("name").toString();
//                cartObject.Price = fruits.getJSONObject(i).getInt("price");
//                cartObject.Weight = fruits.getJSONObject(i).getInt("weight");
//                cartObject.Type = "fruit";
//                CartArray.add(cartObject);
//            }
//            for (int i = 0; i < vegetables.length(); i++) {
//                cartObject = new CartObject();
//                cartObject.Name = vegetables.getJSONObject(i).get("name").toString();
//                cartObject.Price = vegetables.getJSONObject(i).getInt("price");
//                cartObject.Weight = vegetables.getJSONObject(i).getInt("weight");
//                cartObject.Type = "vegetable";
//                CartArray.add(cartObject);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        return CartArray;
//    }

    public static JSONObject ConvertCartObjectToJson(CartObject CartArray) {
        /// TO DO : A function that converts a CartObject to an JsonObject.
        return null;
    }

    // Helps to read json file from resources.
    public static String readFileFromResources(String filename) throws URISyntaxException, IOException {
        byte[] bytes = null;
        try {
            URL resource = JsonHandler.class.getClassLoader().getResource(filename);
            bytes = Files.readAllBytes(Paths.get(resource.toURI()));
        }
        catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new String(bytes);
    }

}
