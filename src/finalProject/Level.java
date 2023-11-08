package finalProject;

/**
 * Levels contain an array of steppedStuff. When a level is displayed, it
 * displays and steps all of the steppedStuff in this array. Level is different
 * from a Screen because Level steps all of its contents. Level basically has 2
 * arrays: 1 array in the class, steppedStuff, which are all of the things which
 * Level steps (processes), and 1 array that is accessed from Screen,
 * displayedStuff, which is all of the stuff that the level displays.
 */
public abstract class Level extends Screen {
	private BoardObject[] steppedStuff; // array of BoardObjects that are
	// stepped.
	protected Map map;
	protected int size;

	/**
	 * Constructor.
	 */
	public Level() {
		super();
		steppedStuff = new BoardObject[MAXOBJECTS];
		size = 0;
		map = new Map();
	}

	/**
	 * The display method for Level not only displays all of the stuff in the super
	 * class Screen's array of Displayables, but it also steps all of the board
	 * objects in the local array steppedStuff.
	 */
	public void display() {
		super.display();
		stepAll();
	}

	/**
	 * this method goes through all of the steppedStuff in the local array
	 * steppedStuff, and if they are not null, steps them, and checks if they have
	 * collided with any of the other BoardObjects in this level, and checks if they
	 * have hit an edge of the screen. The collision check must be done in Level
	 * because all of the BoardObjects in this level must know where the others are
	 * to know if they have collided with one another. The checking of the edge
	 * Collision can technically be in the step() method of booardObject, but it is
	 * Easier to do it here, because all board objects do this.
	 */
	private void stepAll() {
		map.clearMap();
		setMap();
		for (int i = 0; i < size; i++) {
			BoardObject b = steppedStuff[i];
			if (b != null) { // if b exists and has not been "removed" from the level
				b.step();
				b.doEdgeCollision();
				for (int j = 0; j < size; j++) { // Board object b finds out if it has hit any other
													// BoardObject in the level besides itself, and does the
													// appropriate activity if it has. This is all done in
													// doCollision.
					BoardObject otherObject = steppedStuff[j];
					if (otherObject != null) { // if the other object hasn't been removed from the Level.
						if (b != otherObject) // makes sure that the object
												// isn't testing if it is
												// collided with itself.
							b.doCollision(otherObject);
					}
				}
			}
		}
	}

	public void setMap() {
		for (BoardObject b : steppedStuff) {
			if (b instanceof MapObject)
				map.addToGrid((MapObject) b);
		}
	}

	/**
	 * This method adds the given boardObject to both arrays: displayedStuff and
	 * steppedStuff. Also, it assigns this level to the board object.
	 */
	public void addToLevel(BoardObject b) {
		super.addToScreen(b); // adds to displayedStuff.
		steppedStuff[size] = b; // adds to steppedStuff.
		size++;
		b.setLevel(this); // this line is saying that BoardObject b's level is
							// me.
	}

	/**
	 * removes the given BoardObject b from the level by setting it in the array
	 * steppedStuff to null, then it does the same thing for the array
	 * displayedStuff in the superclass Screen by using removeFromScreen() in
	 * Screen. By setting the object to null in steppedStuff, the level stops
	 * stepping it, and by setting it to null in displayedStuff in Screen, the
	 * screen stops displaying it.
	 */
	public void removeFromLevel(BoardObject b) {
		if (b != null) { // if the object actually exists;
			int index = -1;
			for (int i = 0; i < size; i++) {
				if (steppedStuff[i] == b) {
					index = i;
					break;
				}
			}
			if (index != -1) { // if b is in the array, AKA, in this level
				steppedStuff[index] = null; // instead of removing b from the array, it sets it to null
				removeFromScreen(b); // inherited from Screen
			}
		}
	}

	public Map getMap() {
		return map;
	}

	public boolean isWon() {
		for (int i = 0; i < steppedStuff.length; i++) {
			if (steppedStuff[i] instanceof EnemyTank) {
				return false;
			}
		}
		return true;
	}
}
