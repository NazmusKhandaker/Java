package view;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import model.Course;


public class CreateProfilePanel extends JPanel {
	
	private JComboBox<Course> cboCourses;
	private JTextField txtFirstName;
	private JTextField txtSurName;
	private JTextField txtStudentId;
	private JButton btnCreateProfile;
	
	public CreateProfilePanel(){
		this.setLayout(new GridLayout(5,2));
		this.setBorder(new EmptyBorder(25,10,10,10));
		
		JPanel p;
		JLabel lblCourse = new JLabel("Select course");
	    cboCourses = new JComboBox<Course>();
	   
		
	    JLabel lblStudentId = new JLabel("Your Student Number");
	    txtStudentId= new JTextField(10);
		
		JLabel lblFirstName = new JLabel("First Name");
		txtFirstName= new JTextField(20);
		
		JLabel lblSurName = new JLabel("Sur Name");
		txtSurName= new JTextField(20);
		
		btnCreateProfile = new JButton("Create Profile");
		
		p = new JPanel();
		p.add(lblCourse);
		p.setLayout(new FlowLayout(FlowLayout.RIGHT));
		this.add(p);
		p = new JPanel();
		p.add(cboCourses);
		p.setLayout(new FlowLayout(FlowLayout.LEFT));
		this.add(p);
		
		p = new JPanel();
		p.add(lblStudentId);
		p.setLayout(new FlowLayout(FlowLayout.RIGHT));
		this.add(p);
		p = new JPanel();
		p.add(txtStudentId);
		txtStudentId.getDocument().addDocumentListener(new DocumentListener(){

			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				textChangedhanged();
				
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				textChangedhanged();
				
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				textChangedhanged();
				
			}
			
		});
		p.setLayout(new FlowLayout(FlowLayout.LEFT));
		this.add(p);
		
		p = new JPanel();
		p.add(lblFirstName);
		p.setLayout(new FlowLayout(FlowLayout.RIGHT));
		this.add(p);
		p = new JPanel();
		p.add(txtFirstName);
		p.setLayout(new FlowLayout(FlowLayout.LEFT));
		this.add(p);
		txtFirstName.getDocument().addDocumentListener(new DocumentListener(){

			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				textChangedhanged();
				
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				textChangedhanged();
				
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				textChangedhanged();
				
			}
			
		});
		
		p = new JPanel();
		p.add(lblSurName);
		p.setLayout(new FlowLayout(FlowLayout.RIGHT));
		this.add(p);
		p = new JPanel();
		p.add(txtSurName);
		p.setLayout(new FlowLayout(FlowLayout.LEFT));
		this.add(p);
		txtSurName.getDocument().addDocumentListener(new DocumentListener(){

			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				textChangedhanged();
				
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				textChangedhanged();
				
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				textChangedhanged();
				
			}
			
		});
		
		this.add(new JPanel());
		p = new JPanel();
		p.add(btnCreateProfile);
		p.setLayout(new FlowLayout(FlowLayout.LEFT));
		this.add(p);
	}
	
	public void populateComboBox(Course[] courses){
		for (Course c : courses){
			cboCourses.addItem(c);
		}
	}
	
	public void setSelectedCourse(Course course){
		cboCourses.setSelectedItem(course);
	}
	public void resetCourseComboBox(){
		cboCourses.removeAllItems();
	}
	
	public Course getSelectedCourse(){
		return (Course) cboCourses.getSelectedItem();
	}
	
	public void setStudentId(String StudentId){
		txtStudentId.setText(StudentId);
	}
	
	public String getStudentId(){
		return txtStudentId.getText();
	}
	
	public void clearStudentID(){
		txtStudentId.setText(null);
	}
	
	public String getFirstName(){
		return txtFirstName.getText();
	}
	
	public void setFirstName(String firstName){
		txtFirstName.setText(firstName);
	}
	public void clearFirstName(){
		txtFirstName.setText(null);
	}
	
	public String getSurName(){
		return txtSurName.getText();
	}
	public void setSurName(String surName){
		txtSurName.setText(surName);
	}
	
	public void clearSurName(){
		txtSurName.setText(null);
	}
	
	public void textChangedhanged(){
		boolean enableButton = true;
		String stringAndNumberRegex ="[a-zA-Z0-9]{2,10}";
		String stringRegex = "[a-zA-Z\\s]{2,25}";
		
		if (txtStudentId.getText().equals("")){	
			enableButton = false;		
		}
		else if (txtStudentId.getText().matches(stringAndNumberRegex)==false){
			enableButton = false;	
		}

		
		if (txtFirstName.getText().equals("")){
			enableButton = false;
		}
		else if  (txtFirstName.getText().matches(stringRegex)== false){
			enableButton = false;
		}
		
		if (txtSurName.getText().equals("")){
			enableButton = false;
		}
		
		else if (txtSurName.getText().matches(stringRegex)==false){
			enableButton = false;
		}
		
		if (enableButton == true){
			btnCreateProfile.setEnabled(true);
		}
		else{
			//JOptionPane.showMessageDialog(null, "You may not filled all the details Or add invalid characters!!!", "Error message", JOptionPane.ERROR_MESSAGE);
			btnCreateProfile.setEnabled(false);
		}
		
		
		
	}
	public void enbleCourseComboBox(){
		cboCourses.setEditable(true);
	}
	public void disAbleCourseComboBox(){
		cboCourses.setEditable(false);
	}
	public void addCreateProfileListener(ActionListener al){
		btnCreateProfile.addActionListener(al);
	}
}
