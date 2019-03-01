package com.ha.ex;

import java.net.URL;

public class Main {
    public static void main(String[] args) {
        new Main().ss();
    }

    public void ss(){
        URL dld = getClass().getResource("/application.properties");
        System.out.println(dld.toString());
    }
}
