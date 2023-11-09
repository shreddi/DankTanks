package Rendering;

//keeps track of the objects on the map
public class Map {
	private char[][] grid;
	private final int HEIGHT = Driver.GRIDY;
	private final int WIDTH = Driver.GRIDX;

	public Map() {
		grid = new char[HEIGHT][WIDTH];
	}

	// add a new object to the grid
	public void addToGrid(MapObject m) {
		int x = ((int) m.getXcoord());
		int y = ((int) m.getYcoord());
		y /= Driver.GRIDYCONSTANT;
		x /= Driver.GRIDXCONSTANT;
		grid[HEIGHT - y - 1][x] = m.getChar();
	}

	// remove all objects from the map
	public void clearMap() {
		for (int i = 0; i < HEIGHT; i++) {
			for (int j = 0; j < WIDTH; j++) {
				grid[i][j] = ' ';
			}
		}
	}

	// used to print the map for testing purposes
	public void printMap() {
		System.out.print("   ");
		for (int h = 0; h < WIDTH; h++) {
			System.out.print(h % 10 + " ");
		}
		System.out.println();
		for (int i = 0; i < HEIGHT; i++) {
			System.out.print(i % 10 + "| ");
			for (int j = 0; j < WIDTH; j++) {
				System.out.print(grid[i][j] + " ");
			}
			System.out.println();
		}
	}

	// getters and setter methods
	public char get(int row, int col) {
		return grid[row][col];
	}

	public void set(int row, int col, char c) {
		grid[row][col] = c;
	}

	// makes a copy of the map and returns it
	public Map getCopy() {
		Map end = new Map();
		end.copyTo(this);
		return end;
	}

	// copies one map to another
	public void copyTo(Map m) {
		clearMap();
		for (int i = 0; i < m.HEIGHT; i++) {
			for (int j = 0; j < m.WIDTH; j++) {
				set(i, j, m.get(i, j));
			}
		}
	}
}
