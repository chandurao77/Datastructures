package edu.marist.chandu;

/**
 * This class is Queue Implementation.
 */
public class Queue {
    private final LinkedList linkedlist = new LinkedList();

    /**
     * Below method is to dequeue.
     * @return
     */
    public String deqeueue() {
        return linkedlist.remove(0).getData();
    }

    /**
     * Below method is to search data.
     * @param data
     * @return
     */
    public Node search(String data) {
        int index = linkedlist.search(data);
        if (index == -1) {
            return null;
        }
        Node node = linkedlist.readNode(index);
        return node;
    }

    /**
     * Below method is to read peek element.
     * @return
     */
    public String peek() {
        return linkedlist.readNode(0).getData();
    }

    /**
     * Below method is to check empty.
     * @return
     */
    public boolean isEmpty() {
        return linkedlist.getSize() == 0;
    }

    /**
     * Below method is to enqueue.
     * @param data
     */
    public void enqueue(String data) {
        Node node = new Node(data);
        linkedlist.insert(linkedlist.getSize(), node);
    }

    /**
     * Below method is to print queue.
     */
    public void printQueue() {
        linkedlist.printList();
    }
}
