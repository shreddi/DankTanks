package finalProject;

import java.awt.Color;

/**
 * A filled polygon.
 *
 */
public class DisplayedPoly extends Displayable {
	/*
	 * To make a Polygon in Standard Draw, it must have arrays of corresponding
	 * x and y coordinates.
	 */
	protected double[] Xcoords;
	protected double[] Ycoords;

	/**
	 * Constructor 1:
	 * 
	 * @param Xs
	 * @param Ys
	 * @param color
	 */
	public DisplayedPoly(double[] Xs, double[] Ys, Color color) {
		this.Xcoords = Xs;
		this.Ycoords = Ys;
		setColor(color);
	}

	public void display() {
		StdDraw.setPenColor(getColor());
		StdDraw.filledPolygon(Xcoords, Ycoords);
	}

	/**
	 * Sets the x coordinates to the given array
	 * 
	 * @param arr
	 *            the x coordinates to be set to.
	 */
	public void setXcoords(double[] arr) {
		Xcoords = new double[arr.length];
		for (int i = 0; i < arr.length; i++) {
			Xcoords[i] = arr[i];
		}
	}

	/**
	 * Sets the Y coordinates to the given array.
	 * 
	 * @param arr
	 *            the y coordinates to be set to.
	 */
	public void setYcoords(double[] arr) {
		Ycoords = new double[arr.length];
		for (int i = 0; i < arr.length; i++) {
			Ycoords[i] = arr[i];
		}
	}
}