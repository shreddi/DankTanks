package Projectiles;
import Rendering.*;

public class CannonBall extends Projectile {

	public CannonBall(double x, double y, double velocity, double angle) {
		// a type of projectile that is larger
		super(x, y, velocity, angle, 30, StdDraw.DARK_GRAY);
	}

}
