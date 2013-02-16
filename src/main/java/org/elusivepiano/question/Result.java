package org.elusivepiano.question;

public class Result {

	private boolean correct;
	private double timeScore;
	private double precisionScore;

	public Result(boolean correct, double timeScore, double precisionScore) {
		super();
		this.correct = correct;
		this.timeScore = timeScore;
		this.precisionScore = precisionScore;
	}

	public boolean isCorrect() {
		return correct;
	}

	public double getTimeScore() {
		return timeScore;
	}

	public double getPrecisionScore() {
		return precisionScore;
	}
	
	@Override
	public String toString() {
		if( this.isCorrect() ){
			return "Correct!    timeScore="+this.getTimeScore();
		}else{
			return "Wrong!";
		}
	}
}
