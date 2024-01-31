package basics.multithreading.producerconsumermutex;

import java.util.Queue;

public class Producer implements Runnable {
    final private Queue<Object> queue;
    final private String name;
    final private int maxSize;

    Producer(Queue<Object> queue, int maxSize, String name) {
        this.queue = queue;
        this.name = name;
        this.maxSize = maxSize;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (queue) {
                if (queue.size() < maxSize) {
                    System.out.println(name + " is producing an element & size is " + queue.size());
                    queue.add(new Object());
                }
            }
        }
    }
}
