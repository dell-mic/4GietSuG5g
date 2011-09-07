/**
 * 
 */
package ai;

import game.*;

/**
 * @author Michi
 * Interface fuer eine kuenstliche Intelligenz, die einen Zug fuer Vier-Gewinnt berechnet
 */
public interface IComputerPlayer {
	
	/**
	 * Berechnet einen Zug moeglichen Zug fuer den angegebenen Spieler
	 * @param currentPlayer Der Spieler, aus dessen Sicht der Zug ermittelt werden soll
	 * @param currentBoard Das momentane Spielfeld
	 * @return Das Feld, in welches nach Ansicht der kuenstlichen Intelligenz gesetzt werden sollte
	 */
	public abstract Field calcField(Player currentPlayer, Board currentBoard); 

}
