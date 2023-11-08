package finalProject;

/**
 * A boardObject is anything that is displayed and is processed in a Level.
 */
public abstract class BoardObject extends Displayable {
	protected Level myLevel; // the level that this boardObject is in.

	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////// CONSTRUCTORS//////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Constructor 1, only default.
	 */
	public BoardObject() {
		myLevel = null; // initially, the boardObject's doesn't have a level,
		// but it gets its level assigned when it is added
		// to a Level. Refer to addToLevel() in the Level
		// class.
	}

	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////// MISCELLANEOUS//////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * this abstract method is the one that after every increment of time, the
	 * boardObject changes something about itself. for example, Projectile moves
	 * when it does step()
	 */
	public abstract void step();

	/**
	 * this method causes the board object to no longer be processed by the level
	 * it's in and to no longer be displayed by the screen it's in.
	 */
	public void removeSelfFromBoard() {
		myLevel.removeFromLevel(this); // the board object refers to itself
										// using the
		// this keyword. Basically, the board object
		// tells its level to remove itself.
	}

	/**
	 * checks if this board object has collided with BoardObject b. If it has, then
	 * it will collide with that object, calling collideWith(BoardObject b).
	 */
	public void doCollision(BoardObject b) {
		/*
		 * the following variables are the specific boundaries and the coordinates of
		 * this BoardObject.
		 */
		double myYcoord = getYcoord();
		double myXcoord = getXcoord();
		double myRight = getRightBoundary();
		double myLeft = getLeftBoundary();
		double myTop = getTopBoundary();
		double myBottom = getBottomBoundary();

		/*
		 * the following variables are the specific boundaries of the BoardObject that
		 * this BoardObject might be colliding with.
		 */
		double hisRight = b.getRightBoundary();
		double hisLeft = b.getLeftBoundary();
		double hisTop = b.getTopBoundary();
		double hisBottom = b.getBottomBoundary();

		/*
		 * tests if hit from the right. If 1.) the other object is to the right of me,
		 * and if 2.) my rightmost boundary is to the right of the other object's
		 * leftmost boundary, and 3.) I am hitting the other object at the right height,
		 * I have collided with it.
		 */
		if ((getXDistanceFrom(b) < 0) // 1.
				&& (myRight >= hisLeft) // 2.
				&& (myYcoord >= hisBottom && myYcoord <= hisTop) // 3.
		) {
			collideWith(b, "fromRight");
		}

		/*
		 * tests if hit from the left. If 1.) the other object is to the left of me, and
		 * 2.) my leftmost boundary is to the left of the other object's rightmost
		 * boundary, and 3.) I am hitting the other object at the right height, I have
		 * collided with it.
		 */
		if ((getXDistanceFrom(b) > 0) // 1.
				&& (myLeft <= hisRight) // 2.
				&& (myYcoord >= hisBottom && myYcoord <= hisTop) // 3.
		) {
			collideWith(b, "fromLeft");
		}

		/*
		 * tests if hit from the top. If 1.) the other object is above me, and 2.) my
		 * topmost boundary is above the other object's bottom most boundary, and 3.) I
		 * am hitting the other object at the right x position, I have collided with it.
		 */
		if ((getYDistanceFrom(b) < 0) // 1. if the other object is above me
				&& (myTop >= hisBottom) // 2.
				&& (myXcoord <= hisRight && myXcoord >= hisLeft) // 3.
		) {
			collideWith(b, "fromTop");
		}

		/*
		 * tests if hit from the bottom. If 1.) the other object is below me, and 2.) my
		 * bottom most boundary is below the other object's topmost boundary, and 3.) I
		 * am hitting the other object at the right x position, I have collided with it.
		 */
		if ((getYDistanceFrom(b) > 0) // 1.
				&& (myBottom <= hisTop) // 2.
				&& (myXcoord <= hisRight && myXcoord >= hisLeft) // 3.
		) {
			collideWith(b, "fromBottom");
		}
	}

	/**
	 * Checks if the BoardObject has hit the edge of the screen. If so, it will do
	 * the necessary activity based upon the direction that the object hit the edge
	 * from.
	 */
	public void doEdgeCollision() {
		if (getRightBoundary() >= Driver.X) {
			hitEdge("fromRight");
		}
		if (getLeftBoundary() <= 0) {
			hitEdge("fromLeft");
		}
		if (getTopBoundary() >= Driver.Y) {
			hitEdge("fromTop");
		}
		if (getBottomBoundary() <= 0) {
			hitEdge("fromBottom");
		}
	}

	/**
	 * this method is the activity that is done when this boardObject hits another,
	 * and is different for every boardObject. For example, when a projectile hits
	 * another projectile, they both disappear, but if a projectile hits a wall, the
	 * projectile bounces off it and the wall does nothing.
	 * 
	 * @param b
	 *            the other Board object that this BoardObject is colliding with.
	 * @param direction
	 *            direction from which this BoardObject is being hit from.
	 */
	public abstract void collideWith(BoardObject b, String direction);

	/**
	 * this method is the activity that is done when a boardObject hits the edge of
	 * the Screen.
	 * 
	 * @param direction
	 *            from which the edge is hit.
	 */
	public abstract void hitEdge(String direction);

	public abstract void die(); // what happens when the boardObject dies. Usually, it just removes itself.

	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////// GETTERS/SETTERS//////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * this method myLevel for this boardObject to the given level. This method is
	 * used whenever a board object is added to a Level. Refer to addToLevel() in
	 * the Level class.
	 */
	public void setLevel(Level l) {
		myLevel = l;
	}

	/**
	 * returns the distance between this BoardObject and b. I this object is above b
	 * (has a greater Y coordinate) it will return a positive double. If the double
	 * is negative, this BoardObject is below b.
	 * 
	 * @param b
	 *            the other boardObject
	 * @return the Y distance between this BoardObject and b.
	 */
	public double getYDistanceFrom(BoardObject b) {
		double distance = getYcoord() - b.getYcoord();
		return distance;
	}

	/**
	 * returns the X distance between this BoardObject and b. if this object is to
	 * the right of b (has a greater X coordinate) the returned double will be
	 * positive. if it is negative, then this object is to the left of b.
	 * 
	 * @param b
	 *            the other boardObject
	 * @return the X distance between this BoardObject and b.
	 */
	public double getXDistanceFrom(BoardObject b) {
		double distance = getXcoord() - b.getXcoord();
		return distance;
	}

	/*
	 * the following 4 methods are used in calculating collisions.
	 */
	public abstract double getLeftBoundary(); // returns the leftmost point of the board object.

	public abstract double getRightBoundary(); // returns the rightmost point of the board object.

	public abstract double getTopBoundary(); // returns the topmost point of the board object.

	public abstract double getBottomBoundary(); // returns the bottommost point of the board object.

}
