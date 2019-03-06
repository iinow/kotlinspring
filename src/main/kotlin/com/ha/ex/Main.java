package com.ha.ex;

import java.net.URL;
import java.util.concurrent.Callable;

public class Main {
    public static void main(String[] args) {
        new Main().ss();
    }

    public void ss(){
        URL dld = getClass().getResource("/application.properties");
        System.out.println(dld.toString());
        Void d = Void.TYPE.cast(null);

    }

    static class DaytimeTask implements Callable<Void> {

        @Override
        public Void call() throws Exception {
            return null;
        }
    }
}
