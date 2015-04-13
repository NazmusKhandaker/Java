package controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.DiceGameFrame;
import view.OverviewResultsPanel;
import view.SetupGamePanel;
import model.DiceGameEngine;
import model.Die;
import model.Name;
import model.PairOfDice;
import model.Player;

public class DiceGameController {

	private DiceGameFrame view;
	private SetupGamePanel setupPnl;
	private OverviewResultsPanel overviewPnl;
	private DiceGameEngine model;
	
	public DiceGameController(DiceGameFrame view, DiceGameEngine model) {
		this.view = view;
		this.model = model;
		
		setupPnl = view.getSetupGamePanel();
		overviewPnl = view.getResultsPanel();
		
		setupPnl.addPlayGameListener(new PlayGameHandler());
		
		setupPnl.populateComboBox(setupOpponentPlayers());			
		
	}
	
	
	private Player[] setupOpponentPlayers() {
		
		Player easy = new Player(new Name("Easy", "Opponent"), new PairOfDice(new Die(5), new Die(5)));
		Player medium = new Player(new Name("Medium", "Opponent"), new PairOfDice(new Die(6), new Die(6)));
		Player hard = new Player(new Name("Hard", "Opponent"), new PairOfDice(new Die(7), new Die(7)));
		
		return new Player[] {easy, medium, hard};
	}
	
	
	private class PlayGameHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			model.setOpponent(setupPnl.getSelectedPlayer());
			Player human = new Player(new Name(setupPnl.getFNameInput(), setupPnl.getLNameInput()), new PairOfDice(new Die(6), new Die(6)));
			model.setHuman(human);
			
			view.changeTab(1);
			
			model.playGame();
			
			overviewPnl.setOverview(model.calculateResults());
			Player winner = model.getWinner();
			if (winner != null) {
				
				if (winner == human) {
					overviewPnl.setColor(Color.GREEN);
				} else {
					overviewPnl.setColor(Color.RED);
				}
				
			} else {
				overviewPnl.setColor(Color.CYAN);
			}
			
			
			
		}
	}
	
}
