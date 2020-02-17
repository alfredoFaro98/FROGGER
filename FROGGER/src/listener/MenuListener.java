package listener;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import config.Impostazioni;
import graphic.PanelChooseLivel;
import graphic.PanelCredits;
import graphic.PanelPlay;
import graphic.Panel_IA;
import main.Main;

public class MenuListener extends KeyAdapter implements MouseListener {

	private int sorgente;
	private JLabel labelCorrente;
	
	public MenuListener() {}
	
	public MenuListener(int i, JLabel label) {
		sorgente = i;
		labelCorrente = label;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {}

	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}

	@Override
	public void mousePressed(MouseEvent e) {
		
		switch(sorgente)
		{
		case 0:
			Main.contenitore.removeAll();
			PanelChooseLivel scelta = new PanelChooseLivel();
			Main.gameFrame.setSize(Impostazioni.WIDHT_PLAY, Impostazioni.HEIGHT_PLAY);
			Main.contenitore.add(scelta);
			Main.contenitore.revalidate();
			Main.contenitore.repaint();
			scelta.requestFocus();
			break;
			
		case 1:
			Main.contenitore.removeAll();
			Panel_IA ia = new Panel_IA();
			Main.gameFrame.setSize(Impostazioni.WIDHT_PLAY, Impostazioni.HEIGHT_PLAY);
			Main.contenitore.add(ia);
			Main.contenitore.revalidate();
			Main.contenitore.repaint();
			ia.requestFocus();
			break;
			
		case 2:
			Main.contenitore.removeAll();
			PanelCredits n = new PanelCredits();
			Main.contenitore.add(n);
			Main.contenitore.revalidate();
			Main.contenitore.repaint();
			n.requestFocus(); //potrebbe essere inutile
			break;
			
		
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_ESCAPE)
			System.exit(0);
	}

	@Override
	public void keyReleased(KeyEvent arg0) {}

	@Override
	public void keyTyped(KeyEvent arg0) {}
}
