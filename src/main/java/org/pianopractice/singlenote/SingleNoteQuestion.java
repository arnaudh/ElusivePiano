package org.pianopractice.singlenote;

import org.pianopractice.question.Answer;
import org.pianopractice.question.NoteAnswer;
import org.pianopractice.question.Question;
import org.pianopractice.question.StringAnswer;
import org.pianopractice.solfège.NoteHarmonique;
import org.pianopractice.solfège.Partition;

public class SingleNoteQuestion extends Question {

	private NoteHarmonique note;

	public SingleNoteQuestion(NoteHarmonique note) {
		this.note = note;
	}

	public NoteHarmonique getNote() {
		return note;
	}

	@Override
	public String toString() {
		return new Partition(note).stringRepresentation();
	}

	@Override
	public boolean isCorrect(Answer answer) {
		if (answer instanceof StringAnswer) {
			String str = ((StringAnswer) answer).getAnswer();
//			if (str.equals(note.getNote().getFrenchName())
//					|| str.equals(note.getNote().getEnglishName())) {
//				return true;
//			}
			try{
				String frenchName = note.getNote().getFrenchName();
				if( str.charAt(0) == frenchName.charAt(0) ){
					if( str.charAt(0) == 's' ){
						return str.charAt(1) == frenchName.charAt(1);
					}else{
						return true;
					}
				}
			}catch( IndexOutOfBoundsException e ){
				return false;
			}
		}else if(answer instanceof NoteAnswer){
			NoteHarmonique receivedNote = ((NoteAnswer) answer).getNote();
			return receivedNote.equals(note);
		}
		return false;
	}

}
