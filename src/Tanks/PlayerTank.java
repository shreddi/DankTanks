package Tanks;
import Rendering.*;

public class PlayerTank extends Tank {

	public PlayerTank(double x, double y, double direction) {
		super(x, y, direction);
	}

	/*
	 * moves depending on the input by the user
	 */
	public void step() {
		super.step();
		if ((StdDraw.isKeyPressed(69))) {
			moveForward();
		}
		if ((StdDraw.isKeyPressed(68))) {
			moveBackward();
		}
		if ((StdDraw.isKeyPressed(83))) {
			turn(-getTurnSpeed());
		}
		if ((StdDraw.isKeyPressed(70))) {
			turn(getTurnSpeed());
		}
		if (StdDraw.isKeyPressed(81)) {
			shoot();
		}
	}

	public char getChar() {
		return 'p';
	}
}
