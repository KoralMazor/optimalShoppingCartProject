//package com.hit.server;
//
//import com.google.gson.Gson;
//
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.ObjectOutputStream;
//import java.io.OutputStream;
//import java.net.ServerSocket;
//import java.net.Socket;
//import java.util.ArrayList;
//import java.util.HashMap;
//
//public class Server implements Runnable {
//    @Override
//    public void run() {
//        ArrayList<Socket> clients = new ArrayList<>();
//        try(
//                ServerSocket serversocket = new ServerSocket(5000))
//        {
//            System.out.println("Server is started...");
//            while (true) {
//                Socket socket = serversocket.accept();
//                clients.add(socket);
//                ThreadServer ThreadServer = new ThreadServer(socket);
//                ThreadServer.start();
//            }
//        } catch
//        (Exception e)
//
//        {
//            System.out.println(e.getStackTrace());
//        }
//    }
//}
//    class ThreadServer extends Thread {
//        private ObjectOutputStream objectOutput;
//        private Socket socket;
//        private InputStream inputStream = null;
//        private OutputStream outputStream = null;
//
//        public static final int CHECK_FOR_MESSAGES = 1;
//        public static final int SEND_MESSAGE = 2;
//        public static final int GET_HD_INFO = 3;
//        public static final int OKAY = 200;
//
//        public ThreadServer(Socket socket) {
//            this.socket = socket;
//        }
//
//        @Override
//        public void run() {
//            try {
//                Gson gson = new Gson();
//                inputStream = socket.getInputStream();
//                outputStream = socket.getOutputStream();
//                String json = gson.toJson(inputStream.read());
//
//            } catch (IOException e) {
//                e.printStackTrace();
//            } finally {
//                if (inputStream != null) {
//                    try {
//                        inputStream.close();
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//                }
//                if (outputStream != null) {
//                    try {
//                        outputStream.close();
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        }
//    }