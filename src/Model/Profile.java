//Yuri Braga 2017141

package Model;

import java.util.LinkedList;
import java.util.Queue;

import Model.DoublyLinkedListImpl.Node;

/* 
 * This is class will be responsible to get the values inserted on the View and pass to the Database.
 * It will also encapsulate values and through the toString method its possible to observe the registered on the Console.
 * 
 */



public class Profile {
	
	
	// First I define all the attributes to create a Profile.
	
	protected String qNumber;
	

	protected String idProfile;
	protected String surname;
	protected String firstName;
	protected String dateArrival;
	protected String passport;
	protected String priorityLevel;
	
	DoublyLinkedListImpl outerclass;
	
	Node element;
	
	
	
	
	//My Constructor is receiving as a parameter a set of Strings that will be encapsulated for this class.
		//The String values are coming from my View class where the User types in from a jTextField class.
		//This Constructor will also pass the String message to my DB connection using a query message.
		//From there all my values will be saved on my Database.
	
	
	public Profile(String a,String b,String c,String d,String E,String f,String g) {
		this.qNumber=a;
		this.idProfile=b;
		this.surname=c;
		this.firstName=d;
		this.dateArrival=E;
		this.passport=f;
		this.priorityLevel=g;
		
		
		
		element= new Node(a,b,c,d,E,f,g);
		
		
		
		
		
		// element= new Profile (a,b,c,d,E,f,g);
			
			//queue = new DoublyLinkedListImpl<Profile>();
			//queue.addFirst(element);
		
		
	  
		
		/*
		 * String message =
		 * "INSERT INTO `queue`.`profile` (`qNumber`,`idProfile`,`Surname`,`firstName`,`arrivalDate`,`passport`,`priorityLevel`) "
		 * + "VALUES ('" + qNumber + "','" + idProfile + "', '" + surname + "', '" +
		 * firstName + "','" + dateArrival + "','" + passport + "','" + priorityLevel +
		 * "');";
		 * 
		 * Db mydb = new Db(); mydb.DbInsertCustomer(message);
		 * 
		 */
	}
	
	
	 
		
	
	
	
	
	
	
			
	
	
	// My getters and Setters for the values set on this class.
	// The Setter and Getters will enable to get each attribute of this class whatever I would like to use it.
	public String getqNumber() {
		return qNumber;
	}


	public void setqNumber(String qNumber) {
		this.qNumber = qNumber;
	}


	public String getIdProfile() {
		return idProfile;
	}


	public void setIdProfile(String idProfile) {
		this.idProfile = idProfile;
	}


	public String getSurname() {
		return surname;
	}


	public void setSurname(String surname) {
		this.surname = surname;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getDateArrival() {
		return dateArrival;
	}


	public void setDateArrival(String dateArrival) {
		this.dateArrival = dateArrival;
	}


	public String getPassport() {
		return passport;
	}


	public void setPassport(String passport) {
		this.passport = passport;
	}


	public String getPriorityLevel() {
		return priorityLevel;
	}


    public void setPriorityLevel(String priorityLevel) {
		this.priorityLevel = priorityLevel;
	}








			
	
			// The ToString method will transform to String any build path I might want to consult.
			//For Example: When I want to instanciate this class and print the new Object of an ArrayList
			// My to String method will transform this Object to a String which enable the Strings to be printed
			//into the console.
			
			//@Override
			public String toString() {
				return "NAME: "+firstName+" SURNAME "+ surname +" PASSPORT "+ passport +" Arrival Date: "+dateArrival+" ID Profile: "+idProfile+" Priority: "+ priorityLevel+ "";
				
			}
	
	
	
	
	

}
