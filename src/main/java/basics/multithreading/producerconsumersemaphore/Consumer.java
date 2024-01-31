package basics.multithreading.producerconsumersemaphore;

import java.util.Queue;
import java.util.concurrent.Semaphore;

public class Consumer implements Runnable {
    final private Queue<Object> queue;
    final private String name;
    final private int maxSize;
    final private Semaphore producerSemaphore;
    final private Semaphore consumerSemaphore;

    Consumer(Queue<Object> queue, int maxSize, String name,
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
//            if (queue.size() > 0){
            try {
                consumerSemaphore.acquire(); // cs--
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(name + "is consuming an element & size is " + queue.size());
            queue.remove();
            producerSemaphore.release(); // ps++
//            }
        }
    }
}
