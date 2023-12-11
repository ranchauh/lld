package org.basics.threads;

public class Client {
    public static void main(String[] args) {
        Adder adder = new Adder();
        MyThread t1 = new MyThread(adder);
        t1.start();

        Subtractor sub = new Subtractor();
        MyThread t2 = new MyThread(sub);
        t2.start();
    }
}