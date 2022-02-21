package edu.marist.chandu;

class LinkedList {

	// create an object of Node class
	Node head;
  
	public static void main(String[] args) {
  
	  // create an object of LinkedList
	  LinkedList linkedList = new LinkedList();
  
	  // assign values to each linked list node
	  linkedList.head = new Node(1);
	  Node second = new Node(2);
	  Node third = new Node(3);
  
	  // connect each node of linked list to next node
	  linkedList.head.next = second;
	  second.next = third;
  
	  // printing node-value
	  System.out.print("LinkedList: ");
	  while (linkedList.head != null) {
		System.out.print(linkedList.head.value + " ");
		linkedList.head = linkedList.head.next;
	  }
	}
  }