package org.elusivepiano.solfège;

public class NoteHarmonique {

	private Note note;
	private Altération altération;
	private int octave;

	public NoteHarmonique(Note note, Altération altération, int octave) {
		super();
		this.note = note;
		this.altération = altération;
		this.octave = octave;
	}

	public Note getNote() {
		return note;
	}

	public Altération getAltération() {
		return altération;
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
		sb.append(altération.getSymbol());
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
		// altération
		Altération altération;
		if (semiton == 1 || semiton == 3 || semiton == 6 || semiton == 8
				|| semiton == 10) {
			altération = Altération.DIÈSE;
			semiton--;
		} else {
			altération = Altération.AUCUNE;
		}
		// note value (0 to 6)
		if (semiton == 2 || semiton == 4) {
			semiton /= 2;
		} else if (semiton == 5 || semiton == 7 || semiton == 9 || semiton == 11) {
			semiton = (semiton + 1) / 2;
		}
		NoteHarmonique noteHarmonique = new NoteHarmonique(
				Note.values()[semiton], altération, octave);
		return noteHarmonique;
	}

}
