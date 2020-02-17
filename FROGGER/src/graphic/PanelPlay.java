package graphic;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import config.Impostazioni;
import listener.GameListener;
import listener.MenuListener;
import listener.FrogMovementListener;
import logic.GestoreLogica;
import main.Main;

public class PanelPlay extends JPanel implements Runnable{
	
	GestoreLogica gestoreLogica;
	
	public PanelPlay(int livello) {
		this.setFocusable(true);
		this.setBackground(Color.black);
		gestoreLogica = new GestoreLogica(livello); 
//		this.addKeyListener(new FrogMovementListener(this.gestoreLogica.rana, this.gestoreLogica)); //commento questa parte perchè cosi erica puo iniziare a ragionare sul progetto
		new Thread(this).start();
		this.addKeyListener(new GameListener());
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		this.disegnaSfondoNero(g);
		this.disegnaMappa(g);
		this.disegnaRana(g);
		this.disegnaGameOver(g);
		this.disegnaVictory(g);
		this.disegnaCuori(g);
	}
	
	public void disegnaMappa(Graphics g) {
		
		for(int i = 0; i<Impostazioni.ROWS; i++)
		{
			for(int j = 0; j<Impostazioni.COLS; j++)
			{
				if(gestoreLogica.matrix[i][j] == Impostazioni.SNAKE_TAIL)
				{	
					g.drawImage(Main.immagini.getSafezone(), j*Impostazioni.SIZE_TILES, i*Impostazioni.SIZE_TILES,Impostazioni.SIZE_TILES,Impostazioni.SIZE_TILES, null);
					g.drawImage(Main.immagini.getSnake().get(0), j*Impostazioni.SIZE_TILES, i*Impostazioni.SIZE_TILES,Impostazioni.SIZE_TILES,Impostazioni.SIZE_TILES, null);
				}
				else if(gestoreLogica.matrix[i][j] == Impostazioni.SNAKE_HEAD)
				{	
					g.drawImage(Main.immagini.getSafezone(), j*Impostazioni.SIZE_TILES, i*Impostazioni.SIZE_TILES,Impostazioni.SIZE_TILES,Impostazioni.SIZE_TILES, null);
					g.drawImage(Main.immagini.getSnake().get(1), j*Impostazioni.SIZE_TILES, i*Impostazioni.SIZE_TILES,Impostazioni.SIZE_TILES,Impostazioni.SIZE_TILES, null);
				}
				else if(gestoreLogica.matrix[i][j] == Impostazioni.COCCODRILLO)
				{
					if(i == 1 || i == 2)
					{
						g.drawImage(Main.immagini.getWater(), j*Impostazioni.SIZE_TILES, i*Impostazioni.SIZE_TILES,Impostazioni.SIZE_TILES,Impostazioni.SIZE_TILES, null);
						g.drawImage(Main.immagini.getCroco().get(1), j*Impostazioni.SIZE_TILES, i*Impostazioni.SIZE_TILES,Impostazioni.SIZE_TILES,Impostazioni.SIZE_TILES, null);
					}
					else
					{
						g.drawImage(Main.immagini.getWater(), j*Impostazioni.SIZE_TILES, i*Impostazioni.SIZE_TILES,Impostazioni.SIZE_TILES,Impostazioni.SIZE_TILES, null);
						g.drawImage(Main.immagini.getCroco().get(0), j*Impostazioni.SIZE_TILES, i*Impostazioni.SIZE_TILES,Impostazioni.SIZE_TILES,Impostazioni.SIZE_TILES, null);
					}
				}
				else if(gestoreLogica.matrix[i][j] == Impostazioni.RANA) 
				{
					g.drawImage(Main.immagini.getFrog(), /*j*Impostazioni.SIZE_TILES, i*Impostazioni.SIZE_TILES*/j*Impostazioni.SIZE_TILES,i*50,Impostazioni.SIZE_TILES,Impostazioni.SIZE_TILES, null);
				}
				else if(gestoreLogica.matrix[i][j] == Impostazioni.ACQUA)
				{
					g.drawImage(Main.immagini.getWater(), j*Impostazioni.SIZE_TILES, i*Impostazioni.SIZE_TILES,Impostazioni.SIZE_TILES,Impostazioni.SIZE_TILES, null);
				}
				else if(gestoreLogica.matrix[i][j] == Impostazioni.STRADA)
				{
					g.drawImage(Main.immagini.getStreet(), j*Impostazioni.SIZE_TILES, i*Impostazioni.SIZE_TILES,Impostazioni.SIZE_TILES,Impostazioni.SIZE_TILES, null);
				}
				else if(gestoreLogica.matrix[i][j] == Impostazioni.SAFEZONE)
				{
					g.drawImage(Main.immagini.getSafezone(), j*Impostazioni.SIZE_TILES, i*Impostazioni.SIZE_TILES,Impostazioni.SIZE_TILES,Impostazioni.SIZE_TILES, null);
				}
				else if(gestoreLogica.matrix[i][j] == Impostazioni.ROCK) 
				{
					g.drawImage(Main.immagini.getRock(), j*Impostazioni.SIZE_TILES, i*Impostazioni.SIZE_TILES,Impostazioni.SIZE_TILES,Impostazioni.SIZE_TILES, null);
				}
				else if(gestoreLogica.matrix[i][j] == Impostazioni.AUTO)
				{
					if(i == 10 || i == 8) 
					{
						g.drawImage(Main.immagini.getStreet(), j*Impostazioni.SIZE_TILES, i*Impostazioni.SIZE_TILES,Impostazioni.SIZE_TILES,Impostazioni.SIZE_TILES, null);
						g.drawImage(Main.immagini.getCar2(), j*Impostazioni.SIZE_TILES, i*Impostazioni.SIZE_TILES,Impostazioni.SIZE_TILES,Impostazioni.SIZE_TILES, null);
					}
					else if(i == 11 || i == 9)
					{
						g.drawImage(Main.immagini.getStreet(), j*Impostazioni.SIZE_TILES, i*Impostazioni.SIZE_TILES,Impostazioni.SIZE_TILES,Impostazioni.SIZE_TILES, null);
						g.drawImage(Main.immagini.getCar(), j*Impostazioni.SIZE_TILES, i*Impostazioni.SIZE_TILES,Impostazioni.SIZE_TILES,Impostazioni.SIZE_TILES, null);
					
					}
				}
				else if(gestoreLogica.matrix[i][j] == Impostazioni.CAMION) 
				{
					g.drawImage(Main.immagini.getStreet(), j*Impostazioni.SIZE_TILES, i*Impostazioni.SIZE_TILES,Impostazioni.SIZE_TILES,Impostazioni.SIZE_TILES, null);
					g.drawImage(Main.immagini.getCamion(), j*Impostazioni.SIZE_TILES, i*Impostazioni.SIZE_TILES,Impostazioni.SIZE_TILES,Impostazioni.SIZE_TILES, null);	
				}
				else if(gestoreLogica.matrix[i][j] == Impostazioni.TARTARUGHE)
				{
					g.drawImage(Main.immagini.getWater(), j*Impostazioni.SIZE_TILES, i*Impostazioni.SIZE_TILES,Impostazioni.SIZE_TILES,Impostazioni.SIZE_TILES, null);
					if(i == 1)
						g.drawImage(Main.immagini.getTurtleReverse(), j*Impostazioni.SIZE_TILES, i*Impostazioni.SIZE_TILES,Impostazioni.SIZE_TILES,Impostazioni.SIZE_TILES, null);	
					else
						g.drawImage(Main.immagini.getTurtle(), j*Impostazioni.SIZE_TILES, i*Impostazioni.SIZE_TILES,Impostazioni.SIZE_TILES,Impostazioni.SIZE_TILES, null);	
				}
				else if(gestoreLogica.matrix[i][j] == Impostazioni.TRONCO)
				{
					g.drawImage(Main.immagini.getWater(), j*Impostazioni.SIZE_TILES, i*Impostazioni.SIZE_TILES,Impostazioni.SIZE_TILES,Impostazioni.SIZE_TILES, null);
					g.drawImage(Main.immagini.getTronco(), j*Impostazioni.SIZE_TILES, i*Impostazioni.SIZE_TILES,Impostazioni.SIZE_TILES,Impostazioni.SIZE_TILES, null);
				}
			}
		}
	}
	
