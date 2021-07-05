package com.hit.server;

import com.google.gson.Gson;
import sun.rmi.runtime.Log;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server implements Runnable , Serializable {
    transient ObjectInputStream reader;
    transient ObjectOutputStream writer;
    transient String s;
    static final int MAX_T = 3;
    public boolean KEPP_SERVBER_ALIVE = true;
    ExecutorService pool;

    @Override
    public void run() {
        pool = Executors.newFixedThreadPool(MAX_T);
        try {

            ServerSocket serversocket = null;
            serversocket = new ServerSocket(5000);
            System.out.println("Server is started...");
            Socket socket = new Socket();
            while(KEPP_SERVBER_ALIVE) {
                socket = serversocket.accept();
                HandleRequest request = new HandleRequest(socket, reader, writer);
                pool.execute(request);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
    public void setServerStatus(boolean state){
        this.KEPP_SERVBER_ALIVE = state;
    }
}
