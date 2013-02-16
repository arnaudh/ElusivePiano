package org.elusivepiano.question;

import org.elusivepiano.solfège.NoteHarmonique;

public class NoteAnswer extends Answer {

	private NoteHarmonique note;

	public NoteAnswer(NoteHarmonique note) {
		super();
		this.note = note;
	}

	public NoteHarmonique getNote() {
		return note;
	}
	
	
}
