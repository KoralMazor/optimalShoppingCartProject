package com.hit.util;

import com.hit.server.Server;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CLI implements Runnable {

    private InputStream in;
    private PrintStream out;
    private final List<util.IObserver> observers = new ArrayList<>();
    private boolean isRunning;

    public CLI(InputStream in, PrintStream out) {
        this.in = in;
        this.out = out;
    }
    public InputStream getIn() {
        return in;
    }

    public void setIn(InputStream in) {
        this.in = in;
    }

    public PrintStream getOut() {
        return out;
    }

    public void setOut(PrintStream out) {
        this.out = out;
    }

    public boolean isRunning() {
        return isRunning;
    }

    public void setServerListening(boolean on) throws IOException {
        if(on == isRunning)
            return;
        isRunning = on;
        for(util.IObserver iObserver : observers) {
            iObserver.propertyChange(this);
        }
    }
    public void addPropertyChangeListener(Server server){

            observers.add(server);
    }

    public void run(){

        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        while (true) {
            out.println("Enter command start/stop/exit");
            try {
                String command = reader.readLine();
                if(command.equals("start")) {
                    setServerListening(true);

                }
                else if(command.equals("stop")) {
                    setServerListening(false);
                }
                else if(command.equals("exit")) {
                    return;
                }
                else {
                    out.println("wrong command, possible commands: start / stop / exit");
                }
            } catch (IOException e) {
                e.printStackTrace();
                return;
            }
        }

    }
}
