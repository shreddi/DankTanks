package Tanks;
import Rendering.*;

public class GatlingTank extends MovingEnemyTank {

	public GatlingTank(double x, double y, double direction, PlayerTank p) {
		// shoots faster than normal tanks
		super(x, y, direction, p);
		setReloadTime(5);
		setBodyColor(StdDraw.YELLOW);
	}
}
