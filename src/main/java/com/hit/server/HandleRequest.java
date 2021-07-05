package com.hit.server;

import com.google.gson.Gson;
import com.hit.dm.Cart;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;
public class HandleRequest<T> implements Runnable , Serializable {
    private Gson gson_handler;
    private String jsonString;
    T obj;
    private Socket socket;
    transient ObjectInputStream inStream;
    transient ObjectOutputStream outStream;

    public HandleRequest(Socket socket,ObjectInputStream inStream,ObjectOutputStream outStream) throws IOException, ClassNotFoundException  { // Add controller
    this.socket = socket;
    this.inStream  = inStream;
    this.outStream = outStream;
    }


    @Override
    public void run() {
        while(!socket.isClosed()){
            String s;
            try {
                gson_handler = new Gson();
                inStream = new ObjectInputStream(socket.getInputStream());
                Request request = gson_handler.fromJson((String)inStream.readObject(),Request.class);
                switch (request.headers.getAction()){

                }
                inStream.close();
                //outStream.close();
                socket.close();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }


        }
    }
    }


