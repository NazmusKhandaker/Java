package view;
import java.awt.BorderLayout;
import java.util.Vector;

import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import model.Name;

/* This panel is part of the View and displays the register list */
public class RegisterListPanel extends JPanel{	

	//declare JList and DefaultListModel as fields so they can be accessed throughout the class
	private JList<Name> list;
	private DefaultListModel<Name> listModel;

	public RegisterListPanel() {		
		//set layout policy to BorderLayout
		this.setLayout(new BorderLayout());

		//empty border - simple way to provide padding
		this.setBorder(new EmptyBorder(10,10,10,10));

		//LABEL
		JLabel lblRegist = new JLabel("The Register", JLabel.CENTER); //aligns the label in the centrally
		lblRegist.setBorder(new EmptyBorder(0,0,5,0)); //bottom padding for label
		this.add(lblRegist, BorderLayout.NORTH); //add to top of this panel


		//REGISTER LIST
		list = new JList<Name>();
		listModel = new DefaultListModel<Name>();
		list.setModel(listModel); //set the list model for this Jlist
		list.setVisibleRowCount(4);	
		//Decorate with a scroll pane.
		JScrollPane scrollPane = new JScrollPane(list);

		//adding scrollPane directly to BorderLayout.Center will cause it to resize with the containing window
		//if you wanted to restrict this, firstly add it to a JPanel (with FlowLayout)
		this.add(scrollPane, BorderLayout.CENTER); 

	}

	//method to retrieve direct access to the list model
	public DefaultListModel<Name> getListModel() {
		return listModel;
	}
	
	public void setListModel(DefaultListModel<Name> listModel) {
		//sets list model field for this class
		this.listModel = listModel;

		//this forces the list to update itself and clear any selection
		list.setModel(listModel);
	}
	
	//adds a name to the list model (which will then display in the JList)
	public void addName(Name n) {
		listModel.addElement(n);
	}

	//retrieves current selected item or null if none selected
	public Name getSelectedItem() {
		return list.getSelectedValue();
	}
	
	//checks if an item is selected
	public boolean isItemSelected() {
		return list.getSelectedIndex() != -1;
	}
	
	//clears all elements from the defaultlistmodel
	public void clearList() {
		listModel.clear();
	}


}
