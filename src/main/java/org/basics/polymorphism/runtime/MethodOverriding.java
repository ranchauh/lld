package org.basics.polymorphism.runtime;

class A {
    void greeting() {
        System.out.println("Greeting from A");
    }
}

class B extends A {
}

class C extends B {
    void greeting() {
        System.out.println("Greeting from C");
    }
}

class D extends C {
}

public class MethodOverriding {
    public static void main(String[] args) {
        A a = new A();
        a.greeting(); //Greeting from A
        A aa = new B();
        aa.greeting(); //Greeting from A
        B b = new B();
        b.greeting(); //Greeting from A
        C c = new C();
        c.greeting(); //Greeting from C
        A ac = new C();
        ac.greeting(); //Greeting from C
        D d = new D();
        d.greeting(); //Greeting from C
        C cd = new D();
        cd.greeting(); //Greeting from C
        A ad = new D();
        ad.greeting(); //Greeting from C
    }
}
