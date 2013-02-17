package org.elusivepiano;

import org.elusivepiano.midi.MidiHandler;
import org.elusivepiano.midi.MidiUtils;
import org.elusivepiano.profile.Profile;
import org.elusivepiano.session.GUIsession;
import org.elusivepiano.singlenote.SingleNoteQuiz;

public class PianoPractice {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MidiHandler handler = new MidiHandler();
		MidiUtils.midiSetup(handler);
		
		Profile profile = Profile.loadOrCreate("Arnaud");

		GUIsession session = new GUIsession(new SingleNoteQuiz(50), profile);
		handler.addListener(session);
		
//		ChordViewer chordViewer = new ChordViewer();
//		handler.addListener(chordViewer);
//		JFrame frame = new JFrame();
//		frame.getContentPane().add(chordViewer);
//		frame.setSize(new Dimension(500, 200));
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.setVisible(true);
		
	}


}
