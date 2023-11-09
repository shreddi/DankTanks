package Tanks;
import Rendering.*;
import Projectiles.*;
import Obstacles.Wall;
import java.awt.Color;

/**
 * A tank that drives around and shoots projectiles. A lot of the fields of the
 * tank seem like they should be final, but they are not because a playerTank
 * can be upgraded through the course of the game.
 *
 */
public abstract class Tank extends MapObject {

	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////// FIELDS//////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// the following 4 variables are the dimensions of the tank and its turret.
	protected final double WIDTH;
	protected final double HEIGHT;
	protected final double TURRETLENGTH;
	protected final double TURRETHEIGHT;

	// the hitbox of the tank is a special distance away from the tank, less than
	// the width and height of the tank but more than the internal circle of the
	// tank. Our hitbox does not account for the angle at which the tank is turned.
	protected double HITBOXRADIUS;

	// the displayables for the body of the tank and its turret. They are seperate
	// polygons because they can be different colors.
	protected DisplayedPoly tankBody;
	protected DisplayedPoly turret;

	// The following 4 arrays are the corresponding x and y coordinates for
	// displaying the tank body and turret.
	protected double[] bodyVerticesX;
	protected double[] bodyVerticesY;
	protected double[] turretVerticesX;
	protected double[] turretVerticesY;

	// the angle at which the tank is currently facing.
	protected double angle;

	// speed at which the tank moves.
	protected double speed;

	// speed at which the tank turns.
	protected double turnSpeed;

	// the time since the last projectile has been shot.
	protected double time = 0;

	// how much time must be elapsed before the tank can shoot again.
	protected double reloadTime;

	// the speed at which this tank fires projectiles.
	protected double shotVelocity;

	protected double shotSize;

	// the health of the tank. Only important for boss tanks.
	protected int health;

	protected Color turretColor;

	protected Color shotColor;

	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////// CONSTRUCTORS//////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Constructor 1:
	 * 
	 * @param x
	 * @param y
	 * @param direction
	 */
	public Tank(double x, double y, double direction) {
		WIDTH = Driver.X / Driver.GRIDX;
		HEIGHT = Driver.Y / Driver.GRIDY;
		TURRETLENGTH = WIDTH;
		TURRETHEIGHT = HEIGHT / 4;
		HITBOXRADIUS = (HEIGHT - HEIGHT / 4) / 2;
		bodyVerticesX = new double[4];
		bodyVerticesY = new double[4];
		turretVerticesX = new double[4];
		turretVerticesY = new double[4];
		setXcoord(x);
		setYcoord(y);
		setColor(StdDraw.GREEN);
		turretColor = StdDraw.BLACK;
		shotColor = StdDraw.BLUE;
		angle = direction;
		speed = 5;
		turnSpeed = 5;
		reloadTime = 20;
		shotVelocity = 10;
		shotSize = 5;
		health = 1;
		tankBody = new DisplayedPoly(bodyVerticesX, bodyVerticesY, getColor());
		turret = new DisplayedPoly(turretVerticesX, turretVerticesY, turretColor);
	}

	/**
	 * Constructor 2: for specific enemy tanks
	 * 
	 * @param x
	 * @param y
	 * @param direction
	 * @param speed
	 * @param turnSpeed
	 * @param reloadTime
	 * @param shotVelocity
	 * @param shotSize
	 * @param bodyColor
	 * @param turretColor
	 */
	public Tank(double x, double y, double direction, double speed, double turnSpeed, double reloadTime,
			double shotVelocity, double shotSize, Color bodyColor, Color turretColor, Color shotColor) {
		WIDTH = Driver.X / Driver.GRIDX;
		HEIGHT = Driver.Y / Driver.GRIDY;
		TURRETLENGTH = WIDTH;
		TURRETHEIGHT = HEIGHT / 4;
		HITBOXRADIUS = (HEIGHT - HEIGHT / 4) / 2;
		bodyVerticesX = new double[4];
		bodyVerticesY = new double[4];
		turretVerticesX = new double[4];
		turretVerticesY = new double[4];
		setXcoord(x);
		setYcoord(y);
		angle = direction;
		this.speed = speed;
		this.turnSpeed = turnSpeed;
		this.reloadTime = reloadTime;
		this.shotVelocity = shotVelocity;
		this.shotSize = shotSize;
		health = 1;
		this.turretColor = turretColor;
		this.shotColor = shotColor;
		setColor(bodyColor);
		tankBody = new DisplayedPoly(bodyVerticesX, bodyVerticesY, getColor());
		turret = new DisplayedPoly(turretVerticesX, turretVerticesY, turretColor);
	}

