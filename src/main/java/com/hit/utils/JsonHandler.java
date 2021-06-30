package com.hit.utils;

import com.hit.dm.CartObject;
import com.hit.dm.Product;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class JsonHandler {

    // Where we stores our parsed json.
    static ArrayList<CartObject> CartArray = new ArrayList<>();
    String PATH = System.getProperty("user.dir")+"\\src\\main\\resources\\";
    // This function reads the json file from resources and then parsers it to an Cart Object.
    public static CartObject parseJsonToCartObjectShoppingCartOptions(String file) {
        CartObject cartObject = new CartObject();
        try {
            JSONObject tmpObj;

            JSONObject jsonObj = new JSONObject(file);
            ArrayList<Product> products = new ArrayList<>();

            JSONArray fruits = jsonObj.getJSONArray("fruits");
            JSONArray totalPrice = jsonObj.getJSONArray("totalPrice");
            JSONArray buyingOptionAlgo = jsonObj.getJSONArray("buyingOptionAlgo");

            for (int i = 0; i < fruits.length(); i++) {
                Product product = new Product();
                product.setName(fruits.getJSONObject(i).get("name").toString());
                product.setPrice(fruits.getJSONObject(i).getInt("price"));
                product.setWeight(fruits.getJSONObject(i).getInt("weight"));
                product.setType("fruits");
                products.add(product);
            }
            cartObject.setProducts(products);
            cartObject.setTotalPrice(totalPrice.getJSONObject(0).getInt("price"));
            cartObject.setBuyingOptionAlgo(buyingOptionAlgo.getJSONObject(0).get("buyingOptionAlgo").toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cartObject;
    }
    public String ReadFromFile(String fileName) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        StringBuilder stringBuilder = new StringBuilder();
        char[] buffer = new char[10];
        while (reader.read(buffer) != -1) {
            stringBuilder.append(new String(buffer));
            buffer = new char[10];
        }
        reader.close();

        String content = stringBuilder.toString();
        return content;
    }
    public String ObjectToStinrg(CartObject CartObject){
        String s = "{";
        s+="  \n" +
                "  \"fruit\" : [";
        for(int i=0;i<CartObject.getProducts().size();i++){
            if(CartObject.getProducts().get(i).getType()=="fruits"){
                s+="    {\n" +
                        "      \"name\" : "+"\""+CartObject.getProducts().get(i).getName()+"\""+",\n" +
                        "      \"image\" : \"https://upload.wikimedia.org/wikipedia/commons/thumb/1/15/Red_Apple.jpg/265px-Red_Apple.jpg\",\n" +
                        "      \"weight\":"+CartObject.getProducts().get(i).getWeight()+",\n" +
                        "      \"price\" :"+CartObject.getProducts().get(i).getPrice()+"\n" +
                        "    }," ;
            }
        }
        s = s.substring(0, s.length() - 1);
        s+="  \n  ]\n" +
                "}";
        return s;
    }

    public String OptimalToJSON(CartObject CartObject){
        String s = "{";
        s+="  \n" +
                "  \"fruit\" : [";
        for(int i=0;i<CartObject.getProducts().size();i++){
            if(CartObject.getProducts().get(i).getType()=="products"){
                s+="    {\n" +
                        "      \"name\" : "+"\""+CartObject.getProducts().get(i).getName()+"\""+",\n" +
                        "      \"weight\":"+CartObject.getProducts().get(i).getWeight()+",\n" +
                        "      \"price\" :"+CartObject.getProducts().get(i).getPrice()+"\n" +
                        "    }," ;
            }
        }
        s = s.substring(0, s.length() - 1);
        s += "],";
        s+="  \"vegetable\" : [";
        for(int i=0;i<CartObject.getProducts().size();i++){
            if(CartObject.getProducts().get(i).getType()=="totalPrice"){
                s+="    {\n" +
                        "      \"name\" : "+"\""+CartObject.getTotalPrice()+"\""+",\n" +
                        "    }," ;
            }
        }
        s = s.substring(0, s.length() - 1);
        s += "],";
        s+="  \"vegetable\" : [";
        for(int i=0;i<CartObject.getProducts().size();i++){
            if(CartObject.getProducts().get(i).getType()=="totalWeight"){
                s+="    {\n" +
                        "      \"name\" : "+"\""+CartObject.gettotalWeight()+"\""+",\n" +
                        "    }," ;
            }
        }
        s = s.substring(0, s.length() - 1);
        s+="  \n  ]\n" +
                "}";
        return s;
    }}
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
/*
    public static JSONObject ConvertCartObjectToJson(CartObject CartArray) {
        ArrayList<Product>  _products_;
        _products_ = CartArray.getProducts();
        String s = "{";
        s+="  \n" +
                "  \"fruit\" : [";
        for(int i=0;i<_products_.size();i++){
            if(_products_.get(i).getType()=="fruit"){
                s+="    {\n" +
                        "      \"name\" : "+"\""+_products_.get(i).getName()+"\""+",\n" +
                        "      \"image\" : \"https://upload.wikimedia.org/wikipedia/commons/thumb/1/15/Red_Apple.jpg/265px-Red_Apple.jpg\",\n" +
                        "      \"weight\":"+_products_.get(i).getWeight()+",\n" +
                        "      \"price\" :"+_products_.get(i).getPrice()+"\n" +
                        "    }," ;
            }
        }
        s = s.substring(0, s.length() - 1);
        s += "],";
        s+="  \"vegetable\" : [";
        for(int i=0;i<_products_.size();i++){
            if(_products_.get(i).getType().equals("vegetable")){
                s+="    {\n" +
                        "      \"name\" : "+"\""+_products_.get(i).getName()+"\""+",\n" +
                        "      \"image\" : \"https://upload.wikimedia.org/wikipedia/commons/thumb/1/15/Red_Apple.jpg/265px-Red_Apple.jpg\",\n" +
                        "      \"weight\":"+_products_.get(i).getWeight()+",\n" +
                        "      \"price\" :"+_products_.get(i).getPrice()+"\n" +
                        "    }," ;
            }
        }
        s = s.substring(0, s.length() - 1);
        s+="  \n  ]\n" +
                "}";
        JSONObject temp = new JSONObject(s);
        return temp;
    }
/*
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

 */
