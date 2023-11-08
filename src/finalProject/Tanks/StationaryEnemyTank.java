package finalProject;

public class StationaryEnemyTank extends EnemyTank {

	// not able to move but a normal enemy tank
	public StationaryEnemyTank(double x, double y, double direction, PlayerTank p) {
		super(x, y, direction, p);
		setSpeed(0);
		setReloadTime(20);
		setShotVelocity(10);
		setShotSize(5);
		setBodyColor(StdDraw.DARK_GRAY);
		setTurretColor(StdDraw.BLACK);
	}

}
