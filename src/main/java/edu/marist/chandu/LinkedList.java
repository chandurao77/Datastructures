package edu.marist.chandu;

/**
 * This class is implementation of Linkedlist.
 */
public class LinkedList {
    private Node head;
    private Node tail;
    private int size;

    /**
     * Method to insert the node at specific index.
     * @param index
     * @param node
     */
    public void insert(int index, Node node) {
        if (index > size || index < 0) {
            throw new RuntimeException("Invalid Index");
        } else if (index == 0) {
            addFirst(node);
        } else if (index == size) {
            addLast(node);
        } else {
            Node forward = getNodeAt(index);
            Node prev = forward.getPrev();
            prev.setNext(node);
            node.setPrev(prev);
            node.setNext(forward);
            forward.setPrev(node);
            this.size++;
        }
    }

    /**
     * Method to remove item at specific index.
     * @param index
     * @return
     */
    public Node remove(int index) {
        if (index >= size) {
            throw new RuntimeException("Invalid Index");
        } else if (index == 0) {
            return removeFirst();
        } else if (index == size - 1) {
            return removeLast();
        } else {
            Node node = getNodeAt(index);
            Node prev = node.getPrev();
            Node forward = node.getNext();
            prev.setNext(forward);
            forward.setPrev(prev);
            node.setNext(null);
            node.setPrev(null);
            this.size--;
            return node;
        }
    }

    /**
     * Method to read data at specific index.
     * @param index
     * @return
     */
    public String read(int index) {
        if (index > size) {
            throw new RuntimeException("Invalid Index");
        } else if (index == 0) {
            return this.head.getData();
        } else if (index == size) {
            return this.tail.getData();
        } else {
            return getNodeAt(index).getData();
        }
    }

    /**
     * Method to readNode at specific index.
     * @param index
     * @return
     */
    public Node readNode(int index) {
        if (index >= size) {
            throw new RuntimeException("Invalid Index");
        } else if (index == 0) {
            return this.head;
        } else if (index == size - 1) {
            return this.tail;
        } else {
            return getNodeAt(index);
        }
    }

    /**
     * Method to search data.
     * @param data
     * @return
     */
    public int search(String data) {
        if (this.head == null) {
            return -1;
        } else {
            Node node = this.head;
            boolean found = false;
            int i = 0;
            while (node != null) {
                if (node.getData().equals(data)) {
                    found = true;
                    break;
                }
                i++;
                node = node.getNext();
            }
            if (found) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Method to printlist.
     */
    public void printList() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node current = this.head;
        while (current != null) {
            sb.append(current.getData());
            if (current.getNext() != null) {
                sb.append(", ");
            }
            current = current.getNext();
        }
        sb.append("]");
        System.out.println(sb);
    }

    /**
     * Method to set head node.
     * @param head
     */
    public void setHead(Node head) {
        this.head = head;
    }

    /**
     * Method to return head node.
     * @return
     */
    public Node getHead() {
        return this.head;
    }

    /**
     * Method to get size.
     * @return
     */
    public int getSize() {
        return size;
    }

    /**
     * Method to add first node.
     * @param node
     */
    private void addFirst(Node node) {
        if (this.size == 0) {
            this.head = node;
            this.tail = node;
        } else {
            node.setNext(this.head);
            this.head.setPrev(node);
            this.head = node;
        }
        this.size++;
    }

    /**
     * Method to add last node.
     * @param node
     */
    public void addLast(Node node) {
        if (this.size == 0) {
            this.head = node;
            this.tail = node;
        } else {
            this.tail.setNext(node);
            node.setPrev(this.tail);
            this.tail = node;
        }
        this.size++;
    }

    /**
     * Method to  remove first element.
     * @return
     */
    private Node removeFirst() {
        Node node = this.head;
        if (this.size == 0) {
            this.head = null;
            this.tail = null;
        } else {
            Node forward = node.getNext();
            node.setNext(null);
            forward.setPrev(null);
            this.head = forward;
        }
        this.size--;
        return node;
    }

    /**
     * Method to remove last element.
     * @return
     */
    private Node removeLast() {
        Node node = this.tail;
        if (this.size == 1) {
            this.head = null;
            this.tail = null;
        } else {
            Node prev = node.getPrev();
            node.setPrev(null);
            prev.setNext(null);
            this.tail = prev;
        }
        this.size--;
        return node;
    }

    /**
     * Method to getNode at specific index.
     * @param index
     * @return
     */
    private Node getNodeAt(int index) {
        Node current = this.head;
        int nodeIndex = index;
        while (nodeIndex-- > 0) {
            current = current.getNext();
        }
        return current;
    }
}
