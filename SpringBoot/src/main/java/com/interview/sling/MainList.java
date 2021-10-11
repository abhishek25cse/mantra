package com.interview.sling;

public class MainList {
	
	public static void main(String[] a) {
		GenericLinkList<Integer> list =  new GenericLinkList<Integer>();
		
		list.add(1);
		list.add(2);
			
		System.out.println("print insert done");		
		list.printData();
		
		list.deleteNode();
		System.out.println("print after delete");		
		list.printData();
	}

}
