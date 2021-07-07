
package com.hit.server;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.hit.dm.CartObject;
import com.hit.dm.Product;
import com.hit.service.ShoppingCartController;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;
import java.util.Collection;
import java.util.List;

public class HandleRequest<T> implements Runnable , Serializable {

    T obj;
    private Gson gson_handler;
    private String jsonString;
    private Socket socket;
    private ObjectInputStream inStream;
    private ObjectOutputStream outStream;
    private ShoppingCartController shoppingCartController;


    public HandleRequest(Socket socket, ShoppingCartController shoppingCartController) throws IOException  {
        this.socket = socket;
        this.shoppingCartController = shoppingCartController;
        inStream = new ObjectInputStream((socket.getInputStream()));
        outStream = new ObjectOutputStream(socket.getOutputStream());

    }

    @Override
    public void run() {
            try {
                jsonString = (String) inStream.readObject();
                System.out.println(jsonString);
                Request request = gson_handler.fromJson(jsonString, Request.class);
                try {
                    switch (request.headers.getAction()) {
                        case GET: {
                            List productsList = ShoppingCartController.requestTypeGet();
                            if (productsList.size() != 0) {
                                jsonString = gson_handler.toJson(new Response<List<Product>>(productsList, true));
                                outStream.writeObject(jsonString);
                                outStream.flush();
                                break;
                            }
                            else{
                                Response<List<Product>> response = new Response(null, false);
                                jsonString = gson_handler.toJson(response);
                                outStream.writeObject(jsonString);
                                outStream.flush();
                                break;

                            }
                        }
                        case CREATE: {
                            Request<CartObject> buildOptimalShoppingCartRequest = gson_handler.fromJson(jsonString, new TypeToken<Request<CartObject>>() {
                            }.getType());
                            outStream.writeObject(gson_handler.toJson(new Response(shoppingCartController.requestTypeCreate(buildOptimalShoppingCartRequest, true), true)));
                            outStream.flush();
                        }

                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }}







