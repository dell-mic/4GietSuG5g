/**
 * 
 */
package game;

/**
 * @author Michi
 * Bildet einen Spielzug eines Spielers ab
 */
public class Move {

	private Player player;
	private Field field;

	/**
	 * Konstrukur
	 * @param player Der Spieler der den Zug macht
	 * @param field Das Feld in das gesetzt werden soll. (Erwartet das konkrete Feld -  nicht die Spalte)
	 */
	public Move(Player player, Field field) {
		this.player = player;
		this.field = field;
	}

	public int getColumn() {
		return field.getColumn();
	}

	public int getRow() {
		return field.getRow();
	}

	public Player getPlayer() {
		return player;
	}

}
