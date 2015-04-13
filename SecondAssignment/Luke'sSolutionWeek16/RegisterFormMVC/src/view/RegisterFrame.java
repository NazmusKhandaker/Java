package view;
import java.awt.BorderLayout;

import javax.swing.*;

/* This frame is the underlying container for the View. The RegisterListPanel, NamePanel 
 * and ButtonPanel are added. This class is also executable by specifying an inner main method, 
 * rather than having a separate 'test' class. */
public class RegisterFrame extends JFrame{

	//these sub-containers are declared as fields of the class. In this example it is not strictly
	//necessary, but when we develop MVC applications, the view will need to provide the controller
	//with access to its sub-containers.
	private NamePanel np;
	private RegisterListPanel rlp;
	private ButtonPanel bp;
	private RegisterMenuBar rmb;


	public RegisterFrame() {
		this.setTitle("Register Frame");	//set the title
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//set the layout policy for this frame
		this.setLayout(new BorderLayout());

		//create a new name panel
		np = new NamePanel();

		//create a new register list panel
		rlp = new RegisterListPanel();

		//create a new button panel
		bp = new ButtonPanel();


		//sets the menu bar
		rmb = new RegisterMenuBar();
		this.setJMenuBar(rmb);


		//create another container with BorderLayout to hold the button panel and register list panel
		JPanel container = new JPanel();
		container.setLayout(new BorderLayout());

		//add the button panel to the top of the container
		container.add(bp, BorderLayout.PAGE_START);

		//add the register list panel to the center of the container
		container.add(rlp, BorderLayout.CENTER);


		//add the name panel to the top of the frame
		this.add(np, BorderLayout.PAGE_START);

		//add the container to the center of the frame
		this.add(container, BorderLayout.CENTER);


		//set frame properties
		this.pack();
		this.setVisible(true);
		//this.setResizable(false);
	}


	//methods for retrieving the subcontainers of this frame
	public NamePanel getNamePanel() {
		return np;
	}

	public ButtonPanel getButtonPanel() {
		return bp;
	}

	public RegisterListPanel getRegisterListPanel() {
		return rlp;
	}

	public RegisterMenuBar getRegisterMenuBar() {
		return rmb;
	}

}