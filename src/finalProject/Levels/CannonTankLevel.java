package finalProject;

public class CannonTankLevel extends Level {
	public CannonTankLevel(PlayerTank p) {
		p.setXcoord(500);
		p.setYcoord(500);
		// add cannon tanks and set background color
		setBackgroundColor(Driver.BACKGROUND_COLOR);
		addToLevel(new CannonTank(950, 950, 90, p));
		addToLevel(new CannonTank(50, 50, 90, p));
		addToLevel(p);
		// add walls
		for (int i = 225; i <= 775; i += 50) {
			addToLevel(new BreakingWall(i, 400));
			addToLevel(new BreakingWall(i, 600));
		}
	}
}
