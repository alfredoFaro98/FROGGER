package main;

import javax.swing.JFrame;

import config.GestoreImmagini;
import config.Impostazioni;
import graphic.PanelChooseLivel;

public class MainDiprova {
	public static GestoreImmagini immagini = new GestoreImmagini();


	public static void main(String[] args) {
		
		JFrame f = new JFrame();
		f.add(new PanelChooseLivel());
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(Impostazioni.WIDTH_CHOOSELIVEL, Impostazioni.HEIGHT_CHOOSELIVEL);
	}
}
