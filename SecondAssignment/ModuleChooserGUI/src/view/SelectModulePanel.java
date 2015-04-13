package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import model.Module;

public class SelectModulePanel extends JPanel{
	private SelectModuleButtonPanel btnPnl;
	private JList <Module> UnSelectedList;
	private DefaultListModel<Module> UnSelectedListModel;
	private JScrollPane UnSelectedscrollPane;
	private JScrollPane SelectedscrollPane;
	private JList <Module> SelectedList;
	private JScrollPane ReservedscrollPane;
	private JList <Module> ReservedList;
	private DefaultListModel<Module> ReservedListModel;
	private DefaultListModel<Module> SelectedListModel;
	private JTextField txtCurrentCredit;
	private JTextField txtReserveCredit;
	
//	private JButton btnReset,btnRemove,btnAdd;
    public SelectModulePanel(){
    	
    	this.setLayout(new BorderLayout());
	  //empty border - simple way to provide padding
	  this.setBorder(new EmptyBorder(10,10,10,10));
	 JPanel firstContainer = new JPanel();
	firstContainer.setLayout(new BorderLayout());
	
	
	  JPanel firstGVPanel = new JPanel();
	  firstGVPanel.setLayout(new GridLayout(1,1));
	  
	  JLabel lblUnSelectedModule = new JLabel("UnSelected Modules");
	  JLabel lblSelectedModule = new JLabel("Selected Modules");
	  
	  JPanel gvlabelPanel;
	  
	  gvlabelPanel =new JPanel();
	  gvlabelPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
	  gvlabelPanel.add(lblUnSelectedModule);
	  firstGVPanel.add(gvlabelPanel);
	  
	  gvlabelPanel =new JPanel();
	  gvlabelPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
	  gvlabelPanel.add(lblSelectedModule);
	  firstGVPanel.add(gvlabelPanel);
	  
	  JPanel secondGVPanel = new JPanel();
	  secondGVPanel.setLayout(new GridLayout(1,3));
		
	  UnSelectedList = new JList <Module>();
	  UnSelectedListModel = new DefaultListModel<Module>();
	  
	  UnSelectedList.setModel(UnSelectedListModel); //set the list model for this Jlist
	  UnSelectedList.setVisibleRowCount(6);
	  
	  //Decorate with a scroll pane.
	  UnSelectedscrollPane = new JScrollPane(UnSelectedList);
		
		SelectedList = new JList <Module>();
		SelectedListModel = new DefaultListModel<Module>();
		SelectedList.setModel(SelectedListModel); //set the list model for this Jlist
		SelectedList.setVisibleRowCount(6);
		//Decorate with a scroll pane.
		SelectedscrollPane = new JScrollPane(SelectedList);
//		
//		JPanel buttonPanel =new JPanel();
//		buttonPanel.setLayout(new GridLayout(3,1));
//		
//		JPanel addPanel =new JPanel();
//		addPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
//		btnAdd = new JButton(">");
//		btnAdd.setPreferredSize(new Dimension(70,20));
//		addPanel.add(btnAdd);
//		
//		JPanel removePanel = new JPanel();
//		removePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
//		btnRemove =new JButton("<");
//		btnRemove.setPreferredSize(new Dimension(70,20));
//		removePanel.add(btnRemove);
//		
//		JPanel resetPanel = new JPanel();
//		resetPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
//		btnReset =new JButton("Reset");
//		btnReset.setPreferredSize(new Dimension(70,20));
//		resetPanel.add(btnReset);
//		
//		buttonPanel.add(addPanel);
//		buttonPanel.add(removePanel);
//		buttonPanel.add(resetPanel);
		
		JPanel ListPanel;
		ListPanel= new JPanel();
		
		ListPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		ListPanel.add(UnSelectedscrollPane);
		secondGVPanel.add(ListPanel);
	
//		secondGVPanel.add(buttonPanel);
		ListPanel= new JPanel();
		ListPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		ListPanel.add(SelectedscrollPane);
		secondGVPanel.add(ListPanel);
		
		JPanel currentCreditGVPanel = new JPanel();
		currentCreditGVPanel.setLayout(new GridLayout(1,1));
		
		JLabel lblCurrentCredit = new JLabel("Current Credit");
		txtCurrentCredit =new JTextField(3);
		txtCurrentCredit.setEditable(false);
		txtCurrentCredit.setText("0");
		
		 JPanel currentCreditLabelPanel;
		  
		 currentCreditLabelPanel =new JPanel();
		 currentCreditLabelPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		 currentCreditLabelPanel.add(lblCurrentCredit);
		 currentCreditGVPanel.add(currentCreditLabelPanel);
		
		 currentCreditLabelPanel =new JPanel();
		 currentCreditLabelPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		 currentCreditLabelPanel.add(txtCurrentCredit);
		 currentCreditGVPanel.add(currentCreditLabelPanel);
		 
		 firstContainer.add(firstGVPanel,BorderLayout.PAGE_START);
		 firstContainer.add(secondGVPanel,BorderLayout.CENTER);
		firstContainer.add(currentCreditGVPanel,BorderLayout.PAGE_END);
		
		 JPanel secondContainer =new JPanel();
		 secondContainer.setLayout(new BorderLayout());
		 
		 JPanel thirdGVPanel = new JPanel();
		 thirdGVPanel.setLayout(new GridLayout(1,1));
		  
		 JLabel lblReservedModule = new JLabel("Reserved Modules");
		 
		 JPanel reserveGVlabelPanel;
		 reserveGVlabelPanel =new JPanel();
		 reserveGVlabelPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		 reserveGVlabelPanel.add(lblReservedModule);
		 thirdGVPanel.add(reserveGVlabelPanel);
		  
		 JPanel fourthGVPanel  = new JPanel();
		 fourthGVPanel.setLayout(new GridLayout(1,1));
		 
		 ReservedList = new JList <Module>();
		 ReservedListModel = new DefaultListModel<Module>();
		 ReservedList.setModel(ReservedListModel); //set the list model for this Jlist
		 ReservedList.setVisibleRowCount(3);
		//Decorate with a scroll pane.
		 ReservedscrollPane = new JScrollPane(ReservedList);
		 
		 JPanel reserveModulePanel;
		 reserveModulePanel= new JPanel();
			
		 reserveModulePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		 reserveModulePanel.add(ReservedscrollPane);
		 fourthGVPanel.add(reserveModulePanel);
		 
		 JPanel fifthGVPanel = new JPanel();
		 fifthGVPanel.setLayout(new GridLayout(1,1));
		 
		 JLabel lblReservedCredit = new JLabel("Reserved Credit");
		txtReserveCredit =new JTextField(2);
	    txtReserveCredit.setEditable(false);
	    txtReserveCredit.setText("0");
	     
		 JPanel reservedetailsPanel;
		 
		 reservedetailsPanel = new JPanel();
		 reservedetailsPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		 reservedetailsPanel.add(lblReservedCredit);
		 fifthGVPanel.add(reservedetailsPanel);
		 
		 reservedetailsPanel = new JPanel();
		 reservedetailsPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		 reservedetailsPanel.add(txtReserveCredit);
		 fifthGVPanel.add(reservedetailsPanel);

		 secondContainer.add(thirdGVPanel,BorderLayout.PAGE_START);
		 secondContainer.add(fourthGVPanel,BorderLayout.CENTER);
		 secondContainer.add(fifthGVPanel,BorderLayout.PAGE_END);
		 
		btnPnl = new SelectModuleButtonPanel();

		
		this.add(firstContainer, BorderLayout.PAGE_START);
		this.add(secondContainer,BorderLayout.CENTER);
		this.add(btnPnl,BorderLayout.PAGE_END);
		
}
  //method to retrieve direct access to the list model
  	public DefaultListModel<Module> getUnSelectedListModel() {
  		return UnSelectedListModel;
  	}
  	public DefaultListModel<Module> getSelectedListModel() {
  		return SelectedListModel;
  	}
  	public DefaultListModel<Module> getReservedListModel() {
  		return ReservedListModel;
  	}
  	
