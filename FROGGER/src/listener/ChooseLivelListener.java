package listener;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;

import config.Impostazioni;
import graphic.PanelChooseLivel;
import graphic.PanelCredits;
import graphic.PanelMenu;
import graphic.PanelPlay;
import graphic.Panel_IA;
import main.Main;

public class ChooseLivelListener implements MouseListener, KeyListener {
	
	private int sorgente;
	private JLabel labelCorrente;
	
	public ChooseLivelListener(int i, JLabel label) {
		this.sorgente = i;
		this.labelCorrente = label;
	}
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		switch(sorgente)
		{
		case 0:
			Main.contenitore.removeAll();
			PanelPlay scelta = new PanelPlay(1);
			Main.gameFrame.setSize(Impostazioni.WIDHT_PLAY, Impostazioni.HEIGHT_PLAY);
			Main.contenitore.add(scelta);
			Main.contenitore.revalidate();
			Main.contenitore.repaint();
			scelta.requestFocus();
			break;
		case 1:
			Main.contenitore.removeAll();
			PanelPlay scelta2 = new PanelPlay(2);
			Main.gameFrame.setSize(Impostazioni.WIDHT_PLAY, Impostazioni.HEIGHT_PLAY);
			Main.contenitore.add(scelta2);
			Main.contenitore.revalidate();
			Main.contenitore.repaint();
			scelta2.requestFocus();
			break;
		case 2:
			Main.contenitore.removeAll();
			PanelPlay scelta3 = new PanelPlay(3);
			Main.gameFrame.setSize(Impostazioni.WIDHT_PLAY, Impostazioni.HEIGHT_PLAY);
			Main.contenitore.add(scelta3);
			Main.contenitore.revalidate();
			Main.contenitore.repaint();
			scelta3.requestFocus();
			break;
		}
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == e.VK_ESCAPE) {
			Main.contenitore.removeAll();
			PanelMenu scelta = new PanelMenu();
			Main.gameFrame.setSize(Impostazioni.WIDHT_MENU, Impostazioni.HEIGHT_MENU);
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
