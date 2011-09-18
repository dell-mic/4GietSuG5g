package Datenbank;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;

public class DbPlay {

	private Connection dbConnection;
	
	private final String PATH = System.getProperty("user.dir") + "\\get4db";
	

	
	/**
	 * Konstruktor
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	
	public DbPlay() throws ClassNotFoundException, SQLException {
		
		
		// Datenbankverbindung initiieren
		Class.forName("org.hsqldb.jdbcDriver");
		dbConnection = DriverManager.getConnection("jdbc:hsqldb:file:" + PATH, "sa", "");
		
		// Prüfen, ob DB schon existiert
		// falls die Datenbank leer ist, Tabellen erstellen
		if (isEmptyDB())
			initDB();
		
	}
	
	
	
	/**
	 * Datenbank prüfen - wenn DB leer werden keine Tabellen gefunden
	 * @return
	 * @throws SQLException
	 */
	private synchronized boolean isEmptyDB() throws SQLException {
		DatabaseMetaData databaseMetaData = dbConnection.getMetaData();
		ResultSet rs = databaseMetaData.getTables(null, null, null,	new String[] { "TABLE" });

		// falls es einen Datensatz gibt, wurde mindestens eine Tabelle gefunden
		if (rs.next())
			return false;

		// kein Datensatz vorhanden, demnach ist auch keine Tabelle vorhanden
		System.out.println("keine Tabellen vorhanden");
		return true;
	}
	
	/**
	 * Falls DB leer werde hier die Tabellen erzeugt und Daten eingefügt
	 */
	private synchronized void initDB() {
		
			// hier Tabellen erzeugen!
	
		}

	}
	
