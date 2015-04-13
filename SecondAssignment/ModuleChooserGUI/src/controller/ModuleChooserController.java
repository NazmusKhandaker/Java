package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Set;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import model.Course;
import model.Module;
import model.Name;
import model.StudentProfile;
import view.CreateProfilePanel;
import view.ModuleChooserFrame;
import view.ModuleChooserMenuBar;
import view.OverviewResultsPanel;
import view.SelectModuleButtonPanel;
import view.SelectModulePanel;

public class ModuleChooserController {

	private ModuleChooserFrame view;
	private CreateProfilePanel createProPnl;
	private SelectModulePanel slcModPnl;
	private SelectModuleButtonPanel btnPnl;
	private OverviewResultsPanel overviewPnl;
	private StudentProfile model;
    private ModuleChooserMenuBar moduleChooseMenuBar;
	
	public ModuleChooserController(ModuleChooserFrame view, StudentProfile model){
		this.view = view;
		this.model = model;
		
		moduleChooseMenuBar =view.getRegisterMenuBar();
		slcModPnl = view.getSelectModulePanel();
		
		createProPnl = view.getCreateProfilePanel();
		overviewPnl = view.getResultsPanel();
		btnPnl = slcModPnl.getSelectModuleButtonPanel();
		
		createProPnl.addCreateProfileListener(new CreateProfileHandler());
		btnPnl.addResetListener(new ResetButtoHandler());
		btnPnl.addAddListener(new AddButtoHandler());
		btnPnl.addRemoveListener(new RemoveSeletedModuleButtoHandler());
		btnPnl.addSubmitListener(new SubmitButtoHandler());
		btnPnl.addReserveListener(new ReserveButtoHandler());
		btnPnl.addRemoveReserveListener(new RemoveReserveModuleButtoHandler());
		overviewPnl.addSaveOverviewListener(new SaveOverviewButtonHandler());
		
		moduleChooseMenuBar.addSaveListener(e -> saveModelToFile());
	    moduleChooseMenuBar.addLoadListener(new LoadProfileHandler());
		moduleChooseMenuBar.addAboutListener(new AboutMenuHandler());
		moduleChooseMenuBar.addExitListener((ActionEvent e) -> System.exit(0));
		createProPnl.populateComboBox(setupAndGetCourses());
		createProPnl.textChangedhanged();
	}
	
