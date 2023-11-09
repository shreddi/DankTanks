package Screens;
import Rendering.*;
import java.awt.Color;

public class CampaignScreen extends Screen {
	// the following variables are the the things to be displayed.
	private Displayable campaignMode;
	private Displayable spaceBar;
	private Displayable instructions;

	// adds instructions and images to screen
	public CampaignScreen() {
		campaignMode = new DisplayedText("CAMPAIGN MODE", Driver.HALFX, .85 * Driver.Y, StdDraw.RED, 75);
		spaceBar = new DisplayedText("Press Space Bar To Begin Playing", 0.5 * Driver.X, 0.05 * Driver.Y, StdDraw.RED,
				30);
		instructions = new Picture(400, 450, "Images/Campaign Instructions.jpg", 1000, 600, 0);
		addToScreen(campaignMode);
		addToScreen(spaceBar);
		addToScreen(instructions);
		setBackgroundColor(Color.BLACK);
	}
}
