package finalProject;

public class LevelTwo extends Level {
	public LevelTwo(PlayerTank p) {
		// add objects and tanks to level
		p.setXcoord(300);
		p.setYcoord(500);
		addToLevel(p);
		addToLevel(new StationaryEnemyTank(500, 500, 180, p));
		setBackgroundColor(Driver.BACKGROUND_COLOR);
		for (int i = 400; i <= 600; i += 50) {
			addToLevel(new HardWall(400, i));
			addToLevel(new Wall(600, i));
		}
		for (int i = 450; i <= 600; i += 50) {
			addToLevel(new HardWall(i, 400));
			addToLevel(new HardWall(i, 600));
		}
	}
}
