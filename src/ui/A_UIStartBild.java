package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseListener;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle;

public class A_UIStartBild {

	// Constant für die Formatierung der Überschrift
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
			frmMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);						// Beim schließen des Fensters auch das Programm beenden
			frmMain.setLayout(null);													// mit NULL besteht die Option der absolution Positionierung
			
			
			// Label für die Überschrift
			JLabel lbHead = new JLabel("4InALine");
			lbHead.setSize(350, 50);
			lbHead.setLocation(337, 0);
			lbHead.setHorizontalAlignment(CENTER);
			lbHead.setFont(new Font("Serif", Font.BOLD, 26));
			frmMain.add(lbHead);
			
			
			// Grafik für die Optik
			JLabel picLabel2 = new JLabel(new ImageIcon("4gewinnt_small.jpg"));
			picLabel2.setLocation(332, 50);
			picLabel2.setSize(360, 220);
			frmMain.add(picLabel2);	
			
			
			// Button für die Menueauswahl
			JButton btnNewGame = new JButton("Neues Spiel");
			btnNewGame.setSize(350, 50);
			btnNewGame.setLocation(337, 280);
			frmMain.add(btnNewGame);
			
			// Button für die Archivauswahl
			JButton btnArchive = new JButton ("Archiv");
			btnArchive.setSize(350,50);
			btnArchive.setLocation(337, 340);
			frmMain.add(btnArchive);
			
			// Button zum beenden der App
			JButton btnExit = new JButton ("Spiel Beenden");
			btnExit.setSize (350, 50);
			btnExit.setLocation(337, 400);
			frmMain.add(btnExit);
			
			
			

			// Sicherstellung der Darstellung
			frmMain.invalidate();
			frmMain.setVisible(true);
			frmMain.repaint();

}
}
