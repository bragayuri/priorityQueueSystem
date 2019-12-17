package Model;


// This interface will provide a structure for my Node class.
 

public interface NodeInterface <E> {
	
	// This method will set an element.
	public void setElement(E element);
	
	// This method will get and return an Element.
	
	public E getElement();
	
	// This method will enable to set an Element.
	  public void setNext(Node<E> next);
		
	
	
	// This method will set previous Node.
	
	public void setPrev(Node<E> prev);
	
	// This method will get Next Node.
	
	public Node<E> getNext();
	// This method will get previous Node.
	
	public Node<E> getPrev();



  
	
}