		private Course[] setupAndGetCourses(){			
			Course compSci = new Course("Computer Science");
			Course softEng = new Course("Software Engineering");
			
			Course[] courses = new Course[2];
			courses[0] = compSci;
			courses[1] = softEng;

//			try {
//				Scanner scanner = new Scanner(new File("Course.txt"));
//				//Set the scanner's delimiters to angle brackets <> and new lines
//	        //Note: "[<>\r\n]+" is a Regular Expression pattern
//			scanner.useDelimiter("[<>\r\n]+");
//	        String courseName = scanner.next();         //get first element
//	        int i = 0;
//	        while (!courseName.equals("end") ) {     //while not terminator
//	        	compSci = new Course(courseName);
//	        	courses[i] = new Course(courseName);
//	        	courseName = scanner.next();           //read the next element
//	        	i++;
//			} 
//	        
//	        scanner.close();
//			}
//	        catch (FileNotFoundException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}

			
			//Create a scanner to read the text data file
	        try {
				Scanner sc = new Scanner(new File("ComScienceModule.txt"));
				//Set the scanner's delimiters to angle brackets <> and new lines
		        //Note: "[<>\r\n]+" is a Regular Expression pattern
		        sc.useDelimiter("[<>\r\n]+");
		        String moduleCode = sc.next();           //get first element
		        while (!moduleCode.equals("end") ) {     //while not terminator

		        	String moduleName = sc.next();         //get next element(s)
		        	int moduleCredit = sc.nextInt();
		        	boolean mandatory = sc.nextBoolean();
                     
		        	compSci.addModule(new Module(moduleCode,moduleName,moduleCredit,mandatory));
		        	moduleCode = sc.next();              //read the next element
		        }
		        sc.close();
				
			} catch (FileNotFoundException e) {
				JOptionPane.showMessageDialog(null, "Computer science modules are not found!!", "File not found Error", JOptionPane.ERROR_MESSAGE);
			}
	        
	        
	      //Create a scanner to read the text data file
	        try {
				Scanner sc = new Scanner(new File("SoftEngModule.txt"));
				//Set the scanner's delimiters to angle brackets <> and new lines
		        //Note: "[<>\r\n]+" is a Regular Expression pattern - you may look it up!
		        sc.useDelimiter("[<>\r\n]+");
		        String moduleCode = sc.next();           //get first element
		        while (!moduleCode.equals("end") ) {     //while not terminator

		        	String moduleName = sc.next();         //get next element(s)
		        	int moduleCredit = sc.nextInt();
		        	boolean mandatory = sc.nextBoolean();
                     
		        	softEng.addModule(new Module(moduleCode,moduleName,moduleCredit,mandatory));
		        	moduleCode = sc.next();              //read the next element
		        }
		        sc.close();
				
			} catch (FileNotFoundException e) {
				JOptionPane.showMessageDialog(null, "Software Engineering modules are not found!!", "File not found Error", JOptionPane.ERROR_MESSAGE);
			}
//			Module ctec3903 = new Module("CTEC3903", "Software Development Methods", 15, true);
//			Module imat3451 = new Module("IMAT3451", "Computing Project", 30, true);
//			Module ctec3902_SoftEng = new Module("CTEC3902", "Rigerous Systems", 15, true);
//			Module ctec3902_CompSci = new Module("CTEC3902", "Rigerous Systems", 15, false);
//			Module ctec3110 = new Module("CTEC3110", "Secure Web Application Development", 15, false);
//			Module ctec3426 = new Module("CTEC3426", "Telematics", 15, false);
//			Module ctec3604 = new Module("CTEC3604", "Multi-service Networks", 30, false);
//			Module imat3404 = new Module("IMAT3404", "Mobile Robotics", 15, false);
//			Module imat3406 = new Module("IMAT3406", "Fuzzy Logic and Knowledge Based systems", 15, false);
//			Module imat3429 = new Module("IMAT3429", "Privacy and Data Protection", 15, false);
//			Module imat3608 = new Module("IMAT3608", "Mobile Games Development", 30, false);
//			Module imat3426_CompSci = new Module("IMAT3426", "Information Systems Strategy and Services", 30, false);
			
			//Course compSci = new Course("Computer Science");
//			compSci.addModule(ctec3903);
//			compSci.addModule(imat3451);
//			compSci.addModule(ctec3902_CompSci);
//			compSci.addModule(ctec3110);
//			compSci.addModule(ctec3426);
//			compSci.addModule(ctec3604);
//			compSci.addModule(imat3404);
//			compSci.addModule(imat3406);
//			compSci.addModule(imat3429);
//			compSci.addModule(imat3608);
//			compSci.addModule(imat3426_CompSci);
			
			//Course softEng = new Course("Software Engineering");
//			softEng.addModule(ctec3903);
//			softEng.addModule(imat3451);
//			softEng.addModule(ctec3902_SoftEng);
//			softEng.addModule(ctec3110);
//			softEng.addModule(ctec3426);
//			softEng.addModule(ctec3604);
//			softEng.addModule(imat3404);
//			softEng.addModule(imat3406);
//			softEng.addModule(imat3429);
//			softEng.addModule(imat3608);
//			Course[] courses = new Course[2];
//			courses[0] = compSci;
//			courses[1] = softEng;
			return courses;
			}

