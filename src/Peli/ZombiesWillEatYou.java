package Peli;

import java.applet.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.Timer;


@SuppressWarnings("serial")
public class ZombiesWillEatYou extends Applet implements KeyListener, ActionListener {

  int screenWidth;
  int screenHeight;

  Timer timer;

  Image ammus;
  Image scarlett;
  
  private int zombienAlkuX;
  private int zombienAlkuY;
  
  private int ihmistenAlkuX;
  private int ihmistenAlkuY;
  
  int zombejaAlussa = 1;
  int ihmisiaAlussa = 100;
  
  ArrayList<Zombi> zombit = new ArrayList<Zombi>();
  ArrayList<Ihminen> ihmiset = new ArrayList<Ihminen>();

  Image backbuffer;
  Graphics backGraphics;

  int lastTimeWeWereInActionPerformed;

  int ammusX;

  boolean aDown;

  public void init() {
    timer = new Timer(15, this);
    timer.start();

    scarlett       = getImage(getCodeBase(), "images.jpg");

    screenWidth  = 300; //1100;
    screenHeight = 200; //600;

    setSize(screenWidth, screenHeight);
    setBackground(Color.black);
    
    zombienAlkuX = (screenWidth/3);
    zombienAlkuY = (screenHeight/2);
    
    ihmistenAlkuX = (2*screenWidth/3);
    ihmistenAlkuY = (screenHeight/2);
    
    luoZombit();

    backbuffer = createImage(screenWidth, screenHeight);
    backGraphics = backbuffer.getGraphics();

    addKeyListener(this);
  }


  	private void luoZombit() {
  	//Random r = new Random();
		for (int i = 0; i<zombejaAlussa; i++) {
			zombit.add(new Zombi(this));
		}
		for (int i = 0; i<ihmisiaAlussa; i++) {
			ihmiset.add(new Ihminen(this));
		}
  	}


public void update(Graphics g) {
    backGraphics.setColor(Color.black);
    backGraphics.fillRect(0, 0, screenWidth, screenHeight);
    
    for(Ihminen ihminen : ihmiset) {
    	backGraphics.drawImage(ihminen.getImage(), ihminen.getX(), ihminen.getY(), this);
    }
    for (Zombi zombi : zombit) {
    	backGraphics.drawImage(zombi.getImage(), zombi.getX(), zombi.getY(), this);
    }
    
    backGraphics.drawImage(scarlett, 400, 50, this);
    backGraphics.drawImage(ammus, ammusX, 50, this);

    g.drawImage(backbuffer, 0, 0, this);
  }

  public void paint(Graphics g) {
    update(g);
  }


  public void actionPerformed(ActionEvent e) {

    for (Zombi z : zombit) {
    	z.liiku();
    	z.pidaRuudulla(screenWidth, screenHeight);
    }
    for(Ihminen z : ihmiset) {
    	z.liiku();
    	z.pidaRuudulla(screenWidth, screenHeight);
    }
    for (Zombi z : zombit) {
    	for (Ihminen ih: ihmiset) {
    		if (ih.onkoSisalla(z)) {
    			ih.kuole();
    		}
    	}
    }

    repaint();
  }


  public void keyTyped(KeyEvent evt) {}

  public void keyPressed(KeyEvent evt) {
    char c = evt.getKeyChar();
    if (c == 'a') aDown = true;
  }
  public void keyReleased(KeyEvent evt) {
    char c = evt.getKeyChar();
    if (c == 'a') aDown = false;
  }

	public int getZombienAlkuX() {
		return zombienAlkuX;
	}
	
	public int getZombienAlkuY() {
		return zombienAlkuY;
	}
	public int getIhmistenAlkuX() {
		return ihmistenAlkuX;
	}
	
	public int getIhmistenAlkuY() {
		return ihmistenAlkuY;
	}
}
