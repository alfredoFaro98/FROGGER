package listener;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import config.Impostazioni;
import graphic.PanelChooseLivel;
import graphic.PanelMenu;
import graphic.PanelPlay;
import main.Main;

public class GameListener implements KeyListener{

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == e.VK_ESCAPE) {
			Main.contenitore.removeAll();
			PanelChooseLivel scelta = new PanelChooseLivel();
			Main.gameFrame.setSize(Impostazioni.WIDHT_PLAY, Impostazioni.HEIGHT_PLAY);
			Main.contenitore.add(scelta);
			Main.contenitore.revalidate();
			Main.contenitore.repaint();
			scelta.requestFocus();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
