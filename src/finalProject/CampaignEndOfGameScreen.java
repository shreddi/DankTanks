package finalProject;

import java.awt.Color;

public class CampaignEndOfGameScreen extends Screen {
	private Picture playAgain;
	private Displayable lvl;

	// adds text and tells what level the player made it to
	public CampaignEndOfGameScreen(int lvlNum) {
		playAgain = new Picture(500, 500, "Images/CampaignEndOfGameScreen.jpg", 1000, 800, 0);
		lvl = new DisplayedText("You made it to level: " + lvlNum, 0.5 * Driver.X, 0.9 * Driver.Y, StdDraw.WHITE, 40);
		addToScreen(playAgain);
		addToScreen(lvl);
		setBackgroundColor(Color.BLACK);
	}
}
