package Rendering;

import java.awt.Color;

/**
 * A filled circle.
 */
public class DisplayedCirc extends Displayable {
	private double radius;
	
	/**
	 * Constructor 1: takes in:
	 * @param xcoord
	 * @param ycoord
	 * @param c
	 * @param radiusVar
	 */
	public DisplayedCirc(double xcoord, double ycoord, Color c, double radiusVar) {
		radius = radiusVar;
		setXcoord(xcoord);
		setYcoord(ycoord);
		setColor(c);
	}

	public void display() {
		StdDraw.setPenColor(getColor());
		StdDraw.filledCircle(getXcoord(), getYcoord(), radius);
	}
}
