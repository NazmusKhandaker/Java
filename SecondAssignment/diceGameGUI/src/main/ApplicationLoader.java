package main;

import controller.DiceGameController;
import model.DiceGameEngine;
import view.DiceGameFrame;

public class ApplicationLoader {

	
	public static void main(String[] args) {
		
		DiceGameFrame view = new DiceGameFrame();
		DiceGameEngine model = new DiceGameEngine();
		
		DiceGameController controller = new DiceGameController(view, model);

	}

}
