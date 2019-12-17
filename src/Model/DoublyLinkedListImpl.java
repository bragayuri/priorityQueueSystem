 // Student: Yuri Braga
//  Student Number:2017141.

package Model;

import java.util.NoSuchElementException;



/*
 *  This class will build the structure of my DoublyLinkedList and also holds an Inner class Node.
 *  Node will be the structure of my DoublyLinkedList.
 */

public class DoublyLinkedListImpl <E> implements DDL<E> {
	
	private Node<E> head;
	private Node<E> tail;
	private int size=0;
	
	/*
	 * My constructor which will enable a new list
	 */
	
	public DoublyLinkedListImpl() {
		head = new Node<>(null,null,null);
		tail = new Node<>(null,head,null);
		head.setNext(tail);
	}
	
// Method to print the list in forward direction
	
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

// Method to print the list in backward direction
	
	public void displayBackward() {
		if (tail == null) {
			return;
		}
		Node temp = tail;
		while(temp != null) {
			System.out.println(temp.element+ " ==== >");
		
			
			
			temp = temp.prev;
		}
		
		System.out.println ("null");
			
		}
	
	
	
	// method to add an element to a given position.
	
	public void addInPosition(E e, int position) {
		
		Node<E> currentPosition = getNode(position); //getting the node at the given position
		Node<E> insert = new Node<>(e); //passing the element to the new node.
		
		addBefore(insert, currentPosition);// adding the element to the new position.
	}
	
	//method to get the position of the element.
	
	public E get(int position) {
		if(position <=0 || position > size)
			return null;
		
		return getNode(position).getElement();
	}
	
	//Method to get Node at a given position.
	
	public Node<E> getNode(int position){
		
		//if position is invalid
		if (position > size || position == 0)
			return null;
		
		
		Node<E> newNode = null;// create a new node.
		
		// If position is the first half of a list start from the head.
		
		if(position < (this.size()/2)) { //if position is the first half.Start from 
			newNode =  head;
			
			// iterate until one before the last position.
			for( int i= 0; i<position; i++) 
				
				//get next Element.
				newNode = newNode.getNext();
			
			// else will occur in case position is located in the second half of the list
			
		}else {
			newNode = tail; //starts from tail
			
			// iterate from list size until x position to get previous node.
			
			for ( int y = this.size(); y>=position;y--)
				
				newNode = newNode.getPrevious();
			
			
		}
		 // return a node.
		
		return newNode;
	}
	
	
	  
	
	
	
	public void addLast (E e) {
		
		addLast(new Node<>(e,null,null));
	}

	public Node<E> getNextNode(Node<E> e) {
		return e.getNext();
	}
	
	/*
	 *  This method will remove the last N number of nodes from a list.
	 *  It will return the number of nodes removed.
	 */
	public int removeLastNode( int nOfNodes) {
		if(nOfNodes > size) {
			return -1;
			
		} else {
			
			// get the last node and pass to a new node.
			Node<E> lastNode = getNode(size-nOfNodes);
			// set tail now to be this new node.
			tail.setPrevious(lastNode);
			// remove the number of nodes from the size.
			size = size -nOfNodes;
			// returns the number of nodes removed.
			return nOfNodes;
		}
		
		
		
	}
	
	
	
	
	
	
	
	

	@Override
	public int size() {
		
		return size;
	}


	@Override
	public void addFirst(Node<E> node) {
		addBefore(node,head.getNext());
		
	}


	@Override
	public void addBefore(Node<E> toBeAdded, Node<E> before) {
		toBeAdded.setNext(before);
		toBeAdded.setaPrev(before.getPrevious());
		before.getPrevious().setNext(toBeAdded);
		before.setPrevious(toBeAdded);
		size ++;
	
		
	}


	
	public void addLast1(E e) {
		addLast(new Node<>(e,null,head));
		size ++;
		
	}


	@Override
	public boolean isEmpty() {
		
		return size ==0;
	}


	@Override
	public E first() {
		if(isEmpty()) 
			return null;
		return head.getNext().getElement();
		
	}


	@Override
	public E last() {
		if (isEmpty()) return null;
		return tail.getPrevious().getElement();
	}


	@Override
	public E removeFirst() {
		if (isEmpty()) return null;
		return remove(head.getNext());
	}


	@Override
	public E removeLast() {
		if (isEmpty())
			return null;
		
		return  remove(tail.getPrevious());
	}


	
	public E remove(int position) {
		return remove(getNode(position));
		
	}


	@Override
	public E remove(Node<E> node) {
		Node<E> before = node.getPrevious();
		Node<E> after = node.getNext();
		
		before.setNext(after);
		after.setaPrev(before);
		before.setaNext(tail);
		after.setaPrev(head);
		size --;
		
		return node.getElement();
	}


	@Override
	public void addLast(Node<E> node) {
		addBefore(node,tail);
		
	}
	
	public String toString() {
		StringBuilder x = new StringBuilder();
		
		Node<E> y = head;
		
		if ( y != null) {
			y = y.getNext();
			while (y.getNext() != null) {
				x.append(y.getElement().toString());
				x.append("     ");
				y =y.getNext();
			} 
			x.append(y.getElement().toString());
			
		}
		x.append(" ");
		return x.toString();
	}
}
	
	


	