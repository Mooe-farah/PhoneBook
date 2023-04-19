package Myphone;

import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class PhoneBook implements ActionListener {
	ArrayList personsList;
	PersonDAO  pDAO;
	
	JFrame appFrame;
	
	JLabel jlbFullName, jlbAddress, jlbCity, jlbPhoneNumber;
	JTextField jtfFullName, jtfAddress, jtfCity, jtfPhoneNumber;
	JButton jbnSave, jbnDelete, jbnSearch, jbnUpdate, jbnExit;
	
	String fullNames, address, city;
	int phoneNumber;
	int recordNumber;
	Container cPane;
	
	//main method starts here
	public static void main(String[] args) {
		new PhoneBook();
	}
	
	public PhoneBook() {
		fullNames = "";
		address = "";
		city = "";
		phoneNumber = -1; //stores 0 t0 indicate no phone
		recordNumber = -1;
		createGUI(); 
		
		personsList = new ArrayList();
		//creating personDAO object
		pDAO = new PersonDAO();
	}
	
	//method to createGUI
	public void createGUI() {
		/*Create a frame, get its contentPane and set layout*/
   		appFrame = new JFrame("My PhoneBook");
   		
   		cPane = appFrame.getContentPane();
   		cPane.setLayout(new GridBagLayout());
   		
   		//Arrange components on contentPane and set Action Listeners to each JButton
   		arrangeComponents();
   		
   		appFrame.setSize(500, 600);
   		appFrame.setResizable(false);
   		appFrame.setVisible(true);
   		appFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   		
	}
	
	//method to create arrangeComponents();
	public void arrangeComponents() {
		//components of JLabel sector
		jlbFullName = new JLabel("Full Name");
		jlbAddress = new JLabel("Address");
		jlbCity = new JLabel("City");
		jlbPhoneNumber = new JLabel("Phone Number");
		
		//TextFields
		jtfFullName = new JTextField("");
		jtfAddress = new JTextField("");
		jtfCity = new JTextField("");
		jtfPhoneNumber = new JTextField("");
		
		//buttons
		jbnSave = new JButton("Save");
		jbnDelete = new JButton("Delete");
		jbnSearch = new JButton("Search");
		jbnUpdate = new JButton("Update");
		jbnExit =  new JButton("Exit");
		
   		/*add all initialized components to the container*/
		GridBagConstraints gridBagConstraintsx01 = new GridBagConstraints();
        gridBagConstraintsx01.gridx = 0;
        gridBagConstraintsx01.gridy = 0;
        gridBagConstraintsx01.insets = new Insets(5,5,5,5); 
        cPane.add(jlbFullName, gridBagConstraintsx01);
        
        GridBagConstraints gridBagConstraintsx02 = new GridBagConstraints();
        gridBagConstraintsx02.gridx = 1;
        gridBagConstraintsx02.insets = new Insets(5,5,5,5); 
        gridBagConstraintsx02.gridy = 0;
        gridBagConstraintsx02.gridwidth = 2;
        gridBagConstraintsx02.fill = GridBagConstraints.BOTH;
        cPane.add(jtfFullName, gridBagConstraintsx02);
        
        GridBagConstraints gridBagConstraintsx03 = new GridBagConstraints();
        gridBagConstraintsx03.gridx = 0;
        gridBagConstraintsx03.insets = new Insets(5,5,5,5); 
        gridBagConstraintsx03.gridy = 1;
        cPane.add(jlbAddress, gridBagConstraintsx03);
        
        GridBagConstraints gridBagConstraintsx04 = new GridBagConstraints();
        gridBagConstraintsx04.gridx = 1;
        gridBagConstraintsx04.insets = new Insets(5,5,5,5); 
        gridBagConstraintsx04.gridy = 1;
        gridBagConstraintsx04.gridwidth = 2;
        gridBagConstraintsx04.fill = GridBagConstraints.BOTH;
        cPane.add(jtfAddress, gridBagConstraintsx04);
        
        GridBagConstraints gridBagConstraintsx07 = new GridBagConstraints();
        gridBagConstraintsx07.gridx = 0;
        gridBagConstraintsx07.insets = new Insets(5,5,5,5); 
        gridBagConstraintsx07.gridy = 3;
        cPane.add(jlbCity, gridBagConstraintsx07);
        
        GridBagConstraints gridBagConstraintsx08 = new GridBagConstraints();
        gridBagConstraintsx08.gridx = 1;
        gridBagConstraintsx08.gridy = 3;
        gridBagConstraintsx08.gridwidth = 2;
        gridBagConstraintsx08.insets = new Insets(5,5,5,5); 
        gridBagConstraintsx08.fill = GridBagConstraints.BOTH;
        cPane.add(jtfCity, gridBagConstraintsx08);
        
        GridBagConstraints gridBagConstraintsx05 = new GridBagConstraints();
        gridBagConstraintsx05.gridx = 0;
        gridBagConstraintsx05.insets = new Insets(5,5,5,5); 
        gridBagConstraintsx05.gridy = 2;
        cPane.add(jlbPhoneNumber, gridBagConstraintsx05);
        
        GridBagConstraints gridBagConstraintsx06 = new GridBagConstraints();
        gridBagConstraintsx06.gridx = 1;
        gridBagConstraintsx06.gridy = 2;
        gridBagConstraintsx06.insets = new Insets(5,5,5,5); 
        gridBagConstraintsx06.gridwidth = 2;
        gridBagConstraintsx06.fill = GridBagConstraints.BOTH;
        cPane.add(jtfPhoneNumber, gridBagConstraintsx06);
        
        GridBagConstraints gridBagConstraintsx09 = new GridBagConstraints();
        gridBagConstraintsx09.gridx = 0;
        gridBagConstraintsx09.gridy = 4;
        gridBagConstraintsx09.insets = new Insets(5,5,5,5); 
        cPane.add(jbnSave, gridBagConstraintsx09);
        
        GridBagConstraints gridBagConstraintsx10 = new GridBagConstraints();
        gridBagConstraintsx10.gridx = 1;
        gridBagConstraintsx10.gridy = 4;
        gridBagConstraintsx10.insets = new Insets(5,5,5,5); 
        cPane.add(jbnDelete, gridBagConstraintsx10);
        
        GridBagConstraints gridBagConstraintsx13 = new GridBagConstraints();
        gridBagConstraintsx13.gridx = 1;
        gridBagConstraintsx13.gridy = 5;
        gridBagConstraintsx13.insets = new Insets(5,5,5,5); 
        cPane.add(jbnSearch, gridBagConstraintsx13);
        
        GridBagConstraints gridBagConstraintsx11 = new GridBagConstraints();
        gridBagConstraintsx11.gridx = 2;
        gridBagConstraintsx11.gridy = 4;
        gridBagConstraintsx11.insets = new Insets(5,5,5,5); 
        cPane.add(jbnUpdate, gridBagConstraintsx11);
        
        GridBagConstraints gridBagConstraintsx16 = new GridBagConstraints();
        gridBagConstraintsx16.gridx = 2;
        gridBagConstraintsx16.gridy = 6;
        gridBagConstraintsx16.insets = new Insets(5,5,5,5); 
        cPane.add(jbnExit, gridBagConstraintsx16);
        
    	jbnSave.addActionListener(this);
   		jbnDelete.addActionListener(this);
   		jbnUpdate.addActionListener(this);
   		jbnSearch.addActionListener(this);
   		jbnExit.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == jbnSave) {
			SavePerson();
			clear();
		} else if(e.getSource() == jbnDelete) {
			deletePerson();
			clear();
		}else if(e.getSource() == jbnSearch) {
			searchPerson();
		}else if(e.getSource() == jbnUpdate) {
			UpdatePerson();
			clear();
		}else if(e.getSource() == jbnExit) {
			System.exit(0);}
		}
		
	     // Add the Person into the Phone Book 
		public void SavePerson() {
			fullNames = jtfFullName.getText();
			fullNames = fullNames.toUpperCase();
			address = jtfAddress.getText();
			try {
				phoneNumber = Integer.parseInt("" +jtfPhoneNumber.getText());
			} catch(Exception e) {
				System.out.println("Input is a String");
				JOptionPane.showMessageDialog(null, "Please Enter your Phone Number");
			}
			
			if(fullNames.equals("")) {
				JOptionPane.showConfirmDialog(null, "Please Enter full name ");
			} else {
				//create a PersonInfo object and pass it to PersonDAO to Add it
				PersonInfo person = new PersonInfo(fullNames, address, city, phoneNumber);
				pDAO.SavePerson(person);
				JOptionPane.showMessageDialog(null, "Person Added");
			}
		}
		
		public void deletePerson() {
			fullNames = jtfFullName.getText();
			fullNames = fullNames.toUpperCase();
			if(fullNames.equals("")) {
				JOptionPane.showMessageDialog(null, "Please enter person name to delete.");
			}else {
				//remove Person of the given name from the Phone Book database
				int numberOfDeleted = pDAO.removePerson(fullNames);
				JOptionPane.showMessageDialog(null, numberOfDeleted + "Record(s) deleted.");
			}
		}
		
		  //Perform a Case-Insensitive Search to find the Person
		public void searchPerson() {
			fullNames = jtfFullName.getText();
			fullNames = fullNames.toUpperCase();
			/*clear contents of arrayList if there are any from previous search*/
			personsList.clear();
			
			recordNumber = 0;
			
			if(fullNames.equals("")) {
				JOptionPane.showMessageDialog(null,"Please enter person name to search.");
			}else {
				/*get an array list of searched persons using PersonDAO*/
				personsList = pDAO.searchPerson(fullNames);
			}
				if(personsList.size() == 0) {
					JOptionPane.showMessageDialog(null, "No records found.");
					//Perform a clear if no records are found.
		   			clear();
				}else {
					/*downcast the object from array list to PersonInfo*/
					PersonInfo person = (PersonInfo) personsList.get(recordNumber);
					
					 // displaying search record in text fields 
					jtfFullName.setText(person.getfullNames());
					jtfAddress.setText(person.getAddress());
					jtfCity.setText(person.getCity());
					jtfPhoneNumber.setText("" + person.getphoneNumber());}
				
				}
		
		public void UpdatePerson() {
			if(recordNumber >= 0 && recordNumber < personsList.size()) {
				PersonInfo person = (PersonInfo) personsList.get(recordNumber);
				
				int phoneNumber = person.getphoneNumber();
				   /*get values from text fields*/ 
					fullNames = jtfFullName.getText();
					address = jtfAddress.getText();
					phoneNumber = Integer.parseInt(jtfPhoneNumber.getText());
					   /*Modify data of the given person name*/
					person = new PersonInfo(fullNames, address, city, phoneNumber);
					pDAO.UpdatePerson(person);
					
					JOptionPane.showMessageDialog(null, "Person into record update successfully.");         
			}
			else {
				JOptionPane.showMessageDialog(null, "No record to update");
			}
		}
			
			
			  public void clear(){
				    
				   	jtfFullName.setText("");
				   	jtfAddress.setText("");
				   	jtfPhoneNumber.setText("");
				   	jtfCity.setText("");
				   	
				   	/*clear contents of arrayList*/
				    recordNumber = -1;
				   	personsList.clear();

		}
	
	
}



