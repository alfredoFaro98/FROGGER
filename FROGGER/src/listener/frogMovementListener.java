package listener;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import config.Impostazioni;
import logic.GestoreLogica;
import logicAlternative.Personaggio;

public class frogMovementListener implements KeyListener{
	
	Personaggio rana;
	GestoreLogica g;
	
	public frogMovementListener(Personaggio rana, GestoreLogica g) {
		this.rana = rana;
		this.g = g;
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		if(this.g.inGioco && !this.g.vinto) {
			if(e.getKeyCode() == KeyEvent.VK_UP) { 		
				if(rana.getY()/Impostazioni.SIZE_TILES>0) {
					rana.setDirezione(Impostazioni.SOPRA);	
					rana.setY(rana.getY()-rana.getVelocita());
				}
			}
			else if(e.getKeyCode() == KeyEvent.VK_DOWN) {
				if(rana.getY()/Impostazioni.SIZE_TILES<Impostazioni.ROWS-1) {
					rana.setDirezione(Impostazioni.SOTTO);	
					rana.setY(rana.getY()+rana.getVelocita());
				}
				
			}
			else if(e.getKeyCode() == KeyEvent.VK_LEFT) {
				if(rana.getX()/Impostazioni.SIZE_TILES > 0) {
					rana.setDirezione(Impostazioni.SINISTRA);	
					rana.setX(rana.getX()-rana.getVelocita());
				}
				
			}
			else if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
				if(rana.getX()/Impostazioni.SIZE_TILES < Impostazioni.COLS-1) {
					rana.setDirezione(Impostazioni.DESTRA);	
					rana.setX(rana.getX()+rana.getVelocita());
				}
			}

		}
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
