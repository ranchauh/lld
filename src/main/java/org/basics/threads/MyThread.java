package org.basics.threads;


import java.lang.reflect.Field;
import java.util.HashMap;

public class MyThread extends Thread {
    public static HashMap<String, String> map = new HashMap<>();
    private String target;

    MyThread(Runnable r){
        super(r);
        target = r.getClass().getName();
    }

    @Override
    public void start() {
        super.start();
        map.put(target, this.getName());
    }
}