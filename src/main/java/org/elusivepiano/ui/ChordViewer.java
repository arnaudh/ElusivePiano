package org.elusivepiano.ui;

import org.elusivepiano.midi.MidiEventListener;
import org.elusivepiano.solfege.Accord;
import org.elusivepiano.solfege.NoteHarmonique;
import org.elusivepiano.solfege.Partition;

public class ChordViewer extends PartitionPanel implements MidiEventListener {

	private static final long serialVersionUID = 1L;
	private boolean[] keyPressed = new boolean[128];

	@Override
	public void noteDown(int key, int velocity) {
		keyPressed[key] = true;
		updatePartition();
	}

	@Override
	public void noteUp(int key, int velocity) {
		keyPressed[key] = false;
		updatePartition();
	}

	private void updatePartition() {
		partition = new Partition();
		Accord accord = new Accord();
		for (int key = 0; key < keyPressed.length; key++) {
			if (keyPressed[key]) {
				NoteHarmonique note = NoteHarmonique.createFrom(key);
				accord.getNotes().add(note);
			}
		}
		partition.getAccords().add(accord);
		repaint();
	}

}
