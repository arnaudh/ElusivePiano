package org.elusivepiano.solfege;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

import org.elusivepiano.ui.RenderingParams;

public class Portee {

	private List<Mesure> mesures = new ArrayList<Mesure>();
	private Cle cle = Cle.SOL;

	public List<Mesure> getMesures() {
		return mesures;
	}

	public void setMesures(List<Mesure> mesures) {
		this.mesures = mesures;
	}

	public void paint(Graphics2D g2, RenderingParams params) {
		cle.paint(g2, params);
		for( Mesure mesure : mesures ){
			mesure.paint(g2, params);
			g2.translate(params.getDimensionPreviousDraw().width, 0);
		}

		int width = params.getDimensionPreviousDraw().width * mesures.size();
		g2.translate(- width, 0);
		//lignes
		for( int line = 0; line <=8; line+=2){
			int height = line*params.getSpaceBetwenLines()/2;
			g2.drawLine(0, height, width, height);
		}
	}
	
	
}
