package com.ostwebdev.fantasystrategy.game.mud;

import AppServer.RequestWorker;
import java.io.IOException;
import java.net.ServerSocket;

public class mudtest {
    public static void main(String[] args) {
        ServerSocket s;
        try {
            s = new ServerSocket(8080);
        } catch (IOException e) {
            System.out.println("Could not listen to port 4444");
            System.exit(-1);
            return;
        }

        RequestWorker w;
        while(!s.isClosed()) {
            try {
                w = new RequestWorker(s.accept());
                Thread t = new Thread(w);
                t.start();
            } catch (IOException e) {
                System.out.println("Accept failed: 4444");
                System.exit(-1);
                return;
            }
        }
        System.out.println("Out of main loop");
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();

    }


}
