package edu.marist.chandu;

// import java.io.*;
// import java.util.Scanner;

// class ListElement{

//     public int data;
//     public ListElement link;
//     public ListElement list1,list2;

//     Scanner sc = new Scanner(System.in);
//     //construtor
//     ListElement(int data){
//         this.data = data;
//         this.link = null;
//     }

//     //method to update data in List element
//     void updatedata(int data){
//         this.data = data;
//     }

//     //method to setup the Link
//     void setLink(ListElement node){
//         this.link = node;
//     }

//     int getdata(){
//         return this.data;
//     }

//     ListElement getNextNode(){
//         return this.link;
//     }

//     //method that returns length of list
//     int length(){
//         ListElement node = this;
//         int length_of_list = 1;

//         if(node == null){
//             return 0;
//         }

//         while(node.link != null){
//             length_of_list++;
//             node = node.getNextNode();
//         }

//         return length_of_list;
//     }

//     ListElement insert(ListElement head,ListElement node,int position){

//         ListElement previousNode = new ListElement(head.data);
//         previousNode.setLink(head.link);

//         if(head == null){
//             return node;
//         }
//         else{
//             int size = length();
//             if(position > size+1){
//                 System.out.println("Invalid position.");
//                 System.out.println("Valid positions are from 0 to " + size);
//                 return head;
//             }
//             if(position == 1){
//                 node.setLink(head);
//                 return node;
//             }
//             else if(position == 2){
//                 ListElement temp = new ListElement(-11);
//                 temp.setLink(head.link);
//                 head.setLink(node);
//                 node.setLink(temp.getNextNode());
//             }
//             else{
//                 int pos = 1;
//                 while(pos != position-1){
//                     previousNode = previousNode.getNextNode();
//                     pos++;
//                 }
//                 //ListElement temp = head.getNextNode();

//                 previousNode.setLink(node);
//                 node.setLink(null);
//             }
//         }
//         return head;
//     }

//     ListElement insertAtEnd(ListElement node){
//         ListElement head = this;
//         int size = head.length();

//         ListElement temp = this;
//         while(temp.link!=null){
//             temp = temp.getNextNode();
//         }
//         temp.setLink(node);
//         return head;
//     }

//     ListElement deleteByPosition(ListElement head ,int position){
//         ListElement previousNode = head;

//         if(position == 1){
//             head = head.getNextNode();
//             return head;
//         }
//         else{
//             int pos = 1;
//             while(pos != position-1){
//                 previousNode = previousNode.getNextNode();
//                 pos++;
//             }
//             ListElement currentNode = previousNode.getNextNode();
//             previousNode.setLink(currentNode.getNextNode());
//             currentNode.setLink(null);
//             currentNode = null;
//         }

//         return head;
//     }

//     ListElement deleteByData(ListElement head , int data){
//         ListElement previousNode = head;
//         ListElement currentNode = head;
//         if(data == currentNode.data){
//             head.setLink(currentNode.getNextNode());

//         }
//         else{
//             while(data != currentNode.data){
//                 previousNode = currentNode;
//                 currentNode = currentNode.getNextNode();
//             }
//             previousNode.setLink(currentNode.getNextNode());
//             currentNode.setLink(null);
//             currentNode = null;
//         }
//         return head;
//     }

//     void display(ListElement head){
//         ListElement node = head;
//         int position = 1;
//         while(node!= null){
//             System.out.println("Position " + position + " = " + node.data);
//             position++;
//             node = node.getNextNode();
//         }
//     }

//     ListElement reverse(){
//         ListElement head = this;
//         int size = head.length();
//         int[] stack = new int[size];
//         int i=0;
//         ListElement temp = this;
//         while(temp.link != null){
//             stack[i] = temp.data;
//             i++;
//             temp = temp.getNextNode();
//         }
//         stack[i] = temp.data;

