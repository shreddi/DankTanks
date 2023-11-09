package Screens;
import Rendering.*;
import java.awt.Color;

//this class has an array list of stuff that it displays, 
//and the display() method displays all of these things and changes the background to backgroundColor
public abstract class Screen {
	protected final int MAXOBJECTS = 5000;
	private Displayable[] displayedStuff; // array of stuff to be DISPLAYED
	private Color backgroundColor; // the color of the background for this level
	protected int size;

	/**
	 * Default constructor
	 */
	public Screen() {
		displayedStuff = new Displayable[MAXOBJECTS];
		size = 0;
	}

	/**
	 * used by subclasses to add displayable elements to the list of stuff that
	 * is displayed. This is also used in Level when adding a BoardObject to a
	 * level because it is added both to the list of stepped stuff and the list
	 * of displayed Stuff. See addToLevel in Level.
	 */
	public void addToScreen(Displayable d) {
		displayedStuff[size] = d;
		size++;
	}

	/**
	 * Sets the background to Color c.
	 */
	public void setBackgroundColor(Color c) {
		backgroundColor = c;
	}

	/**
	 * What this method does is it displays all of the contents of
	 * displayedStuff. It clears and sets the background color, it shows the
	 * screen, then it pauses for duration of time PAUSETIME.
	 */
	public void display() {
		StdDraw.clear(backgroundColor); // sets background and clears the screen
										// so the display of all stuff being
										// displayed is refreshed. What this
										// means is that a projectile doesn't
										// draw a line when it moves, it just is
										// a
										// dot.
		for (int i = 0; i < size; i++) {// displays all Displayables in
			Displayable d = displayedStuff[i]; // the array if d hasn't been
												// removed from the array.
			if (d != null)
				d.display();
		}
		StdDraw.show();
		StdDraw.pause(Driver.PAUSETIME);
	}

	/**
	 * removes the given Displayable from the array of displayed stuff by
	 * changing it to null. By doing this, it stops the d from being displayed.
	 */
	public void removeFromScreen(Displayable d) {
		if (d != null) { // if the object hasn't been removed from the level
			int index = Utility.indexOf(d, displayedStuff, size); // If b isn't
																	// on this
																	// screen,
																	// then the
																	// index
																	// will be
																	// -1.
			if (index != -1) { // if b is in the array, AKA, on this screen.
				displayedStuff[index] = null; // instead of removing b from the
												// array, it sets it to null, to
												// avoid
												// ConcurrentModificationException.
			}
		}
	}

	public Color getBackgroundColor() {
		return backgroundColor;
	}

}