	public void disegnaRana(Graphics g) {
		g.drawImage(Main.immagini.getFrog(), this.gestoreLogica.rana.getX(), this.gestoreLogica.rana.getY(), this.gestoreLogica.rana.getWidth(), this.gestoreLogica.rana.getWidth(), null);
	}
	
	public void disegnaGameOver(Graphics g) {
		if(!this.gestoreLogica.inGioco && !this.gestoreLogica.vinto)
			g.drawImage(Main.immagini.getGameOver(), Impostazioni.WIDHT_PLAY/5,Impostazioni.HEIGHT_PLAY/3, null);
	}
	
	public void disegnaVictory(Graphics g) {
		if(this.gestoreLogica.vinto)
			g.drawImage(Main.immagini.getWin(), Impostazioni.WIDHT_PLAY/3,Impostazioni.HEIGHT_PLAY/3, null);
	}

	public void disegnaCuori(Graphics g) {
		for(int i = 0; i<this.gestoreLogica.vite; i++) {
			g.drawImage(Main.immagini.getHeart(),0+i*50, Impostazioni.HEIGHT_PLAY-85,50,40, null);
		}
	}
	
	public void disegnaSfondoNero(Graphics g) {
		g.drawImage(Main.immagini.getBlack(),0,0, null);
	}
	
	@Override
	public void run() {
		while(true) {
			this.repaint();
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	
}
