package graphic;

import java.awt.BorderLayout;
import java.awt.Graphics;

import javax.swing.JPanel;

public class PanelContenitore extends JPanel {
	
	public PanelContenitore() {
		this.setLayout(new BorderLayout());
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
	}
}
