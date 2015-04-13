package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class SelectModuleButtonPanel extends JPanel {

		//declared for access throughout class
		private JButton btnReset,btnRemove,btnAdd, btnReserve, btnSubmit, btnRemoveReserve;
		
	    public SelectModuleButtonPanel() { 
	            	
	    	this.setLayout(new BorderLayout());
	    	//this.setBackground(Color.lightGray);
	    
	    	btnReset = new JButton("Reset");
	    	btnReset.setPreferredSize(new Dimension(200,30));

            btnRemove = new JButton("Remove from selected module");
	    	btnRemove.setPreferredSize(new Dimension(210,30));
	    	
	    	btnRemoveReserve = new JButton("Remove from reserve module");
	    	btnRemoveReserve.setPreferredSize(new Dimension(210,30));
	    	
            btnAdd = new JButton("Add to selected module");
	        btnAdd.setPreferredSize(new Dimension(200,30));

	        btnReserve = new JButton("Add to reserve module");
	        btnReserve.setPreferredSize(new Dimension(200,30));
	        
            btnSubmit = new JButton("Submit");
	        btnSubmit.setPreferredSize(new Dimension(200,30));

	        JPanel topButtonPanel = new JPanel();
	        topButtonPanel.setLayout(new GridLayout(2,3));
	        
	        JPanel topPanel;
			 
	        topPanel = new JPanel();
	        topPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
	        topPanel.add(btnReset);
	        topButtonPanel.add(topPanel);
	        
	        topPanel = new JPanel();
	        topPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
	        topPanel.add(btnSubmit);
	        topButtonPanel.add(topPanel);
	        
	        topPanel = new JPanel();
	        topPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
	        topPanel.add(btnAdd);
	        topButtonPanel.add(topPanel);
			 
	        
//	        JPanel bottomButtonPanel = new JPanel();
//	        topButtonPanel.setLayout(new GridLayout(1,3));
	        
//	        JPanel bottomPanel;
			 
	        topPanel = new JPanel();
	        topPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
	        topPanel.add(btnReserve);
	        topButtonPanel.add(topPanel);
	        
	        topPanel = new JPanel();
	        topPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
	        topPanel.add(btnRemove);
	        topButtonPanel.add(topPanel);
	        
	        topPanel = new JPanel();
	        topPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
	        topPanel.add(btnRemoveReserve);
	        topButtonPanel.add(topPanel);
	        
	        this.add(topButtonPanel,BorderLayout.PAGE_START);
//	        this.add(bottomButtonPanel,BorderLayout.CENTER);
	        
//               JPanel p; //temp panel
//               
//               p = new JPanel();
//    	       p.add(btnSubmit); 
//    	       this.add(p);
//    	       
//	    	p = new JPanel();
//	    	p.add(btnReset);
//	    	this.add(p);
// 
//	       p = new JPanel();
//	        p.add(btnRemove);
//	        this.add(p);
//
//	        p = new JPanel();
//	        p.add(btnRemoveReserve);
//	        this.add(p);
//	        
//	        p = new JPanel();
//	        p.add(btnAdd); 
//	        this.add(p);
//
//	       p = new JPanel();
//	       p.add(btnReserve); 
//	       this.add(p);
	        
	      
	    }
	    
	    //these methods allow listeners to be externally attached to this view
	    public void addSubmitListener(ActionListener al) {
			btnSubmit.addActionListener(al);
		}
		
		public void addResetListener(ActionListener al) {
			btnReset.addActionListener(al);
		}
		
		public void addRemoveListener(ActionListener al) {
			btnRemove.addActionListener(al);
		}
		public void addRemoveReserveListener (ActionListener al){
			btnRemoveReserve.addActionListener(al);
		}
		public void addAddListener(ActionListener al) {
			btnAdd.addActionListener(al);
		}
		
		public void addReserveListener(ActionListener al) {
			btnReserve.addActionListener(al);
		}  
	}
