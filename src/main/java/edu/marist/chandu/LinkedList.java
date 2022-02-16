package edu.marist.chandu;

public class LinkedList {
	private Node header;
	private Node lastNode;
	private int size;
	
	public LinkedList() {
		header = new Node(null);
		lastNode = header;
	}
	
	public void prepend(Integer data) {
		Node n = new Node(data);
		if(size == 0) {
			header.next = n;
			lastNode = n;
			size++;
		}
		else {
			Node temp = header.next;
			header.next = n;
			n.next = temp;
			size++;
			
		}
	}
	
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
        list.prepend(11);
        list.prepend(12);
        list.prepend(13);
        list.prepend(14);
        list.prepend(15);
        
        System.out.println(list);
		System.out.println(list.getSize());
        
        list.append(55);
        list.append(56);
        list.append(57);
        list.append(58);
        list.append(59);
        list.append(60);
        
        System.out.println(list);
        

        list.insertAt(1, 54);
        list.insertAt(3, 69);
        System.out.println(list);
    
    }
	
}
