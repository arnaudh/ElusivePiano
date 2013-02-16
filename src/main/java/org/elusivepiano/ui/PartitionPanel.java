package org.elusivepiano.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import org.elusivepiano.solfège.Accord;
import org.elusivepiano.solfège.NoteHarmonique;
import org.elusivepiano.solfège.Partition;

@SuppressWarnings("serial")
public class PartitionPanel extends JPanel {

	protected Partition partition = new Partition();
	private int spaceBetwenLines = 5;
	private int noteHeight = spaceBetwenLines * 2;
	private int noteWidth = (int) (noteHeight * 1.2);
	private Image cleDeSol = new ImageIcon("resources/cleDeSol.png").getImage();
	
	public void setPartition(Partition partition) {
		this.partition = partition;
		repaint();
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;

		if( partition == null ) return;

		g2.setBackground(Color.WHITE);
		g2.clearRect(0, 0, this.getWidth(), this.getHeight());
		g2.setColor(Color.BLACK);
		int offset = 10;
		//lines
		for (int line = 2; line <= 10; line += 2) {
			int height = lineHeight(line);
			g2.drawLine(offset, height, getWidth() - 10, height);
		}
		//clé de sol
		offset += 5;
		g2.drawImage(cleDeSol, offset, lineHeight(13), 25, lineHeight(-2)-lineHeight(13), null);
		offset += 50;

		for (Accord accord : partition.getAccords()) {
			offset += 20;
			for( NoteHarmonique note : accord.getNotes() ){
				drawNote(g2, offset, note);
			}
		}
	}

	/**
	 * @param g2
	 * @param offset
	 * @param note
	 */
	private void drawNote(Graphics2D g2, int offset, NoteHarmonique note) {
		int y = lineHeight(note.getLine());
		AffineTransform noteTransform = new AffineTransform();
		noteTransform.translate(offset, y);
		noteTransform.shear(-0.4, 0);
		Shape transformedEllipse = noteTransform.createTransformedShape(
				new Ellipse2D.Float(-noteWidth/2, -noteHeight/2, noteWidth, noteHeight)
		);
		g2.fill(transformedEllipse);
		g2.draw(transformedEllipse);
//			g2.setColor(Color.white);
		g2.drawLine(offset + noteWidth / 2, lineHeight(note.getLine()), 
				offset + noteWidth / 2, lineHeight(note.getLine())-noteHeight*3);
		//draw lines up/down to the note
		if (note.getLine() < 1) {
			for (int line = 0; line >= note.getLine() - 1; line -= 2) {
				drawDash(g2, offset, line);
			}
		}
		if(note.getLine() > 11){
			for( int line = 12; line <= note.getLine(); line +=2){
				drawDash(g2, offset, line);
			}
		}
		//altération
		g2.drawString(note.getAltération().getSymbol(), offset-noteWidth/2 - 16, lineHeight(note.getLine())+6);
	}

	/**
	 * @param g2
	 * @param offset
	 * @param line
	 */
	private void drawDash(Graphics2D g2, int offset, int line) {
		int height = lineHeight(line);
		g2.drawLine((int) (offset - noteWidth*0.6), height, (int) (offset + noteWidth*0.6), height);
	}
	
//	private void drawNote()

	private int lineHeight(int line) {
		return getHeight() - (line + 8 * 4) * spaceBetwenLines;
	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(300, 300);
	}
}
