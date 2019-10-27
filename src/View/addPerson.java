package View;

import java.awt.Font;
import Controller.Actions;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JComboBox;

/*   name:Yuri Braga
 *   student number:2017141
 */

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Controller.Actions;
import Model.DoublyLinkedListImpl;
import Model.Profile;

/*
 * The responsibility of this class is to ensure a frame is set and the User can register a new Person.
 * This class is extending JFrame and Implementing the ActionListener interface.
 */


public class addPerson extends JFrame implements ActionListener {
	
	
	JTextField t2;//idprofile
	JTextField t4;//surname
	JTextField t5;//name
	JTextField t6;//arrivaldate
	JTextField t7;//passport
	JLabel total;
	JComboBox<String> combo;//prioritylevel
	
	Actions action = new Actions();
	

	DoublyLinkedListImpl<Profile> queue;
	
	//My constructor which will set up my frame and its attributes. 
	public addPerson() {
		this.setVisible(true);
		this.setSize(500,550);
		
		// The grid layout here will organise my panels.
		GridLayout mygrid = new GridLayout(10,1);
		this.setLayout(mygrid);
		
		/*
		 *#########################################
		 */
		JPanel one = new JPanel();
		this.add(one);
		
		
		JLabel mylabel = new JLabel("ADD NEW PERSON");
		one.add(mylabel);
		mylabel.setFont(new Font("Serif", Font.PLAIN, 30));
		
		/*
		 * ##########################################
		 */
		

		JPanel three = new JPanel();
		this.add(three);

		JLabel l2 = new JLabel("idProfile");
		three.add(l2);

		t2= new JTextField(20);
		three.add(t2);
		
		//*****************************************
		
		JPanel four = new JPanel();
		this.add(four);

		JLabel l3 = new JLabel("Priorty Level");
		four.add(l3);

		String[] items = {"HIGHT(H)", "MEDIUM(M)", "LOW(L)"};

		combo = new JComboBox<>(items);
		four.add(combo);
		
		/*
		 * #################################################
		 */

		JPanel five = new JPanel();
		this.add(five);

		JLabel l4 = new JLabel("SURNAME");
		five.add(l4);

		t4= new JTextField(20);
		five.add(t4);
		
		/*
		 * ####################################################
		 */

		JPanel six = new JPanel();
		this.add(six);

		JLabel l5 = new JLabel("NAME");
		six.add(l5);

		t5= new JTextField(20);
		six.add(t5);
		
		//*********************************************
		
		JPanel seven = new JPanel();
		this.add(seven);

		JLabel l6 = new JLabel("ARRIVAL DATE");
		seven.add(l6);

		t6= new JTextField(20);
		seven.add(t6);
		
		/*
		 * ############################################
		 */

		JPanel eight = new JPanel();
		this.add(eight);

		JLabel l7 = new JLabel("PASSPORT");
		eight.add(l7);

		t7= new JTextField(20);
		eight.add(t7);
		//**********************************************
		
		JPanel fourteen = new JPanel();
		this.add(fourteen);

		JPanel newone = new JPanel();
		this.add(newone);

		total = new JLabel ("0 Number Registered");
		newone.add(total);
		
		//*************************************************
		
		/*
		 * At this stage my frame is done and I will add some buttons to it.
		 * The button`s functionality will Register,Go Back or direct to the Main Panel.
		 */

		JButton btn1 = new JButton("REGISTER");
		fourteen.add(btn1);
		btn1.setActionCommand("REGISTER");
		btn1.addActionListener(this);
		
		JButton btn2 = new JButton("GO BACK");
		fourteen.add(btn2);
		btn2.setActionCommand("GOBACK");
		btn2.addActionListener(this);
		
		JButton btn3 = new JButton("HOME");
		fourteen.add(btn3);

		this.validate();
		this.repaint();








		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("REGISTER")) {
			
			String a="0";
			String b = t2.getText();
			String c = t4.getText();
			String d = t5.getText();
			String E = t6.getText();
			String f = t7.getText();
			String g = (String) combo.getSelectedItem();
			
			//Instance of my Profile class receiving the String values.
			
			Profile myprofile = new Profile(a,b,c,d,E,f,g);
			/*
			 * queue = new DoublyLinkedListImpl<Profile>(); queue.addFirst(myprofile);
			 */
			
			// Actions class will add the new user to an ArrayList
						action.cadastraCustomer(myprofile);
						
			//This will display the amount of registered Users saved on an ArrayList.
						total.setText(action.numberOfContacts()+" Registred New Users");

						JOptionPane.showMessageDialog(this, "Register Completed!");

						// This is a test to be displayed on the Console if everything works.
						System.out.println(myprofile);

						//This will erase the values of my JTextField once transaction is done.
						t2.setText("");
						t4.setText("");
						t5.setText("");
						t6.setText("");
						t7.setText("");
						
						/*
						 * The else if will direct the user to the previous page in case GOBACK button is pressed.         
						 */

					}else if(e.getActionCommand().equals("GOBACK")) {

						MainPanel myPanel = new MainPanel();
						this.dispose();

					}

			
			
			
			
		}
		
		
		
		
	}
		
	


