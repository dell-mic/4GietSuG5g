
package io;
import general.Debug;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;

/**
 * @author Michi
 * Klasse zum schreiben der Kommunikationsdateien fuer den Server
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
	 * Schreibt eine Nachricht in die Datei für den Server
	 * @param message
	 */
	private void write(String message) {   
		BufferedWriter bw = null;
	    try { 
	        bw = new BufferedWriter(new java.io.FileWriter(file.getAbsolutePath())); 
	    	bw.write(message);
	    	bw.flush();
	    } 
	    catch (IOException ioe) { 
	    	Debug.error("Fehler beim Schreiben der Datei: " + ioe.getMessage());
	    } 
	    finally {
	    	if (bw != null) {
				try {
					bw.close();
				} catch (IOException e) {
					Debug.error("Fehler beim Schreiben der Datei: " + e.getMessage());
				}
			}
	    }
	}
	
	/**
	 * Setzt den Pfad für die zu schreibende Datei neu
	 * @param path
	 */
	public void setPath(String path) {
		file = new File(path);
	}
	
	/**
	 * Wrappermethode, um eine Ganzzahl in die Datei zu schreiben
	 * @param move Die Spalte, in die gesetzt werden soll
	 */
	public void write(int move) {
		write(String.valueOf(move));
	}
}
