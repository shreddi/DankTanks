package Screens;
import Rendering.*;
import java.awt.Color;
import Tanks.*;

public class PvPEndOfGameScreen extends Screen {
	protected Tank playerOne;
	protected Tank playerTwo;
	protected Displayable spaceBar;
	protected Displayable youWon;
	protected Displayable playAgain;

	public PvPEndOfGameScreen(Tank p1, Tank p2) {
		//adds text to screen
		playAgain=new Picture(500, 550, "Images/PvPEndOfGameScreen.jpg",  1000, 600, 0);
		spaceBar = new DisplayedText("Press Space Bar To Go Back To Start Screen", 0.5 * Driver.X, 0.10 * Driver.Y,
				StdDraw.WHITE, 25);
		playerOne = p1;
		playerTwo = p2;
		//decides which player won and displays that
		if (playerOne.getHealth() > playerTwo.getHealth()) {
			youWon = new DisplayedText("PLAYER ONE WINS!!!", 0.5 * Driver.X, 0.20 * Driver.Y, StdDraw.WHITE, 40);
		}
		else if(playerTwo.getHealth()>playerOne.getHealth()){
			youWon = new DisplayedText("PLAYER TWO WINS!!!", 0.5 * Driver.X, 0.20 * Driver.Y, StdDraw.WHITE, 40);
		}
		else{
			youWon = new DisplayedText("EVERY ONE LOSES :(", 0.5 * Driver.X, 0.20 * Driver.Y, StdDraw.WHITE, 40);
		}
		addToScreen(spaceBar);
		addToScreen(youWon);
		addToScreen(playAgain);
		setBackgroundColor(Color.BLACK);

	}
}
