package graphic;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import config.Impostazioni;
import listener.MenuListener;
import logic.GestoreMenu;
import main.Main;

public class PanelMenu extends JPanel implements Runnable{
	
	ArrayList<JLabel>labels;
	public GestoreMenu gestoreMenu;
	
	public PanelMenu() {
		
		labels = new ArrayList<JLabel>();
		gestoreMenu = new GestoreMenu();
		this.setLayout(new GridLayout(8,3));
		this.setFocusable(true);
		this.setBackground(Color.GREEN);
		this.gestisciLabel();
		this.addKeyListener(new MenuListener());
		new Thread(this).start();		
	}
	
	public void gestisciLabel() {
		for(int i = 0; i<24; i++) {
			labels.add(new JLabel());
			if(i == 1) {
				this.labels.get(labels.size()-1).setIcon(new ImageIcon(Main.immagini.getTitolo()));
			}
			else if(i == 4) {
				this.labels.get(labels.size()-1).setIcon(new ImageIcon(Main.immagini.getBottoniMenu().get(0)));
				this.labels.get(labels.size()-1).addMouseListener(new MenuListener(0,this.labels.get(labels.size()-1)));
			}
			else if(i == 7) {
				this.labels.get(labels.size()-1).setIcon(new ImageIcon(Main.immagini.getBottoniMenu().get(1)));
				this.labels.get(labels.size()-1).addMouseListener(new MenuListener(1,this.labels.get(labels.size()-1)));
			}
			else if(i == 10) {
				this.labels.get(labels.size()-1).setIcon(new ImageIcon(Main.immagini.getBottoniMenu().get(2)));
				this.labels.get(labels.size()-1).addMouseListener(new MenuListener(2,this.labels.get(labels.size()-1)));
			}
			this.add(labels.get(labels.size()-1));
		}
	}
	
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		this.disegnaSfondo(g);
		this.disegnaFrog(g);
	}
	
	private void disegnaFrog(Graphics g) {
		g.drawImage(Main.immagini.getFrogAnimation().get(gestoreMenu.rana.getImgCorr()), gestoreMenu.rana.getX(), gestoreMenu.rana.getY(), null);
	}
	
	private void disegnaSfondo(Graphics g)
	{
		g.drawImage(Main.immagini.getSfondoMenu(), Impostazioni.TRASCURABILE, Impostazioni.TRASCURABILE, null);
	}

	@Override
	public void run() {
		while(true) {
			this.repaint();
			try {
				Thread.sleep(Impostazioni.FPS_MENU);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
}
