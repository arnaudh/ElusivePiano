package org.elusivepiano.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import org.elusivepiano.solfege.Partition;

@SuppressWarnings("serial")
public class PartitionPanel extends JPanel {

	protected Partition partition = new Partition();
	private RenderingParams params = new RenderingParams();
	
	public void setPartition(Partition partition) {
		this.partition = partition;
		params.setSpaceBetwenLines(10);
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
		
		g2.translate(10, 50);

		partition.paint(g2, params);

//		g2.drawImage(new ImageIcon("resources/cleDeSol.png").getImage(), 10, 10, 25, 50, null);
		
	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(300, 300);
	}
}
