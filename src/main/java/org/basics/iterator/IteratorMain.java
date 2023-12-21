package org.basics.iterator;

import java.util.Iterator;

public class IteratorMain {
    static class Node implements Iterable<Integer> {
        private int data;
        private Node next;

        public Node(int data, Node next){
            this.data = data;
            this.next = next;
        }

        @Override
        public Iterator<Integer> iterator() {
            return new NodeIterator();
        }


        class NodeIterator implements Iterator<Integer> {
            Node current = Node.this;

            @Override
            public boolean hasNext() {
                return current !=  null;
            }

            @Override
            public Integer next() {
                if(hasNext()) {
                    Integer value = current.data;
                    current = current.next;
                    return value;
                } else {
                    throw new NullPointerException("No next node");
                }
            }
        }
    }
}



