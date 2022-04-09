package edu.marist.chandu;

/**
 * Below class is the implementation of Stack Datastructure.
 */
public class Stack {

    private final LinkedList linkedlist = new LinkedList();

    /**
     * Below method is to pop element.
     * @return
     */
    public String pop() {
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
     * Below method is to push element.
     * @param data
     */
    public void push(String data) {
        Node node = new Node(data);
        linkedlist.insert(0, node);
    }

    /**
     * Below method is to print stack cnotent.
     */
    public void printStack() {
        linkedlist.printList();
    }
}