//         int pos = 2;
//         ListElement start = new ListElement(stack[i]);
//         for(int j=size-1 ; j>0 ; j--){
//             ListElement node = new ListElement(j);
//             insert(start,node,pos);
//             pos++;
//         }
//         return start;
//     }

//     int findElement(int data){
//         ListElement node = new ListElement(this.data);
//         node.setLink(this.link);
//         boolean isPresent = false;
//         int position = 1;
//         while(!isPresent){
//             if(node.data == data){
//                 isPresent = true;
//             }
//             else{
//                 if(node.getNextNode()!= null){
//                     node = node.getNextNode();
//                     position++;
//                 }
//                 else{
//                     break;
//                 }
//             }
//         }

//         if(isPresent){
//             return position;
//         }
//         else{
//             return -1;
//         }
//     }

//     int getElement(int position){
//         ListElement node = new ListElement(this.data);
//         node.setLink(this.link);

//         int size = this.length();
//         if(size < position){
//             return -1111;
//         }
//         else {
//             int pos = 1;
//             while (pos != position) {
//                 node = node.getNextNode();
//                 pos++;
//             }
//             return node.data;
//         }
//     }

//     int[] convertToArray(){
//         ListElement head = this;
//         int size = head.length();
//         int[] list = new int[size];
//         int position = 0;
//         while(head.link != null){
//             list[position] = head.data;
//             position++;
//             head = head.getNextNode();
//         }
//         list[position] = head.data;

//         return list;
//     }

//     int findMax(){
//         ListElement node = new ListElement(this.data);
//         node.setLink(this.link);

//         int max = 0;
//         while(true){

//             if(max < node.data){
//                 max = node.data;
//             }
//             if(node.getNextNode()!= null){
//                 node = node.getNextNode();
//             }
//             else{
//                 break;
//             }
//         }
//         return max;
//     }

//     int findMin(){
//         ListElement node = new ListElement(this.data);
//         node.setLink(this.link);

//         int min = node.data;
//         while(true){

//             if(min > node.data){
//                 min = node.data;
//             }
//             if(node.getNextNode()!= null){
//                 node = node.getNextNode();
//             }
//             else{
//                 break;
//             }
//         }
//         return min;
//     }

//     ListElement makeDummyList() {
//         ListElement head = this;
//         for(int i=2 ; i < 10 ; i++){
//             ListElement node = new ListElement(i);
//             head.insert(head,node,i);
//         }
//         return head;
//     }

//     int countOccurences(int data) {
//         int count = 0;
//         ListElement head = this;
//         while(head.link != null){
//             if(head.data == data){
//                 count++;
//             }
//             head = head.getNextNode();
//         }
//         if(head.data == data){
//             count++;
//         }
//         return count;
//     }

//     ListElement pop(){
//         ListElement head = this;
//         if(head.link == null){
//             return null;
//         }
//         else{
//             head = head.getNextNode();
//             return head;
//         }
//     }

//     ListElement recursiveReverse(ListElement previousNode){
//         /*ListElement currentNode = this;
//         if(currentNode.link != null){
//             previousNode = currentNode;
//             currentNode.link.recursiveReverse(previousNode,head);
//         }
//         if(previousNode != null){
//             currentNode.link = previousNode;
//             previousNode.link = null;
//         }*/
//         return this;
//     }

// }
// public class LinkedList {



//     public static void main(String args[]){
//         Scanner sc = new Scanner(System.in);
//         ListElement head = new ListElement(1);
//         head.setLink(null);
//         int cont =1;
//         head = head.makeDummyList();
//         while(cont == 1){
//             System.out.println("Program to implement linked list");
//             System.out.println("The Following choices are availiable : ");
//             System.out.println("1.Insert element in Linked List");
//             System.out.println("2.Delete element from Linked List");
//             System.out.println("3.Display Linked List");
//             System.out.println("4.Display Length of Linked List");
//             System.out.println("5.Find element in Linked List");
//             System.out.println("6.Get data from a position in Linked List");
//             System.out.println("7.find Max and Min from Linked List");
//             System.out.println("8.Reverse Linked List");
//             System.out.println("9.Convert Linked List to Array");
//             System.out.println("10.Insert element at the end");
//             System.out.println("11.Count Occurences of an element");
//             System.out.println("12.Pop Element from Linked List");
//             System.out.println("13.FrontBack Split Linked List");
//             System.out.println("0.Exit");
//             System.out.print("Enter Your choice :");

