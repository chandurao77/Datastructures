package edu.marist.chandu;

class Queue
{
    private int[] arr;
    private int front;
    private int rear;
    private int capacity;
    private int count;
 
    Queue(int size)
    {
        arr = new int[size];
        capacity = size;
        front = 0;
        rear = -1;
        count = 0;
    }
 
    public int dequeue()
    {
        if (isEmpty())
        {
            System.out.println("Underflow\nThe End");
            System.exit(-1);
        }
 
        int x = arr[front];
 
        System.out.println("Removing " + x);
 
        front = (front + 1) % capacity;
        count--;
 
        return x;
    }
 
    public void enqueue(int item)
    {
        if (isFull())
        {
            System.out.println("Overflow\nThe End");
            System.exit(-1);
        }
 
        System.out.println("Inserting " + item);
 
        rear = (rear + 1) % capacity;
        arr[rear] = item;
        count++;
    }
 
    public int peek()
    {
        if (isEmpty())
        {
            System.out.println("Underflow\nThe End");
            System.exit(-1);
        }
        return arr[front];
    }
 
    public int size() {
        return count;
    }
 
    public boolean isEmpty() {
        return (size() == 0);
    }
 
    public boolean isFull() {
        return (size() == capacity);
    }
}
 
class Main
{
    public static void main (String[] args)
    {
        // create a queue of capacity 5
        Queue q = new Queue(5);
 
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
 
        System.out.println("The front element is " + q.peek());
        q.dequeue();
        System.out.println("The front element is " + q.peek());
 
        System.out.println("The queue size is " + q.size());
 
        q.dequeue();
        q.dequeue();
 
        if (q.isEmpty()) {
            System.out.println("queue is full");
        }
        else {
            System.out.println("queue is not empty");
        }
    }
}