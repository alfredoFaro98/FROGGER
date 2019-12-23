package graphic;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import config.Impostazioni;
import listener.GameListener;
import main.Main;

public class PanelCredits extends JPanel{
	
	
	protected ArrayList<JLabel> labels;
	
	public PanelCredits() {
		this.setBackground(Color.green);
		this.addKeyListener(new GameListener());
		this.gestisciLabels();
	}

	public void gestisciLabels()
	{
		labels = new ArrayList<JLabel>();
		this.setLayout(new GridLayout(Impostazioni.ROWS_CREDITS,Impostazioni.COLS_CREDITS));
		labels.add(new JLabel(new ImageIcon(Main.immagini.getLogo())));
		JLabel uno = new JLabel("Created by: Erica Coppolillo e Alfredo Farò", JLabel.CENTER);
		uno.setFont(new Font("Courier New", Font.ITALIC, 30));
		labels.add(uno);
		JLabel due = new JLabel("Powered by: Francesco Calimeri e Simona Perri", JLabel.CENTER);
		labels.add(due);
		due.setFont(new Font("Courier New", Font.ITALIC, 30));
		
		for(int i = 0; i<labels.size(); i++)
		{
			this.add(labels.get(i));
		}
			
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		this.disegnaSfondo(g);
	}
	
	private void disegnaSfondo(Graphics g)
	{
		g.drawImage(Main.immagini.getSfondoCredits(),Impostazioni.TRASCURABILE, Impostazioni.TRASCURABILE, null);
	}
}
