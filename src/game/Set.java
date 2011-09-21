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
	private Player currentPlayer;
	private Player winnerPlayer;
	private Player ourPlayer;
	private Player enemyPlayer;
	private Board board;
	
	public Set(Player ourPlayer) {
		board = new Board(Config.COLS, Config.ROWS);
		this.setOurPlayer(ourPlayer);
	}
	
	
	/**
	 * Fuehrt einen Zug aus und aktualisiert den Gewinner
	 * @param move Der Zug, der auf dem Brett gemacht werden soll
	 */
	public void makeMove(Move move) {
		board.makeMove(move);
		winnerPlayer = board.findWinner();
	}
	
	/**
	 * Fuehrt einen Wurf aus und aktualisiert den Gewinner
	 * @param player Der werfende Spieler
	 * @param column Die Spalte, in die geworfen werden soll
	 */
	public void makeDrop(Player player, int column) {
		board.makeDrop(player, column);
		winnerPlayer = board.findWinner();
	}
	
	public Player getStartingPlayer() {
		return startingPlayer;
	}
	
	public void setStartingPlayer(Player startingPlayer) {
		this.startingPlayer = startingPlayer;
	}
	
	public Player getCurrentPlayer() {
		return currentPlayer;
	}
	
	public Player getWinnerPlayer() {
		return winnerPlayer;
	}

	public void setWinnerPlayer(Player winnerPlayer) {
		this.winnerPlayer = winnerPlayer;
	}

	public Board getBoard() {
		return board;
	}

	public Player getOurPlayer() {
		return ourPlayer;
	}

	/**
	 * Fixiert unseren Spieler und impliziet den der Gegnerpartei
	 * @param ourPlayer Die "Farbe", die unser Spieler bekommt
	 */
	public void setOurPlayer(Player ourPlayer) {
		this.ourPlayer = ourPlayer;
		this.enemyPlayer = (ourPlayer == Player.X) ? Player.O : Player.X;
	}

	public Player getEnemyPlayer() {
		return enemyPlayer;
	}

	/**
	 * Fixiert den gegnerischen Spieler und implizit unseren
	 * @param enemyPlayer Die "Farbe", die der Gegenspieler bekommt
	 */
	public void setEnemyPlayer(Player enemyPlayer) {
		this.enemyPlayer = enemyPlayer;
		this.ourPlayer = (enemyPlayer == Player.X) ? Player.O : Player.X;
	}
	
	
	
}
