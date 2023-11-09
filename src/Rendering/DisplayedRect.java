package Rendering;

import java.awt.Color;

public class DisplayedRect extends Displayable{
	protected double width;
	protected double height;
	
	public DisplayedRect(double xcoord, double ycoord, Color c, double widthVar, double heightVar){
		width = widthVar;
		height = heightVar;
		setXcoord(xcoord);
		setYcoord(ycoord);
		setColor(c);
	}
	
	public void display() {
		StdDraw.setPenColor(getColor());
		StdDraw.filledRectangle(getXcoord(), getYcoord(), width/2, height/2);
	}
}
