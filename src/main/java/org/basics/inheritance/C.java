package org.basics.inheritance;

import java.util.AbstractList;

public class C implements A, B{

    @Override
    public void fun() {
        System.out.println("C's fun");
    }

    @Override
    public void fun1() {
        System.out.println("C's fun1");
    }

    public static void main(String[] args) {
        A a = new C();
        a.fun(); // C's fun
        a.fun1(); // C's fun1

        B b = new C();
        b.fun(); // C's fun
        b.fun1(); // C's fun1
    }
}
