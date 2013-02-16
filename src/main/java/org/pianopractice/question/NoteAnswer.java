package org.pianopractice.question;

import org.pianopractice.solfège.NoteHarmonique;

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
