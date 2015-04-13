package view;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;


/* This panel is part of the View and displays buttons */
public class ButtonPanel extends JPanel {
	
	//declared for access throughout class
	private JButton addBtn, clearBtn, findBtn, submitBtn;
	
	public ButtonPanel() {
		
		//sets layout, ensures buttons are aligned centrally
		this.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		//ADD BUTTON
		addBtn = new JButton("Add");		
		
		//CLEAR BUTTON
		clearBtn = new JButton("Clear");		
		
		//FIND BUTTON
		findBtn  = new JButton("Find");
		
		//SUBMIT BUTTON
		submitBtn  = new JButton("Submit");	
		
		//declares temporary panel
		JPanel p; 
		
		//add each button to temporary panel (providing a little padding) then add that to the overall ButtonPanel
		p = new JPanel();
		p.add(addBtn);
		this.add(p);
		
		p = new JPanel();
		p.add(clearBtn);
		this.add(p);
		
		p = new JPanel();
		p.add(findBtn);
		this.add(p);
		
		p = new JPanel();
		p.add(submitBtn);
		this.add(p);
		
	}
	
	//these methods allow listeners to be externally attached to this view
	public void addAddListener(ActionListener al) {
		addBtn.addActionListener(al);
	}
	
	public void addClearListener(ActionListener al) {
		clearBtn.addActionListener(al);
	}
	
	public void addFindListener(ActionListener al) {
		findBtn.addActionListener(al);
	}
	
	public void addSubmitListener(ActionListener al) {
		submitBtn.addActionListener(al);
	}

}
