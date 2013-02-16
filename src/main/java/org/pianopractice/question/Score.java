package org.pianopractice.question;

public class Score {

	private double overallScore;

	public Score(double overallScore) {
		super();
		this.overallScore = overallScore;
	}

	public double getOverallScore() {
		return overallScore;
	}
	
	@Override
	public String toString() {
		return "### Overall Score = "+overallScore+" ###";
	}
}
