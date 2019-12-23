package thread;

import config.Impostazioni;
import logic.GestoreLogica;

public class CalcolatorePartita implements Runnable{

	GestoreLogica g;
	
	public CalcolatorePartita(GestoreLogica g) {
		this.g = g;
	}
	@Override
	public void run() {
		while(true) {
			if(g.collisioneConNemico())
			{
				this.g.vite--;
				this.g.rana.setX(Impostazioni.SIZE_TILES*4);
				this.g.rana.setY(Impostazioni.SIZE_TILES*12);
				if(this.g.vite == 0)
					this.g.inGioco = false;
			}
			if(g.collisioneConBuco() && g.inGioco)
			{
				if(this.g.arrivate.size() == Impostazioni.OBIETTIVO)
					this.g.vinto = true;
				else
					this.g.rana.setX(Impostazioni.SIZE_TILES*4);
					this.g.rana.setY(Impostazioni.SIZE_TILES*12);
			}
			try {
				Thread.sleep(Impostazioni.FPS_CALCOLATORE_PARTITA);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
