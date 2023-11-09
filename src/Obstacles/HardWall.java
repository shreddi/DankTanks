package Obstacles;
import Rendering.*;
import Projectiles.*;

public class HardWall extends Wall {

	public HardWall(double x, double y) {
		super(x, y, StdDraw.GRAY);
	}

	// projectiles die when the collide with this wall
	public void collideWith(BoardObject b, String direction) {
		if (b instanceof Projectile) {
			b.die();
		} else
			super.collideWith(b, direction);
	}
}
