/**
 * 
 */
package general;

/**
 * Klasse zum zentralen Ablegen verschiedener Parameter
 */
public class Config {
	
	/**
	 * Die Zeit in Millisekunden, die zwischen zwei Versuchen eine Serverantwort zu lesen gewartet wird
	 */
	public static int TIMERINTERVALL = 300;

	/**
	 * Die Standardanzahl, mit wie vielen Reihen gespielt werden soll
	 */
	public static int ROWS = 6;
	
	/**
	 * Die Standardanzahl, mit wie vielen Spalten gespielt werden soll
	 */
	public static int COLS = 7;
	
	/**
	 * Anzahl Saetze, die waehrend eines Spiels standardmaessig gepsielt werden
	 */
	public static int SETCOUNT = 3;
}
