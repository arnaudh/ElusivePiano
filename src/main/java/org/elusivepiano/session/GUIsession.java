package org.elusivepiano.session;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import org.elusivepiano.midi.MidiEventListener;
import org.elusivepiano.profile.Profile;
import org.elusivepiano.profile.Score;
import org.elusivepiano.question.Answer;
import org.elusivepiano.question.NoteAnswer;
import org.elusivepiano.question.Question;
import org.elusivepiano.question.Quiz;
import org.elusivepiano.question.Result;
import org.elusivepiano.question.StringAnswer;
import org.elusivepiano.singlenote.SingleNoteQuestion;
import org.elusivepiano.solfege.NoteHarmonique;
import org.elusivepiano.solfege.Partition;
import org.elusivepiano.ui.PartitionPanel;

public class GUIsession implements ActionListener, MidiEventListener {

	private Quiz quiz;
	private Question currentQuestion;
	private Profile profile;


	private JFrame frame = new JFrame();
	private PartitionPanel questionPanel = new PartitionPanel();
	private JTextField answerField = new JTextField(20);
	private JLabel infoPanel = new JLabel();

	public GUIsession(Quiz quiz, Profile profile) {
		this.quiz = quiz;
		this.profile = profile;
		answerField.addActionListener(this);

		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				setupUI();
			}
		});

		showNextQuestion();
	}

	private void setupUI() {
		// LAYOUT
		Container pane = frame.getContentPane();
		pane.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridy++;
		pane.add(questionPanel, gbc);
		gbc.gridy++;
		pane.add(answerField, gbc);
		gbc.gridy++;
		infoPanel
				.setPreferredSize(new Dimension(answerField.getPreferredSize()));
		pane.add(infoPanel, gbc);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle(quiz.getTitle());
		frame.setAlwaysOnTop(true);
		frame.setVisible(true);
		frame.setMinimumSize(frame.getSize());
	}

	protected void showNextQuestion() {
		currentQuestion = quiz.getNextQuestion();
		if (currentQuestion instanceof SingleNoteQuestion) {
			NoteHarmonique note = ((SingleNoteQuestion) currentQuestion)
					.getNote();
			questionPanel.setPartition(new Partition(note));
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.answerField && currentQuestion != null) {
			Answer answer = new StringAnswer(answerField.getText());
			handle(answer);
			answerField.setText("");
		}
	}

	public void handle(Answer answer) {
		if( currentQuestion==null ) return;
		Result result = quiz.postAnswer(currentQuestion, answer);
		infoPanel.setText(result.toString());
		if (result.isCorrect()) {
			infoPanel.setText(result.toString());
			showNextQuestion();
			if (currentQuestion == null) { // The end
				Score score = quiz.evaluateScore(System.currentTimeMillis());
				boolean highScore = true;
				for( Integer i :  profile.getInts(quiz.getTitle()) ){
					if( score.getOverallScore() < i ){
						highScore = false;
						break;
					}
				}
				String infoText = highScore?"High Score = ":"Score = ";
				infoText += score.getOverallScore() + " (time per question = "+score.getTimePerQuestion()+"ms, number of errors = "
						+ score.getErrors() + ")";
				infoPanel.setText(infoText);
				
				
				profile.append(quiz.getTitle(), "" + score.getOverallScore());
			}
		}

	}

	@Override
	public void noteDown(int key, int velocity) {
		handle(new NoteAnswer(NoteHarmonique.createFrom(key)));
	}

	@Override
	public void noteUp(int key, int velocity) {
	}

}
