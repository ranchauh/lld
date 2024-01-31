package basics.multithreading.producerconsumersemaphore;

import java.util.Queue;
import java.util.concurrent.Semaphore;

public class Producer implements Runnable {
    final private Queue<Object> queue;
    final private String name;
    final private int maxSize;
    final private Semaphore producerSemaphore;
    final private Semaphore consumerSemaphore;

    Producer(Queue<Object> queue, int maxSize, String name,
             Semaphore producerSemaphore, Semaphore consumerSemaphore) {
        this.queue = queue;
        this.name = name;
        this.maxSize = maxSize;
        this.producerSemaphore = producerSemaphore;
        this.consumerSemaphore = consumerSemaphore;
    }

    @Override
    public void run() {
        while (true) {
//            if (queue.size() < maxSize) {
            System.out.println(name + "is producing an element & size is " + queue.size());
            try {
                producerSemaphore.acquire(); // ps--
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            queue.add(new Object());
            consumerSemaphore.release(); // cs++
//            }
        }
    }
}
