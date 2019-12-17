// Yuri Braga Student Number: 2017141

package View;

import java.awt.BorderLayout;
import java.awt.Color;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import Model.DoublyLinkedListImpl;
import Model.Profile;






/* 
 * This is my Main Panel Class. This Class is responsible for the visual aspects of the main panel.
 * 
 */

/*
 * Applying the object oriented programming where MainPanel is an abstraction of my JFrame Class.
 * Also the MainPanel class implements the interface ActionListener.
 */
public class MainPanel extends JFrame implements ActionListener {
	
	/*
	 * Instance of my JTable that will hold the values regards Users.
	 * 
	 */
	static JTable t;
	
	/*
	 * Instance of my Customer ArrayList to use within my connection.
	 */

	ArrayList<Profile> profiles;
	
	/* 
	 * Here is my default Table Model which will hold the values from my ArrayList.
	 */
	 
	public DefaultTableModel tableModel ;

	/*
	 * This constructor will start defining attributes of my frame.
	 */
	/*
	 * Here are my variables that will be Encapsulated and are protected to this class.
	 */
	    protected String qNumber;
		protected String profileId;
		protected String name;	 
		protected String surname;
		protected String arrivaldate;
		protected String passport;
		protected String priorityLevel;
		
		JTextArea queuetxt = new JTextArea();
		
		private DoublyLinkedListImpl <Profile >list;
		
		/* 
		 * Here is my default Table Model which will hold the values from my ArrayList.
		 */
		 
	
		 
	public MainPanel() {
		this.setVisible(true);
		this.setSize(800, 800);
		
		queuetxt.setEditable(false);

		
		
		/*
		 * creating a GridLayout to organise all the items.
		 */
		GridLayout grid = new GridLayout(3, 1);
		this.setLayout(grid);

		/*
		 * creating a container to my frame.
		 */

		JPanel one = new JPanel();
		this.add(one);

		JLabel welcome = new JLabel("WELCOME TO THE IMMIGRATION LIST SERVICE");// Label that is the Title of my frame.
		one.add(welcome);// adding my Label to my Panel.
		welcome.setFont(new Font("Serif", Font.PLAIN, 30));// setting a new Font to the Label.
		welcome.setForeground(Color.BLUE);// Setting a new colour to my Label.

		// ##################################################################################################

		JPanel two = new JPanel();// creating a container to my frame.
		this.add(two); 

		GridLayout grid6 = new GridLayout(1, 2); // creating a GridLayout to organise all the items.
		two.setLayout(grid6);

		/*
		 * Creating some JButtons.
		 */

		/*
		 * This button will bring a new window to create a new profile for a person in the queue.
		 */
		JButton btn1 = new JButton("+ NEW PROFILE");
		two.add(btn1);
		btn1.setActionCommand("+profile");
		btn1.addActionListener(this);
		
		/*
		 *  This button will check the position for a profile in the queue.
		 */

		JButton btn2 = new JButton("CHECK POSITION");
		two.add(btn2);
		btn2.setActionCommand("checkposition");
		btn2.addActionListener(this);

		/*
		 * This button will delete a profile in the queue.
		 */
		JButton btn3 = new JButton("DELETE PROFILE");
		two.add(btn3);
		btn3.setActionCommand("delete");
		btn3.addActionListener(this);
		
		/*
		 * This will update a profile without affecting the order in the queue.
		 */
		
		JButton btn4 = new JButton("UPDATE PROFILE");
		two.add(btn4);
		btn4.setActionCommand("Media");
		btn4.addActionListener(this);
		
		/*
		 * This will enable to cut off positions at the end of the queue.
		 */
		
		JButton btn5 = new JButton("EDIT QUEUE");
		two.add(btn5);
		btn5.setActionCommand("e");
		btn5.addActionListener(this);

		// ######################################################################################################
		JPanel three = new JPanel();
		this.add(three);

		GridLayout grid2 = new GridLayout(1, 1); // creating a GridLayout to organise all the items.
		three.setLayout(grid2);

		// ######################################################################################################

		JPanel left = new JPanel();
		three.add(left);
		
		JLabel welcome2 = new JLabel("WELCOME TO THE IMMIGRATION LIST SERVICE");// Label that is the Title of my frame.
		left.add(welcome2);// adding my Label to my Panel.
		welcome2.setFont(new Font("Serif", Font.PLAIN, 15));// setting a new Font to the Label.
		welcome2.setForeground(Color.RED);// Setting a new colour to my Label.
		
		 String[] columnName = {"qNumber",
				 "PersonID", 
				 "Name", 
				 "Surname","ArrivalDate",
				 "Passport","PriorityLevel",
				 
				 };
		 //Here I set my DefaultTable model and its columns Names.
		 //Also I start my Db connection.
		 
		 tableModel = new DefaultTableModel(columnName, 1);
		Db ();
		  
		  // Here my table adds the TableModel.
		 
		t = new JTable(tableModel);
		
		 
		// Here I set the Selectmode to be able to Update the table.
		//Also I will ad my ScrollPane.
	   t.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
	        JScrollPane sp = new JScrollPane(t);
	        left.add(sp);
	        
	        
	        
	        
	   
		this.validate();
		this.repaint();

	}
	
