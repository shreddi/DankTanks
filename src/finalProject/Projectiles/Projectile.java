package finalProject;

import java.awt.Color;

public class Projectile extends BoardObject {

	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////// FIELDS//////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// how much the x coordinate increases with each
	// step
	private double xVelocity;

	// how much the y coordinate increases with each
	// step
	private double yVelocity;

	// how many times the projectile has hit something.
	private int hitCount;

	// if the projectile's hits exceed this amount, it will
	// die.
	private final int MAXHITS;

	// the projectile's displayable AKA what the projectile looks like when it
	// is
	// displayed.
	private Displayable circ;

	// radius of the projectile
	private double radius;

	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////// CONSTRUCTORS//////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Constructor 1: makes a projectile with a default radius of 5. Takes in a:
	 * 
	 * @param x
	 * @param y
	 * @param velocity
	 * @param angle
	 */
	public Projectile(double x, double y, double velocity, double angle) {
		setYcoord(y);
		setXcoord(x);
		calculateVelocities(velocity, angle); // sets xVel and yVel
		radius = 5;
		MAXHITS = 3;
		circ = new DisplayedCirc(x, y, StdDraw.BLUE, radius);
	}

	/**
	 * Constructor 2: takes in a:
	 * 
	 * @param x
	 * @param y
	 * @param velocity
	 * @param angle
	 * @param radius
	 * @param c
	 */
	public Projectile(double x, double y, double velocity, double angle, double radius, Color c) {
		setYcoord(y);
		setXcoord(x);
		setColor(c);
		calculateVelocities(velocity, angle);
		this.radius = radius;
		MAXHITS = 3;
		circ = new DisplayedCirc(x, y, col, radius);
	}

	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////// MISCELLANEOUS//////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public void display() {
		circ.setXcoord(getXcoord());
		circ.setYcoord(getYcoord());
		circ.display();
	}

	/**
	 * calculates the fields xVelocity and yVelocity using a given angle and
	 * velocity. This method is private because it is only used once in the
	 * constructor.
	 */
	private void calculateVelocities(double velocity, double angle) {
		angle = angle * Math.PI / 180; // converts angle to radians.
		xVelocity = velocity * Math.cos(angle);
		yVelocity = velocity * Math.sin(angle);
	}

	/**
	 * if the projectile has hit an amount of walls greater than or equal to the
	 * maximum amount of walls it can hit, it will die. otherwise, it just
	 * moves.
	 */
	public void step() {
		if (hitCount >= MAXHITS)
			die();
		move();

		// ideas for homing missiles below
		// if (getXcoord() > 500)
		// xVelocity--;
		// if (getXcoord() < 500)
		// xVelocity++;
		// if (getYcoord() > 500)
		// yVelocity--;
		// if (getYcoord() < 500)
		// yVelocity++;
		//
	}

	/**
	 * moves the projectile based on its y and x velocity
	 */
	public void move() {
		setXcoord(getXcoord() + xVelocity);
		setYcoord(getYcoord() + yVelocity);
	}

	public void die() {
		removeSelfFromBoard();
	}

	/**
	 * when a projectile hits an edge, it bounces off by inverting either its x
	 * or y velocity.
	 */
	public void hitEdge(String direction) {
		hitCount++; // if a projectile hits any edge, its hit count increases.
		if (direction.equals("fromRight") || direction.equals("fromLeft"))
			invertXvel();
		if (direction.equals("fromTop") || direction.equals("fromBottom"))
			invertYvel();
	}

	public void collideWith(BoardObject b, String direction) {
		if (b instanceof Wall) {
			if (b instanceof Pothole) {
				// does nothing, projectiles go over pothole
			} else if (b instanceof BreakingWall) {
				/*
				 * if the projectile hits a breaking wall, both the projectile
				 * and the wall break.
				 */
				this.die();
				b.die();
			} else {
				hitEdge(direction);
			}
		}
		if (b instanceof Tank) {
			/*
			 * if the projectile hits a tank, both the projectile and the tank
			 * die.
			 */
			die();
			((Tank) b).takeDamage();
		}
		if (b instanceof Projectile) {
			/*
			 * if the projectile hits another projectile, both will die.
			 */
			die();
			b.die();
		}
		if (b instanceof HardWall) {
			/*
			 * if the projectile hits a hard wall it will die
			 */
			die();
		}
	}

	public void invertXvel() {
		xVelocity *= -1;
	}

	public void invertYvel() {
		yVelocity *= -1;
	}

	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////// GETTERS/SETTERS//////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public String toString() {
		return "projectile";
	}

	public double getLeftBoundary() {
		return getXcoord() - radius;
	}

	public double getRightBoundary() {
		return getXcoord() + radius;
	}

	public double getTopBoundary() {
		return getYcoord() + radius;
	}

	public double getBottomBoundary() {
		return getYcoord() - radius;
	}

	public double getYvelocity() {
		return yVelocity;
	}

	public double getXvelocity() {
		return xVelocity;
	}

	public void setXvelocity(double d) {
		xVelocity = d;
	}

	public void setYvelocity(double d) {
		yVelocity = d;
	}
}
