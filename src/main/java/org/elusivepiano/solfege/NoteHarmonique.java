package org.elusivepiano.solfege;

import java.awt.Graphics2D;

import org.elusivepiano.ui.RenderingParams;

public class NoteHarmonique implements Symbole {

	private Note note;
	private Alteration alteration;
	private int octave;
	private Figure figure;

	public NoteHarmonique(Note note, Alteration alteration, int octave, Figure figure) {
		super();
		this.note = note;
		this.alteration = alteration;
		this.octave = octave;
		this.figure = figure;
	}

	public Note getNote() {
		return note;
	}

	public Alteration getAlteration() {
		return alteration;
	}

	public int getOctave() {
		return octave;
	}
	
	public void paint(Graphics2D g2, RenderingParams params){
		int translate = getLine() * params.getSpaceBetwenLines()/2;

		g2.translate(0, translate);
		figure.paint(g2, params);
		alteration.paint(g2, params);
		g2.translate(0, -translate);
		
		int increment = getLine() < 0 ? 1 : -1;
		int lineStart = getLine() + -getLine()%2;
		System.out.println("getLine()="+getLine()+", getLine()%2="+getLine()%2+", increment="+increment+", lineStart="+lineStart);
		for( int line = lineStart; line != 0; line+=increment*2 ){
			drawDash(g2, params, 0, line);
		}
	}

	private void drawDash(Graphics2D g2, RenderingParams params, int offset, int line) {
		int height = line * params.getSpaceBetwenLines()/2;
		int width = (int) (params.getNoteWidth()*0.8);
		g2.drawLine(-width, height, width, height);
	}
	
	/**
	 * Fa5 = 0
	 * Mi5  = 1
	 * ...
	 * @return
	 */
	public int getLine(){
		return 7 * (5 - octave) - note.getIndex() + 3;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder(note.toString());
		sb.append(alteration.getSymbol());
		sb.append(octave);
		return sb.toString();
	}
	
	@Override
	public boolean equals(Object obj) {
		if( obj instanceof NoteHarmonique ){
			return ((NoteHarmonique) obj).toString().equals(this.toString());
		}
		return false;
	}

	public static NoteHarmonique createFrom(int key) {
		int octave = key / 12;
		int semiton = key % 12;
		// alteration
		Alteration alteration;
		if (semiton == 1 || semiton == 3 || semiton == 6 || semiton == 8
				|| semiton == 10) {
			alteration = Alteration.DIESE;
			semiton--;
		} else {
			alteration = Alteration.AUCUNE;
		}
		// note value (0 to 6)
		if (semiton == 2 || semiton == 4) {
			semiton /= 2;
		} else if (semiton == 5 || semiton == 7 || semiton == 9 || semiton == 11) {
			semiton = (semiton + 1) / 2;
		}
		NoteHarmonique noteHarmonique = new NoteHarmonique(
				Note.values()[semiton], alteration, octave, Figure.CROCHE);
		return noteHarmonique;
	}

}
