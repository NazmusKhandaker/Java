package view;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import model.Name;

/* This panel is part of the View and displays the name panel form.*/
public class NamePanel extends JPanel {

	//declare components as fields so they can be accessed throughout the class
	private JComboBox<String> cboTitle;
	private JTextField txtSurname, txtFirstName;

	public NamePanel() {
		//create a combound border, a titled border, which then has an empty border for padding
		this.setBorder(BorderFactory.createCompoundBorder(new EmptyBorder(10, 10, 10, 10), new TitledBorder("Name")));

		//set the layout manager for this panel to be grid layout
		this.setLayout(new GridLayout(3,2));


		//LABELS
		JLabel lblTitle = new JLabel("Title", JLabel.RIGHT); //alignment applied
		lblTitle.setBorder(new EmptyBorder(0,0,0,5)); //add right padding

		JLabel lblSurname = new JLabel("Surname", JLabel.RIGHT);  //alignment applied
		lblSurname.setBorder(new EmptyBorder(0,0,5,5)); //add right and bottom padding

		JLabel lblFirstName = new JLabel("First name", JLabel.RIGHT);  //alignment applied
		lblFirstName.setBorder(new EmptyBorder(0,0,5,5)); //add right and bottom padding


		/* NOTE how combobox and textfields (below) are initialised in the constructor but have been
		 * declared as class level fields so they can be accessed throughout the class (in other methods/event handlers) */


		//COMBO BOX
		String[] titles = {"Mr", "Mrs", "Miss", "Ms", "Dr"};
		cboTitle = new JComboBox<String>(titles);

		//TEXT BOXES
		txtSurname = new JTextField(10);
		txtFirstName = new JTextField(10);

		//temp panel used to add certain components to stop them resizing/filling size of grid cell
		//as JPanel uses FlowLayout by default, which stops this behaviour
		JPanel p;


		//ADD TO CONTAINER AND SET ALIGNMENT
		this.add(lblTitle); //cell 1,1

		p = new JPanel();
		p.setLayout(new FlowLayout(FlowLayout.LEFT));
		p.add(cboTitle);
		this.add(p); //cell 1,2


		this.add(lblSurname); //cell 2,1

		p = new JPanel();
		p.setLayout(new FlowLayout(FlowLayout.LEFT));
		p.add(txtSurname);
		this.add(p); //cell 2,2


		this.add(lblFirstName); //cell 3,1

		p = new JPanel();
		p.setLayout(new FlowLayout(FlowLayout.LEFT));
		p.add(txtFirstName);
		this.add(p); //cell 3,2

	}


	//returns a name object based on the input fields
	public Name getNameInput() {
		String title = cboTitle.getSelectedItem().toString();
		String fName =  txtFirstName.getText();
		String lName = txtSurname.getText();
		return new Name(title, fName, lName);
	}

	//sets input fields based on received name object
	public void setNameInput(Name name) {
		cboTitle.setSelectedItem(name.getTitle());
		txtFirstName.setText(name.getFirstName());
		txtSurname.setText(name.getFamilyName());
	}

	//clear the input fields
	public void reset() {
		cboTitle.setSelectedIndex(0);
		txtFirstName.setText("");
		txtSurname.setText("");
	}

}
