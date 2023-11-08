package finalProject;

public class MultiplayerLevel extends Level {
	protected Tank playerOne;
	protected Tank playerTwo;

	public MultiplayerLevel(Tank p1, Tank p2) {
		// add both players and all of the walls to the level
		playerOne = p1;
		playerTwo = p2;
		playerOne.setXcoord(100);
		playerOne.setYcoord(900);
		playerTwo.setXcoord(900);
		playerTwo.setYcoord(100);
		playerOne.setDirection(0);
		playerTwo.setDirection(0);
		addToLevel(playerOne);
		addToLevel(playerTwo);
		addWalls();
		setBackgroundColor(StdDraw.ORANGE);
	}

	public void addWalls() {
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
