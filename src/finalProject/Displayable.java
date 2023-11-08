package finalProject;

import java.awt.Color;

/**
 * A Displayable is anything that is displayed on a screen.
 */
public abstract class Displayable {
	/*
	 * all Displayables have an x and y coordinate and a color.
	 */
	protected double xcoord;
	protected double ycoord;
	protected Color col;

	/**
	 * abstract method that is different among all Displayables. Displays all of
	 * the stuff that needs to be displayed.
	 */
	public abstract void display();

	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////// GETTERS/SETTERS//////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public void setXcoord(double x) {
		xcoord = x;
	}

	public void setYcoord(double y) {
		ycoord = y;
	}

	public void setColor(Color c) {
		col = c;
	}

	public double getXcoord() {
		return xcoord;
	}

	public double getYcoord() {
		return ycoord;
	}

	public Color getColor() {
		return col;
	}
}
