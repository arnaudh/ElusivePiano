package org.elusivepiano.question;

import org.elusivepiano.profile.Score;


public abstract class Quiz{

	protected int length;
	protected long timePenaltyOnError = 1000; // 1 second

	private long startTimestamp=-1;
	private int errors = 0;
	
	protected Quiz(int length) {
		super();
		this.length = length;
	}

	public Result postAnswer(Question question, Answer answer) {
		if( !question.isCorrect(answer) ){
			errors++;
		}
		return new Result(question.isCorrect(answer), 0, 0);
	}

	public abstract String getTitle();

	public Question getNextQuestion(){
		if( startTimestamp < 0 ){
			startTimestamp = System.currentTimeMillis();
		}
		return getQuestion();
	}
	
	protected abstract Question getQuestion();

	public int getLength() {
		return length;
	}

	public Score evaluateScore(long stopTime) {
		double timePerQuestion = (stopTime - startTimestamp) / length;
		double penaltyPerQuestion =  timePenaltyOnError*errors / length;
		double denominator = (timePerQuestion + penaltyPerQuestion)/1000;
		int score = (int) (1000 / (denominator*denominator));
		return new Score(errors, timePerQuestion, score);
	}
	
	
}
