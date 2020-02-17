package graphic;


import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import config.GestoreImmagini;
import config.Impostazioni;
import listener.ChooseLivelListener;
import listener.MenuListener;
import main.Main;
import main.MainDiprova;

public class PanelChooseLivel extends JPanel{

	public ArrayList<JLabel>labels;
	
	public PanelChooseLivel() {
		this.setBackground(Color.green);
		this.setLayout(new GridLayout(9,3)); //dovrebbero essere tre righe e una colonna--->qui potrei renderlo piu modulare
		this.createJLabels();
		this.addKeyListener(new ChooseLivelListener(0, null));
	}
	
	private void createJLabels()
	{
		labels = new ArrayList<JLabel>();
		for(int i = 1; i<=Impostazioni.NUMERO_LIVELLI; i++) //cosi mi creo le labels coi bottoni
		{
			this.labels.add(new JLabel());
			this.labels.get(this.labels.size()-1).setIcon(new ImageIcon(Main.immagini.getbuttonsLivel().get(i-1)));
			this.labels.get(this.labels.size()-1).addMouseListener(new ChooseLivelListener(i-1,this.labels.get(labels.size()-1)));
		}
		
		for(int i = 0; i<Impostazioni.ROWSGRIDLEVELS; i++)
		{
			for(int j = 0; j<Impostazioni.COLSGRIDLEVELS; j++)
			{
				if(i == 0 && j == 1) {	
					JLabel l = new JLabel();
					l.setIcon(new ImageIcon(Main.immagini.getChooseLivel()));
					this.add(l);
				}
				else if(i == 2 && j == 1)
				{
					this.add(labels.get(0));
				}
				else if(i == 4 && j == 1)
				{
					this.add(labels.get(1));
				}
				else if(i == 6 && j == 1)
				{
					this.add(labels.get(2));
				}
				else
				{
					this.add(new JLabel());
				}
			}
		}
	}
	
}
