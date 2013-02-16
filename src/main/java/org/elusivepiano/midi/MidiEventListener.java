package org.elusivepiano.midi;

public interface MidiEventListener {

	public void noteDown(int key, int velocity);
	public void noteUp(int key, int velocity);
}
