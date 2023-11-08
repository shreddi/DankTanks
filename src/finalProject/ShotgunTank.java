package finalProject;

import java.awt.Color;

public class ShotgunTank extends MovingEnemyTank {

	public ShotgunTank(double x, double y, double direction, PlayerTank p) {
		super(x,y,direction,p);
		setBodyColor(Driver.WALL_BROWN);
		setReloadTime(80);
	}

	public void shoot() {
		//shoots many projectiles in several directions
		if (getTime() > getReloadTime()) {
			double theta = Math.toRadians(angle);
			double x = getXcoord() + TURRETLENGTH * Math.cos(theta);
			double y = getYcoord() + TURRETLENGTH * Math.sin(theta);
			double x2 = getXcoord() + TURRETLENGTH * Math.cos(theta+Math.PI/12);
			double y2 = getYcoord() + TURRETLENGTH * Math.sin(theta+Math.PI/12);
			double x3 = getXcoord() + TURRETLENGTH * Math.cos(theta-Math.PI/12);
			double y3 = getYcoord() + TURRETLENGTH * Math.sin(theta-Math.PI/12);
			Projectile p1 = new BuckShot(x, y, shotVelocity, angle);
			Projectile p2 = new BuckShot(x2, y2, shotVelocity, angle + 15);
			Projectile p3 = new BuckShot(x3, y3, shotVelocity, angle - 15);
			myLevel.addToLevel(p1);
			myLevel.addToLevel(p2);
			myLevel.addToLevel(p3);
			setTime(0); // resets the time since the last shot.
		}
	}
}
