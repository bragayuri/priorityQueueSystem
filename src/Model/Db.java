// Yuri Braga 2017141

package Model;

import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
 * This class will be responsible for some of my Db connections.
 */

public class Db {
	
	private static final String Customer = null;

	String[][] data = new String[12][12]; //arrays with the query information
	
	Connection conn = null;
	
	Statement stmt =null;
	
	ResultSet rs =null;
	
	
	
	
	
	
// public void DbInsertCustomer(String t1, String t2, String t3, String t4, String t5, String t6, String t7, String t8, String t9, String t10, String t11) 
	
	 public void DbInsertCustomer(String message) {
	        try {
	// Load the database driver

	            //Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
	            String dbServer = "jdbc:mysql://localhost:3306/queue?useTimezone=true&serverTimezone=UTC";
	            String user = "root";
	            String password3 = "rootroot";

	            String query = message;
	// Get a connection to the database
	            Connection conn = DriverManager.getConnection(dbServer, user, password3);

	// Get a statement from the connection
	            Statement stmt = conn.createStatement();

	// Execute the query
	            stmt.execute(query);
	            stmt.close();
	            conn.close();

	// Close the result set, statement and the connection
	        } catch (SQLException se) {
	            System.out.println("SQL Exception:");

	// Loop through the SQL Exceptions
	            while (se != null) {
	                System.out.println("State : " + se.getSQLState());
	                System.out.println("Message: " + se.getMessage());
	                System.out.println("Error : " + se.getErrorCode());

	                se = se.getNextException();
	            }
	        } catch (Exception e) {
	            System.out.println(e);
	        }
	        
	 }
	 
	 
	 
	 
}
	 