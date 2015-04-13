package view;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

public class OverviewResultsPanel extends JPanel {

	private JTextArea txtOverview;
	
	public OverviewResultsPanel() {
		this.setLayout(new FlowLayout());
		
		txtOverview = new JTextArea("Overview will appear here", 12, 30);
		txtOverview.setEditable(false);
		this.setBorder(new EmptyBorder(25,10,10,10));

		this.add(txtOverview);

	}
	
	public void setOverview(String overview) {
		txtOverview.setText(overview);
	}
	
	public void setColor(Color c) {
		txtOverview.setBackground(c);
	}
	
}
