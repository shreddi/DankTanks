package Rendering;

/*
 * class used to make and display picture objects
 */
public class Picture extends Displayable {
	protected double width;
	protected double height;
	protected double degrees;
	protected String fileName;

	public Picture(double xcoord, double ycoord, String fn, double widthVar, double heightVar, double d) {
		width = widthVar;
		height = heightVar;
		fileName=fn;
		setXcoord(xcoord);
		setYcoord(ycoord);
		degrees = d;
	}
	
	public void display() {
		StdDraw.picture(getXcoord(), getYcoord(), fileName, width, height, degrees);
	}
}
