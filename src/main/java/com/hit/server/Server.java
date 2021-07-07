package com.hit.server;

import com.hit.dm.Product;
import com.hit.service.ShoppingCartController;
import com.hit.util.CLI;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server implements util.IObserver, Runnable , Serializable {

    ServerSocket serverSocket;
    Socket socket;
    Scanner scn;
    PrintWriter printout;
    ExecutorService pool;

    public boolean isServerRun;

    public Socket getSocket() {
        return socket;
    }

    public boolean isServerRunning() {
        return isServerRun;
    }

    public Server(int port) {
        try {
            serverSocket = new ServerSocket(port);
            isServerRun = true;
            pool = Executors.newFixedThreadPool(5);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {

        System.out.format("Server is listening on port %d  \n", serverSocket.getLocalPort());
        while (isServerRun) {
            try {
                socket = serverSocket.accept();
                pool.execute(new HandleRequest<>(socket, new ShoppingCartController<Product>()));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


    }


    @Override
    public void propertyChange(CLI cli) throws IOException {
        if (cli.isRunning()) {
            new Thread(this).start();
        } else {
            if (serverSocket != null)
                serverSocket.close();
        }
    }
}