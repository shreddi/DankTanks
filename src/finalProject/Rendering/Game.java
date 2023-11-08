package finalProject;

import java.util.ArrayList;

public class Game {
	private Screen titleScreen;
	private Screen campaignScreen;
	private Screen pvPScreen;
	private Screen campaignWinScreen;
	private Screen campaignLoseScreen;
	private Screen upgradeScreen;
	private Level multiplayer;
	private Level random;
	private Screen pvpEndOfGameScreen;
	private int step;
	private Tank playerOne;
	private Tank playerTwo;
	private PlayerTank campPlayer;
	private ArrayList<Level> levels;
	private int lvlNum;
	private Level lvlOne;
	private Screen campaignEndOfGameScreen;
	private int numRegLevels;

	public Game() {
		// players
		playerOne = new PlayerTank(400, 500, 0);
		playerTwo = new PlayerTankTwo(500, 400, 0);
		campPlayer = new PlayerTank(400, 500, 0);
		// screens
		pvPScreen = new PvPScreen();
		upgradeScreen = new UpgradeScreen(campPlayer);
		titleScreen = new TitleScreen();
		campaignScreen = new CampaignScreen();
		pvpEndOfGameScreen = new PvPEndOfGameScreen(playerOne, playerTwo);
		// variables keep track of step and level number
		step = 0;
		lvlNum = 0;
		// create new levels and add to array list
		multiplayer = new MultiplayerLevel(playerOne, playerTwo);
		levels = new ArrayList<Level>();
		lvlOne = new LevelOne(campPlayer);
		levels.add(lvlOne);
		// create screen
		campaignEndOfGameScreen = new CampaignEndOfGameScreen(lvlNum);
		// set number until generate new random levels
		numRegLevels = 2;
	}

	/*
	 * method that runs the game changes the step variable depending on what screen
	 * should be shown
	 */
	public void run() {
		// title screen
		if (step == 0) {
			resetGame();
			titleScreen.display();
			chooseTypeGame();
			// campaign pre-game screen
		} else if (step == 1) {
			campaignScreen.display();
			startPlayingCampaign();
			// pvp pre-game screen
		} else if (step == 2) {
			pvPScreen.display();
			startPlayingPvP();
			// play campaign
		} else if (step == 3) {
			playCampaignMode();
			checkIfPlayerLost();
			checkIfLevelWon();
			// play multiplayer
		} else if (step == 4) {
			multiplayer.display();
			checkIfPlayerOneDied();
			checkIfPlayerTwoDied();
			// campaign end of game screen
		} else if (step == 6) {
			campaignEndOfGameScreen = new CampaignEndOfGameScreen(lvlNum);
			campaignEndOfGameScreen.display();
			checkIfPlayAgain();
			// upgrade playerOne
		} else if (step == 7) {
			upgrade(playerOne);
			// upgrade playerTwo
		} else if (step == 8) {
			upgrade(playerTwo);
			// display the pvp end of game screen
		} else if (step == 9) {
			pvpEndOfGameScreen = new PvPEndOfGameScreen(playerOne, playerTwo);
			pvpEndOfGameScreen.display();
			checkIfPlayAgain();
		}
	}

	/*
	 * calls a method to decide if the level is won if so then adds a new random
	 * level to the list so player can continue playing
	 */
	public void checkIfLevelWon() {
		if (levels.get(lvlNum).isWon()) {
			lvlNum++;
			if (lvlNum == 1) {
				levels.add(new LevelTwo(campPlayer));
			} else if (lvlNum == 2) {
				levels.add(new SniperLevel(campPlayer));
			} else if (lvlNum == 3) {
				levels.add(new CannonTankLevel(campPlayer));
			} else {
				levels.add(new RandomLevel(lvlNum, campPlayer));
			}
			step = 7;
		}
	}

	/*
	 * upgrades the tank depending on what keys the press
	 */
	public void upgrade(Tank p) {
		upgradeScreen = new UpgradeScreen(campPlayer);
		upgradeScreen.display();
		if (StdDraw.isKeyPressed(49)) {
			campPlayer.setReloadTime(campPlayer.getReloadTime() - 3);
			step = 3;
		} else if (StdDraw.isKeyPressed(50)) {
			campPlayer.addToShotSpeed(5);
			step = 3;
		} else if (StdDraw.isKeyPressed(51)) {
			step = 3;
		}
	}

	/*
	 * updates all of the aspects of the game for the next game
	 */
	public void resetGame() {
		campPlayer = new PlayerTank(400, 500, 0);
		multiplayer = new MultiplayerLevel(playerOne, playerTwo);
		lvlNum = 0;
		levels = new ArrayList<Level>();
		lvlOne = new LevelOne(campPlayer);
		levels.add(lvlOne);
	}

	/*
	 * checks if the player wants to play again, if so then it resets the players
	 */
	public void checkIfPlayAgain() {
		if (StdDraw.isKeyPressed(32)) {
			playerOne.reset();
			playerTwo.reset();
			campPlayer.reset();
			step = 0;
		}
	}

	/*
	 * checks if player one died
	 */
	public void checkIfPlayerOneDied() {
		if (playerOne.getHealth() <= 0) {
			step = 9;
		}
	}

	/*
	 * checks if player two died
	 */
	public void checkIfPlayerTwoDied() {
		if (playerTwo.getHealth() <= 0) {
			step = 9;
		}
	}

	/*
	 * checks if the campaign player died and lost
	 */
	public void checkIfPlayerLost() {
		if (campPlayer.getHealth() <= 0) {
			step = 6;
		}
	}

	/*
	 * displays the multiplayer screen
	 */
	public void playPvPMode() {
		multiplayer.display();

	}

	/*
	 * start playing pvp mode
	 */
	public void startPlayingPvP() {
		if (StdDraw.isKeyPressed(32)) {
			step = 4;
		}
	}

	/*
	 * play the next level in campaign mode
	 */
	public void playCampaignMode() {
		levels.get(lvlNum).display();
	}

	/*
	 * start playing campaign mode if space bar pressed
	 */
	public void startPlayingCampaign() {
		if (StdDraw.isKeyPressed(32)) {
			step = 3;
		}
	}

	/*
	 * ask what mode to play
	 */
	public void chooseTypeGame() {
		if (StdDraw.isKeyPressed(49)) {
			step = 1;
		} else if (StdDraw.isKeyPressed(50)) {
			step = 2;
		} else {
			step = 0;
		}
	}
}
