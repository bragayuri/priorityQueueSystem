// Author: Yuri braga
// 2017141

package Model;


// This interface will hold the methods that a Node should have.
 

public interface NodeInterface <E> {
	
	// To set an element.
	public void setElement(E element);
	
	// To get and return an Element.
	
	public E getElement();
	
	// To enable to set an Element.
	  public void setNext(Node<E> next);
		
	
	
	// To set previous Node.
	
	public void setPrev(Node<E> prev);
	
	// To get Next Node.
	
	public Node<E> getNext();
	// To get previous Node.
	
	public Node<E> getPrev();



  
	
}
