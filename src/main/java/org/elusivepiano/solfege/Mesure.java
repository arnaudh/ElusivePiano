package org.elusivepiano.solfege;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

import org.elusivepiano.ui.RenderingParams;

public class Mesure {

	private List<Symbole> symboles = new ArrayList<Symbole>();

	public Mesure(List<Symbole> symboles) {
		super();
		this.symboles = symboles;
	}
	
	public void paint(Graphics2D g2, RenderingParams params){
		//barre de mesure
		g2.drawLine(0, 0, 0, 4*params.getSpaceBetwenLines());
		int space = 30;
		int translateBack = 0;
		for( Symbole symbole : symboles ){
			g2.translate(space, 0);
			translateBack += space;
			symbole.paint(g2, params);
		}
		g2.translate(space, 0);
		translateBack+=space;
		g2.drawLine(0, 0, 0, 4*params.getSpaceBetwenLines());
		params.setDimensionPreviousDraw(new Dimension(translateBack, 0));
		g2.translate(-translateBack, 0);
	}
}
