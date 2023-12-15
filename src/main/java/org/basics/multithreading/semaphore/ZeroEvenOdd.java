package org.basics.multithreading.semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

/**
 * You have an object printNumber. printNumber.accept(x) can be called with an integer parameter that prints it to the console.
 *
 * You are given an instance of the class ZeroEvenOdd that has three functions: zero, even, and odd. The same instance of ZeroEvenOdd will be passed to three different threads:
 *
 * Thread A: calls zero() that should only output 0's.
 * Thread B: calls even() that should only output even numbers.
 * Thread C: calls odd() that should only output odd numbers.
 * Modify the given class to output the series "010203040506..." where the length of the series must be 2n.
 *
 * Implement the ZeroEvenOdd class:
 *
 * ZeroEvenOdd(int n) Initializes the object with the number n that represents the numbers that should be printed.
 * void zero(printNumber) Calls printNumber to output one zero.
 * void even(printNumber) Calls printNumber to output one even number.
 * void odd(printNumber) Calls printNumber to output one odd number.
 * Example 1:
 * Input: n = 2
 * Output: "0102"
 * Explanation: There are three threads being fired asynchronously.
 * One of them calls zero(), the other calls even(), and the last one calls odd().
 * "0102" is the correct output.
 * Example 2:
 * Input: n = 5
 * Output: "0102030405"
 * Constraints:
 * 1 <= n <= 1000
 */
public class ZeroEvenOdd {
    private int n;

    int num;

    private Semaphore zeroS, oddS, evenS;

    public ZeroEvenOdd(int n) {
        this.n = n;
        this.num = 1;
        this.zeroS = new Semaphore(1);
        this.oddS = new Semaphore(0);
        this.evenS = new Semaphore(0);
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        while (num < n) {
            zeroS.acquire();
            // output 0
            printNumber.accept(0);
            if(num % 2 == 0) {
                evenS.release();
            } else {
                oddS.release();
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        while (num < n) {
            evenS.acquire();
            // output even
            printNumber.accept(num);
            num++;
            zeroS.release();
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        while (num < n) {
            oddS.acquire();
            // output odd
            printNumber.accept(num);
            num++;
            zeroS.release();
        }
    }

    public static void main(String[] args) {
        ZeroEvenOdd zeroEvenOdd = new ZeroEvenOdd(5);
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        executorService.submit(() -> {
            try {
                zeroEvenOdd.zero(System.out::print);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

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
