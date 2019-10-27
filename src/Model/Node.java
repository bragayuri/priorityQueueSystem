package Model;



public class Node <E> {
	
		Profile element;
		Node next;
		Node prev;
		protected String qNumber;
	    protected String idProfile;
		protected String surname;
		protected String firstName;
		protected String dateArrival;
		protected String passport;
		protected String priorityLevel;
		DoublyLinkedListImpl<Profile> queue;
		
		public Node(Profile element, Node next,Node prev) {
			this.element=element;
			this.next=next;
			this.prev=prev;
			
		}

		public Node(String a, String b, String c, String d, String E, String f, String g) {
			this.qNumber=a;
			this.idProfile=b;
			this.surname=c;
			this.firstName=d;
			this.dateArrival=E;
			this.passport=f;
			this.priorityLevel=g;
			
			
		//	System.out.println(" Pegando classe Node"+ element);
			
		}
	}


