package View;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Model.Db;

public class CheckPosition extends JFrame implements ActionListener {
	
	public CheckPosition () {
		
		welcomeframe();
		
	}
	
	public void welcomeframe() {
		
		    JTextField field1 = new JTextField("");
	        JPanel panel = new JPanel(new GridLayout(0, 1));
	        
	        panel.add(new JLabel("Enter Person ID:"));
	        panel.add(field1);
	       
	     
	        
	        int result = JOptionPane.showConfirmDialog(null, panel, "CHECK POSITION",
	           
	        		JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
	        
	        if (result == JOptionPane.OK_OPTION) {
	            System.out.println(
	                 " " + field1.getText()
	                );
	           
	            String message = "Select * from profile WHERE idProfile ='" + field1.getText() +  "'";
	             Db mydb = new Db();
	             mydb.DbInsertCustomer(message);
	            ;
	        } else {
	            System.out.println("Cancelled");
	        }
	    }

	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
