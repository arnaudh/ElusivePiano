package org.elusivepiano.profile;

public class Score {

	private int errors;
	private double timePerQuestion;
	private int overallScore;
	
	public Score(int errors, double timePerQuestion, int overallScore) {
		super();
		this.errors = errors;
		this.timePerQuestion = timePerQuestion;
		this.overallScore = overallScore;
	}
	public int getErrors() {
		return errors;
	}
	public double getTimePerQuestion() {
		return timePerQuestion;
	}
	public int getOverallScore() {
		return overallScore;
	}
	
	
}
