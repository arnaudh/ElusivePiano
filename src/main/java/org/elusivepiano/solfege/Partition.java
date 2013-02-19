package org.elusivepiano.solfege;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

import org.elusivepiano.ui.RenderingParams;

public class Partition {

	private List<Portee> portees = new ArrayList<Portee>();

	public Partition() {
		super();
	}

	public Partition(NoteHarmonique note) {
		List<Symbole> symboles = new ArrayList<Symbole>();
		symboles.add(note);
		Mesure mesure = new Mesure(symboles);
		Portee portee = new Portee();
		portee.getMesures().add(mesure);
		this.portees.add(portee);
	}

	public void paint(Graphics2D g2, RenderingParams params) {
		for( Portee portee : portees ){
			portee.paint(g2, params);
			g2.translate(0, params.getSpaceBetwenLines()*20);
		}
	}

	public List<Portee> getPortees() {
		return portees;
	}

	public void setPortees(List<Portee> portees) {
		this.portees = portees;
	}
	
	
}
