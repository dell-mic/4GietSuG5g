/**
 * 
 */
package game;

import general.Config;

/**
 * @author Michi
 * Bildet genau einen Satz eines Vier-Gewinnt-Spiels ab
 */
public class Set {
	private Player startingPlayer;
	private Player winningPlayer;
	private Player currentPlayer;
	private Player ourPlayer;
	private Player enemyPlayer;
	private Board board;
	
	public Set() {
		board = new Board(Config.COLS, Config.ROWS);
	}
	
	public Player getStartingPlayer() {
		return startingPlayer;
	}
	
	public void setStartingPlayer(Player startingPlayer) {
		this.startingPlayer = startingPlayer;
	}

	public Player getWinningPlayer() {
		return winningPlayer;
	}
	
	public Player getCurrentPlayer() {
		return currentPlayer;
	}
	
	public Board getBoard() {
		return board;
	}

	public Player getOurPlayer() {
		return ourPlayer;
	}

	public void setOurPlayer(Player ourPlayer) {
		this.ourPlayer = ourPlayer;
	}

	public Player getEnemyPlayer() {
		return enemyPlayer;
	}

	public void setEnemyPlayer(Player enemyPlayer) {
		this.enemyPlayer = enemyPlayer;
	}
	
	
	
}
