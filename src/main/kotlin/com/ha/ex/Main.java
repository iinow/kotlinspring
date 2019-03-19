package com.ha.ex;

import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.Optional;
import java.util.concurrent.Callable;

public class Main {
    private String content;
    public static void main(String[] args) {
        new Main().ss();
    }

    public void ss(){
        try {
            "".getBytes("UTF-8");

//            new Thread()
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    static class DaytimeTask implements Callable<Void> {

        @Override
        public Void call() throws Exception {
            int a = 0;
            if(a == '\r'){

            }
            return null;
        }
    }
}
