//Author:Yuri Braga
//2017141

/*
 * This enum will control the priority access of the list.
 */

package Model;


public enum Priority {
	//Definig here my priority access Level
	HIGH("high priority"), // High as the highest access and goes to the front
	MEDIUM("medium priority"), // Medium will be added in the middle.
	LOW("low priority");// Goes to the end of the list.
	
	private final static String[] descriptions= generateArrayDescription();
	private static final Priority[] priorities = values();
	private final String description;
	
	Priority(String description){
		this.description=description;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public static Priority[] getAllOptions() {
		return priorities;
	}
	
	public static String[] generateArrayDescription() {
		String[] names = new String[priorities.length];
		for(int x = 0; x< names.length; x++) {
			names[x] = priorities[x].getDescription();
		}
		return names;
	}
	
	
	public static String[] getAllDescriptions() {
		return descriptions;
	}
	
	

}
