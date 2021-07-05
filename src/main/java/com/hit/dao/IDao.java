package com.hit.dao;

import com.hit.dm.CartObject;
import com.hit.dm.OptimalCartObject;
import com.hit.dm.Product;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public interface IDao <T>{

    void write(OptimalCartObject t) throws FileNotFoundException, IOException;
    List<Product> read(String filePath) throws IOException;
    CartObject readInputUser(String filePath) throws IOException;
    void remove(T t);
}
