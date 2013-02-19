package org.elusivepiano.singlenote;

import org.elusivepiano.question.Answer;
import org.elusivepiano.question.NoteAnswer;
import org.elusivepiano.question.Question;
import org.elusivepiano.question.StringAnswer;
import org.elusivepiano.solfege.NoteHarmonique;

public class SingleNoteQuestion extends Question {

	private NoteHarmonique note;

	public SingleNoteQuestion(NoteHarmonique note) {
		this.note = note;
	}

	public NoteHarmonique getNote() {
		return note;
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
