package org.elusivepiano.solfege;

import java.awt.Font;
import java.awt.Graphics2D;

import org.elusivepiano.ui.RenderingParams;


public enum Alteration {
	AUCUNE(""),
	DIESE("♯"),
	BEMOL("♭"),
	BECARRE("♮");
	
	private String symbol;
	Alteration(String symbol){
		this.symbol = symbol;
	}
	public String getSymbol() {
		return symbol;
	}
	public void paint(Graphics2D g2, RenderingParams params) {
		g2.setFont(new Font("TimesRoman", Font.BOLD, 25));
		g2.drawString(symbol, -params.getNoteWidth()-7, 7);		
	}
}