package com.hit.dao;

public interface IDao <T>{
    void write(T t);
    T read();
    void remove(T t);
}
