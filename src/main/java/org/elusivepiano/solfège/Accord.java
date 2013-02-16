package org.elusivepiano.solfège;

import java.util.ArrayList;
import java.util.List;

public class Accord {

	private List<NoteHarmonique> notes = new ArrayList<NoteHarmonique>();

	public Accord(NoteHarmonique ... notes_) {
		for( NoteHarmonique note : notes_ ){
			notes.add(note);
		}
	}
	
	public List<NoteHarmonique> getNotes() {
		return notes;
	}

	public void setNotes(List<NoteHarmonique> notes) {
		this.notes = notes;
	}
	
	
}