	private class CreateProfileHandler implements ActionListener {
		public void actionPerformed (ActionEvent e) {
			
			model.setpNumber(createProPnl.getStudentId());
			model.setStudentName(new Name(createProPnl.getFirstName(),createProPnl.getSurName()));
			model.setCourse(createProPnl.getSelectedCourse());
	     
	       slcModPnl.clearSelectedList();
	       slcModPnl.clearUnSelectedList();
	       slcModPnl.setCurrentCredit(0);
	       for (Module m : model.getCourse().getModulesOnCourse()){
	    	if ( m.isMandatory()){
	    		int totalCredit = 0;
	    		 totalCredit = m.getCredits() + slcModPnl.getCurrentCredit();
	    		 System.out.println(slcModPnl.getCurrentCredit());
	    		slcModPnl.setCurrentCredit(totalCredit);
	    	   slcModPnl.addSelectedModule(m);
	    	} else{
	    		slcModPnl.addUnSelectedModule(m);
	    	}
	       
	       }
	       
		view.changeTab(1);
		}
	}
	
	private class ResetButtoHandler implements ActionListener {
		public void actionPerformed (ActionEvent e) {
			slcModPnl.clearReservedList();
			slcModPnl.clearSelectedList();
		       slcModPnl.clearUnSelectedList();
		       slcModPnl.setCurrentCredit(0);
		       slcModPnl.setReservedCredit(0);
			for (Module m : model.getCourse().getModulesOnCourse()){
		    	if ( m.isMandatory()){
		    		int totalCredit = m.getCredits() + slcModPnl.getCurrentCredit();
		    		slcModPnl.setCurrentCredit(totalCredit);
		    	   slcModPnl.addSelectedModule(m);
		    	} else{
		    		slcModPnl.addUnSelectedModule(m);
		    	}
		       
		       }
			
		}
	}
	
	private class AddButtoHandler implements ActionListener {
		public void actionPerformed (ActionEvent e) {
			if (slcModPnl.isItemSelectedInUnSelectedListModel()){
				int totalCredit = slcModPnl.getSelectedItemInUnSelectedList().getCredits() + slcModPnl.getCurrentCredit();
				if (totalCredit <= 120){
					slcModPnl.addSelectedModule(slcModPnl.getSelectedItemInUnSelectedList());
				slcModPnl.setCurrentCredit(totalCredit);
				slcModPnl.removeModuleFromUnSelectedList(slcModPnl.getSelectedItemInUnSelectedList());
				}
				else{
					JOptionPane.showMessageDialog(null, "You cannot select more than 120 credits!!!");
				}	
			}
			else{
				JOptionPane.showMessageDialog(null, "Please select a module from UnSelected module list!!!");
			}
		
		}
	}
	
	private class RemoveReserveModuleButtoHandler implements ActionListener {
		public void actionPerformed (ActionEvent e) {
			if (slcModPnl.isItemSelectedInReservedListModel()){
				
				   slcModPnl.addUnSelectedModule(slcModPnl.getSelectedItemInReservedList());
					slcModPnl.setReservedCredit(slcModPnl.getReservedCredit() - slcModPnl.getSelectedItemInReservedList().getCredits());
					slcModPnl.removeModuleFromReservedList(slcModPnl.getSelectedItemInReservedList());	
			}
			else{
				JOptionPane.showMessageDialog(null, "Please select a module from Reserved module list!!!");
			}
		}
	}
	
	private class RemoveSeletedModuleButtoHandler implements ActionListener {
		public void actionPerformed (ActionEvent e) {
			if (slcModPnl.isItemSelectedInSelectedListModel()){
				if(slcModPnl.getSelectedItemInSelectedList().isMandatory()){
					JOptionPane.showMessageDialog(null, "You cannot remove compulsory module!!!");
				}
				else{
					slcModPnl.addUnSelectedModule(slcModPnl.getSelectedItemInSelectedList());
					slcModPnl.setCurrentCredit(slcModPnl.getCurrentCredit() - slcModPnl.getSelectedItemInSelectedList().getCredits());
					slcModPnl.removeModuleFromSelectedList(slcModPnl.getSelectedItemInSelectedList());
				}
			}
			else{
				JOptionPane.showMessageDialog(null, "Please select a module from Selected module list!!!");
			}
		}
	}
	
