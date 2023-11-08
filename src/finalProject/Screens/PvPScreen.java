package finalProject;

import java.awt.Color;

public class PvPScreen extends Screen {
	protected Displayable controls;

	public PvPScreen() {
		// displays the controls
		controls = new Picture(500, 500, "Images/PvPStartScreen.jpg", 1000, 1000, 0);
		addToScreen(controls);
		setBackgroundColor(Color.BLACK);
	}
}
