package Obstacles;
import Rendering.*;
import java.awt.Color;

public class Wall extends MapObject {
	private DisplayedRect box;
	private final double WIDTH;
	private final double HEIGHT;

	public Wall(double x, double y) {
		setXcoord(x);
		setYcoord(y);
		WIDTH = Driver.X / Driver.GRIDX;
		HEIGHT = Driver.Y / Driver.GRIDY;
		box = new DisplayedRect(x, y, Driver.WALL_BROWN, WIDTH, HEIGHT);
	}

	public Wall(double x, double y, Color c) {
		setXcoord(x);
		setYcoord(y);
		setColor(c);
		WIDTH = Driver.X / Driver.GRIDX;
		HEIGHT = Driver.Y / Driver.GRIDY;
		box = new DisplayedRect(getXcoord(), getYcoord(), getColor(), WIDTH, HEIGHT);
	}

	public void step() {
		// does nothing
	}

	@Override
	public double getLeftBoundary() {
		return getXcoord() - WIDTH / 2;
	}

	@Override
	public double getRightBoundary() {
		return getXcoord() + WIDTH / 2;
	}

	@Override
	public double getTopBoundary() {
		return getYcoord() + HEIGHT / 2;
	}

	@Override
	public double getBottomBoundary() {
		return getYcoord() - HEIGHT / 2;
	}

	@Override
	public void display() {
		box.display();
	}

	@Override
	public void collideWith(BoardObject b, String direction) {
		/*
		 * since Wall does not move and cannot die, it does not need to react
		 * when it is collided with by another BoardObject. The implementations
		 * of collideWith in Tank and projectile take care of this specific
		 * activity. For example, a projectile bounces itself off of the wall if
		 * it collides with a wall, instead of a wall bouncing that same
		 * projectile.
		 */
	}

	@Override
	public void die() {
		myLevel.removeFromLevel(this);
	}

	public double getWidth() {
		return WIDTH;
	}

	public double getHeight() {
		return HEIGHT;
	}

	public char getChar() {
		return 'w';
	}

	@Override
	public void hitEdge(String direction) {
		// does nothing, a wall can never hit an edge of the screen and even if
		// it did,
		// it wouldn't do anything still.
	}

}
