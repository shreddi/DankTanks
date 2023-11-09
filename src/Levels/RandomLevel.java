package Levels;
import Obstacles.*;
import Tanks.*;
import Rendering.*;

/*
 * generates random levels after the pre-game made levels
 */
public class RandomLevel extends Level {
	private int multiplier;
	private PlayerTank playerOne;

	public RandomLevel(int m, PlayerTank p1) {
		playerOne = p1;
		playerOne.setXcoord(25);
		playerOne.setYcoord(25);
		addToLevel(playerOne);
		multiplier = m;
		setBackgroundColor(StdDraw.ORANGE);
		addWalls();
		addEnemies();
		addBreakableWalls();
		addPotholes();
	}

	// uses a multiplier that is the level number to increase the difficulty in
	// the
	// levels
	public void addWalls() {
		for (int x = 25; x < 175; x += 25) {
			addToLevel(new BreakingWall(x, 175));
		}
		for (int y = 25; y < 175; y += 25) {
			addToLevel(new BreakingWall(175, y));
		}
		for (int i = 0; i < multiplier * 1.5; i++) {
			int x = (int) (Math.random() * 825 + 175);
			int y = (int) (Math.random() * 825 + 175);
			addToLevel(new Wall(x, y));
		}
	}

	public void addEnemies() {
		for (int i = 0; i < multiplier; i++) {
			int x = (int) (Math.random() * 825 + 175);
			int y = (int) (Math.random() * 825 + 175);
			addToLevel(new MovingEnemyTank(x, y, 0, playerOne));
		}
	}

	public void addBreakableWalls() {
		for (int i = 0; i < multiplier * 2; i++) {
			int x = (int) (Math.random() * 825 + 175);
			int y = (int) (Math.random() * 825 + 175);
			addToLevel(new BreakingWall(x, y));
		}
	}

	public void addPotholes() {
		for (int i = 0; i < multiplier * 2; i++) {
			int x = (int) (Math.random() * 825 + 175);
			int y = (int) (Math.random() * 825 + 175);
			addToLevel(new Pothole(x, y));
		}
	}

}
