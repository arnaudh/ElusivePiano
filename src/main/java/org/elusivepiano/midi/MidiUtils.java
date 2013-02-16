package org.elusivepiano.midi;

import java.util.List;

import javax.sound.midi.MidiDevice;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Receiver;
import javax.sound.midi.Transmitter;

public class MidiUtils {

	public static void midiSetup(Receiver receiver) {

		MidiDevice device;
		MidiDevice.Info[] infos = MidiSystem.getMidiDeviceInfo();
		for (int i = 0; i < infos.length; i++) {
			try {
				device = MidiSystem.getMidiDevice(infos[i]);
				// does the device have any transmitters?
				// if it does, add it to the device list
				System.out.println(infos[i]);

				// get all transmitters
				List<Transmitter> transmitters = device.getTransmitters();
				// and for each transmitter

				for (int j = 0; j < transmitters.size(); j++) {
					// create a new receiver
					transmitters.get(j).setReceiver(receiver);
				}

				Transmitter trans = device.getTransmitter();
				trans.setReceiver(receiver);

				// open each device
				device.open();
				// if code gets this far without throwing an exception
				// print a success message
				System.out.println(device.getDeviceInfo() + " Was Opened");

			} catch (MidiUnavailableException e) {
//				e.printStackTrace();
			}
		}		
	}
}