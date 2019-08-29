package Speicherung;

import java.util.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.io.*;

public class QuizKartenPlayer {
	
	private JTextArea anzeige;
	private ArrayList<QuizKarte> kartenliste;
	private QuizKarte aktuelleKarte;
	private int aktuelleKarteIndex;
	private JFrame frame;
	private JButton nächsteKarteButton;
	private boolean istAntwortAngezeigt;

	public static void main(String[] args) {
		QuizKartenPlayer reader = new QuizKartenPlayer();
		reader.los();
	}

	public void los()  {
		
		// GUI aufbauen kaputt
		
		frame = new JFrame("Quizkarten-Player");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel hauptPanel = new JPanel();
		Font bigFont = new Font("sanserif", Font.BOLD, 24);
		
		anzeige = new JTextArea(10, 20);
		anzeige.setFont(bigFont);
		
		anzeige.setLineWrap(true);
		anzeige.setEditable(false);
		
		JScrollPane fScroller = new JScrollPane(anzeige);
		fScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		fScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		nächsteKarteButton = new JButton("Frage zeigen");
		hauptPanel.add(fScroller);
		hauptPanel.add(nächsteKarteButton);
		nächsteKarteButton.addActionListener(new NächsteKarteListener());
		
		JMenuBar menüleiste = new JMenuBar();
		JMenu menüDatei = new JMenu("Datei");
		JMenuItem menüPunktLaden = new JMenuItem("Kartensatz laden");
		menüPunktLaden.addActionListener(new MenüÖffnenListener());
		menüDatei.add(menüPunktLaden);
		menüleiste.add(menüDatei);
		frame.setJMenuBar(menüleiste);
		frame.getContentPane().add(BorderLayout.CENTER, hauptPanel);
		frame.setSize(500, 600);
		frame.setVisible(true);
		}  // Ende los

	
	private class NächsteKarteListener implements ActionListener  {
		public void actionPerformed(ActionEvent ev)  {
			if (istAntwortAngezeigt)  {
				anzeige.setText(aktuelleKarte.getAntwort());
				nächsteKarteButton.setText("Nächste Karte");
				istAntwortAngezeigt = false;
			}  else  {
				if (aktuelleKarteIndex < kartenliste.size())  {
					nächsteKarteZeigen();
				}  else  {
				
				anzeige.setText("Das war die letzte Karte.");
				nächsteKarteButton.setEnabled(false);
			}
		}
		}

	
	private class MenüÖffnenListener implements ActionListener  {
		public void actionPerformed(ActionEvent ev)  {
			JFileChooser dateiÖffnen = new JFileChooser();
			dateiÖffnen.showOpenDialog(frame);
			dateiLaden(dateiÖffnen.getSelectedFile());
		}
	
	
	private void dateiLaden(File datei)  {
		
		kartenliste = new ArrayList ();
		try  {
			BufferedReader reader = new BufferedReader(new FileReader(datei));
			String zeile = null;
			while ((zeile = reader.readLine()) != null)  {
				karteErstellen(zeile);
			}
			reader.close();
		}  catch  (Exception ex)  {
			System.out.println("konnte Kartendatei nicht lesen");
			ex.printStackTrace();
		}
		
		nächsteKarteZeigen();
	}
	
	private void karteErstellen(String zuParsendeZeile)  {
		String[] ergebnis = zuParsendeZeile.split("/");
		QuizKarte karte = new QuizKarte(ergebnis[0], ergebnis[1]);
		kartenliste.add(karte);
		System.out.println("Karte erstellt");
		}
	
	private void nächsteKarteZeigen()  {
		aktuelleKarte = kartenliste.get(aktuelleKarteIndex);
		aktuelleKarteIndex++;
		anzeige.setText(aktuelleKarte.getFrage());
		nächsteKarteButton.setText("Antwort zeigen");
		istAntwortAngezeigt = true;
	}
}
	
}
}

