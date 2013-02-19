package org.elusivepiano.solfege;

import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;

import org.elusivepiano.ui.RenderingParams;

public enum Cle {

	SOL("resources/cleDeSol.png"),
	FA("resources/cleDeFa.png");
	
	private Image image;
	
	private Cle( String path ){
		image = new ImageIcon(path).getImage();
	}
	
	public void paint( Graphics2D g2, RenderingParams params ){
		g2.drawImage(image, 0, 0, 25, 11*params.getSpaceBetwenLines(), null);
	}
}
