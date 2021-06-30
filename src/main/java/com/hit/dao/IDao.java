package com.hit.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Collection;

public interface IDao <T>{
    void write(T t, String path) throws FileNotFoundException, IOException;
    T read(String file) throws URISyntaxException, IOException;
    void remove(T t);
}
