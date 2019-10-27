package Model;

import java.util.LinkedList;
import java.util.Queue;

import View.DeletePerson;

public class Queues {
	
	protected String qNumber;
	protected String idProfile;
	protected String surname;
	protected String name;
	protected String arrivalDate;
	protected String passport;
	protected String priorityLevel;
	
	
	public Queues() {
		
		Queue<Profile> q = new LinkedList<>();
		
		for(int i=0;i<q.size();i++) {
			
			DeletePerson x = new DeletePerson();
			x.Db();
			
			
			qNumber = ((LinkedList<Profile>) q).get(i).getqNumber();
			idProfile = ((LinkedList<Profile>) q).get(i).getIdProfile();
			surname = ((LinkedList<Profile>) q).get(i).getSurname();
			name = ((LinkedList<Profile>) q).get(i).getFirstName();
			arrivalDate = ((LinkedList<Profile>) q).get(i).getDateArrival();
			passport = ((LinkedList<Profile>) q).get(i).getPassport();
			priorityLevel =((LinkedList<Profile>) q).get(i).getPriorityLevel();
			
		}
		
		System.out.println("Elements of my queue"+q);
		
	}

}
