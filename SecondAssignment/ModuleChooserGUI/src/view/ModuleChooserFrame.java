package view;

import java.awt.Dimension;
import java.awt.event.KeyEvent;

import javax.swing.*;

public class ModuleChooserFrame extends JFrame {

	private CreateProfilePanel createProPnl;
	private OverviewResultsPanel overviewPnl;
	private SelectModulePanel slcModPnl;
	private SelectModuleButtonPanel btnPnl;
	private JTabbedPane tabPane;
	private ModuleChooserMenuBar moduleChooseMenuBar;
	
	public ModuleChooserFrame(){
		this.setTitle("Final Year Module Chooser Tool");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		  
        /* Use a tabbed pane, so components can be placed on tabs*/
        tabPane = new JTabbedPane(JTabbedPane.TOP);
        tabPane.setPreferredSize(new Dimension(800, 420));
        this.add(tabPane);
      
        createProPnl = new CreateProfilePanel();
        tabPane.addTab("Create Profile",createProPnl);
        tabPane.setMnemonicAt(0, KeyEvent.VK_1);
        
        slcModPnl = new SelectModulePanel();
        tabPane.addTab("Select Module",slcModPnl);
        tabPane.setMnemonicAt(1, KeyEvent.VK_2);
        
        overviewPnl = new OverviewResultsPanel();
        tabPane.addTab("Overview Result", overviewPnl);
        tabPane.setMnemonicAt(2, KeyEvent.VK_3);
        
      //sets the menu bar
        moduleChooseMenuBar = new ModuleChooserMenuBar();
    this.setJMenuBar(moduleChooseMenuBar);
        
        this.pack();
        this.setVisible(true);
	}
	
	public void changeTab(int index){
		tabPane.setSelectedIndex(index);
	}
	
	public CreateProfilePanel getCreateProfilePanel(){
		return createProPnl;
	}
	
	public OverviewResultsPanel getResultsPanel(){
		return overviewPnl;
	}
	public SelectModulePanel getSelectModulePanel(){
		return slcModPnl;
	}
//	public SelectModuleButtonPanel getSelectModuleButtonPanel(){
//		return btnPnl;
//	}
	
	//allows the menu bar to be retrieved to access its methods and attach listeners
		public ModuleChooserMenuBar getRegisterMenuBar() {
			return moduleChooseMenuBar;
		}
}
