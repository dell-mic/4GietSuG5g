package Datenbank;

import java.sql.Connection; // Datenbankverbindung
import java.sql.Statement; // ermöglicht SQL Abfragen
import java.sql.DatabaseMetaData;
import java.sql.DriverManager; //Einstiegspunkt
import java.sql.SQLException;
import java.sql.ResultSet; //Ergebnisverwaltung

public class DbPlay {

	private Connection dbConnection;
	private Statement dbStatement;	
	private final String PATH = System.getProperty("user.dir") + "\\get4db";
	private String driverClass = "org.hsqldb.jdbcDriver";

	
	/**
	 * Konstruktor
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	
	public DbPlay() throws ClassNotFoundException, SQLException {
		
		
		// Datenbankverbindung initiieren
		try{
		Class.forName(driverClass);
		}
		catch(ClassNotFoundException exc) {
			System.out.println(exc.getMessage());
			System.exit(1);
		}
		
		
		dbConnection = DriverManager.getConnection("jdbc:hsqldb:file:" + PATH, "sa", "");  //Verbindungsaufbau
		
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
		return true;
	}
	
	/**
	 * Falls DB leer - werde hier die Tabellen erzeugt
	 */
	private synchronized void initDB() {
	
		try{
		// Tabelle für die Spiele
		statement("CREATE TABLE Game ("
				+ " GameID INT NOT NULL,"
				+ " Beginn TIMESTAMP,"
				+ " End TIMESTAMP,"
				+ " CONSTRAINT pk_Game PRIMARY KEY (GameID),"
				+ ");"
		);
		
		// Tabelle für die Spieler
		statement("CREATE TABLE Player ("
				+ " PlayerID INT NOT NULL,"
				+ " Name VARCHAR(255),"
				+ " CONSTRAINT pk_Player PRIMARY KEY (PlayerID),"
				+ ");"
		);

		// Tabelle für den Zug
		statement("CREATE TABLE Move ("
				+ " MoveID INT NOT NULL,"
				+ " GameID INT NOT NULL,"
				+ " RoundID INT NOT NULL,"
				+ " PlayerID INT NOT NULL,"
				+ " PositionX INT,"
				+ " PositionY INT,"
				+ " CONSTRAINT pk_Move PRIMARY KEY (MoveID, PlayerID, RoundID),"
				+ " CONSTRAINT fk_Move_Player FOREIGN KEY (PlayerID) PREFERENCES Player (PlayerID),"
				+ " CONSTRAINT fk_Move_Round FOREIGN KEY (RoundID) PREFERENCES Round (RoundID, GameID),"
				+ ");"
		);

		// Tabelle für den Satz
		statement("CREATE TABLE Round ("
				+ " GameID INT NOT NULL,"
				+ " RoundID INT NOT NULL,"
				+ " Beginn TIMESTAMP,"
				+ " End TIMESTAMP,"
				+ " CONSTRAINT pk_Round PRIMARY KEY (GameID, RoundID),"
				+ " CONSTRAINT fk_Round_Game FOREIGN KEY (GameID) PREFERENCES Game (GameID),"
				+ ");"
		);
		
		// Tabelle für Spieler spielt Spiel
		statement("CREATE TABLE PlayerPlaysGame ("
				+ " GameID INT NOT NULL,"
				+ " PlayerID INT NOT NULL,"
				+ " Win INT,"
				+ " Sign VARCHAR(255),"
				+ " CONSTRAINT pk_PPG PRIMARY KEY (PlayerID, GameID),"
				+ " CONSTRAINT fk_PPG_Game FOREIGN KEY (GameID) PREFERENCES Game (GameID),"
				+ ");"
		);
		
		// Tabelle für Spieler spielt Satz
		statement("CREATE TABLE PlayerPlaysRound ("
				+ " GameID INT NOT NULL,"
				+ " RoundID INT NOT NULL,"
				+ " PlayerID INT NOT NULL,"
				+ " Win INT,"
				+ " Starts INT,"
				+ " CONSTRAINT pk_PPR PRIMARY KEY (PlayerID, GameID, RoundID),"
				+ " CONSTRAINT fk_PPR_Game FOREIGN KEY (GameID) PREFERENCES Game (GameID),"
				+ " CONSTRAINT fk_PPR_Player FOREIGN KEY (PlayerID) PREFERENCES Player (PlayerID),"
				+ ");"
		);
		
		
		
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		}
	
	/**
	 * Führt ein beliebiges Update Statement auf der Datenbank aus
	 * @param SQL Anweisung
	 * @throws SQLException
	 */
	public synchronized void statement(String expression) throws SQLException {
		int i = dbStatement.executeUpdate(expression);

		if (i == -1) {
			throw new SQLException("Database error for this statement: " + expression);
		}
	}

	}
	
