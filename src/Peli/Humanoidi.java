package Peli;

import java.awt.Image;
import java.util.Random;

public class Humanoidi {

	protected ZombiesWillEatYou peli;
	protected Image kuva = null;
	protected int x;
	protected int y;
	protected static Random r = new Random();
	
	protected int pystyliike;
	protected int sivuliike;
	
	protected int vauhti;
	
	protected int red;
	protected int green;
	protected int blue;
	
	protected int korkeus;
	protected int leveys;
	
	protected double suunta =666;
	
	public Humanoidi (ZombiesWillEatYou peli) {
		this.peli = peli;
		//kuva = createImage(2,2);
		vauhti = 5; //pitää ehkä olla pariton?
		red = 0;
		green = 0;
		blue = 0;
	}
	
	public Image getImage() {
		return kuva;
	}

	public int getX() {
		// TODO Auto-generated method stub
		return x;
	}
	
	public int getY() {
		// TODO Auto-generated method stub
		return y;
	}
	
	public int getX2() {
		return x + kuva.getWidth(peli);
	}
	
	public int getY2() {
		return y + kuva.getHeight(peli);
	}
	
	public void vaihdaSuuntaa(double x) {
		suunta += x;
		while (suunta >= (2*Math.PI)) {
			suunta -= (2*Math.PI);
		}
	}
	
	public void liiku () {
		if (suunta == 666) {
			pystyliike = (r.nextInt(vauhti)-vauhti/2);
			sivuliike = (r.nextInt(vauhti)-vauhti/2);
			x += sivuliike;
			y += pystyliike;
		}
		else {
			pystyliike = (int) ((Math.cos(suunta))*vauhti);
			sivuliike = (int) ((Math.sin(suunta))*vauhti);
			x += sivuliike;
			y += pystyliike;
		}
	}

	public void pidaRuudulla(int screenWidth, int screenHeight) {
		if (y<0 || y> (screenHeight - kuva.getHeight(peli))) {
			y -= pystyliike;
			//vaihdaSuuntaa(2.6);
		}
		if (x<0 || x> (screenWidth - kuva.getWidth(peli))) {
			x -= sivuliike;
			//vaihdaSuuntaa(2.6);
		}
	}
	public boolean onkoSisalla(Humanoidi humanoidi) {
		if (x > humanoidi.getX() && x < humanoidi.getX2()
		&&  y > humanoidi.getY() && y < humanoidi.getY2()) {
			return true;
		}
		return false;
	}
	public void kuole () {
		peli.kuole(this);
	}
}