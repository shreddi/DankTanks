package Levels;
import Obstacles.*;
import Tanks.*;
import Rendering.*;

public class EnemyLevel extends Level {
	private Tank e;
	private Tank g;
	private Tank s;
	private Tank sn;
	private Tank m;

	public EnemyLevel(PlayerTank p) {
		//adds new enemies and walls to level
		e = new MovingEnemyTank(325, 325, 90, p);
		g = new GatlingTank(100, 500, 0, p);
		s = new ShotgunTank(900, 100, 90, p);
		sn = new SniperTank(100, 900, 80, p);
		m = new MagicTank(500, 100, 70, p);
		setBackgroundColor(Driver.BACKGROUND_COLOR);
		addToLevel(p);
		addToLevel(e);
		addToLevel(g);
		addToLevel(s);
		addToLevel(sn);
		addToLevel(m);
		for (int i = 425; i < 825; i += 50) {
			addToLevel(new Wall(i, 425));
			addToLevel(new Wall(425, i));
		}
	}
}
