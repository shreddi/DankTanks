package finalProject;

import java.awt.Color;

public class MovingEnemyTank extends EnemyTank {

	public MovingEnemyTank(double x, double y, double direction, PlayerTank p) {
		// set all of the atributes of the moving enemy tank
		super(x, y, direction, p);
		setSpeed(2);
		setReloadTime(30);
		setShotVelocity(10);
		setShotSize(5);
		setBodyColor(StdDraw.DARK_GRAY);
		setTurretColor(StdDraw.BLACK);
	}

}
