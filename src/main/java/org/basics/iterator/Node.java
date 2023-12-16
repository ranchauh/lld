package org.basics.iterator;

import java.util.Iterator;
class Node implements Iterable<Node> {
    private int data;
    private Node next;

    public Node(int data, Node next){
        this.data = data;
        this.next = next;
    }

    @Override
    public Iterator<Node> iterator() {
        return new NodeIterator<>(this);
    }
}

class NodeIterator<Node> implements Iterator<Node> {
    Node node;

    public NodeIterator(Node node) {
        this.node = node;
    }

    @Override
    public boolean hasNext() {
        return node !=  null;
    }

    @Override
    public Node next() {
        return node;
    }
}

