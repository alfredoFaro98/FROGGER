package main;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

import config.GestoreImmagini;
import config.Impostazioni;
import graphic.PanelContenitore;
import graphic.PanelMenu;
import graphic.Panel_IA;
import it.unical.mat.embasp.base.Handler;
import it.unical.mat.embasp.base.InputProgram;
import it.unical.mat.embasp.languages.asp.ASPInputProgram;
import it.unical.mat.embasp.platforms.desktop.DesktopHandler;
import it.unical.mat.embasp.specializations.dlv2.desktop.DLV2DesktopService;
import logicAlternative.Personaggio;



public class Main {
	
	public static PanelContenitore contenitore = new PanelContenitore();
	public static GestoreImmagini immagini = new GestoreImmagini();
	public static JFrame gameFrame = new JFrame();
	
	public static String encodingResource="encodings/froggerASP";
	
	public static Handler handler;
	
	public static void main(String[] args) {
		
		
		Dimension dim= Toolkit.getDefaultToolkit().getScreenSize();
		
		gameFrame.setVisible(true);
		gameFrame.add(contenitore);
		PanelMenu menu = new PanelMenu();
		contenitore.setFocusable(true);
		contenitore.add(menu);
		menu.requestFocus();
		gameFrame.setResizable(false);
		
		gameFrame.setSize(Impostazioni.WIDHT_MENU, Impostazioni.HEIGHT_MENU);
		gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}
}
