package org.pianopractice.midi;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import javax.sound.midi.MidiMessage;
import javax.sound.midi.Receiver;

public class MidiToQwerty implements Receiver {
	
	@SuppressWarnings("unused")
	private String mapping;
	private Robot robot;
	
	public MidiToQwerty(String mapping) {
		this.mapping = mapping;
		try {
			this.robot = new Robot();
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		MidiUtils.midiSetup(this);
		robot.keyPress(65);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new MidiToQwerty("aqsedrfgyhujiklpm");
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
			byte key = bytes[1];
			if( 36<key && key<50){
				robot.keyPress(KeyEvent.VK_A);
				robot.delay(100);
			}
		}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	

}
