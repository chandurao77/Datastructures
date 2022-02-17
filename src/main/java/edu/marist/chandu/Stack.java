package edu.marist.chandu;

public class Stack {

private Object pop() {
    return null;
}

private void push(int i) {
}
 public static void main(String args[]) {

  
  Stack s = new Stack();

  s.push(1);
  s.push(2);
  s.push(3);
  s.push(4);
  s.push(5);

  System.out.println("s:" + s);

  Object ele = s.pop();

  System.out.println("s.pop(): " + ele);

  System.out.println("s:" + s);

 }


}