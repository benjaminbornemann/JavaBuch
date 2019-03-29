package Pack1;

import javax.sound.midi.*;

public class MiniMusikPlayer2 implements ControllerEventListener  {

	public static void main(String[] args) {
		MiniMusikPlayer2 mini = new MiniMusikPlayer2();
		mini.los();
	}

	public void los()  {
		try  {
			Sequencer sequencer = MidiSystem.getSequencer();
			sequencer.open();
			
			int[] gewünschteEvents = {127};
			sequencer.addControllerEventListener(this,  gewünschteEvents);
			
			Sequence seq = new Sequence(Sequence.PPQ, 4);
			Track track = seq.createTrack();
			
			for (int i = 5; i < 60; i += 4)  {
				track.add(eventErzeugen(144, 1, i, 100, i));
				track.add(eventErzeugen(176, 1, 127, 0, i));
				track.add(eventErzeugen(128, 1, i, 100, i + 2));
			}
			
			sequencer.setSequence(seq);
			sequencer.setTempoInBPM(220);
			sequencer.start();
			Thread.sleep(5000);
			sequencer.close();
		}  catch  (Exception ex)  {ex.printStackTrace();}
	}  // ende los
	
	public void controlChange(ShortMessage event)  {
		System.out.println("la");
	}
	
	public MidiEvent eventErzeugen(int comd, int chan, int one, int two, int tick)  {
		MidiEvent event = null;
		try  {
			ShortMessage a = new ShortMessage();
			a.setMessage(comd, chan, one, two);
			event = new MidiEvent(a, tick);
			}  catch (Exception e)  {}
		return event;
	}  // ende eventErzeugen
}  //ende Klasse
