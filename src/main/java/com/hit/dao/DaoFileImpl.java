package com.hit.dao;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.hit.dm.CartObject;
import com.hit.dm.OptimalCartObject;
import com.hit.dm.Product;

import java.io.*;

import java.util.List;

public class DaoFileImpl<T> implements IDao<T> {

    private String filePath;

    public DaoFileImpl(){

    }
    public DaoFileImpl(String filePath) {
        this.filePath = filePath;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public void write(OptimalCartObject optimalCartObject) throws FileNotFoundException, IOException {
        Gson gson = new Gson();
        FileWriter writer = new FileWriter(filePath);
        gson.toJson(optimalCartObject, writer);
        writer.flush();
        writer.close();
    }

    @Override
    public List<Product> read(String filePath) throws IOException {
        Gson gson = new Gson();
        List<Product> products = gson.fromJson(new FileReader(filePath), new TypeToken<List<Product>>() {}.getType());
        return products;
    }

    @Override
    public CartObject readInputUser(String filePath) throws IOException {
        Gson gson = new Gson();
        CartObject cartObject = gson.fromJson(new FileReader(filePath), CartObject.class);
        return cartObject;
    }

    @Override
    public void remove(T t) {

    }

}
