package finalProject;

public class PlayerTankTwo extends Tank {
	public PlayerTankTwo(double x, double y, double direction) {
		super(x, y, direction);
		setColorRed();
	}
	
	//moves depending on user input
	public void step() {
		super.step();
		if ((StdDraw.isKeyPressed(38))) {
			moveForward();
		}
		if ((StdDraw.isKeyPressed(40))) {
			moveBackward();
		}
		if ((StdDraw.isKeyPressed(37))) {
			turn(-getTurnSpeed());
		}
		if ((StdDraw.isKeyPressed(39))) {
			turn(getTurnSpeed());
		}
		if (StdDraw.isKeyPressed(77)) {
			shoot();
		}

	}
}
