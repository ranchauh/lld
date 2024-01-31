package basics.multithreading.producerconsumermutex;

import java.util.Queue;

public class Consumer implements Runnable {
    final private Queue<Object> queue;
    final private String name;
    final private int maxSize;

    Consumer(Queue<Object> queue, int maxSize, String name) {
        this.queue = queue;
        this.maxSize = maxSize;
        this.name = name;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (this.queue) {
                if (queue.size() > 0){
                    System.out.println(name + "is consuming an element & size is " + queue.size());
                    queue.remove();
                }
            }
        }
    }
}
