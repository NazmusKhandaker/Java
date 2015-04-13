package view;

import java.awt.Dimension;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;


public class DiceGameFrame extends JFrame {

	private SetupGamePanel setupPnl;
	private OverviewResultsPanel overviewPnl;
	private JTabbedPane tabPane;
	
	public DiceGameFrame() {
		
		this.setTitle("Dice Game GUI");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        /* Use a tabbed pane, so components can be placed on tabs*/
        tabPane = new JTabbedPane(JTabbedPane.TOP);
        tabPane.setPreferredSize(new Dimension(620, 280));
        this.add(tabPane);
        
        
        setupPnl = new SetupGamePanel();
        tabPane.addTab("Create Profile", setupPnl);
        tabPane.setMnemonicAt(0, KeyEvent.VK_1);
        
        
        overviewPnl = new OverviewResultsPanel();
        tabPane.addTab("Overview Results", overviewPnl);
        tabPane.setMnemonicAt(1, KeyEvent.VK_2);
        

		this.pack();
		this.setVisible(true);
		
	}

	public void changeTab(int index) {
		tabPane.setSelectedIndex(index);
	}
	
	public SetupGamePanel getSetupGamePanel() {
		return setupPnl;
	}
	
	public OverviewResultsPanel getResultsPanel() {
		return overviewPnl;
	}
	
	
}
