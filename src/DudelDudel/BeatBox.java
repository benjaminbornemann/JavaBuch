package DudelDudel;

import java.awt.*;
import javax.swing.*;
import javax.sound.midi.*;
import java.util.*;
import java.awt.event.*;
import java.io.*;

public class BeatBox {
	
	JPanel hauptPanel;
	ArrayList<JCheckBox> checkBoxListe;
	Sequencer sequencer;
	Sequence sequence;
	Track track;
	JFrame derFrame;
	
	String[] instrumentenNamen = {"Bassdrum", "Hi-Hat, geschlossen", "Hi-Hat, offen", "Snaredrum", "Crashbecken", "H�ndelklatschen",
			"Hohes Tom-Tom", "Hohes Bongo", "Maracas", "Trillerpfeife", "Tiefe Conga", "Kuhglocke", "Vibraslap", "Tieferes Tom-Tom",
			"Hohes Agogo", "Hohe Conga, offen"};
	int [] instrumente = {35, 42, 46, 38, 49, 39, 50, 60, 70, 72, 64, 56, 58, 47, 67, 63};
	

	public static void main(String[] args) {
		new BeatBox().guiErstellen();
	}

	public void guiErstellen()  {
		derFrame = new JFrame("Cyber-BeatBox");
		derFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		BorderLayout layout = new BorderLayout();
		JPanel hintergrund = new JPanel(layout);
		hintergrund.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		
		checkBoxListe = new ArrayList<JCheckBox>();
		Box buttonBox = new Box(BoxLayout.Y_AXIS);
		
		JButton start = new JButton("Starten");
		start.addActionListener(new MeinStartListener());
		buttonBox.add(start);
		
		JButton stopp = new JButton("Stoppen");
		stopp.addActionListener(new MeinStoppListener());
		buttonBox.add(stopp);
		
		JButton schneller = new JButton("Schneller");
		schneller.addActionListener(new MeinSchnellerListener());
		buttonBox.add(schneller);
		
		JButton langsamer = new JButton("Langsamer");
		schneller.addActionListener(new MeinLangsamerListener());
		buttonBox.add(langsamer);
		
		Box namensBox = new Box(BoxLayout.Y_AXIS);
		for (int i = 0; i < 16; i++)  {
			namensBox.add(new Label(instrumentenNamen[i]));
		}
		
		hintergrund.add(BorderLayout.EAST, buttonBox);
		hintergrund.add(BorderLayout.WEST, namensBox);
		
		derFrame.getContentPane().add(hintergrund);
		
		GridLayout raster = new GridLayout(16,16);
		raster.setVgap(1);
		raster.setHgap(2);
		hauptPanel = new JPanel(raster);
		hintergrund.add(BorderLayout.CENTER, hauptPanel);
		
		for (int i = 0; i < 256; i++)  {
			JCheckBox c = new JCheckBox();
			c.setSelected(false);;
			checkBoxListe.add(c);
			hauptPanel.add(c);
		} // Ende Schleife
		
		midiEinrichten();
		
		derFrame.setBounds(50, 50, 300, 300);
		derFrame.pack();
		derFrame.setVisible(true);
		}  // Ende guiErstellen
	
	public void midiEinrichten()  {
		try  {
			sequencer = MidiSystem.getSequencer();
			sequencer.open();
			sequence = new Sequence(Sequence.PPQ,4);
			track = sequence.createTrack();
			sequencer.setTempoInBPM(120);
		}  catch(Exception e)  {e.printStackTrace();}
	}  // Ende midiEinrichten
	
