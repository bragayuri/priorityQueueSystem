// Author: Yuri Braga
// 2017141

// Class Node will hold the Node element that forms a doubly linked list.


package Model;

import View.addPerson;

// this class will implement Node Interface which holds the desirable methods to be used.

public class Node <E> implements NodeInterface {
	
		E element; // the data which comes from my Person class.
		private Node<E> next; // next Node.
		Node<E> prev; // previous Node.
		
		
		
		// Constructor to initialise variables.
		public Node(E element, Node<E >prev,Node<E>next) {
			this.element=element;
			this.next=next;
			this.prev=prev;
			
		
			
			
			
			
		}
		
		public Node(E element) {
			this.element = element;
		}

		
			
			
			
			
			
			  
			
			
			
			
			
		
			
			
			
	
			
		}

		@Override
		
		/*
		 * This method will set data to Node
		 */
		public void setElement(Object element) {
			 this.element = (E) element;
			
		}

		@Override
		
		/*
		 * This method returns data from a Node.
		 */
		public E getElement() {
			
			return element;
		}

		
		
		/*
		 * This method will set the next Node.
		 */
		public void setaNext(Node<E> next) {
			this.next = next;
			
			
		}

		
		public void setaPrev(Node<E> prev) {
			this.prev=prev;
			
			
		}

		@Override
		
		// This method will get next Node.
		public Node<E> getNext() {
			
			return next;
		}

		@Override
		
		// This method returns the previous Node.
		public Node<E> getPrev() {
		return next;
			
		}

		@Override
		public void setNext(Node next) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void setPrev(Node prev) {
			// TODO Auto-generated method stub
			
		}
	}


