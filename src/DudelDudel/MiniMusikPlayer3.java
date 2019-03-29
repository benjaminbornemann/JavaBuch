package DudelDudel;

import javax.sound.midi.*;
import javax.swing.*;
import java.awt.*;



public class MiniMusikPlayer3 {
	
	static JFrame f = new JFrame("Mein erstes Musikvideo");
	static MeinZeichenPanel ml;
	

	public static void main(String[] args) {
		MiniMusikPlayer3 mini = new MiniMusikPlayer3();
		mini.los();
	}  // ende main

	public void guiErstellen()  {
		ml = new MeinZeichenPanel();
		f.setContentPane(ml);
		f.setBounds(30, 30, 300, 300);
		f.setVisible(true);
	}  // ende guiErstellen
	
	
	public void los()  {
		guiErstellen();
		
		try  {
			
			Sequencer sequencer = MidiSystem.getSequencer();
			sequencer.open();
			sequencer.addControllerEventListener(ml, new int[] {127});
			Sequence seq = new Sequence(Sequence.PPQ, 4);
			Track track = seq.createTrack();
			int r = 0;
			for (int i = 0; i < 60; i += 4)  {
				
				r = (int) ((Math.random() * 50) + 1);
				track.add(eventErzeugen(144, 1, r, 100, i));
				track.add(eventErzeugen(176, 1, 127, 0, i));
				track.add(eventErzeugen(128, 1, r, 100, i + 2));
			}  // ende for-Schleife
			
			sequencer.setSequence(seq);
			sequencer.start();
			Thread.sleep(5000);
			sequencer.close();
			sequencer.setTempoInBPM(120);
			}  catch  (Exception ex)  {
				ex.printStackTrace();
			}
	}  // ende los
	
	
public MidiEvent eventErzeugen(int comd, int chan, int one, int two, int tick)  {
	MidiEvent event = null;
	try  {
		ShortMessage a = new ShortMessage();
		a.setMessage(comd, chan, one, two);
		event = new MidiEvent(a, tick);
	}  catch  (Exception e)  {  }
	return event;
}  // ende eventErzeugen
	
	

	
	
	
	
}  // ende MiniMusikPlayer


class MeinZeichenPanel extends JPanel implements ControllerEventListener  {
	
	boolean msg = false;
	
	public void controlChange(ShortMessage event)  {
		msg= true;
		repaint();
	}
	
	public void paintComponent(Graphics g)  {
		
		if (msg)  {
			
		Graphics2D g2 = (Graphics2D)  g;
		
		int r = (int) (Math.random() * 250);
		int gr = (int) (Math.random() * 250);
		int b = (int) (Math.random() * 250);
		
		g.setColor(new Color(r, gr, b));
		
		int höhe = (int) ((Math.random() * 120) + 10);
		int breite = (int) ((Math.random() * 120) + 10);
		int x = (int) ((Math.random() * 40) + 10);
		int y = (int) ((Math.random() * 40) + 10);
		g.fillRect(x,  y,  breite, höhe);
		msg = false;
		}  // ende if
	
	}  // ende paintComponent
	
}  // ende MeinZeichenPanel
