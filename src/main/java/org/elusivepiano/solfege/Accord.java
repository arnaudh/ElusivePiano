package org.elusivepiano.solfege;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

import org.elusivepiano.ui.RenderingParams;

public class Accord implements Symbole {

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

	@Override
	public void paint(Graphics2D g2, RenderingParams params) {
		for( NoteHarmonique note : notes ){
			note.paint(g2, params);
		}
	}
	
	
}
