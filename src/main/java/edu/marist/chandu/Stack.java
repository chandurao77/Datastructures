package edu.marist.chandu;

public class Stack {
    
    private Object pop() {
        return null;
    }
    
    private void push(int i) {
    }
     public static void main(String args[]) {
    
      Stack s = new Stack();
    
      s.push(101);
      s.push(102);
      s.push(103);
      s.push(104);
      s.push(105);
    
      System.out.println("s:" + s);
    
    
      Object ele = s.pop();
    
      System.out.println("s.pop(): " + ele);
    
      System.out.println("s:" + s);
    
     }
}
