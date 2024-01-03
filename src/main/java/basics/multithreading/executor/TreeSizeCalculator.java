package basics.multithreading.executor;

import java.util.concurrent.*;

class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        this.left = this.right = null;
    }
}

/**
 * Binary tree size calculator using multithreading
 */
public class TreeSizeCalculator implements Callable<Integer> {

    Node root;
    ExecutorService executorService;

    public TreeSizeCalculator(Node root, ExecutorService executorService) {
        this.root = root;
        this.executorService = executorService;
    }

    @Override
    public Integer call() throws Exception {
        if(root == null) {
            return 0;
        }
        Future<Integer> leftOfLSTFuture = executorService.submit(new TreeSizeCalculator(root.left, executorService));
        Future<Integer> rightOfLSTFuture = executorService.submit(new TreeSizeCalculator(root.right, executorService));

        return 1 + leftOfLSTFuture.get() + rightOfLSTFuture.get();
    }

    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Node root = new Node(1);
        TreeSizeCalculator treeSizeCalculator = new TreeSizeCalculator(root, executorService);
        System.out.println(treeSizeCalculator.call());
        root.left = new Node(2);
        root.right = new Node(2);
        System.out.println(treeSizeCalculator.call());
    }
}