//             int choice = sc.nextInt();

//             switch(choice){

//                 case 1:
//                     System.out.print("Enter data : ");
//                     int data = sc.nextInt();
//                     System.out.print("Enter position : ");
//                     int position = sc.nextInt();

//                     ListElement node = new ListElement(data);
//                     if(head == null){
//                         head = node;
//                     }
//                     else{
//                         int length = head.length();
//                         head = head.insert(head,node,position);
//                     }
//                     break;

//                 case 2:
//                     System.out.println("There are two choices :");
//                     System.out.println("1.Delete by data");
//                     System.out.println("2.Delete by position");
//                     System.out.print("Enter Your choice :");
//                     int choices = sc.nextInt();
//                     switch (choices){
//                         case 1:
//                             System.out.print("Enter the data to be deleted : ");
//                             int deleteData = sc.nextInt();
//                             head = head.deleteByData(head,deleteData);
//                             break;

//                         case 2:
//                             System.out.print("Enter position of element to be deleted : ");
//                             int pos = sc.nextInt();
//                             head = head.deleteByPosition(head, pos);
//                             break;
//                     }
//                     break;

//                 case 3:
//                     head.display(head);
//                     break;

//                 case 4:
//                     if(head == null){
//                         System.out.println("The Length of Linked List is 0");
//                     }
//                     else{
//                         int length = head.length();
//                         System.out.println("The Length of Linked List is " + length);
//                     }

//                     break;

//                 case 5:
//                     System.out.print("Enter the element to be searched : ");
//                     int element = sc.nextInt();
//                     int pos = head.findElement(element);
//                     if(pos == -1){
//                         System.out.println("The entered element is not present in the list");
//                     }
//                     else{
//                         System.out.println("The Entered element is found at position " + pos );
//                     }
//                     break;

//                 case 6:
//                     System.out.print("Enter the position : ");
//                     position = sc.nextInt();
//                     int ele = head.getElement(position);
//                     if(ele == -1111){
//                         System.out.println("Invalid position number");
//                     }
//                     else{
//                         System.out.println("The data at position " + position + " is " + ele );
//                     }
//                     break;

//                 case 7:
//                     int max = head.findMax();
//                     int min = head.findMin();

//                     System.out.println("The Max element is : " + max);
//                     System.out.println("The Min element is : " + min);
//                     break;

//                 case 8:
//                     ListElement rev = null;
//                     rev = head.reverse();
//                     rev.display(rev);
//                     break;

//                 case 9:
//                     int[] list = head.convertToArray();
//                     int length = list.length;
//                     for(int i=0 ; i<length ; i++){
//                         System.out.println("Position " + i + " = " + list[i]);
//                     }
//                     break;

//                 case 10:
//                     System.out.print("Enter data : ");
//                     data = sc.nextInt();
//                     node = new ListElement(data);
//                     head.insertAtEnd(node);
//                     break;

//                 case 11:
//                     System.out.print("Enter data : ");
//                     data = sc.nextInt();
//                     int count = head.countOccurences(data);
//                     System.out.println("The element " + data + " was found " + count + " times in the Linked list");
//                     break;

//                 case 12:
//                     head = head.pop();
//                     head.display(head);
//                     break;

//                 case 0:
//                         cont = 0;
//                         break;

//             }
//         }
//     }

//     public void remove(String key) {
//     }

//     public void clear() {
//     }

//     public boolean isEmpty() {
//         return false;
//     }

//     public void add(String key) {
//     }

//     public String get(String key) {
//         return null;
//     }

//     public boolean contains(String value) {
//         return false;
//     }

// }
