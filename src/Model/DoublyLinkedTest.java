/*
 * Author: Yuri Braga
 * 
 * This is a test class for my linked list methods.
 * I tried to implement an Inner class Node.
 * After all I could not use this class.
 */

package Model;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import View.CheckPosition;
import View.DeletePerson;

public class DoublyLinkedTest <E>{
	
	private Node head;
	private Node tail;
	private int length;
	private int size=0;
	private DeletePerson table;
	
	public DoublyLinkedTest() {
		this.head= null;
		this.tail = null;
		this.length = 0;
	
	}
	public <T> T[] toArray(T[] a) {
		return a;
		
	};
	
	public void displayForward() {
		
		Node current = head;
		if (head ==null) {
			System.out.println("List is empty");
			return;
		}
		
		System.out.println("Nodes: ");
		
		
		while(current!= null) {
			System.out.println(current.element.toString()+ " ");
			current=current.next;
			
			
			
		
			
			
		}
		
		
	}
	
	public void displayBackward() {
		if (tail == null) {
			return;
		}
		Node temp = tail;
		while(temp != null) {
			System.out.println(temp.element+ " ==== >");
		
			
			
			temp = temp.previous;
		}
		
		System.out.println ("null");
			
		}
	
	public int size() { return size; }
	
	
	
	
	
	public boolean isEmpty() {
		return length ==0;
	}
	
	public int length() {
		return length;
		
	}
	
	public void addBefore(Node<E> toBeAdded, Node<E> before) {
		toBeAdded.setNext(before);
		toBeAdded.setPrevious(before.getPrevious());
		before.getPrevious().setNext(toBeAdded);
		before.setPrevious(toBeAdded);
		size ++;
	
		
	}
	
	public void addFirst(Node<E> node) {
		addBefore(node,head.getNext());
		
	}
	
	public void insertLast(E element) {
		Node newnode = new Node(element);
		if(isEmpty()) {
			head= newnode;
		}else {
			tail.next = newnode;
			
		}
		 newnode.previous = tail;
		 tail = newnode;
		 length ++;
			
		
		
	}
	
	public DoublyLinkedTest<Profile> getList(){
		return getList();
	}
	
	

	//Private Inner class Node
	
	private class Node <E>{
		private E element;
		private Node<E> next;
		private Node<E> previous;
		
		public Node (E element) {
			this.element=element;
		}
		
		public Node(E element,Node<E >prev,Node<E>next) {
			this.element=element;
			this.next=next;
			this.previous=prev;
			
		}
		
		public E getElement() {
			return element;
		}



		public void setElement(E element) {
			this.element = element;
		}



		public Node<E> getNext() {
			return next;
		}



		public void setNext(Node<E> next) {
			this.next = next;
		}



		public Node<E> getPrevious() {
			return previous;
		}



		public void setPrevious(Node<E> previous) {
			this.previous = previous;
		}
		
		@Override
		public String toString() {
			
			String list= "";
			
			Node current = head;
			
			while (current != null) {
				list = list + current.toString() + "\n";
				 current = current.next;
				
			}
			
			return list;
			
			
		}



		
		
		
	}

}