	private class ReserveButtoHandler implements ActionListener {
		public void actionPerformed (ActionEvent e) {
			if (slcModPnl.isItemSelectedInUnSelectedListModel()){
				int reserveCredit = slcModPnl.getReservedCredit() + slcModPnl.getSelectedItemInUnSelectedList().getCredits();
				if(reserveCredit > 30){
					JOptionPane.showMessageDialog(null, "You cannot choose more than 30 credits as reserve modules!!!");
				}
				else{
					slcModPnl.addReservedModule(slcModPnl.getSelectedItemInUnSelectedList());
					slcModPnl.setReservedCredit(slcModPnl.getReservedCredit() + slcModPnl.getSelectedItemInUnSelectedList().getCredits());
					slcModPnl.removeModuleFromUnSelectedList(slcModPnl.getSelectedItemInUnSelectedList());
				}
			}
			else{
				JOptionPane.showMessageDialog(null, "Please select a module from UnSelected module list!!!");
			}
		}
	}
	private class SubmitButtoHandler implements ActionListener {
		public void actionPerformed (ActionEvent e) {
			
			Course studentCourse=model.getCourse();
		String studentID= model.getpNumber();
		
		String studentName= model.getStudentName().getFullName();
		
		if ((slcModPnl.getCurrentCredit()==120 && slcModPnl.getReservedCredit()==30)){
			 String StudentDescription ="Student Name: " + studentName +"\n"+"Student Id : "+ studentID + "\n" + " Student Course: " + studentCourse;
			
			DefaultListModel<Module> selectedModule=slcModPnl.getSelectedListModel();
			DefaultListModel<Module> reserveModule = slcModPnl.getReservedListModel();
			
			StudentDescription = StudentDescription + "\n" + "Selected Modules:";
				
			for (int i = 0; i < selectedModule.size(); i++) {

				String code = selectedModule.get(i).getModuleCode();
				int credits =selectedModule.get(i).getCredits();
				StudentDescription = StudentDescription + "\n" +" Module code: " + code + "\n" +" Module name: " + selectedModule.get(i).getModuleName() + "\n" +"Credit: "+credits +"\n" ;
			   model.addSelectedModule(selectedModule.get(i));
			}
			
			StudentDescription = StudentDescription + "\n" + "Your  reserved module list: " + "\n";
			for (int i =0; i < reserveModule.size(); i++ ){
				StudentDescription = StudentDescription +   "\n" +" Module code: " + reserveModule.get(i).getModuleCode() + "\n" +" Module name: " + reserveModule.get(i).getModuleName() + "\n" +"Credit: "+reserveModule.get(i).getCredits() +"\n" ;
			model.addReservedModule(reserveModule.get(i));
			}
			overviewPnl.setOverview(StudentDescription);
			view.changeTab(2);
		}
		else{
			JOptionPane.showMessageDialog(null, "Please choose 120 credits as compulsory credit and 30 credits as reserved credit!!!");
		}
		
		}
	}
	
	
	private class SaveOverviewButtonHandler implements ActionListener {
    	public void actionPerformed(ActionEvent e) {
    		try {
				PrintWriter out = new PrintWriter(new File ("Student'sDetails.txt"));
				
				Course studentCourse=model.getCourse();
				String studentID= model.getpNumber();
				String studentName= model.getStudentName().getFullName();
				String StudentDescription = "Student Name: " + studentName + "\n"+ "Student ID: " + studentID + "\n" + "Student Course: " + studentCourse;
				DefaultListModel<Module> module=slcModPnl.getSelectedListModel();
				
				for (int i = 0; i < module.size(); i++) {
					String code = module.get(i).getModuleCode();
					int credits =module.get(i).getCredits();
					StudentDescription = StudentDescription + "\n" +"Module code: " + code + "\n" +"Module name: " + module.get(i).getModuleName() + "\n" +"Credit: "+credits +"\n" ;
				}
				
				
				DefaultListModel<Module> reserveModule = slcModPnl.getReservedListModel();
				StudentDescription = StudentDescription + "\n" + "Your  reserved module list: " + "\n";
				
				for (int i =0; i < reserveModule.size(); i++ ){
					StudentDescription = StudentDescription +   "\n" + "Module code: " + reserveModule.get(i).getModuleCode() + "\n" + "Module name: " + reserveModule.get(i).getModuleName() + "\n" + "Credit: "+ reserveModule.get(i).getCredits() +"\n" ;
				}
				
				out.println(StudentDescription);
				out.close();
				
    		} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
    	
    	}
    }
	
	
//	private class ReserveButtoHandler implements ActionListener {
//		public void actionPerformed (ActionEvent e) {
//			System.out.println("Reserve button is clicked");
//		//view.changeTab(1);
//		}
//	}
	
