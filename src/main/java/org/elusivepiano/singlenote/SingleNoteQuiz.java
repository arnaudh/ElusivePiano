package org.elusivepiano.singlenote;

import org.elusivepiano.question.Question;
import org.elusivepiano.question.Quiz;
import org.elusivepiano.solfege.NoteHarmonique;
import org.elusivepiano.utils.RandomInt;

public class SingleNoteQuiz extends Quiz {

//    private final RandomEnum<Note> notes = new RandomEnum<Note>(Note.class);
    
    private final int length;
    private final int noteMin = 4*12;
    private final int noteMax = 6*12;
    private final RandomInt semitons = new RandomInt(noteMin, noteMax);
    
    public SingleNoteQuiz(int length) {
    	this.length = length;
	}
    
    private int passed = -1;
	@Override
	public Question getNextQuestion() {
		passed++;
		if( passed >= length ){
			return null;
		}
		NoteHarmonique note = NoteHarmonique.createFrom(semitons.getNextInt());
		return new SingleNoteQuestion(note);
	}

	@Override
	public String getTitle() {
		return "FindTheNote-"+noteMin+"-to-"+noteMax;
	}

}
