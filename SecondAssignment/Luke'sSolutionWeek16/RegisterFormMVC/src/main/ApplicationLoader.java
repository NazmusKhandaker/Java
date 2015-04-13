package main;
import model.Register;
import view.RegisterFrame;
import controller.RegisterController;

/* Loads the application and creates an instance of the model, view and controller */
public class ApplicationLoader {

	public static void main(String[] args) {
		/* The view and model are decoupled. The controller is 
		 * passed a reference to the model and view. Its job
		 * is to add event handlers to the view and ensure that
		 * the model and view are updated appropriately.*/
		
		RegisterFrame view = new RegisterFrame();
		Register model = new Register();
		RegisterController controller = new RegisterController(view, model);
	}

}
