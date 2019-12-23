package logic;

import config.Impostazioni;
import logicAlternative.Personaggio;

public class GestoreMenu {
	
	public Personaggio rana;
	
	public GestoreMenu() {
		rana = new Personaggio(Impostazioni.TRASCURABILE, Impostazioni.TRASCURABILE, Impostazioni.WIDHT_MENU/4, Impostazioni.HEIGHT_MENU/2, 10, Impostazioni.NESSUNA);
	}
}
