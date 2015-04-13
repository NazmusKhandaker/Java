package controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

import model.Name;
import model.Register;

import view.ButtonPanel;
import view.NamePanel;
import view.RegisterFrame;
import view.RegisterListPanel;
import view.RegisterMenuBar;


public class RegisterController {
	//fields to be accessed throughout htis class
	private NamePanel np;
	private ButtonPanel bp;
	private RegisterListPanel rlp;
	private RegisterMenuBar rmb;
	private Register model;

	public RegisterController(RegisterFrame view, Register model) {
		//initialise view fields
		np = view.getNamePanel();
		bp = view.getButtonPanel();
		rlp = view.getRegisterListPanel();
		rmb = view.getRegisterMenuBar();

		//initialise model
		this.model = model;

		//add listeners to the view
		bp.addAddListener(new AddButtonHandler());

		//showing use of a lambda expression instead of a inner-class
		bp.addClearListener(e -> {
			//resets name panel in view
			np.reset();		
			//resets listmodel in view
			rlp.clearList();  	
		});

		bp.addFindListener(new FindButtonHandler());
		bp.addSubmitListener(new SubmitButtonHandler());

		rmb.addLoadListener(new LoadMenuHandler());

		//more example of using lambda expressions
		rmb.addSaveListener(e -> saveModelToFile());
		rmb.addExitListener(e -> System.exit(0));
		rmb.addAboutListener(e -> JOptionPane.showMessageDialog(rmb, "Registration App - Ver 2.1"));
	}


	//event handlers
	private class AddButtonHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			//retrieves name from view
			Name n = np.getNameInput();

			//check input not empty
			if(n.getFirstName().equals("") || n.getFamilyName().equals("")) {
				//output error
				JOptionPane.showMessageDialog(null, "Need to input first and family name!", "Add Error", JOptionPane.ERROR_MESSAGE);

			} else {
				//adds it to the default list model
				rlp.addName(n);

				//resets name panel in view
				np.reset();
			}
		}
	}

	private class FindButtonHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			//check item selected
			if (rlp.isItemSelected()) {

				//get selected item
				Name n = rlp.getSelectedItem();

				//assess if model contains the item
				if (model.contains(n)) {
					np.setNameInput(new Name(n.getTitle(), "Found...", n.getFamilyName()));
				} else {
					np.setNameInput(new Name(n.getTitle(), "Not Found...", n.getFamilyName()));
				}

			} else {
				//output error
				JOptionPane.showMessageDialog(null, "Need to select a name!", "Select Error", JOptionPane.ERROR_MESSAGE);
			} 		

		}
	}

	private class SubmitButtonHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			//retrieve added names from view and convert to arraylist
			ArrayList<Name> names = Collections.list(rlp.getListModel().elements());

			//submit names to model
			for (Name n : names) {
				model.add(n);
			}

			//resets list model view
			rlp.clearList();  	
		}
	}

	private class LoadMenuHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			//load model (register) as an object from a file
			try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("registerObj.dat"));) {

				//read Register object from file
				model = (Register) ois.readObject();
				
				//show list data in view
				DefaultListModel<Name> dlm = new DefaultListModel<Name>();
				
				//iterate through each name in Register and add to list model
				for (Name n : model) {
					dlm.addElement(n);
				}
				
				//set default list model in view
				rlp.setListModel(dlm);
				
			}
			catch (IOException ioExcep){
				//output error
				JOptionPane.showMessageDialog(null, "Error loading from file!", "Load Error", JOptionPane.ERROR_MESSAGE);
			}
			catch (ClassNotFoundException c) {
				System.out.println("Class Not found");
			}
		}
	}

	private void saveModelToFile() {
		//saves current model (register) as an object to a file 
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("registerObj.dat"));) {
			//write Register object instance
			oos.writeObject(model);
			oos.flush();
		}
		catch (IOException ioExcep){
			//output error
			JOptionPane.showMessageDialog(null, "Error saving to file!", "Save Error", JOptionPane.ERROR_MESSAGE);
		}
	}



}
