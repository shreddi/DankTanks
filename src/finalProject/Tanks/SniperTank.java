package finalProject;

public class SniperTank extends StationaryEnemyTank {

	public SniperTank(double x, double y, double direction, PlayerTank p) {
		// able to shoot very fast at player tanks
		super(x, y, direction, p);
		setBodyColor(StdDraw.RED);
		setShotVelocity(25);
		setReloadTime(30);
	}

}
