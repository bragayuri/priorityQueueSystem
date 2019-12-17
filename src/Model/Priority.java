//Author:Yuri Braga
//2017141

/*
 * This enum will control the priority access of the list.
 */

package Model;

/*
 *  This Enum priority will be used to define access level to each profile.
 *  It Priority holds a number to be used as a reference to compare.
 *  If it is High, goes to the front of the queue.
 *  If it is Medium goes to the middle.
 *  If its Low goes to the end of the queue.
 */

public enum Priority {
	//Definig here my priority access Level
	HIGH("1"), // High as the highest access and goes to the front
	MEDIUM("2"), // Medium will be added in the middle.
	LOW("3");// Goes to the end of the list.
	
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
