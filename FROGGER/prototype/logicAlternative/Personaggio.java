package logicAlternative;

import config.Impostazioni;

public class Personaggio extends Elemento implements Runnable{
	
	
	protected int velocita;
	protected int direzione;
	protected int img_corr = 0;
	
	public Personaggio(int width, int height, int x, int y, int lunghezzaSalto, int direzione) {
		super(width, height, x, y);
		this.velocita = lunghezzaSalto;
		this.direzione = direzione;
		new Thread(this).start();
	}


	public int getVelocita() {
		return velocita;
	}


	public void setVelocita(int velocita) {
		this.velocita = velocita;
	}


	public int getDirezione() {
		return direzione;
	}


	public void setDirezione(int direzione) {
		this.direzione = direzione;
	}


	@Override
	public void run() {
		while(true)
		{
			this.img_corr++;
			if(this.img_corr == Impostazioni.IMGS_PERSONAGGIO)
				this.img_corr = 0;
			try {
				Thread.sleep(Impostazioni.FPS_PERSONAGGIO);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public int getImgCorr() {
		return this.img_corr;
	}
	
	public void goUp()
	{
		this.setDirezione(Impostazioni.SOPRA);
		this.setY(this.getY()-this.velocita);
	}
	
	public void goDown()
	{
		this.setDirezione(Impostazioni.SOTTO);
		this.setY(this.getY()+this.velocita);
	}
	
	public void goLeft()
	{
		this.setDirezione(Impostazioni.SINISTRA);
		this.setX(this.getX()-this.velocita);
	}
	
	public void goRight()
	{
		this.setDirezione(Impostazioni.DESTRA);
		this.setX(this.getX()+this.velocita);
	}
	
	
	
	
	
	




}
