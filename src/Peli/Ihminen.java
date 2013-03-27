package Peli;

import java.awt.Graphics;

public class Ihminen extends Humanoidi {

	Genomi genomi;
	public Ihminen(ZombiesWillEatYou peli) {
		super(peli);
		x = peli.getIhmistenAlkuX();
		y = peli.getIhmistenAlkuY();
		genomi = new Genomi();
		vauhti = genomi.getVauhti();
		korkeus = genomi.getKorkeus();
		leveys = genomi.getLeveys();
		suunta = genomi.getSuunta();
		teeKuva();
		
		
	}
	void teeKuva () {
		kuva = peli.createImage(leveys, korkeus);
		Graphics g = kuva.getGraphics();
		g.setColor(genomi.getTaustavari());
		g.fillRect(0, 0, leveys, korkeus);
		for (int i =0; i<leveys; i ++) {
			for (int j=0; j<korkeus; j++) {
				g.setColor(genomi.getTaustavari());
				g.drawRect(i, j, i, j);
				//System.out.println(i + " " + j + " " + genomi.getTaustavari().getBlue());
			}
		} 
	}


}
