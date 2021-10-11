package com.interview.sling;

public class GenericLinkList<T> {
	
	GenericLinkList<T> next;
	T data;

	GenericLinkList<T> head;
	
	GenericLinkList<T> tail;
	
	
	
	public Boolean add(T data) {
		GenericLinkList<T> node = tail;
		
		if(head == null) {
			GenericLinkList<T> newNode = new GenericLinkList<T>();
			newNode.data = data;
			newNode.next = null;
			head = newNode;
			tail =  head;
			return Boolean.TRUE;
		}
		
		while(node.next != null) {
			node = node.next;
		}
		GenericLinkList<T> newNode = new GenericLinkList<T>();
		newNode.data = data;
		newNode.next = null;	
		node.next = newNode;
		tail = newNode;
		return Boolean.TRUE;
	}
	
	public void printData() {
		GenericLinkList<T> node = head;
		if(head == null ) {
			System.out.println("Empty ");
			return;
		}
		
		while(node.next != null) {
			System.out.println(" , "+ node.data);
			node = node.next;
		}
		System.out.println(" , "+ node.data);
		
	}
	public int size() {
		int i = 0;
		GenericLinkList<T> node = head;
		
		while (node.next != null) {
			node = node.next;
			i++;
		}
		return i;
		
	}
	
	public T deleteNode() {
		
		GenericLinkList<T> node = head;
		
		if(size() == 0 ) {
			System.out.println("empty   ");
			return null;
		} /*
			 * else if(size()<2) { return head.data; }
			 */
		/*1--> 2
		head  = 1
		tail = 2
		
		node = 1, 2*/
		//prevNode =1 
		GenericLinkList<T> prevNode = head;
		
		while (node.next != null) {
			prevNode =  node;
			node = node.next;
			
		}

		GenericLinkList<T> deleted = tail;
		tail = prevNode;
		prevNode.next = null;
		return deleted.data;
	}
	
	
	

}
