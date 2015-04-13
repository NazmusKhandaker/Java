package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.text.DefaultCaret;

public class OverviewResultsPanel extends JPanel {
	
	private JTextArea txtOverview;
	private JButton btnSaveOverview;
	
	public OverviewResultsPanel(){
        this.setLayout(new BorderLayout());
		txtOverview = new JTextArea("Overview will appear here", 15, 10);
		JScrollPane scrollPane = new JScrollPane(txtOverview);
		
		txtOverview.setEditable(false);
		this.setBorder(new EmptyBorder(25,10,10,10));
		btnSaveOverview = new JButton("Save Overview");
		 JPanel p; //temp panel
         
         
		this.add(scrollPane,BorderLayout.PAGE_START);
//		gvlabelPanel =new JPanel();
//		  gvlabelPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
//		  gvlabelPanel.add(lblUnSelectedModule);
//		  firstGVPanel.add(gvlabelPanel);
		
		p = new JPanel();
		p.setLayout(new FlowLayout(FlowLayout.CENTER));
	    p.add(btnSaveOverview); 
	    this.add(p,BorderLayout.CENTER);
	}
	
	public void setOverview(String overview) {
		txtOverview.setText(overview);
	}
	
	public void clearOverview(){
		txtOverview.setText(null);
	}
	public String getOverview(){
		return txtOverview.getText();
	}
	
	public void addSaveOverviewListener(ActionListener al) {
		btnSaveOverview.addActionListener(al);
	}
	
}
