package basics.inheritance;

public interface A {
    default void fun() {
        System.out.println("A's fun");
    }

    void fun1();
}

