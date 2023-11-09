package Screens;
import Rendering.*;

import java.awt.Color;

public class TitleScreen extends Screen {
	private Displayable title;
	private Displayable selectCampaign;
	private Displayable selectPvP;
	private Displayable tank;

	public TitleScreen() {
		// adds text and instructions onto screen
		title = new DisplayedText("DANK TANKS", Driver.X / 2, Driver.Y / 2, StdDraw.WHITE, 100);
		selectCampaign = new DisplayedText("Campaign (Press '1')", .30 * Driver.X, .35 * Driver.Y, StdDraw.GREEN, 30);
		selectPvP = new DisplayedText("PvP (Press '2')", .78 * Driver.X, .35 * Driver.Y, StdDraw.BLUE, 30);
		tank = new Picture(500, 800, "Images/StartScreen.jpg", 400, 400, 0);
		addToScreen(title);
		addToScreen(selectCampaign);
		addToScreen(selectPvP);
		addToScreen(tank);
		setBackgroundColor(Color.BLACK);
	}

	public void display() {
		super.display();
	}
}