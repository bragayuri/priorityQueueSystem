package View;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import Model.Profile;

public class DeletePerson extends JFrame implements ActionListener {

	Queue<Profile> person;
	static JTable t;
	
	protected String qNumber;
	protected String idProfile;
	protected String surname;
	protected String name;
	protected String arrivalDate;
	protected String passport;
	protected String priorityLevel;
	
	
	public DefaultTableModel tableModel;
	
	public DeletePerson() {
		this.setVisible(true);
		this.setSize(900,400);
		this.setTitle("Editing Profile");
		
		JPanel one = new JPanel();
		this.add(one);
		
		GridLayout grid = new GridLayout(2,1);
		one.setLayout(grid);
		
		String[] columnName = {
				"qNumber",
				"idProfile",
				"surname",
				"name",
				"arrival",
				"passport",
				"priorityLevel",
				
		};
		
		tableModel = new DefaultTableModel(columnName,1);
	    Db ();
		
		t = new JTable(tableModel);
		
		t.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		JScrollPane sp = new JScrollPane(t);
		one.add(sp);
		
		JPanel two = new JPanel();
		one.add(two);
		
		GridLayout grid2 = new GridLayout(1,5);
		two.setLayout(grid2);
		
		JButton btn1 = new JButton("Save Changes");
		two.add(btn1);
		btn1.setActionCommand("save");
		btn1.addActionListener(this);
		
		
		JButton btn2 = new JButton("Delete");
		two.add(btn2);
		btn2.addActionListener(new ActionListener () {
			public void actionPerformed (ActionEvent e) {
				
				tableModel = (DefaultTableModel)t.getModel();
				try {
					
					int rowToRemove = t.getSelectedRow();
					tableModel.removeRow(rowToRemove);
		
		}catch(Exception ex) {
			
			JOptionPane.showMessageDialog(null, ex);
		}
			}
			
		});
		
		
		JButton btn3 = new JButton("Home");
		two.add(btn3);
		btn3.setActionCommand("home");
		btn3.addActionListener(this);
		
		JButton btn4 = new JButton ("Go Back");
		two.add(btn4);
		btn4.setActionCommand("Go Back");
		btn4.addActionListener(this);
		
		this.validate();
		this.repaint();
		
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
	
		
		if (e.getActionCommand().equals("Go Back")) {
			this.dispose();
			MainPanel mypanel = new MainPanel();
		
		}else if (e.getActionCommand().equals("home")) {
			MainPanel mypanel2 = new MainPanel();
		}
		
	}
	
	public void Db() {
		
		try {
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
						Profile  p;
						
						
						while (rs.next())
						{ p = new Profile (
								rs.getString("qNumber"),
								rs.getString("idprofile"),
								rs.getString("surname"),
								rs.getString("firstname"),
								rs.getString("arrivalDate"),
								rs.getString("passport"),
								rs.getString("priorityLevel")
								);
						person = new LinkedList<>();
						person.add(p);
						
						for(int i= 0; i<person.size();i++) {
							qNumber = ((LinkedList<Profile>) person).get(i).getqNumber();
							idProfile = ((LinkedList<Profile>) person).get(i).getIdProfile();
							surname = ((LinkedList<Profile>) person).get(i).getSurname();
							name = ((LinkedList<Profile>) person).get(i).getFirstName();
							arrivalDate = ((LinkedList<Profile>) person).get(i).getDateArrival();
							passport = ((LinkedList<Profile>) person).get(i).getPassport();
							priorityLevel =((LinkedList<Profile>) person).get(i).getPriorityLevel();
							
							
							Object[] data = {
									qNumber,idProfile,surname,name,arrivalDate,passport,priorityLevel
							};
							
							tableModel.addRow(data);
							
						}
							
						}
						
						rs.close();
						stmt.close();
						conn.close();
						
						
						
			
		} catch (SQLException se) {
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
		
	}
	


