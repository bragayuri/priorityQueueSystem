/*
 * Yuri Braga studentNumber:2017141
 */

// This class belong to my controller class
package Controller;
import java.util.ArrayList;

import Model.Profile;

// This class will make add a new customer to an ArrayList every time a new user is generated.
public class Actions{
	
	/*
	 * This ArrayList will hold values while the program is running;
	 */
	
	ArrayList<Profile> people = new ArrayList();
	
	/*
	 * this method will add a new customer to an ArrayList.
	 */
	public void cadastraCustomer(Profile contact) {
		people.add(contact);
	}
	
	/*
	 * this method will count the number of new Users inside the Array.
	 */
	
	public String numberOfContacts() {
		return people.size()+"";
	}
	
}