  	public void setSelectedModuleList(DefaultListModel<Module> selectedModules){
  	    //sets list model field for this class
  		this.SelectedListModel = selectedModules;
  		
  	//this forces the list to update itself and clear any selection
  		SelectedList.setModel(SelectedListModel);
  	}
  	
  	public void setUnSelectedListModel(DefaultListModel<Module> UnSelectedListModel) {
		//sets list model field for this class
		this.UnSelectedListModel = UnSelectedListModel;
		//this forces the list to update itself and clear any selection
		UnSelectedList.setModel(UnSelectedListModel);
		}
  	
  	public void setReservedListModel(DefaultListModel<Module> ReservedListModel) {
		//sets list model field for this class
		this.ReservedListModel = ReservedListModel;
		//this forces the list to update itself and clear any selection
		ReservedList.setModel(ReservedListModel);
		}
  	
  //adds a name to the list model (which will then display in the JList)
  	public void addUnSelectedModule(Module module) {
  		UnSelectedListModel.addElement(module);
  	}
  	
  	public void removeModuleFromUnSelectedList(Module module){
  		int index = UnSelectedList.getSelectedIndex();
  		UnSelectedListModel.removeElementAt(index);
  	}
  	
	public void removeModuleFromSelectedList(Module module){
  		int index = SelectedList.getSelectedIndex();
  		SelectedListModel.removeElementAt(index);
  	}
	
