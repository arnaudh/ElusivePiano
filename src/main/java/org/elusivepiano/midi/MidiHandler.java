package org.elusivepiano.midi;

import java.util.ArrayList;
import java.util.List;

import javax.sound.midi.MidiMessage;
import javax.sound.midi.Receiver;
import javax.sound.midi.ShortMessage;

public class MidiHandler implements Receiver {

	private List<MidiEventListener> listeners = new ArrayList<MidiEventListener>();
	
	public void addListener(MidiEventListener listener) {
		this.listeners.add(listener);
	}
	
	@Override
	public void close() {
	}

	@Override
	public void send(MidiMessage message, long timeStamp) {
		try{
			byte[] bytes = message.getMessage();
			switch (bytes.length) {
			case 3: //
				byte code = bytes[0];
				byte key = bytes[1];
				byte value = bytes[2];
				System.out.println(code);
				switch(code){
				case (byte) ShortMessage.NOTE_ON :
					for( MidiEventListener listener : listeners ){
						listener.noteDown(key, value);
					}
					break;
				case (byte) ShortMessage.NOTE_OFF :
					for( MidiEventListener listener : listeners ){
						listener.noteUp(key, value);
					}
					break;
				}
			}
		}catch( Exception e ){
			e.printStackTrace();
		}
	}

}
