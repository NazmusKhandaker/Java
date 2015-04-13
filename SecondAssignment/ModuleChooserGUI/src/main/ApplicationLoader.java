package main;

import controller.ModuleChooserController;
import model.StudentProfile;
import view.ModuleChooserFrame;

public class ApplicationLoader {

	public static void main(String[] args) {
		
		ModuleChooserFrame view = new ModuleChooserFrame();
		StudentProfile model = new StudentProfile();

		ModuleChooserController controller = new ModuleChooserController(view, model);
	}

}
