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
		isEmptyDB();
		
	}
	
	
	
	/**
	 * Datenbank prüfen - wenn DB leer werden keine Tabellen gefunden
	 * @throws SQLException
	 */
	private synchronized void isEmptyDB() throws SQLException {
		DatabaseMetaData databaseMetaData = dbConnection.getMetaData();
		ResultSet rs = databaseMetaData.getTables(null, null, null,	new String[] { "TABLE" });
		
		// falls es einen Datensatz gibt, wurde mindestens eine Tabelle gefunden
		if (rs.next())
			insertDB(); // Absprung in Einfügen der Daten

		// kein Datensatz vorhanden, demnach ist auch keine Tabelle vorhanden
		else
			initDB(); // Absprung erzeugen der Tabellen
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
				+ " SetID INT NOT NULL,"
				+ " PlayerID INT NOT NULL,"
				+ " Column INT,"
				+ " Row INT,"
				+ " CONSTRAINT pk_Move PRIMARY KEY (MoveID, PlayerID, SetID),"
				+ " CONSTRAINT fk_Move_Player FOREIGN KEY (PlayerID) REFERENCES Player (PlayerID),"
				+ " CONSTRAINT fk_Move_Set FOREIGN KEY (SetID)  REFERENCES Set (SetID, GameID),"
				+ ");"
		);

		// Tabelle für den Satz
		statement("CREATE TABLE Set ("
				+ " GameID INT NOT NULL,"
				+ " SetID INT NOT NULL,"
				+ " Beginn TIMESTAMP,"
				+ " End TIMESTAMP,"
				+ " CONSTRAINT pk_Set PRIMARY KEY (GameID, SetID),"
				+ " CONSTRAINT fk_Set_Game FOREIGN KEY (GameID) REFERENCES Game (GameID),"
				+ ");"
		);
		
		// Tabelle für Spieler spielt Spiel
		statement("CREATE TABLE PlayerPlaysGame ("
				+ " GameID INT NOT NULL,"
				+ " PlayerID INT NOT NULL,"
				+ " Win INT,"
				+ " Sign VARCHAR(255),"
				+ " CONSTRAINT pk_PPG PRIMARY KEY (PlayerID, GameID),"
				+ " CONSTRAINT fk_PPG_Game FOREIGN KEY (GameID) REFERENCES Game (GameID),"
				+ ");"
		);
		
		// Tabelle für Spieler spielt Satz
		statement("CREATE TABLE PlayerPlaysSet ("
				+ " GameID INT NOT NULL,"
				+ " SetID INT NOT NULL,"
				+ " PlayerID INT NOT NULL,"
				+ " Win INT,"
				+ " Starts INT,"
				+ " CONSTRAINT pk_PPR PRIMARY KEY (PlayerID, GameID, SetID),"
				+ " CONSTRAINT fk_PPR_Game FOREIGN KEY (GameID) REFERENCES Game (GameID),"
				+ " CONSTRAINT fk_PPR_Player FOREIGN KEY (PlayerID) REFERENCES Player (PlayerID),"
				+ ");"
		);
		
		insertDB();
		
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		}
	
	/**
	 * Datensaätzen in die Tabelle speichern (Spiel, Spieler, Sätze, Spielzüge)
	 * @param SQL Anweisung
	 * @throws SQLException
	 */
	
	private synchronized void insertDB()
	{
		//E
		
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
	
