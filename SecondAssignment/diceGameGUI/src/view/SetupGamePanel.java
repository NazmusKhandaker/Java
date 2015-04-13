package view;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import model.Player;

public class SetupGamePanel extends JPanel {
	
	private JComboBox<Player> cboPlayers;
	private JTextField txtFName, txtLName;
	private JButton btnPlay;
	
	public SetupGamePanel() {
		this.setLayout(new GridLayout(5,2));
		this.setBorder(new EmptyBorder(25,10,10,10));
		
		JPanel p;
		
		JLabel lblCourse = new JLabel("Select opponent: ");
		cboPlayers = new JComboBox<Player>();
		
		JLabel lblName = new JLabel("Input first name: ");
		txtFName= new JTextField(12);
		JLabel lblPno = new JLabel("Input last name: ");
		txtLName = new JTextField(12);
		
		btnPlay = new JButton("Play Game");
		
		
		p = new JPanel();
		p.add(lblCourse);
		p.setLayout(new FlowLayout(FlowLayout.RIGHT));
		this.add(p);
		p = new JPanel();
		p.add(cboPlayers);
		p.setLayout(new FlowLayout(FlowLayout.LEFT));
		this.add(p);
		
		p = new JPanel();
		p.add(lblName);
		p.setLayout(new FlowLayout(FlowLayout.RIGHT));
		this.add(p);
		p = new JPanel();
		p.add(txtFName);
		p.setLayout(new FlowLayout(FlowLayout.LEFT));
		this.add(p);
		
		p = new JPanel();
		p.add(lblPno);
		p.setLayout(new FlowLayout(FlowLayout.RIGHT));
		this.add(p);
		p = new JPanel();
		p.add(txtLName);
		p.setLayout(new FlowLayout(FlowLayout.LEFT));
		this.add(p);
	
		
		this.add(new JPanel());
		p = new JPanel();
		p.add(btnPlay);
		p.setLayout(new FlowLayout(FlowLayout.LEFT));
		this.add(p);
		
	}
	
	public void populateComboBox(Player[] players) {
		for (Player p : players) {
			cboPlayers.addItem(p);
		}
	}
	
	public Player getSelectedPlayer() {
		return (Player) cboPlayers.getSelectedItem();
	}
	
	public String getFNameInput() {
		return txtFName.getText();
	}
	
	public String getLNameInput() {
		return txtLName.getText();
	}
	
	public void addPlayGameListener(ActionListener al) {
		btnPlay.addActionListener(al);
	}
}
