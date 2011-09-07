/**
 * 
 */
package game;

/**
 * @author Michi
 * Bildet ein einzelnes Feld eine Vier-Gewinnt-Spielfeldes ab
 */
public class Field {
	
	private final int column;
    private final int row;
    
    /**
     * Konstrukor fuer ein Feld
     * @param column Spalte (X-Wert)
     * @param row Reihe (Y-Wert)
     */
	public Field(int column, int row) {
		this.column = column;
		this.row = row;
	}


	public int getColumn() {
		return column;
	}


	public int getRow() {
		return row;
	}
	
	
    
    

}
