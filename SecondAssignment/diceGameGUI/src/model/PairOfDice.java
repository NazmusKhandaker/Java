package model;


public class PairOfDice {
	//Fields
	private Die red;
	private Die blue;
	
	//Constructors
	public PairOfDice() {
		red = new Die();
		blue = new Die();
	}
	
	public PairOfDice(Die red, Die blue) {
		this.red = red;
		this.blue = blue;
	}
	
	//Methods
	public void rollDice() {
		red.roll();
		blue.roll();
	}
	
	public int getDiceScore() {
		return red.getScore() + blue.getScore();
	}
	
	public Die getRed() {
		return red;
	}

	public Die getBlue() {
		return blue;
	}
	
	public String toString() {
		return "PairOfDice:[red=" + red + ", blue=" + blue + "]";
	}

}
