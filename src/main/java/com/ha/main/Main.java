package com.ha.main;

import java.net.URL;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello");
        new Main().dd();
    }

    public void dd(){
        URL url = Main.class.getClassLoader().getResource("/application.properties");
//        URL url = getClass().getResource("/application.properties");
        System.out.println(url.getPath());
    }
}
