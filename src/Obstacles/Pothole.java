package Obstacles;
import Rendering.*;
import Projectiles.*;

import java.awt.Color;

/*
 * like a wall except that projectiles can pass over it
 */
public class Pothole extends Wall {
	protected DisplayedCirc c;

	public Pothole(double x, double y) {
		super(x, y);
		setColor(Driver.POTHOLE_BROWN);
		c = new DisplayedCirc(getXcoord(), getYcoord(), getColor(), getWidth() / 2);
	}

	public Pothole(double x, double y, Color col) {
		super(x, y, col);
		setColor(col);
		c = new DisplayedCirc(getXcoord(), getYcoord(), getColor(), getWidth() / 2);
	}

	public void display() {
		c.display();
	}

	public void collideWith(BoardObject b, String direction) {
		if (b instanceof Projectile) {
			// do nothing
		} else {
			super.collideWith(b, direction);
		}
	}
}
