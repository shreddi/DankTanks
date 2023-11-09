package Levels;
import Obstacles.*;
import Tanks.*;
import Rendering.*;

public class WallLevel extends Level {
	protected Tank t1 = new PlayerTank(400, 300, 0);

	public WallLevel() {
		setBackgroundColor(Driver.BACKGROUND_COLOR);
		addToLevel(t1);
		for (int i = 25; i < 1000; i += 50) {
			Pothole p = new Pothole(300, i);
			Wall w;
			if ((i / 50) % 2 == 0)
				w = new Wall(i, 600);
			else
				w = new BreakingWall(600, i);
			addToLevel(p);
			addToLevel(w);
		}
	}
}
