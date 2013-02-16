package org.elusivepiano.question;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class Quiz implements Iterable<Question> {

	protected List<Question> questions = new ArrayList<Question>();

	public Result postAnswer(Question question, Answer answer) {
		if (question.isCorrect(answer)) {
			question.setPassed(true);
		}
		return new Result(question.isCorrect(answer), 0, 0);
	}

	public abstract Score getScore();

	public Iterator<Question> iterator() {
		return questions.iterator();
	}

	public String getTitle() {
		return this.getClass().getSimpleName();
	}

	public Question getNextQuestion() {
		for (Question question : questions) {
			if (!question.isPassed()) {
				return question;
			}
		}
		return null;
	}

}
