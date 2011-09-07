/**
 * 
 */
package ai;

import java.util.ArrayList;

import game.Board;
import game.Field;
import game.Player;
import general.Debug;

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
	    int randomField = (int) Math.round(Math.random() * highest);
	    Debug.log(35, "Random-KI: Generierte Zufallszahl: " + randomField);
	    
	    //korrespondiertendes Feld ermitteln
	    Field targetField = legalMoves.get(randomField);
	    
	    Debug.log(20, "Durch KI berechneter eigener Zug: (" + targetField.getColumn() + "/" + targetField.getRow() + ")");

		return targetField;
	}

}
