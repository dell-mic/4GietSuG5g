package ui;

import java.awt.*;
import java.util.Date;
import javax.swing.*;

public class A_UIHistorie {

	// Constraint f�r die Formatierung der �berschrift
		private static final int CENTER = 0;
		
		
		/**
		 * @param args
		 */
		public static void main(String[] args) {
			
			// Einen Top-Level-Container erzeugen
			JFrame frmMain = new JFrame();
			frmMain.setTitle("Prototype A - Hauptmenue");
			frmMain.setSize(1024, 768);
			frmMain.setLocationRelativeTo(null);										// Default Location wird mit null auf Center - x&y - gesetzt
			frmMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);						// Beim schlie�en des Fensters auch das Programm beenden
			frmMain.setLayout(new BorderLayout());
			
			
			
			
			// Array f�r die Spaltennamen
			String[] columnNames = {"Nummer", "Spielstart", "Spielende", "Dauer in min.", "Sieger"};
			
			// Daten die angezeigt werden sollen
			// Hier handelt es sich um Testdaten -> DB anzapfen
			Object[][] data = {
				    {new Integer(1), new Date(), new Date(), new Integer(10), "blau"},
				    {new Integer(2), new Date(), new Date(), new Integer(20), "gelb"}
				    };
			
			
			// Tabelle bauen
			JTable tblArchive = new JTable(data, columnNames);
			
			
			// Label f�r die �berschrift
			JLabel lb1 = new JLabel("Dies ist das Archiv");
			lb1.setSize(50, 50);
			lb1.setFont(new Font("Serif", Font.BOLD, 26));
			lb1.setHorizontalAlignment(CENTER);
			frmMain.add(lb1, BorderLayout.NORTH);
			
			
			
			// Scroll Pane  f�r die Tabelle im Center
			JScrollPane scrollPane = new JScrollPane(tblArchive);
			frmMain.add(scrollPane, BorderLayout.CENTER);
			
			
			
			// Zur�ck Button
			JButton btnBack = new JButton("Zur�ck");
			btnBack.setSize (350, 50);
			frmMain.add(btnBack, BorderLayout.SOUTH);

			
			
			
			// Sicherstellung der Darstellung
			frmMain.invalidate();
			frmMain.setVisible(true);
			frmMain.repaint();

		}

	}
