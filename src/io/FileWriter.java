
package io;
import general.Debug;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;

/**
 * @author Michi
 * Klasse zum Schreiben der Kommunikationsdateien fuer den Server
 */
public class FileWriter {
	private File file;
	
	/**
	 * Konstruktor.
	 * @param path Kommunikationspfad mit Server
	 */
	public FileWriter(String path) {
		this.file = new File(path);
	}
	
	/**
	 * Schreibt eine Nachricht in die Datei für den Server und meldet Erfolg
	 * @param message
	 * @return TRUE, falls Datei korrekt erstellt werden konnte, FALSE sonst
	 */
	private boolean write(String message) {   
		BufferedWriter bw = null;
		Boolean success = true;
	    try { 
	        bw = new BufferedWriter(new java.io.FileWriter(file.getAbsolutePath())); 
	    	bw.write(message);
	    	bw.flush();
	    	Debug.log(20, "File-Writer: Antwortdatei erfolgreich erstellt.");
	    } 
	    catch (IOException ioe) { 
	    	success = false;
	    	Debug.error("File-Writer: Fehler beim Schreiben der Datei: " + ioe.getMessage());
	    } 
	    finally {
	    	if (bw != null) {
				try {
					bw.close();
				} catch (IOException ioe) {
					success = false;
					Debug.error("File-Writer: Fehler beim Schreiben der Datei: " + ioe.getMessage());
				}
			}
	    }
	    return success;
	}
	
	/**
	 * Setzt den Pfad zu der zu schreibende Datei neu
	 * @param path Der Pfad zur Datei
	 */
	public void setPath(String path) {
		file = new File(path);
	}
	
	/**
	 * Wrappermethode, um eine Ganzzahl in die Datei zu schreiben
	 * @param move Die Spalte, in die gesetzt werden soll
	 * @return TRUE, falls Datei korrekt erstellt werden konnte, FALSE sonst
	 */
	public boolean writeMove(int move) {
		return write(String.valueOf(move));
	}
}
