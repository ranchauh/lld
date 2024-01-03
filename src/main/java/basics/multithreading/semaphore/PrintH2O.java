package basics.multithreading.semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class PrintH2O {

    // semaphore for printing H using two threads
    private Semaphore hydroS;
    // semaphore for printing O using one threads
    private Semaphore oxyS;

    int hydro;

    public PrintH2O() {
        hydroS = new Semaphore(2);
        oxyS = new Semaphore(0);
    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        // acquire lock to print H
        hydroS.acquire();
        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
        releaseHydrogen.run();
        hydro++;
        // release oxygen thread lock so that it could print O
        if(hydro == 2) oxyS.release();
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        // acquire lock to print O
        oxyS.acquire();
        // releaseOxygen.run() outputs "O". Do not change or remove this line.
        releaseOxygen.run();
        hydro = 0;
        // release hydrogen thread lock so that they could print H
        // releasing twice as we want two threads to print H simulteneously
        hydroS.release(2);
    }

    public static void main(String[] args) {
        PrintH2O printH2O = new PrintH2O();
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        String[] inputArray = {"HOH","OOHHHH"};
        for (String input : inputArray) {
            for(char ch : input.toCharArray()) {
                switch (ch) {
                    case 'H' -> executorService.submit(() -> {
                        try {
                            printH2O.hydrogen(() -> System.out.print(ch));
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    });
                    case 'O' -> executorService.submit(() -> {
                        try {
                            printH2O.oxygen(() -> System.out.print(ch));
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    });
                }
            }
        }
        executorService.shutdown();
    }
}
