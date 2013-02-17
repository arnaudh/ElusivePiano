package org.elusivepiano.solfege;


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
}