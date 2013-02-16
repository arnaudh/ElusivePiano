package org.elusivepiano.solfège;


public enum Altération {
	AUCUNE(""),
	DIÈSE("♯"),
	BÉMOL("♭"),
	BÉCARRE("♮");
	
	private String symbol;
	Altération(String symbol){
		this.symbol = symbol;
	}
	public String getSymbol() {
		return symbol;
	}
}