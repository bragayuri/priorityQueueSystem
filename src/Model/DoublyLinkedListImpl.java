 // Student: Yuri Braga
//  Student Number:2017141.

package Model;

import java.util.NoSuchElementException;

/*
 *  This class will build the structure of my DoublyLinkedList and also holds an Inner class Node.
 *  Node will be the structure of my DoublyLinkedList.
 */

public class DoublyLinkedListImpl <E> {
	
	private Node head;
	private Node tail;
	private int size;
	
	
	public DoublyLinkedListImpl() {
		size = 0;
	}
	
	/**
	 * this Inner Class keeps track of each element information
	 */

	
		/**
		 * returns size of the linked list
		 */
		public int size() {
			return size;
		}
		
		/**
		 * return wheter the list is empty or not
		 */
		
		public boolean isEmpty() {
			return size == 0;
			
		}
		
		/**
		 * add elements at the starting of the linked list
		 */
		
		public void addFirst(Node node) {
			//Declaring my class Node which will receive an element and a head and then check it.
			Node info = new Node (node, head,null);
			
			if(head !=null) {head.prev = info;}
			head = info;
			if(tail ==null) {tail = info;}
			size++;
			
			System.out.println("adding: "+node);
			System.out.println();
		}
		
		/**
		 * this methos walks forward through the linked list
		 * 
		 */
		public void iterateForward() {
			System.out.println("iterating forward...");
			Node info = head;
			
			while(info != null) {
				System.out.println(info.element);
				info=info.next;
			}
		}
			/**
			 * this method removes element from the end of the linked list
			 * 
			 */
			public E  removeLast() {
				if (size==0) throw new NoSuchElementException();
				Node tmp = tail;
				tail = tail.prev;
				tail.next = null;
				size --;
				System.out.println("deleted: "+tmp.element);
				return tmp.element;
				
			}
			
			/**
			 * this method removes element in the front of the list
			 * 
			 */
			
			public E removeFirst() {
				if(size==0) throw new NoSuchElementException();
				Node tmp = head;
				head = head.next;
				head.prev = null;
				size --;
				System.out.println("deleted"+tmp.element);
				return tmp.element;
			}
		}
		
	
