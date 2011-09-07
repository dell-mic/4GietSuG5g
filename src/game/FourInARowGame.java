/**
 * 
 */
package game;

import general.Debug;
import io.FileMonitor;
import io.ServerResponse;

import java.io.File;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

/**
 * @author Michi
 * Bildet ein Vier-Gewinnt-Spiel mit mehreren Saetzen ab
 */
public class FourInARowGame implements Observer {
	private ArrayList<Set> sets;
	int setIndex = -1;
	int setCount;
	String enemy;
	String commDirString;
	File commDir;
	FileMonitor commDirMonitor;
	
	public FourInARowGame(int setCount, String commDirString) {
		sets = new ArrayList<Set>();
		this.setCount = setCount;
		this.commDir = new File(commDirString);
		this.commDirMonitor = new FileMonitor( new File(commDir + "\\test.txt"));
		
		//Wir werden ueber Aenderungen informiert
		this.commDirMonitor.addObserver(this);
		
		//Teste Kommunikationspfad
		if (commDir.canWrite()) Debug.log(2, "Kommunikationspfad erfolgreich eingerichtet.");
		else Debug.error("Angegebenes Kommunikationsverzeichnes konnte nicht eingerichtet werden!");
	}
	
	/**
	 * Beginnt einen neuen Satz
	 */
	public void startNewSet() {
		sets.add(new Set());
		setIndex++;
		commDirMonitor.startMonitoring();
	}

	/**
	 * Wird vom FileMonitor aufgerufen, sobald eine neue Datei des Servers gefunden und ausgewertet werden konnte
	 * @param arg0 Das Objekt, welches das Update ausgeloest hat
	 * @param arg1 Die Serverantwort, die aus der gefunden XML-Datei gelesen wurde
	 */
	@Override
	public void update(Observable arg0, Object arg1) {
		if (arg1 != null && arg1 instanceof ServerResponse) { 
			//Falls es sich um eine korrekte Serverantwort handelt in eigene Variable casten
			ServerResponse serverResponse = (ServerResponse) arg1;
			//TODO Antwort auswerten und reagieren
		}
		
	}
}
