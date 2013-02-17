package org.elusivepiano.question;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class Quiz implements Iterable<Question> {

	protected List<Question> questions = new ArrayList<Question>();

	public Result postAnswer(Question question, Answer answer) {
		return new Result(question.isCorrect(answer), 0, 0);
	}

	public Iterator<Question> iterator() {
		return questions.iterator();
	}

	public abstract String getTitle();

	public abstract Question getNextQuestion();
}
