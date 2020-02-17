package config;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class GestoreImmagini {
	
	private Image sfondo = null;
	private Image titolo = null;
	private ArrayList<Image>bottoniMenu = null;
	private Image water = null;
	private Image rock = null;
	private Image street = null;
	private Image frog = null;
	private Image safezone = null;
	private Image car = null;
	private Image car2 = null;
	private Image camion = null;
	private Image turtle = null;
	private Image turtleReverse = null;
	private Image tronco = null;
	private Image gameOver = null;
	private Image win = null;
	private Image heart = null;
	private Image black = null;
	private ArrayList<Image>frogAnimation = null;
	private Image sfondoCredits = null;
	private Image logo = null;
	private ArrayList<Image> buttonsLivel = null;
	private Image chooseLivel = null;
	private ArrayList<Image> croco = null;
	
	public GestoreImmagini() {
		
		this.caricaSfondoMenu();
		this.caricaTitolo();
		this.caricaBottoniMenu();
		this.caricaTilesets();
		this.caricaFrogAnimation();
		this.caricaButtonsLivel();
		this.loadChooseTitle();
		this.caricaCroco();
	}
	
	private void caricaCroco()
	{
		this.croco = new ArrayList<Image>();
		try {
			this.croco.add(ImageIO.read(new File("risorse" + File.separator + "crocoSx.png")));
			this.croco.add(ImageIO.read(new File("risorse" + File.separator + "crocoDx.png")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void caricaTitolo() {
		try {
			titolo = ImageIO.read(new File("risorse" + File.separator + "titolo.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public Image getTitolo() {return this.titolo;}
	
	private void loadChooseTitle() {
		try {
			this.chooseLivel = ImageIO.read(new File("risorse" + File.separator + "chooseLivel.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Image getChooseLivel() {
		return this.chooseLivel;
	}
	
	
	public void caricaSfondoMenu() {
		try {
			sfondo = ImageIO.read(new File("risorse" + File.separator + "sfondo.jpeg"));
			sfondoCredits = ImageIO.read(new File("risorse" + File.separator + "sfondoCredits.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public Image getSfondoMenu() {return sfondo;}
	public Image getSfondoCredits() {return sfondoCredits;}
	
	public void caricaBottoniMenu() {
		this.bottoniMenu = new ArrayList<Image>();
			try {
				this.bottoniMenu.add(ImageIO.read(new File("risorse" + File.separator + "buttonPlay.png")));
				this.bottoniMenu.add(ImageIO.read(new File("risorse" + File.separator + "buttonIA.png")));
				this.bottoniMenu.add(ImageIO.read(new File("risorse" + File.separator + "buttonCredits.png")));
			} catch (IOException e) {
				e.printStackTrace();
			}
			
	}
	
	public void caricaButtonsLivel() {
		this.buttonsLivel = new ArrayList<Image>();
		for(int i = 1; i<=Impostazioni.NUMERO_LIVELLI; i++)
		{
			try {
				this.buttonsLivel.add(ImageIO.read(new File("risorse" + File.separator + "button" +i+".png")));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public ArrayList<Image> getBottoniMenu(){return this.bottoniMenu;}
	
	public void caricaFrogAnimation()
	{
		frogAnimation = new ArrayList<Image>();
		for(int i = 0; i<Impostazioni.IMGS_PERSONAGGIO; i++)
		{
			try {
				this.frogAnimation.add(ImageIO.read(new File("risorse" + File.separator + "frogAnimation"+ File.separator +i+ ".png")));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public ArrayList<Image> getFrogAnimation(){	return this.frogAnimation;	}
	
	public void caricaTilesets() {
		try {
			this.rock = ImageIO.read(new File("risorse" + File.separator + "rock.png"));
			this.water = ImageIO.read(new File("risorse" + File.separator + "water.png"));
			this.street = ImageIO.read(new File("risorse" + File.separator + "street.png"));
			this.frog = ImageIO.read(new File("risorse" + File.separator + "frog.png"));
			this.safezone = ImageIO.read(new File("risorse" + File.separator + "safezone.jpg"));			
			this.car = ImageIO.read(new File("risorse" + File.separator + "car.png"));			
			this.car2 = ImageIO.read(new File("risorse" + File.separator + "car2.png"));
			this.camion = ImageIO.read(new File("risorse" + File.separator + "camion.png"));
			this.turtle = ImageIO.read(new File("risorse" + File.separator + "turtle.png"));
			this.turtleReverse = ImageIO.read(new File("risorse" + File.separator + "turtleReverse.png"));
			this.tronco = ImageIO.read(new File("risorse" + File.separator + "tronco.png"));
			this.gameOver = ImageIO.read(new File("risorse" + File.separator + "gameover.png"));
			this.win = ImageIO.read(new File("risorse" + File.separator + "win.png"));
			this.heart = ImageIO.read(new File("risorse" + File.separator + "heart.png"));
			this.black = ImageIO.read(new File("risorse" + File.separator + "black.jpg"));
			this.logo = ImageIO.read(new File("risorse" + File.separator + "logo.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Image> getCroco(){
		return this.croco;
	}
	
	public Image getStreet() {		return this.street; 	}
	public Image getRock() {		return this.rock; 	}
	public Image getWater() {		return this.water; 	} 
	public Image getFrog() {	return this.frog;	}
	public Image getSafezone() {	return this.safezone;	}
	public Image getCar() {		return this.car; 	}
	public Image getCar2() {		return this.car2; 	}
	public Image getCamion() { 	return this.camion; 	}
	public Image getTurtle() {	return this.turtle; }
	public Image getTurtleReverse() {	return this.turtleReverse;  }
	public Image getTronco() {	return this.tronco;	}
	public Image getGameOver() {	return this.gameOver; 	}
	public Image getWin() {		return this.win;	}
	public Image getHeart() {		return this.heart;	}
	public Image getBlack() {		return this.black;	}
	public Image getLogo() {		return this.logo;	}
	public ArrayList<Image> getbuttonsLivel(){ return this.buttonsLivel;	}
	
}
