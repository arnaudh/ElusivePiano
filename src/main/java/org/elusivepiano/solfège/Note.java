package org.elusivepiano.solfège;


public enum Note {
	DO(0, "do", "C"),
	RE(1, "ré", "D"),
	MI(2, "mi", "E"),
	FA(3, "fa", "F"),
	SOL(4, "sol", "G"),
	LA(5, "la", "A"),
	SI(6, "si", "B");
	
	private int index;
	private String frenchName;
	private String englishName;
	
	Note(int index, String frenchName, String englishName){
		this.index = index;
		this.frenchName = frenchName;
		this.englishName = englishName;
	}
		
	public int getIndex() {
		return index;
	}

	public String getFrenchName() {
		return frenchName;
	}

	public String getEnglishName() {
		return englishName;
	}
	
	@Override
	public String toString() {
		return frenchName;
	}
}
