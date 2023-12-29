package org.basics.multithreading.semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

public class OddEvenPrinter {
    private int n;

    int num;

    private Semaphore oddS, evenS;

    public OddEvenPrinter(int n) {
        this.n = n;
        this.num = 1;
        this.oddS = new Semaphore(1);
        this.evenS = new Semaphore(0);
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        while (num < n) {
            evenS.acquire();
            // output even
            printNumber.accept(num);
            num++;
            oddS.release();
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        while (num < n) {
            oddS.acquire();
            // output odd
            printNumber.accept(num);
            num++;
            evenS.release();
        }
    }

    public static void main(String[] args) {
        OddEvenPrinter zeroEvenOdd = new OddEvenPrinter(10);
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        executorService.submit(() -> {
            try {
                zeroEvenOdd.odd(System.out::print);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        executorService.submit(() -> {
            try {
                zeroEvenOdd.even(System.out::print);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        executorService.shutdown();
    }
}
