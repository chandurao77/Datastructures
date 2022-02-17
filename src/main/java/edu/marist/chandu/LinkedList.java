package edu.marist.chandu;


public class LinkedList {
	//reference to the first Node
	private Node header;
	//Reference to last node
	private Node lastNode;
	//Size of linked List
	private int size;
	
	//constructor implementation
	public LinkedList() {
		//create dummy Node
		header = new Node(null);
		//reference dummy Node
		lastNode = header;
	}
	
	//prepend
	public void prepend(Integer data) {
		Node n = new Node(data);
		if(size == 0) {
			header.next = n;
			lastNode = n;
			size++;
		}
		else {
			//temporary value to save next node
			Node temp = header.next;
			header.next = n;
			n.next = temp;
			size++;
			
		}
	}
	
	//append()
	public void append(Integer data) {
		Node n = new Node(data);
		if(size == 0) {
			header.next = n;
			lastNode = n;
			size++;
		}
		else {
			lastNode.next = n;
			lastNode = n;
			size++;
		}
	}
	
	public int getSize() {
		return size;
	}
	
	//InsertAt 
	public void insertAt(int index, Integer data) {
		if(index <= 0 || index > size)
			return;
		else if(index == 1) 
			prepend(data);
		else if(index == size)
			append(data);
		else {
			Node n = new Node(data);
			Node x = header.next;
			int count = 1;
			while(count != index - 1) {
				x = x.next;
				count++;
			}
			Node temp = x.next;
			x.next = n;
			n.next = temp;
			size++;
		}
		
	}
	public String toString() {
		//reference first node
		Node n = header.next;
		String temp = "";
		while(n != null) {
			temp = temp + n.data + "";
			n = n.next;
		}
		return temp;
	}

    public static void main(String[] args) {

        LinkedList list = new LinkedList();
        //Adding prepend()
        list.prepend(1);
        list.prepend(2);
        list.prepend(3);
        list.prepend(4);
        list.prepend(5);
        
        //Print Prepend list
        System.out.println(list);
//		System.out.println(list.getSize());
        
        //Adding Append()
        list.append(5);
        list.append(6);
        list.append(7);
        list.append(8);
        list.append(9);
        list.append(10);
        
        //Print Append list
        System.out.println(list);
        
        //Adding insertAt()
        //inserting 78 at first position
        list.insertAt(1, 78);
        //inserting 127 at third position
        list.insertAt(3, 127);
        //Print Append list
        System.out.println(list);
    
    }
	
}
