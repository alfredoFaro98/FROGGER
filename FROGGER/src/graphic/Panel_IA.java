package graphic;

import java.awt.Color;

import javax.swing.JPanel;

import listener.MenuListener;

public class Panel_IA extends JPanel{
	public Panel_IA() {
		this.setBackground(Color.black);
		this.addKeyListener(new MenuListener());
	}
}
