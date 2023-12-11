package org.basics.inheritance;

public interface B {
    default void fun() {
        System.out.println("B's fun");
    }
    void fun1();
}

