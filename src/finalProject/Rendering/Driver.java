package finalProject.Rendering;
import java.awt.Color;

public class Driver {
	// sets variables to be used throughout the classes
	public static final int X = 1000;
	public static final int Y = 1000;
	public static final int HALFX = 500;
	public static final int HALFY = 500;
	final static int PAUSETIME = 20;
	final static int GRIDX = 20;
	final static int GRIDY = 20;
	final static int GRIDXCONSTANT = X / GRIDX;
	final static int GRIDYCONSTANT = Y / GRIDY;
	final static Color WALL_BROWN = new Color(162, 108, 0);
	final static Color BREAKINGWALL_BROWN = new Color(162, 128, 0);
	final static Color POTHOLE_BROWN = new Color(212, 158, 50);
	final static Color BACKGROUND_COLOR = new Color(232, 168, 60);

	public static void main(String[] args) {
		// changes size of screen and x and y scales
		StdDraw.setCanvasSize(650, 650);
		StdDraw.setXscale(0, X);
		StdDraw.setYscale(0, Y);
		// enable double buffering so that all changes to screen occur at once
		StdDraw.enableDoubleBuffering();
		// create a new game
		Game game = new Game();
		while (true) {
			// run the game continuously
			game.run();
		}
	}
}
