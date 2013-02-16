package org.elusivepiano.singlenote;

import org.elusivepiano.question.Question;
import org.elusivepiano.question.Quiz;
import org.elusivepiano.question.Score;
import org.elusivepiano.solfège.NoteHarmonique;
import org.elusivepiano.utils.RandomInt;

public class SingleNoteQuiz extends Quiz {

//    private final RandomEnum<Note> notes = new RandomEnum<Note>(Note.class);
//    private final RandomEnum<Altération> altérations = new RandomEnum<Altération>(Altération.class);
    private final RandomInt semitons = new RandomInt(4*12, 6*12);
    
	@Override
	public Score getScore() {
		return new Score(1000);
	}
	
	@Override
	public Question getNextQuestion() {
		NoteHarmonique note = NoteHarmonique.createFrom(semitons.getNextInt());
		return new SingleNoteQuestion(note);
	}

}
