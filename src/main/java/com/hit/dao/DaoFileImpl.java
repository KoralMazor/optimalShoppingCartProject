package com.hit.dao;

// This class will implement  IDao interface
// This class  will be responsible for  read from files and write to them

import com.hit.dm.CartObject;
import com.hit.utils.JsonHandler;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collection;

import static com.hit.utils.JsonHandler.*;

public class DaoFileImpl <T> implements IDao<CartObject> {
    String PATH = System.getProperty("user.dir")+"\\src\\main\\resources\\";
    JsonHandler jsonHandler;
    @Override
    public void write(CartObject t, String filename) throws FileNotFoundException, IOException {
        String s = jsonHandler.ObjectToStinrg(t);
        FileOutputStream fout=new FileOutputStream(PATH+"dataSource.txt");
        fout.write(jsonHandler.ObjectToStinrg(t).toString().getBytes(StandardCharsets.UTF_8));
        fout.close();
    }

    @Override
    public CartObject read(String inputFile) throws URISyntaxException, IOException {
        CartObject cartObject = new CartObject();
        jsonHandler = new JsonHandler();
        String file = jsonHandler.ReadFromFile(PATH+inputFile);
        cartObject = parseJsonToCartObjectShoppingCartOptions(file);
        return cartObject;

    }

    @Override
    public void remove(CartObject o) {

    }



}
