package general;

import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * @author Michi
 * Klasse zur Ausgabe von Debug-Informationen auf der Konsole
 */
public class Debug {
	
	private static boolean debug = true;
	
	/**
	 * Setzt das Debug-Level, bis zu welchem die Meldungen ausgegeben werden sollen
	 * 10: Hauptmeldungen, z.B: "Spiel gestartet"
	 * 20: Ereignisse, z.B: Button geklickt
	 * 30: Interne Debug-Informationen, z.B: Variable X hat Werte Y
	 */
	private static int level = 99;
	
	
	 /**
     * Gibt Debugging-Informationen auf der Standardkonsole aus. Je nach gesetzem Debug-Level werden unterschiedlich viele Meldungen ausgegeben.
     * @param level Der Debug-Level
     * @param message Nachricht, die angezeigt werden soll
     */
	public static void log(int level, String message) {
        if (debug && level <= Debug.level)
                System.out.println(getTimeStamp() + " " + message);
	}
	
	/**
     * Gibt eine Fehlermeldung auf der konsole aus
     * @param message
     */
    public static void error(String message) {
            System.err.println(getTimeStamp() + " " + message);
    }
	
    /**
     * Gibt das das aktuellen Datum als formatierten String zurueck
     * @return Der Zeitstempel
     */
    public static String getTimeStamp() {
            return new SimpleDateFormat("dd.MM.yyyy HH:mm:ss").format(new Date());
    }

	public static void setDebug(boolean debug) {
		Debug.debug = debug;
	}
	
	
	public static void setLevel(int level) {
		Debug.level = level;
	}
    
    
	
	
}
