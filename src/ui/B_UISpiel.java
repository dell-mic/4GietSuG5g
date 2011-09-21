package ui;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;

public class B_UISpiel {

	private static final int CENTER = 0;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
				// Einen Top-Level-Container erzeugen
				JFrame frmMain = new JFrame();
				frmMain.setTitle("Prototype A - Spielfeld");
				frmMain.setSize(1024, 768);
				frmMain.setLocationRelativeTo(null);										// Default Location wird mit null auf Center - x&y - gesetzt
				frmMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);						// Beim schließen des Fensters auch das Programm beenden
				frmMain.setLayout(null);													// mit NULL besteht die Option der absolution Positionierung
				
				
				
					// Label für die Überschrift
					JLabel lbHead = new JLabel("4InALine");
					lbHead.setSize(350, 50);
					lbHead.setLocation(337, 0);
					lbHead.setHorizontalAlignment(CENTER);
					lbHead.setFont(new Font("Serif", Font.BOLD, 26));
					frmMain.add(lbHead);
					
					
					// Panel für die Optionsauswahl
					JPanel pnlOption = new JPanel();
					pnlOption.setSize(280, 80);
					pnlOption.setLocation(372, 70);
					TitledBorder titleOption = new TitledBorder(BorderFactory.createTitledBorder("Spieloption"));					// Titel zur Border hinzufügen und formatieren
					pnlOption.setBorder(titleOption);																				// ""
					frmMain.add(pnlOption);
					
						// Komponenten des Panels - Optionsfelder
						// DropDown für Spielerauswahl
						String[] arStrings = { "Spieler X", "Spieler Y" };
						JComboBox cbPlayer = new JComboBox(arStrings);
						pnlOption.add(cbPlayer);
						
						//Button zum starten des Satzes
						JButton btnStart = new JButton("Satz starten");
						pnlOption.add(btnStart);
						
						
						
					// Panel für den Spielstand
					JPanel pnlSpielstand = new JPanel();
					pnlSpielstand.setSize(280, 80);
					pnlSpielstand.setLocation(372, 150);
					TitledBorder titleSpielstand = new TitledBorder(BorderFactory.createTitledBorder("Spielstand"));						// Titel zur Border hinzufügen und formatieren
					pnlSpielstand.setBorder(titleSpielstand);																				// ""
					frmMain.add(pnlSpielstand);
					
						// Komponenten des Panels
						// DropDown für Spielerauswahl
						JLabel lbSpielstand = new JLabel("0:0");
						lbSpielstand.setSize(50, 50);
						lbSpielstand.setFont(new Font("Serif", Font.BOLD, 26));
						lbSpielstand.setHorizontalAlignment(CENTER);
						pnlSpielstand.add(lbSpielstand);
					
					
						
					// Panel für das Spielfeld
					JPanel pnlSpiel = new JPanel();
					pnlSpiel.setSize(280, 240);
					pnlSpiel.setLocation(372, 240);
					pnlSpiel.setLayout(null);
					TitledBorder titleSpiel = new TitledBorder(BorderFactory.createTitledBorder("Spielfeld"));								// Titel zur Border hinzufügen und formatieren
					pnlSpiel.setBorder(titleSpiel);																							// ""
					frmMain.add(pnlSpiel);
					
						// Komponenten des Panels - Spielsteine
						// Lediglich eine Graphik zur Veranschaulichung
						JLabel picLabel = new JLabel(new ImageIcon("../4GietSuG5g/src/ui/images/gewinntSmall.jpg"));
						picLabel.setBounds(10, 15, 260, 220);
						picLabel.setSize(260, 220);
						pnlSpiel.add(picLabel);
					
					
					
					// Panel für das Log
					JPanel pnlLog = new JPanel();
					pnlLog.setSize(320, 410);
					pnlLog.setLocation(20, 70);
					TitledBorder titleLog = new TitledBorder(BorderFactory.createTitledBorder("Log"));									// Titel zur Border hinzufügen und formatieren
					pnlLog.setBorder(titleLog);																							// ""
					frmMain.add(pnlLog);
					
						// Komponenten des Panels
						// Editor Pane in Scroll Pane zur Darstellung des Logs
						JEditorPane epaLog = new JEditorPane();
						epaLog.setEditable(true);																						// Editor Pane ist nicht editierbar
						epaLog.setSize(290, 390);
						JScrollPane scpaLog = new JScrollPane(epaLog);																	// Scroll Pane für das Log
						scpaLog.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);										// Anzeigen der ScrollBar
						scpaLog.setPreferredSize(new Dimension(310,370));
						scpaLog.setMinimumSize(new Dimension(310, 370));
						pnlLog.add(scpaLog);
					
					
						
					// Grafik für die Optik
					JLabel picLabel2 = new JLabel(new ImageIcon("../4GietSuG5g/src/ui/images/pic.jpg"));
					picLabel2.setLocation(680, 80);
					picLabel2.setSize(280, 490);
					frmMain.add(picLabel2);	
						
								
					// Button für das Hauptmenue
					JButton btnBack = new JButton("Zum Hauptmenue");
					btnBack.setSize (280, 50);
					btnBack.setLocation(372, 520);
					frmMain.add(btnBack);
					
					// Button für den Reset
					JButton btnReset = new JButton("Reset Log");
					btnReset.setSize (310, 50);
					btnReset.setLocation(25, 520);
					frmMain.add(btnReset);
						
						
						
						
						
				// Sicherstellung der Darstellung
				frmMain.invalidate();
				frmMain.setVisible(true);
				frmMain.repaint();

	}

}
