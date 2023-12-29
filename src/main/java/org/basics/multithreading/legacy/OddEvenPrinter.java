package org.basics.multithreading.legacy;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;

class Number {
    int val;
    Number(int n) {
        this.val = n;
    }
}

class OddPrinter implements Runnable {
    Number number;
    int limit;

    OddPrinter(Number number, int limit) {
        this.number = number;
        this.limit = limit;
    }

    @Override
    public void run() {
        while (true) {
            try {
                synchronized (this.number) {
                    if (this.number.val % 2 == 0) {
                        this.number.wait();
                    }
                    if (this.number.val > this.limit) {
                        break;
                    }
                    System.out.print(this.number.val + " ");
                    this.number.val++;
                    this.number.notify();
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

}

class EvenPrinter implements Runnable {
    Number number;
    int limit;

    EvenPrinter(Number number, int limit) {
        this.number = number;
        this.limit = limit;
    }

    @Override
    public void run() {
        while (true) {
            try {
                synchronized (this.number) {
                    if (this.number.val % 2 != 0) {
                        this.number.wait();
                    }
                    if (this.number.val > this.limit) {
                        break;
                    }
                    System.out.print(this.number.val + " ");
                    this.number.val++;
                    this.number.notify();
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

}

public class OddEvenPrinter {
    public static void main(String[] args) throws InterruptedException {
        Number number = new Number(1);
        Runnable oddPrinter = new OddPrinter(number, 10);
        Runnable evenPrinter = new EvenPrinter(number, 10);

        Thread t1 = new Thread(oddPrinter);
        Thread t2 = new Thread(evenPrinter);

        t1.start();
        t2.start();

        t1.join();
        t2.join();
    }
}
