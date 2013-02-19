package org.elusivepiano.solfege;

import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;

import org.elusivepiano.ui.RenderingParams;

public enum Figure {

	CARREE(8),
	RONDE(4),
	BLANCHE(2),
	NOIRE(1),
	CROCHE(1/2),
	DOUBLE_CROCHE(1/4),
	TRIPLE_CROCHE(1/8),
	QUADRUPLE_CROCHE(1/16);
	
	private final double duree;
	private Figure(double duree){
		this.duree = duree;
	}
	public double getDuree() {
		return duree;
	}
	
	public void paint(Graphics2D g2, RenderingParams params){
		AffineTransform noteTransform = new AffineTransform();
		noteTransform.shear(-0.4, 0);
		int width = (int) (params.getSpaceBetwenLines()*1.2);
		Shape transformedEllipse = noteTransform.createTransformedShape(
				new Ellipse2D.Float(-width/2, -params.getSpaceBetwenLines()/2, width, params.getSpaceBetwenLines())
		);
		g2.fill(transformedEllipse);
		g2.draw(transformedEllipse);
	}
}
