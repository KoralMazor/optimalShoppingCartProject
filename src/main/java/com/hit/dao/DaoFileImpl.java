package com.hit.dao;

// This class will implement  IDao interface
// This class  will be responsible for  read from files and write to them

import com.hit.dm.CartObject;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collection;

import static com.hit.utils.JsonHandler.*;

public class DaoFileImpl <T> implements IDao<CartObject> {
    @Override
    public void write(CartObject t, String filePath) throws FileNotFoundException, IOException {
        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(filePath, true));
        // Call here to ConvertCartObjectToJson and then write the json to file
        outputStream.writeObject(t + "\n");
        outputStream.close();
    }

    @Override
    public CartObject read(String inputFile) throws URISyntaxException, IOException {
        CartObject cartObject = new CartObject();
        String file = readFileFromResources(inputFile);
        cartObject = parseJsonToCartObjectShoppingCartOptions(file);
        return cartObject;

    }

    @Override
    public void remove(CartObject o) {

    }



}
