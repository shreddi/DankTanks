package finalProject;

public class CannonTank extends MovingEnemyTank {

	public CannonTank(double x, double y, double direction, PlayerTank p) {
		super(x, y, direction, p);
		setBodyColor(StdDraw.ORANGE);
		setReloadTime(40);
	}

	// a tank that shoots cannon balls
	public void shoot() {
		if (getTime() > getReloadTime()) {
			double theta = Math.toRadians(angle);
			double x = getXcoord() + (TURRETLENGTH + 30) * Math.cos(theta);
			double y = getYcoord() + (TURRETLENGTH + 30) * Math.sin(theta);
			// create a projectile cannon ball
			Projectile p = new CannonBall(x, y, shotVelocity, angle);
			myLevel.addToLevel(p);
			setSpeed(20);
			moveBackward();
			setSpeed(2);
			setTime(0); // resets the time since the last shot.
		}
	}

}
