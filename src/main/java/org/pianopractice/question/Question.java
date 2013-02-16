package org.pianopractice.question;

public abstract class Question {

	private boolean passed = false;
	
	public abstract boolean isCorrect(Answer a);

	public boolean isPassed() {
		return passed;
	}
	public void setPassed(boolean passed) {
		this.passed = passed;
	}
}
