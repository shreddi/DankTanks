package Rendering;

import java.awt.Color;
import java.awt.Font;

public class DisplayedText extends Displayable {
	protected String text;
	protected Font f;
	
	/*
	 * constructor with text displayed, the x and y coordinates of the text, and the color
	 */
	public DisplayedText(String textVar, double xcoord, double ycoord, Color col, int size, String font) {
		text = textVar;
		setXcoord(xcoord);
		setYcoord(ycoord);
		setColor(col);
	}
	
	/*
	 * constructor with text displayed, the x and y coordinates of the text, the color, and the font size
	 */
	public DisplayedText(String t, double xcoord, double ycoord, Color col, int size) { 
		text = t;
		setXcoord(xcoord);
		setYcoord(ycoord);
		setColor(col);
		f = new Font("Impact", Font.PLAIN, size);
	}
	
	/*
	 * default constructor
	 */
	public DisplayedText() {
		text = "Default text";
		ycoord = 0.5 * Driver.X;
		xcoord = 0.5 * Driver.Y;
		setColor(StdDraw.BLACK);
		f = new Font("Impact", Font.PLAIN, 20);
	}

	public void display() {
		StdDraw.setFont(f);
		StdDraw.setPenColor(getColor());
		StdDraw.text(getXcoord(), getYcoord(), text);
	}
}
