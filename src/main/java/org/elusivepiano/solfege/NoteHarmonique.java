package org.elusivepiano.solfege;

public class NoteHarmonique {

	private Note note;
	private Alteration alteration;
	private int octave;

	public NoteHarmonique(Note note, Alteration alteration, int octave) {
		super();
		this.note = note;
		this.alteration = alteration;
		this.octave = octave;
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
	
	/**
	 * C4 -> 1
	 * C4# -> 1
	 * D4b -> 2
	 * D4 -> 2
	 * ...
	 * C5 -> 8
	 * ...
	 * @return
	 */
	public int getLine(){
		return 7 * (octave - 4) + note.getIndex();
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
				Note.values()[semiton], alteration, octave);
		return noteHarmonique;
	}

}
