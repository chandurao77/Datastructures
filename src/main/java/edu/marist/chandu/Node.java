package edu.marist.chandu;

/**
 * This class is Node class with string data.
 */
public class Node {

    private String key;
    private String data;
    private Node prev;
    private Node next;

    /**
     * Node class default constructor.
     */
    Node() {
    }

    /**
     * Node class constructor overloading with string.
     * @param data
     */
    Node(String data) {
        this.data = data;
    }

    public Node(String key, String value) {
        this.key = key;
        this.data = value;
    }

    /**
     * method to get data.
     * @return
     */
    public String getData() {
        return data;
    }

    /**
     * Method to set data.
     * @param data
     */
    public void setData(String data) {
        this.data = data;
    }

    /**
     * Method to get previous element.
     * @return
     */
    public Node getPrev() {
        return prev;
    }

    /**
     * Method to set previous element.
     * @param prev
     */
    public void setPrev(Node prev) {
        this.prev = prev;
    }

    /**
     * Method to get next element.
     * @return
     */
    public Node getNext() {
        return next;
    }

    /**
     * Method to set next element.
     * @param next
     */
    public void setNext(Node next) {
        this.next = next;
    }

    /**
     * method to return content as string.
     * @return
     */
    @Override
    public String toString() {
        return "Node{"
            + "data='" + data + '\''
            + '}';
    }
}
