package Tanks;

public abstract class EnemyTank extends Tank {
	protected PlayerTank target;

	public EnemyTank(double x, double y, double direction, PlayerTank p) {
		super(x, y, direction);
		target = p;
	}

	public char getChar() {
		return 'e'; // for enemy
	}

	public void step() {
		fight();
		super.step();
	}

	/*
	 * tracks down the player tank and tries to shoot it
	 */
	public void fight() {
		double xDist = getXDistanceFrom(target);
		double yDist = getYDistanceFrom(target);
		double angle = Math.atan(yDist / xDist);
		angle = angle * 180 / Math.PI;
		if (xDist > 0) {// if the target is to my left
			angle += 180;
		}
		setAngle(angle);
		shoot();
		moveForward();
	}

	// sets a new target
	public void setTarget(PlayerTank p) {
		target = p;
	}

	public PlayerTank getTarget() {
		return target;
	}
}