	/**
	 * Constructor 3: for boss tanks. Takes in:
	 * 
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 * @param direction
	 * @param speed
	 * @param turnSpeed
	 * @param reloadTime
	 * @param shotVelocity
	 * @param shotSize
	 * @param health
	 * @param bodyColor
	 * @param turretColor
	 */
	public Tank(double x, double y, double width, double height, double direction, double speed, double turnSpeed,
			double reloadTime, double shotVelocity, double shotSize, int health, Color bodyColor, Color turretColor,
			Color shotColor) {
		WIDTH = width;
		HEIGHT = height;
		TURRETLENGTH = WIDTH;
		TURRETHEIGHT = HEIGHT / 4;
		HITBOXRADIUS = (HEIGHT - HEIGHT / 4) / 2;
		bodyVerticesX = new double[4];
		bodyVerticesY = new double[4];
		turretVerticesX = new double[4];
		turretVerticesY = new double[4];
		setXcoord(x);
		setYcoord(y);
		angle = direction;
		this.speed = speed;
		this.turnSpeed = turnSpeed;
		this.reloadTime = reloadTime;
		this.shotVelocity = shotVelocity;
		this.shotSize = shotSize;
		this.health = health;
		this.turretColor = turretColor;
		this.shotColor = shotColor;
		setColor(bodyColor);
		tankBody = new DisplayedPoly(bodyVerticesX, bodyVerticesY, getColor());
		turret = new DisplayedPoly(turretVerticesX, turretVerticesY, turretColor);
	}

	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////// MISCELLANEOUS////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public void display() {
		turret.display();
		tankBody.display();
	}

	/**
	 * keeps angle within boundaries of 0 and 359, increases time since the last
	 * shot, and sets the vertices for the tank's polygon displayable.
	 */
	public void step() {
		if (health <= 0)
			removeSelfFromBoard();
		if (angle < 0)
			angle += 360;
		else if (angle >= 360)
			angle -= 360;
		time++;
		setVertices();

	}

	public void hitEdge(String direction) {
		if (direction.equals("fromRight"))
			setXcoord(getXcoord() - speed);
		if (direction.equals("fromLeft"))
			setXcoord(getXcoord() + speed);
		if (direction.equals("fromTop"))
			setYcoord(getYcoord() - speed);
		if (direction.equals("fromBottom"))
			setYcoord(getYcoord() + speed);
	}

	public void collideWith(BoardObject b, String direction) {
		if (b instanceof Projectile) {
			/*
			 * if the tank has hit a projectile, both boardObjects die.
			 */
			b.die();
			takeDamage();
		}
		/*
		 * if a tank runs into a wall or another tank, it will just collide with it like
		 * a normal edge
		 */
		if (b instanceof Wall) {
			hitEdge(direction);
		}
		if (b instanceof Tank) {
			hitEdge(direction);
		}
	}

	/**
	 * creates a new projectile at the end of the turret, if the tank has waited
	 * long enough (reload time) to do so, with the velocity shotVelocity.
	 */
	public void shoot() {
		if (time > reloadTime) {
			double theta = Math.toRadians(angle);
			double x = getXcoord() + TURRETLENGTH * Math.cos(theta);
			double y = getYcoord() + TURRETLENGTH * Math.sin(theta);
			Projectile p = new Projectile(x, y, shotVelocity, angle, shotSize, shotColor);
			myLevel.addToLevel(p);
			time = 0; // resets the time since the last shot.
		}
	}
	public void ReloadTime(int n) {
		reloadTime=n;
	}
	
	/**
	 * moves the tank forward based on the tank's speed.
	 */
	public void moveForward() {
		double theta = angle * (Math.PI / 180);
		double yVelo = Math.sin(theta) * speed;
		double xVelo = Math.cos(theta) * speed;
		setYcoord(getYcoord() + yVelo);
		setXcoord(getXcoord() + xVelo);
	}

	/**
	 * moves the tank backward based on the tank's speed.
	 */
	public void moveBackward() {
		double theta = angle * (Math.PI / 180);
		double yVelo = Math.sin(theta) * speed;
		setYcoord(getYcoord() - yVelo);
		double xVelo = Math.cos(theta) * speed;
		setXcoord(getXcoord() - xVelo);
	}

	public void die() {
		removeSelfFromBoard();
	}

	/**
	 * turns the tank by a specific amount of degrees
	 * 
	 * @param numDegrees
	 */
	public void turn(double numDegrees) {
		angle += -numDegrees;
	}

	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////// GETTERS/SETTERS////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public void setAngle(double ang) {
		angle = ang;
	}

	public double getLeftBoundary() {
		return getXcoord() - HITBOXRADIUS;
	}

	public double getRightBoundary() {
		return getXcoord() + HITBOXRADIUS;
	}

	public double getTopBoundary() {
		return getYcoord() + HITBOXRADIUS;
	}

	public double getBottomBoundary() {
		return getYcoord() - HITBOXRADIUS;
	}

	/**
	 * Based upon the center x and y position of the tank, calculates the vertices
	 * of the polygons of the Tank, then sets the polygon's vertices to those
	 * values.
	 */
	public void setVertices() {
		double x = getXcoord();
		double y = getYcoord();
		double theta = Math.toRadians(angle);
		double alpha = Math.atan(HEIGHT / WIDTH);
		double beta = Math.atan((TURRETHEIGHT / 2) / (TURRETLENGTH));
		bodyVerticesX[0] = x + (WIDTH / 2) * Math.cos(alpha + theta);
		bodyVerticesX[1] = x + (WIDTH / 2) * Math.cos(theta + (Math.PI - alpha));
		bodyVerticesX[2] = x + (WIDTH / 2) * Math.cos(theta - (Math.PI - alpha));
		bodyVerticesX[3] = x + (WIDTH / 2) * Math.cos(theta - alpha);

		bodyVerticesY[0] = y + (WIDTH / 2) * Math.sin(alpha + theta);
		bodyVerticesY[1] = y + (WIDTH / 2) * Math.sin(theta + (Math.PI - alpha));
		bodyVerticesY[2] = y + (WIDTH / 2) * Math.sin(theta - (Math.PI - alpha));
		bodyVerticesY[3] = y + (WIDTH / 2) * Math.sin(theta - alpha);

		turretVerticesX[0] = x + (TURRETLENGTH) * Math.cos(theta + beta);
		turretVerticesX[1] = x + (TURRETHEIGHT / 2) * Math.cos(theta + Math.PI / 2);
		turretVerticesX[2] = x + (TURRETHEIGHT / 2) * Math.cos(theta - Math.PI / 2);
		turretVerticesX[3] = x + (TURRETLENGTH) * Math.cos(theta - beta);

		turretVerticesY[0] = y + (TURRETLENGTH) * Math.sin(theta + beta);
		turretVerticesY[1] = y + (TURRETHEIGHT / 2) * Math.sin(theta + Math.PI / 2);
		turretVerticesY[2] = y + (TURRETHEIGHT / 2) * Math.sin(theta - Math.PI / 2);
		turretVerticesY[3] = y + (TURRETLENGTH) * Math.sin(theta - beta);

		tankBody.setYcoords(bodyVerticesY);
		tankBody.setXcoords(bodyVerticesX);
		turret.setYcoords(turretVerticesY);
		turret.setXcoords(turretVerticesX);
	}

	public void setColorRed() {
		tankBody = new DisplayedPoly(bodyVerticesX, bodyVerticesY, StdDraw.RED);
	}

	public void setColorBlack() {
		tankBody = new DisplayedPoly(bodyVerticesX, bodyVerticesY, StdDraw.BLACK);
	}

	public void addToVelocity(int n) {
		speed += n;
	}

	public void addToShotSpeed(int n) {
		shotVelocity += n;
	}

	public void addToHealth(int n) {
		health += n;
	}

	public double getVelocity() {
		return speed;
	}

	public double getShotSpeed() {
		return shotVelocity;
	}

	public void reset() {
		health = 1;
		speed = 5;
		shotVelocity = 10;
	}

	public void takeDamage() {
		health--;
	}

	public int getHealth() {
		return health;
	}

	public double getTurnSpeed() {
		return turnSpeed;
	}

	public double getSpeed() {
		return speed;
	}

	public char getChar() {
		return 't';
	}

	public String toString() {
		return "tank";
	}

	public void setSpeed(double d) {
		speed = d;
	}

	public void setReloadTime(double d) {
		reloadTime = d;
	}

	public void setShotVelocity(double d) {
		shotVelocity = d;
	}

	public void setShotSize(double d) {
		shotSize = d;
	}

	public void setHealth(int i) {
		health = i;
	}

	public void setTurretColor(Color c) {
		turretColor = c;
		turret = new DisplayedPoly(bodyVerticesX, bodyVerticesY, c);
	}

	public void setBodyColor(Color c) {
		setColor(c);
		tankBody = new DisplayedPoly(bodyVerticesX, bodyVerticesY, getColor());
	}
	
	public double getReloadTime() {
		return reloadTime;
	}
	
	public double getTime() {
		return time;
	}
	
	public void setTime(double d) {
		time = d;
	}
	
	public void setDirection(int n){
		angle=n;
	}
}
