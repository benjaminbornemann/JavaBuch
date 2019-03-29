package Pack1;

import javax.sound.midi.*;

public class MiniMusikPlayer1 {

	public static void main(String[] args) {
		
		try  {
			Sequencer sequencer = MidiSystem.getSequencer();
			sequencer.open();
			
			Sequence seq = new Sequence(Sequence.PPQ, 4);
			Track track = seq.createTrack();
		
			for (int i = 5; i < 87; i+=4  ) {
				System.out.println(i);
				track.add(eventErzeugen(144, 1, i, 100, i));
				track.add(eventErzeugen(128, 1, i, 100, i + 3));
				}
			
			sequencer.setSequence(seq);
			sequencer.setTempoInBPM(220);
			sequencer.start();
			Thread.sleep(11000);
			sequencer.close();
			}catch (Exception e)  {}
				

	}
	
	public static MidiEvent eventErzeugen(int comd, int chan, int one, int two, int tick)  {
		MidiEvent event = null;
		try  {
			ShortMessage a = new ShortMessage();
			a.setMessage(comd, chan, one, two);
			event = new MidiEvent(a, tick);
			
		}  catch (Exception e)  {}
		return event;
	}

}
