package config;

public class Impostazioni {
	

	//impostazioni grafiche delle mattonelle
	public final static int SIZE_TILES = 70;
	
	//impostazioni della logica
	public final static int ROWS = 13;
	public final static int COLS = 10;
	public final static int FROG_JUMP = 1;
	public final static int OBIETTIVO = 5;
	public static final int VITE = 3;


	//impostazioni grafica
	public final static int HEIGHT_MENU = 1000;
	public final static int WIDHT_MENU = 900;
	public final static int N_LABEL_MENU = 12;
	public final static int N_BUTTONS_MENU = 3;
	public final static int WIDHT_PLAY = SIZE_TILES*COLS + 5;
	public final static int HEIGHT_PLAY = SIZE_TILES*ROWS + 85;
	public final static int ROWS_CREDITS = 3;
	public final static int COLS_CREDITS = 1;
	
	//impostazioni grafica dei personaggi
	public final static int FROG_DIMENSION = 1; //QUESTA  VA MODIFICATA
	public static final int IMGS_PERSONAGGIO = 10;
	
	//impostazioni direzione
	public final static int SOPRA = 0;
	public final static int DESTRA = 1;
	public final static int SINISTRA = 2;
	public final static int SOTTO = 3;
	public final static int NESSUNA = 4;

	//impostazioni numeriche dei valori che rispecchiano i vari personaggi del gioco
	public final static int SAFEZONE = 0;
	public final static int STRADA = 1;
	public final static int ACQUA = 2;
	public final static int TARTARUGHE = 3;
	public final static int AUTO = 4;
	public final static int TRONCO = 5;
	public final static int CAMION = 6;
	public final static int BUCO = 7;
	public final static int ROCK = 8;
	public final static int RANA = -1;
	public final static int COCCODRILLO = 9;
	
	//impostazioni FPS
	public static final int FPS_GESTORELOGICA = 1200;
	public static final int FPS_CALCOLATORE_PARTITA = 10;
	public static final int FPS_PERSONAGGIO = 10;
	public static final int FPS_MENU = 200;
	
	//dato di riserva
	public final static int TRASCURABILE = 0;
	
	//ulteriori dati
	public final static int NUMERO_LIVELLI = 3;

	public static final int WIDTH_CHOOSELIVEL = 900;
	public static final int HEIGHT_CHOOSELIVEL = 1000;

	public static final int ROWSGRIDLEVELS = 9;

	public static int COLSGRIDLEVELS = 3;
		

}
