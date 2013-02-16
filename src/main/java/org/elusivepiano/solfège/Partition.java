package org.elusivepiano.solfège;

import java.util.ArrayList;
import java.util.List;

public class Partition {

	private List<Accord> accords = new ArrayList<Accord>();

	private NoteHarmonique lowestNote;
	private NoteHarmonique highestNote;

	public Partition() {
	}

	public Partition(NoteHarmonique note) {
		accords.add(new Accord(note));
		this.lowestNote = this.highestNote = note;
	}


	public String stringRepresentation() {
		int lowestHeight = Math.min(lowestNote.getLine(), 0);
		int highestHeight = Math.max(highestNote.getLine(), 10);

		int partitionLenght = 7;
		char[][] partition = new char[(highestHeight - lowestHeight)][partitionLenght];
		for (int height = lowestHeight; height < highestHeight; height++) {
			char c = (2 <= height && height <= 10 && height % 2 == 0) ? '-'
					: ' ';
			for (int i = 0; i < partitionLenght; i++) {
				partition[height - lowestHeight][i] = c;
			}
		}

		int offset = 0;
		for( Accord accord : accords ){
			for (NoteHarmonique note : accord.getNotes()) {
				offset += 3;
				partition[offset][note.getLine()] = 'O';
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = partition.length-1; i >= 0; i--){
			sb.append(partition[i]);
			sb.append('\n');
		}
		return sb.toString();
	}

	public List<Accord> getAccords() {
		return accords;
	}
}
