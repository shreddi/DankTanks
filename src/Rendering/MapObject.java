package Rendering;

/**
 * a map object is anything that is processed by an enemy tank, and shows up on
 * its "map." This includes Tanks and Walls, but NOT projectiles.
 *
 */
public abstract class MapObject extends BoardObject {
	/**
	 * returns the 1-character code for this type of board object.
	 * 
	 * @return the 1-character code for this type of board object.
	 */
	public abstract char getChar();
}
