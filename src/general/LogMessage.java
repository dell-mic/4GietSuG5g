/**
 * 
 */
package general;

import java.util.Date;

/**
 * @author Michi
 * Stellt einen Logeintrag dar
 *
 */
public class LogMessage {
	private int logLevel;
	private String message;
	private Date timeStamp;
	
	/**
	 * Konstruktor
	 * @param logLevel Der Loglevel (siehe Klasse Debug)
	 * @param message Die Meldung
	 */
	public LogMessage(int logLevel, String message) {
		this.logLevel = logLevel;
		this.message = message;
		this.timeStamp = new Date();
	}

	public int getLogLevel() {
		return logLevel;
	}

	public String getMessage() {
		return message;
	}

	public Date getTimeStamp() {
		return timeStamp;
	}
	
	
	
	
	
}