	//event handlers
//	private void saveModelToFile(){
//		//saves current model as an object to a file
//		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("studentDetailsObj.dat"));) {
//		//write Student profile object instance
//			System.out.println(model);
//			oos.writeObject(model);
//			oos.flush();
//	}
//	}
	
	
//	private class saveModelToFile implements ActionListener {
//		public void actionPerformed(ActionEvent e) {
//			//load model (register) as an object from a file
//			try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("StudentDetailsObj.dat"));) {
//				
//				//write Register object instance
//				oos.writeObject(model);
//				oos.flush();
//			}
//			catch (IOException ioExcep){
//				//output error
//				JOptionPane.showMessageDialog(null, "Error saving to file!", "Save Error", JOptionPane.ERROR_MESSAGE);
//			}
//		}
//	}
	
	private void saveModelToFile() {
		//saves current model (Student Profile) as an object to a file 
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("StudentDetailsObj.dat"));) {
			
			//write Student Profile object instance
			oos.writeObject(model);
			oos.flush();
			view.changeTab(0);
			createProPnl.resetCourseComboBox();
			createProPnl.populateComboBox(setupAndGetCourses());
			createProPnl.clearFirstName();
			createProPnl.clearSurName();
			createProPnl.clearStudentID();
			slcModPnl.clearSelectedList();
			slcModPnl.clearUnSelectedList();
			slcModPnl.clearReservedList();
			slcModPnl.resetCurrentCredit();
			slcModPnl.resetReserveCredit();
			overviewPnl.clearOverview();
		}
		catch (IOException ioExcep){
			//output error
			JOptionPane.showMessageDialog(null, "Error saving to file!", "Save Error", JOptionPane.ERROR_MESSAGE);
		}
	}
