package org.pianopractice.singlenote;

import org.pianopractice.question.Question;
import org.pianopractice.question.Quiz;
import org.pianopractice.question.Score;
import org.pianopractice.solfège.NoteHarmonique;
import org.pianopractice.utils.RandomInt;

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