	public void trackErstellenUndStarten()  {
		int[] trackListe = null;
		
		sequence.deleteTrack(track);
		track = sequence.createTrack();
		
		for (int i = 0; i < 16; i++)  {
			trackListe = new int[16];
			
			int taste = instrumente[i];
			
			for (int j = 0; j < 16; j++)  {
				JCheckBox jc = checkBoxListe.get(j + (16*i));
				if (jc.isSelected())  {
					trackListe[j] = taste;
				}  else  {
					trackListe[j] = 0;
				}
			}  // Ende innere Schleife
			
			trackErzeugen(trackListe);
			}  // Ende der �u�eren Schleife
		
		track.add(eventErzeugen(192, 9, 1, 0, 16));
		try  {
			
			sequencer.setSequence(sequence);
			sequencer.setLoopCount(Sequencer.LOOP_CONTINUOUSLY);
			sequencer.start();
			sequencer.setTempoInBPM(120);
			}  catch (Exception e)  {e.printStackTrace();}
	}  // Ende Methode trackErstellenUndStarten 
	
	public class MeinStartListener implements ActionListener  {
		public void actionPerformed(ActionEvent a)  {
			trackErstellenUndStarten();
		}
	}  // Ende MeinStartListener
	
	public class MeinStoppListener implements ActionListener  {
		public void actionPerformed(ActionEvent a)  {
			sequencer.stop();
		}
	}  // Ende MeinStoppListener
	
	public class MeinSchnellerListener implements ActionListener  {
		public void actionPerformed(ActionEvent a)  {
			float tempoFactor = sequencer.getTempoFactor();
			sequencer.setTempoFactor((float) (tempoFactor * 1.03));
		}
	}  // Ende MeinSchnellerListener
	
	public class MeinLangsamerListener implements ActionListener  {
		public void actionPerformed(ActionEvent a)  {
			float tempoFactor = sequencer.getTempoFactor();
			sequencer.setTempoFactor((float) (tempoFactor * .97));
		}
	}  // Ende MeinLangsamerListener
	
	public void trackErzeugen(int[] liste)  {
		for (int i = 0; i < 16; i++)  {
			int taste = liste[i];
			
			if (taste != 0)  {
				track.add(eventErzeugen(144, 9, taste, 100, i));
				track.add(eventErzeugen(128, 9, taste, 100, i+1));
			}
		}
	}
	
	public class MeinSendenListener implements ActionListener  {
		
		public void actionPerformed(ActionEvent a)  {
			boolean[] checkboxZustand = new boolean[256];
			
			for (int i = 0; i < 256; i++)  {
				
				JCheckBox check = (JCheckBox) checkBoxListe.get(i);
				if (check.isSelected())  {
					checkboxZustand[i] = true;
				}
			}
			
			try  {
				FileOutputStream fileStream = new FileOutputStream(new File("Checkbox.ser"));
				ObjectOutputStream os = new ObjectOutputStream(fileStream);
				os.writeObject(checkboxZustand);
			}  catch(Exception ex  ) {
				ex.printStackTrace();
			}
		}
	}  // Ende MeinSendenListener -------------------------------------------------------
	
	public class MeinEinlesenListener implements ActionListener  {
		
		public void actionPerformed(ActionEvent a)  {
			boolean[] checkboxZustand = null;
			try  {
				FileInputStream fileIn = new FileInputStream(new File("Checkbox.ser"));
				ObjectInputStream is = new ObjectInputStream(fileIn);
				checkboxZustand = (boolean[]) is.readObject();
			}  catch(Exception ex)  {ex.printStackTrace();}
			
			for (int i = 0; i < 256; i++)   {
				JCheckBox check = (JCheckBox) checkBoxListe.get(i);
				if (checkboxZustand[i])  {
					check.setSelected(true);
				} else  {
					check.setSelected(false);
				}
			}
			
			sequencer.stop();
			trackErstellenUndStarten();
			
		}
	}
	
	public MidiEvent eventErzeugen (int comd, int chan, int one, int two, int tick)  {
		MidiEvent event = null;
		try  {
			ShortMessage a = new ShortMessage();
			a.setMessage(comd, chan, one, two);
			event = new MidiEvent(a, tick);
			}  catch (Exception e)  {e.printStackTrace();}
		return event;
	}
	
}  // Ende Klasse