	public void removeModuleFromReservedList(Module module){
  		int index = ReservedList.getSelectedIndex();
  		ReservedListModel.removeElementAt(index);
	}
	
  //adds a name to the list model (which will then display in the JList)
  	public void addSelectedModule(Module module) {
  		SelectedListModel.addElement(module);
  	}
  	
  	public void addReservedModule(Module module) {
  		ReservedListModel.addElement(module);
  	}
  
  	
  //retrieves current selected item or null if none selected
  	public Module getSelectedItemInUnSelectedList() {
  		return UnSelectedList.getSelectedValue();
  	}
  	
	public Module getSelectedItemInSelectedList() {
  		return SelectedList.getSelectedValue();
  	}
  	
	public Module getSelectedItemInReservedList() {
  		return ReservedList.getSelectedValue();
  	}
  	
  //checks if an item is selected
  	public boolean isItemSelectedInUnSelectedListModel() {
  		return UnSelectedList.getSelectedIndex() != -1;
  	}
  	
  	public boolean isItemSelectedInSelectedListModel() {
  		return SelectedList.getSelectedIndex() != -1;
  	}
  	public boolean isItemSelectedInReservedListModel(){
  		return ReservedList.getSelectedIndex() != -1;
  	}
  	
  	public void clearReservedList(){
  		ReservedListModel.clear();
  	}
  	
  //clears all elements from the defaultlistmodel
  	public void clearSelectedList() {
  		SelectedListModel.clear();
  	}
  	
	public void clearUnSelectedList() {
  		UnSelectedListModel.clear();
  	}
	
	public SelectModuleButtonPanel getSelectModuleButtonPanel(){
	   return btnPnl;	
	}

	public void setCurrentCredit(int credit){
		txtCurrentCredit.setText(Integer.toString(credit));
	}
	
	public void resetCurrentCredit(){
		txtCurrentCredit.setText("0");
	}
	
	public int getCurrentCredit(){
		return Integer.parseInt(txtCurrentCredit.getText());
	}
  	
	public void setReservedCredit(int reservedCredit){
		txtReserveCredit.setText(Integer.toString(reservedCredit));
	}
	
	public int getReservedCredit(){
		return Integer.parseInt(txtReserveCredit.getText());
	}
	
	public void resetReserveCredit(){
		txtReserveCredit.setText("0");
	}
//	public void addAddListener(ActionListener al) {
//		btnAdd.addActionListener(al);
//	}
}
