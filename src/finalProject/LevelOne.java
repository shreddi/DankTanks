package finalProject;

public class LevelOne extends Level {
	private PlayerTank playerOne;

	public LevelOne(PlayerTank p1) {
		// adds tanks and objects into level
		playerOne = p1;
		playerOne.setXcoord(100);
		playerOne.setYcoord(500);
		Tank p2 = new MovingEnemyTank(900, 500, 0, playerOne);
		addToLevel(p2);
		addToLevel(playerOne);
		setBackgroundColor(StdDraw.ORANGE);
		createWalls();
	}

	// uses loops to create all of the walls in the level
	public void createWalls() {
		for (int y = 975; y > 625; y -= 50) {
			Wall w = new Wall(350, y);
			addToLevel(w);
		}
		for (int x = 150; x < 400; x += 50) {
			Wall w = new Wall(x, 625);
			addToLevel(w);
		}
		for (int x = 575; x < 1000; x += 50) {
			Wall w = new Wall(x, 625);
			addToLevel(w);
		}
		for (int y = 625; y < 775; y += 50) {
			Wall w = new Wall(575, y);
			addToLevel(w);
		}
		for (int y = 25; y < 375; y += 50) {
			Wall w = new Wall(575, y);
			addToLevel(w);
		}
		for (int x = 575; x < 850; x += 50) {
			Wall w = new Wall(x, 375);
			addToLevel(w);
		}
		for (int x = 25; x < 375; x += 50) {
			Wall w = new Wall(x, 375);
			addToLevel(w);
		}
		for (int y = 175; y < 400; y += 50) {
			Wall w = new Wall(375, y);
			addToLevel(w);
		}

	}
}
