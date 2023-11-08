package finalProject;

import java.awt.Color;

public class BreakingWall extends Wall {
	
	public BreakingWall(double x, double y) {
		super(x, y, Driver.BREAKINGWALL_BROWN);
	}

	public BreakingWall(double x, double y, Color c) {
		super(x, y, c);
	}
	
	/*
	 * if it collides with a projectile it does not die but the projectile does
	 */
	public void collideWith(BoardObject b, String direction) {
		if (b instanceof Projectile) {
			b.die();
			die();
		} else {
			super.collideWith(b, direction);
		}
	}
}
