/**
 * 
 */
package io;

/**
 * @author Michi
 * Bildet eine Antwort des Servers ab
 */
public class ServerResponse {
	private final Boolean freigabe;
    private final String satzstatus;
    private final int gegnerzug;
    private final String sieger;
    
    /**
     * Konstruktor
     * @param freigabe Freigabestatus fuer eigenen Zug
     * @param satzstatus Status des Satzes ("Satz spielen" | "beendet")
     * @param gegnerzug Der Zug des Gegners, sonst -1
     * @param sieger Sieger des Satzes, falls dieser feststeht
     */
	public ServerResponse(Boolean freigabe, String satzstatus, int gegnerzug,
			String sieger) {
		
		this.freigabe = freigabe;
		this.satzstatus = satzstatus;
		this.gegnerzug = gegnerzug;
		this.sieger = sieger;
	}

	public Boolean getFreigabe() {
		return freigabe;
	}

	public String getSatzstatus() {
		return satzstatus;
	}

	public int getGegnerzug() {
		return gegnerzug;
	}

	public String getSieger() {
		return sieger;
	}
	
	
    
    
}
