package com.hit.server;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class HandleRequest<T> implements Runnable {
    private ObjectInputStream reader;
    private ObjectOutputStream writer;
    private Gson gson_handler;
    private String jsonString;
    T obj;
    private Socket socket;

    public HandleRequest(Socket socket) {
    this.socket = socket;
        try {
            reader = new ObjectInputStream(socket.getInputStream());
            writer = new ObjectOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void run() {
        while(!socket.isClosed()){
           // Request request = gson_handler.fromJson(reader.readObject())
        }
    }
}