	public DoublyLinkedListImpl<Profile> getList(){
		return list;
	}
	
	public void Db() {
		
		
		
		try{
			// Load the database driver
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance() ;
			
			String dbServer = "jdbc:mysql://localhost:3306/queue?useTimezone=true&serverTimezone=UTC";
			String user = "root";
			String password = "rootroot";
			
			// Get query
			
			String query = "Select * from profile";

			// Get a connection to the database
			Connection conn = DriverManager.getConnection(dbServer, user, password) ;

			// Get a statement from the connection
			java.sql.Statement stmt = conn.createStatement() ;

			// Execute the query
			ResultSet rs = stmt.executeQuery(query) ;
			
            // setting a value to c type Customer.
			Profile p;
			
			
			
			  //Here p will receive the Strings from my Database using the rs.
			  // From here the values from my Profile Database are now with the variable ` p `.
	            while (rs.next()) 
	            {  p = new Profile (
	            		        rs.getString("qNumber"),
	        					rs.getString("idprofile"),
	        					rs.getString("Surname"),
	        					rs.getString("firstName"),
	        					rs.getString("arrivalDate"),
	        					rs.getString("passport"),
	        					rs.getString("priorityLevel")
	        					
	        					);
	            
                  //Here I start an Instance of my ArrayList of Profile which will hold the values extracted from my Databases.
	            
	              profiles = new ArrayList<Profile>();
	              
	              //Here I am passing the values to the Array List. From here all the values extracted from the Database are now
	              // hold into an ArrayList of Customer, which I named users.
                  profiles.add(p);
                  
                  // here I will pass the values from my Customer List to an Object.
                  // For each line I will use the get methods from my Customer ArrayList.
                  //From this point ahead all the values from the Database will be placed into a new set of Strings.
                  
                  
                  for(int i=0; i< profiles.size(); i++) {
         			 qNumber =profiles.get(i).getqNumber();
         			 profileId=profiles.get(i).getIdProfile();
         			 surname=profiles.get(i).getSurname();
         			 name=profiles.get(i).getFirstName();
         			 arrivaldate=profiles.get(i).getDateArrival();
         			 passport=profiles.get(i).getPassport();
         			 priorityLevel=profiles.get(i).getPriorityLevel();
         	
         			 
         			 // This next line I will pass these Strings to an array of Objects.
         			 //Which then will be placed into my Default Table Model.
         			 
         			Object[] data = {qNumber, profileId, surname, name, arrivaldate, passport, 
                            priorityLevel};
         			
         			// Here I am adding the values to the default Table Model.
         			
         			tableModel.addRow(data);
         			
         			 
         		 }
         		 

	            }


			// Close the result set, statement and the connection
			rs.close() ;
			stmt.close() ;
			conn.close() ;
		}
		catch( SQLException se ){
			System.out.println( "SQL Exception:" ) ;

			// Loop through the SQL Exceptions
			while( se != null ){
				System.out.println( "State  : " + se.getSQLState()  ) ;
				System.out.println( "Message: " + se.getMessage()   ) ;
				System.out.println( "Error  : " + se.getErrorCode() ) ;

				se = se.getNextException() ;
			}
		}
		catch( Exception e ){
			System.out.println( e ) ;
		}
	}

	@Override
	
	//@Override
	public void actionPerformed(ActionEvent e) {
		

		if (e.getActionCommand().equals("+profile")) {
			//this.dispose();

			addPerson nc = new addPerson();

		} else if ((e.getActionCommand().equals("checkposition"))) {
			this.dispose();

			CheckPosition nr = new CheckPosition();

		}
		if ((e.getActionCommand().equals("e"))) {
			
			
			System.out.println("LIST: ");
			list.displayForward();
			
			
          
			

		}
		else if ((e.getActionCommand().equals("delete"))) {
			this.dispose();

			DeletePerson del = new DeletePerson();



	}
	}
}


