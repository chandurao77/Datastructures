package edu.marist.chandu;

// class Stack {

//     // variable to store elements of stack
//     private int arr[];

//     private int head;

//     private int memory;

//     // Creating a stack
//     Stack(int size) {
//       // initializing the stack variables
//       arr = new int[size];
//       memory = size;
//       head = -1;
//     }

//     // push elements to the head of stack
//     public void push(int x) {
//       if (isFull()) {
//         System.out.println("Stack OverFlow");

//         // terminates the program
//         System.exit(1);
//       }

//       // insert element on head of stack
//       System.out.println("Inserting " + x);
//       arr[++head] = x;
//     }

//     // pop elements from head of stack
//     public int pop() {

//       // if stack is empty there are no elements to pop
//       if (isEmpty()) {
//         System.out.println("The Stack is Empty");
//         System.exit(1);
//       }

//       // pop element from top of stack
//       return arr[head--];
//     }

//     // size of the stack
//     public int getSize() {
//       return head + 1;
//     }

//     // testing if array size is empty
//     public Boolean isEmpty() {
//       return head == -1;
//     }

//     // testing if array size is full
//     public Boolean isFull() {
//       return head == memory - 1;
//     }

//     // print array elements
//     public void printStack() {
//       for (int i = 0; i <= head; i++) {
//         System.out.print(arr[i] + ", ");
//       }
//     }

//     public static void main(String[] args) {
//       Stack stack = new Stack(5);

//       stack.push(40);
//       stack.push(30);
//       stack.push(20);

//       System.out.print("Stack: ");
//       stack.printStack();

//       // pop element from stack
//       stack.pop();
//       System.out.println("\nAfter pop");
//       stack.printStack();

//     }
//   }
