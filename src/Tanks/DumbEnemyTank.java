package Tanks;

//a very easy to beat enemy tank
public class DumbEnemyTank extends EnemyTank {

	public DumbEnemyTank(double x, double y, double direction, PlayerTank p) {
		super(x, y, direction, p);
		setColorBlack();
	}

	public void step() {
		// moves depending on random numbers that are generated
		super.step();
		int n = (int) (Math.random() * 5) + 1;
		if (n == 1) {
			moveForward();
		}
		if (n == 2) {
			moveBackward();
		}
		if (n == 3) {
			turn(-getTurnSpeed());
		}
		if (n == 4) {
			turn(getTurnSpeed());
		}
		if (n == 5) {
			shoot();
		}

	}

	public String toString() {
		return "ENEMY DUM TANK";
	}
}
