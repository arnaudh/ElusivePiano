package org.pianopractice;

import org.pianopractice.midi.MidiHandler;
import org.pianopractice.midi.MidiUtils;
import org.pianopractice.session.GUIsession;
import org.pianopractice.singlenote.SingleNoteQuiz;

public class PianoPractice {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MidiHandler handler = new MidiHandler();
		MidiUtils.midiSetup(handler);

		GUIsession session = new GUIsession(new SingleNoteQuiz());
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