//	private class LoadProfileHandler implements ActionListener {
//    	public void actionPerformed(ActionEvent e) {
//    		System.out.println("Load button is clicked");
//    		//Reads a list object from a file and assigns it to list field
//
//			try{
//				//method throws exceptions, rather than catching them, so caller must handle them.
//				ObjectInputStream ois = new ObjectInputStream(new FileInputStream("studentDetailsObj.dat"));
//
//
//				DefaultListModel<Module> listModel = (DefaultListModel<Module>) ois.readObject();
//				
//				slcModPnl.setSelectedModuleList(listModel);
//				
//				
//				ois.close(); 
//			}	
//			catch (IOException ex){
//				ex.printStackTrace();
//				System.out.println("Error reading");
//			} catch (ClassNotFoundException e1) {
//				e1.printStackTrace();
//				System.out.println("Error casting");
//			}
//    	}
//    }
	
	private class LoadProfileHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			//load model (Student profile) as an object from a file
			try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("StudentDetailsObj.dat"));) {

				//read Student Profile object from file
				model = (StudentProfile) ois.readObject();
				
				//set student Id
				createProPnl.setStudentId(model.getpNumber());
				
				//set student first name
				createProPnl.setFirstName(model.getStudentName().getFirstName());
				
			    //set student surname
				createProPnl.setSurName(model.getStudentName().getFamilyName());
				
				//set student course
//				Arrays.asList(array).indexOf(4);
				createProPnl.enbleCourseComboBox();
				Course studentCourse = model.getCourse();
				
				createProPnl.setSelectedCourse(studentCourse);
				createProPnl.disAbleCourseComboBox();
				
				//text for overview panel
				String overviewText = "";
				overviewText = " Student ID: " + model.getpNumber();
				overviewText = overviewText + "\n" + "Student Name: " + model.getStudentName().getFullName();
				overviewText = overviewText + "\n" + "Student course: " + model.getCourse();
				
				overviewText = overviewText + "\n" + "Selected modules:";
				overviewText = overviewText + "\n" + "========================================================";
				Set<Module> studentSelectedModule = model.getSelectedModules();
				for (Module m : studentSelectedModule) {
					String code = m.getModuleCode();
					int credits = m.getCredits();
					String moduleName = m.getModuleName();
					boolean mandatory = m.isMandatory();
					String isCompulsory = "Yes";
					if (mandatory == false){
						isCompulsory = "No";
					}
					overviewText = overviewText + "\n" +"Module code: " + code + "\n" +"Module name: " + moduleName + "\n" +"Credit: "+ credits + "\n" + "Is module mandatory: " + isCompulsory + "\n";
				}
				
				overviewText = overviewText + "\n" + "Reserved modules:";
				overviewText = overviewText + "\n" + "========================================================";
				Set<Module> studentReservedModule = model.getReservedModules();
				for (Module m : studentReservedModule) {
					String code = m.getModuleCode();
					int credits = m.getCredits();
					String moduleName = m.getModuleName();
					
					overviewText = overviewText + "\n" +"Module code: " + code + "\n" +"Module name: " + moduleName + "\n" +"Credit: "+ credits + "\n" ;
				}
				
				overviewPnl.setOverview(overviewText);
				
				//show list data in view
				DefaultListModel<Module> selectedModules = new DefaultListModel<Module>();
				DefaultListModel<Module> unSelectedModules = new DefaultListModel<Module>();
				DefaultListModel<Module> reservedModules = new DefaultListModel<Module>();
				
				//iterate through each name in Student Profile model and add to list model
				
				int totalCredit = 0;
				int reservedCredit = 0;
				 for (Module m : model.getCourse().getModulesOnCourse()){
					
				    if(model.getSelectedModules().contains(m)){
				    	  selectedModules.addElement(m);
				          totalCredit = totalCredit + m.getCredits();
				    }
				    else if (model.getReservedModules().contains(m)){
				    	reservedModules.addElement(m);
				    	reservedCredit = reservedCredit + m.getCredits();
				    }
				    	else
				    		unSelectedModules.addElement(m); 
				       }
				
				//set current credit
				slcModPnl.setCurrentCredit(totalCredit);
				
				//set reserved credit
				slcModPnl.setReservedCredit(reservedCredit);
				
				//set default list model in view
				slcModPnl.setSelectedModuleList(selectedModules);
				
				//set unselected module
				slcModPnl.setUnSelectedListModel(unSelectedModules);
				
				//set reserved module
				slcModPnl.setReservedListModel(reservedModules);
				view.changeTab(0);
				
			}
			catch (IOException ioExcep){
				//output error
				JOptionPane.showMessageDialog(null, "Error loading from file!", "Load Error", JOptionPane.ERROR_MESSAGE);
			}
			catch (ClassNotFoundException c) {
				System.out.println("Class Not found");
			}
		}
	}
	
	private class ExitMenuHandler implements ActionListener {
    	public void actionPerformed(ActionEvent e) {
    		System.exit(0);
    	}
    }
	
    private class AboutMenuHandler implements ActionListener {
    	public void actionPerformed(ActionEvent e) {
    		JOptionPane.showMessageDialog(null, "Registration App - Ver 2.1");
    	}
    }
	
}
