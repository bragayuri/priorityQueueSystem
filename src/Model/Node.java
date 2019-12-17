package Model;

import View.addPerson;

public class Node <E> implements NodeInterface {
	
		private E element; // the data which comes from my Person class.
		private Node<E> next; // next Node.
		private Node<E> prev; // previous Node.
		
		
		protected String qNumber;
	    protected String idProfile;
		protected String surname;
		protected String firstName;
		protected String dateArrival;
		protected String passport;
		protected String priorityLevel;
		DoublyLinkedListImpl<E> queue;
		
		
		public Node(E element, Node<E >prev,Node<E>next) {
			this.element=element;
			this.next=next;
			this.prev=prev;
			
		
			
			
			
			
		}
		
		public Node(E element) {
			this.element = element;
		}

		public Node(String a, String b, String c, String d, String E, String f, String g) {
			this.qNumber=a;
			this.idProfile=b;
			this.surname=c;
			this.firstName=d;
			this.dateArrival=E;
			this.passport=f;
			this.priorityLevel=g;
			
			element=(E) (qNumber+idProfile+surname+firstName+dateArrival+passport+priorityLevel);
			
			
			
			
			
			  
			
			
			
			
			
		
			
			
			
	
			
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


