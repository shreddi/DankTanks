package finalProject;

import java.awt.Color;

public class UpgradeScreen extends Screen {
	private Tank player;
	private Displayable title;
	private Displayable yourSpeed;
	private Displayable yourBulletSpeed;
	private Displayable pass;

	public UpgradeScreen(Tank p) {
		player = p;
		//displays the info about the current state of the tank and gives instructions
		title = new DisplayedText("CHOOSE YOUR UPGRADE", Driver.X / 2, .75 * Driver.Y, StdDraw.RED, 50);
		yourSpeed = new DisplayedText("Reload Time= " + player.getReloadTime() + " (press '1' to upgrade)",
				0.5 * Driver.X, 0.50 * Driver.Y, StdDraw.RED, 30);
		yourBulletSpeed = new DisplayedText("Bullet Speed= " + player.getShotSpeed() + " (press '2' to upgrade)",
				0.5 * Driver.X, 0.40 * Driver.Y, StdDraw.RED, 30);
		pass = new DisplayedText("(press '3' for no upgrade)", 0.5 * Driver.X, 0.30 * Driver.Y, StdDraw.RED, 30);
		addToScreen(title);
		addToScreen(yourSpeed);
		addToScreen(yourBulletSpeed);
		addToScreen(pass);
		setBackgroundColor(Color.BLACK);
	}
}
