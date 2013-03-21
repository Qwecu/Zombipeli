package Peli;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.util.Random;

public class Zombi extends Humanoidi {
	
	
	public Zombi (ZombiesWillEatYou peli) {
		super(peli);
		x = peli.getZombienAlkuX();
		y = peli.getZombienAlkuY();
		korkeus = 20;
		leveys = 20;
		kuva = peli.createImage(korkeus, leveys);
		Graphics g = kuva.getGraphics();
		g.setColor(Color.RED);
		g.fillRect(0, 0, korkeus, leveys);
		
	}
	
	
}
