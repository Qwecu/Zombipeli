package Peli;
import java.awt.Color;
import java.util.Random;

public class Genomi {
	int [] a1;
	int [] a2;
	int [] b1;
	int [] b2;
	public Genomi() {
		Random r = new Random();
		a1 = new int[256];
		a2 = new int[256];
		b1 = new int[256];
		b2 = new int[256];
		for (int i = 0; i<256; i++) {
			a1[i] = r.nextInt(256);
			b1[i] = r.nextInt(256);
			a2[i] = r.nextInt(256);
			b2[i] = r.nextInt(256);
		}
	}
	public Genomi (Genomi aiti, Genomi isa) {
		a1 = aiti.getAKromosomi();
		a2 = isa.getAKromosomi();
		b1 = aiti.getBKromosomi();
		b2 = aiti.getBKromosomi();
	}
	
	private int get(int i) {
		if (a1[i] < a2[i]) {
			return Math.min(b1[a1[i]], b2[a1[i]]);
		}
		return Math.min(b1[a2[i]], b2[a2[i]]);
	}
	
	public int[] getBKromosomi() { //TODO
		int[]b = new int[256];
		Random r = new Random();
		if (r.nextInt()==0) {
			for (int i : b1) {
				b[i] = b1[i];
			}
		}
		else {
			for (int i : b2) {
				b[i] = b2[i];
			}
		}
		for (int i = 0; i<(get(0)/get(1)); i++) {
			
		}
		return b1;
	}
	public int[] getAKromosomi() {
		// TODO Auto-generated method stub
		return a1;
	}
	
	public Color getTaustavari() {
		Random r = new Random();
		 int[] vari ={get(2)+ (r.nextInt(get(3)+1) -(get(3)/2)), get(4) + ((r.nextInt(get(5)+1)-get(5)/2)), get(6) + ((r.nextInt(get(7)+1)-get(7)/2))};
		 for (int i =0; i <3; i++) {
			 if (vari[i] < 0) {vari[i] = 0;}
			 if (vari[i] > 255) {vari[i] = 255;}	 
		 }
	//	 System.out.println(vari[0] + " " + vari[1] + " " + vari[2]);
		 return new Color (vari[0], vari[1], vari[2]);
	}
}
