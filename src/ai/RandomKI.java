/**
 * 
 */
package ai;

import java.util.ArrayList;

import game.Board;
import game.Field;
import game.Player;

/**
 * @author apfelbaum24 Eine einfache KI, die einen (legalen) Zufallszug
 *         ermittelt
 */
public class RandomKI implements IComputerPlayer {

	/*
	 * (non-Javadoc)
	 * 
	 * @see ai.IComputerPlayer#calcField(game.Player, game.Board)
	 */
	@Override
	public Field calcField(Player currentPlayer, Board currentBoard) {
		ArrayList<Field> legalMoves = currentBoard.getLegalMoves();

		int highest = legalMoves.size() - 1;
		// Zufaelligganzzahl erzeugen
	    int randomColumn = (int) Math.round(Math.random() * highest)+1;
	    
	    //korrespondiertendes Feld ermitteln
	    Field targetField = currentBoard.findFirstEmtpyFieldInColumn(randomColumn);

		return targetField;
	}

}
