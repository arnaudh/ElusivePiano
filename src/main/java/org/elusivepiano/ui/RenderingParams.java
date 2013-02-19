package org.elusivepiano.ui;

import java.awt.Dimension;

public class RenderingParams {

	private int spaceBetwenLines;
	private Dimension dimensionPreviousDraw;

	
	
	public void setSpaceBetwenLines(int spaceBetwenLines) {
		this.spaceBetwenLines = spaceBetwenLines;
	}

	public int getSpaceBetwenLines() {
		return spaceBetwenLines;
	}

	public int getNoteWidth() {
		return (int) (spaceBetwenLines*1.2);
	}
	
	public Dimension getDimensionPreviousDraw() {
		return dimensionPreviousDraw;
	}

	public void setDimensionPreviousDraw(Dimension dimensionPreviousDraw) {
		this.dimensionPreviousDraw = dimensionPreviousDraw;
	}
	
}
