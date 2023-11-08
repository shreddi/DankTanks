package finalProject;

public class MagicTank extends StationaryEnemyTank {

	public MagicTank(double x, double y, double direction, PlayerTank p) {
		super(x, y, direction, p);
		setBodyColor(StdDraw.PINK);
		setShotVelocity(1);
		setReloadTime(50);
	}

	public void shoot() {
		// shoots homing projectiles
		if (getTime() > getReloadTime()) {
			double theta = Math.toRadians(angle);
			double x = getXcoord() + TURRETLENGTH * Math.cos(theta);
			double y = getYcoord() + TURRETLENGTH * Math.sin(theta);
			Projectile p = new HomingProjectile(x, y, shotVelocity, angle, getTarget());
			myLevel.addToLevel(p);
			setTime(0); // resets the time since the last shot.
		}
	}

}
