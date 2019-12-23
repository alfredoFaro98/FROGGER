package logic;

import java.util.ArrayList;

import config.Impostazioni;
import logicAlternative.Personaggio;
import thread.CalcolatorePartita;

public class GestoreLogica implements Runnable{
	
	//cose da fare:
	//1. aggiustare la velocita dei vari elementi in movimento ---> forse per questo ci sarà bisogno di un'aòtra modellazione a LIVELLO LOGICO affinche si possano applicare delle tecniche di spostamento diverse e migliori da un punto di vista grafico.
	//1.1 considerare4 che ogni riga deve spostarsi leggermente a veloctà di versa da un'altra riga superiore o inferiore
	//2. definire un tipo diverso di classi per DLV
	
	public Personaggio rana;			
	public int [][] matrix;
	public boolean inGioco = true;
	public boolean vinto = false;
	public int raneArrivate = 0;
	public ArrayList<Pair> arrivate;
	public int vite = Impostazioni.VITE;
	
	public GestoreLogica() {
		
		matrix = new int[Impostazioni.ROWS][Impostazioni.COLS];
		this.init();
//		this.stampaMatrice();
		rana = new Personaggio(Impostazioni.SIZE_TILES, Impostazioni.SIZE_TILES, Impostazioni.SIZE_TILES*5, Impostazioni.SIZE_TILES*12, 1*Impostazioni.SIZE_TILES, Impostazioni.SOPRA);
		this.creaPersonaggi();
		new Thread(this).start();
		new Thread(new CalcolatorePartita(this)).start();
		arrivate = new ArrayList<Pair>();
	}
	
	private void init() {
		for(int i = 0; i<Impostazioni.ROWS; i++)
		{
			for(int j = 0; j<Impostazioni.COLS; j++) 
			{
				if(i == 0) {
					if(j % 2 == 0) 
						this.matrix[i][j] = Impostazioni.ROCK;
					else 
						this.matrix[i][j] = Impostazioni.BUCO;
				}
				else if(i>0 && i<=5) {
					this.matrix[i][j] = Impostazioni.ACQUA;
				}
				else if(i == 6) {
					this.matrix[i][j] = Impostazioni.SAFEZONE;
				}
				else if(i >= 7 && i<=11) {
					this.matrix[i][j] = Impostazioni.STRADA;					
				}
				else if(i == 12) {
					this.matrix[i][j] = Impostazioni.SAFEZONE;
				}				
			}
		}
	}
	
	public void creaPersonaggi() {
		this.creaPersonaggi_11();
		this.creaPersonaggi_9();
		this.creaPersonaggi_10();	
		this.creaPersonaggi_8();	
		this.creaPersonaggi_7();
		this.creaTartarughe(5);
		this.creaTartarughe(1);
		this.creaTartarughe(3);
		this.creaPersonaggi_2();
		this.creaPersonaggi_4();
	}
	
	private void creaPersonaggi_2()
	{
		for(int j = 0; j< Impostazioni.COLS; j++) {
			if(j%2 == 0) {
				this.matrix[2][j] = Impostazioni.TRONCO;
			}
		}
		this.matrix[2][1] = Impostazioni.TRONCO;
	}
	
	private void creaPersonaggi_4() {
		
		this.matrix[4][0] = Impostazioni.TRONCO;
		this.matrix[4][1] = Impostazioni.TRONCO;
		this.matrix[4][4] = Impostazioni.TRONCO;
		this.matrix[4][5] = Impostazioni.TRONCO;
		this.matrix[4][6] = Impostazioni.TRONCO;
		this.matrix[4][9] = Impostazioni.TRONCO;
		this.matrix[4][8] = Impostazioni.TRONCO;
	}
	private void creaTartarughe(int riga) {
		for(int j = 0; j< Impostazioni.COLS; j++) {
			if(j%3 != 0)
				this.matrix[riga][j] = Impostazioni.TARTARUGHE;
		}
		matrix[riga][0] = Impostazioni.TARTARUGHE;
	}
	
	
	private void creaPersonaggi_8() {
		for(int j = 0; j< Impostazioni.COLS; j++) {
			if(j%5 == 0)
				this.matrix[8][j] = Impostazioni.AUTO;
		}
//		this.matrix[8][1] = Impostazioni.AUTO;
//		this.matrix[8][6] = Impostazioni.AUTO;
//		this.matrix[8][7] = Impostazioni.AUTO;
		
	}
	
	private void creaPersonaggi_7() {
		for(int i = 0; i<Impostazioni.COLS; i++) {
			if(i%4 == 0) {
				this.matrix[7][i] = Impostazioni.CAMION;
			}
		}
//		this.matrix[7][5] = Impostazioni.CAMION;
	}
	
	
	private void creaPersonaggi_9() {
		for(int j = 0; j< Impostazioni.COLS; j++) {
			if(j%5 == 0)
				this.matrix[9][j] = Impostazioni.AUTO;
		}
//		this.matrix[9][1] = Impostazioni.AUTO;
//		this.matrix[9][6] = Impostazioni.AUTO;
//		this.matrix[9][7] = Impostazioni.AUTO;
		
	}
	
	private void creaPersonaggi_11() {
		for(int j = 0; j< Impostazioni.COLS; j++) {
			if(j%4 == 0)
				this.matrix[11][j] = Impostazioni.AUTO;
		}
	}
	
	private void creaPersonaggi_10() {
		for(int j = 0; j< Impostazioni.COLS; j++) {
			if(j%4 == 0)
				this.matrix[10][j] = Impostazioni.AUTO;
		}
//		this.matrix[10][1] = Impostazioni.AUTO;
//		this.matrix[10][7] = Impostazioni.AUTO;

	}
	
	public void aggiornaPersonaggiDestra(int riga) {
		int temp = matrix[riga][Impostazioni.COLS-1];
		
		if(matrix[rana.getY()/Impostazioni.SIZE_TILES][rana.getX()/Impostazioni.SIZE_TILES] == Impostazioni.TARTARUGHE 
				|| matrix[rana.getY()/Impostazioni.SIZE_TILES][rana.getX()/Impostazioni.SIZE_TILES] == Impostazioni.TRONCO)
		{
			if(rana.getY()/Impostazioni.SIZE_TILES == riga && rana.getX()/Impostazioni.SIZE_TILES == Impostazioni.COLS-1) {
				vite--;
				rana.setX(Impostazioni.SIZE_TILES*4);
				rana.setY(Impostazioni.SIZE_TILES*12);
				if(this.vite == 0)
					this.inGioco = false;
			}
		}
		
		
		for(int j = Impostazioni.COLS-1; j > 0; j--) 
		{
			if(rana.getY()/Impostazioni.SIZE_TILES == riga)
			{
				if(rana.getX()/Impostazioni.SIZE_TILES == j-1 && (matrix[rana.getY()/Impostazioni.SIZE_TILES][rana.getX()/Impostazioni.SIZE_TILES] == Impostazioni.TARTARUGHE 
						|| matrix[rana.getY()/Impostazioni.SIZE_TILES][rana.getX()/Impostazioni.SIZE_TILES] == Impostazioni.TRONCO))
					rana.setX(j*Impostazioni.SIZE_TILES);
				matrix[riga][j] = matrix[riga][j-1];
			}
			else
				matrix[riga][j] = matrix[riga][j-1];
		}
		matrix[riga][0] = temp;
	}
	
	
	public  void aggiornaPersonaggiSinistra(int riga) {
		int temp = matrix[riga][0];
		
//	devo effettuare lo spostamento della rana solo se è su un cavalcabile
		if(matrix[rana.getY()/Impostazioni.SIZE_TILES][rana.getX()/Impostazioni.SIZE_TILES] == Impostazioni.TARTARUGHE 
				|| matrix[rana.getY()/Impostazioni.SIZE_TILES][rana.getX()/Impostazioni.SIZE_TILES] == Impostazioni.TRONCO)
		{
			if(rana.getY()/Impostazioni.SIZE_TILES == riga && rana.getX()/Impostazioni.SIZE_TILES == 0) {
				vite--;
				rana.setX(Impostazioni.SIZE_TILES*4);
				rana.setY(Impostazioni.SIZE_TILES*12);
				if(this.vite == 0)
					this.inGioco = false;
			}
		}
		
		
		for(int j = 0; j < Impostazioni.COLS-1 ; j++) 
		{
			if(rana.getY()/Impostazioni.SIZE_TILES == riga) //se la rana è su questa riga che sto aggiornando e non è gia morta
			{
				/*mi basta controllare la colonna perchè la riga già è stata controllata e constata se sono qui dentro*/
				if(rana.getX()/Impostazioni.SIZE_TILES == j+1 && (matrix[rana.getY()/Impostazioni.SIZE_TILES][rana.getX()/Impostazioni.SIZE_TILES] == Impostazioni.TARTARUGHE 
						|| matrix[rana.getY()/Impostazioni.SIZE_TILES][rana.getX()/Impostazioni.SIZE_TILES] == Impostazioni.TRONCO))
					rana.setX(j*Impostazioni.SIZE_TILES);
				matrix[riga][j] = matrix[riga][j+1];
			}
			else											//altrimenti non faccio nulla e continuo semplicemente le operazioni di spostamento
				matrix[riga][j] = matrix[riga][j+1];
		}
		matrix[riga][Impostazioni.COLS-1] = temp;
		
		
	}
	
	
	private void stampaMatrice() {
		for(int i = 0; i<Impostazioni.ROWS; i++) {
			for(int j = 0; j<Impostazioni.COLS; j++) {
				System.out.print(this.matrix[i][j]);
			}
			System.out.println();
		}
	}
	
	public boolean collisioneConNemico() {
		if(
		   (this.matrix[rana.getY()/Impostazioni.SIZE_TILES][rana.getX()/Impostazioni.SIZE_TILES] == Impostazioni.STRADA) || 
		   (this.matrix[rana.getY()/Impostazioni.SIZE_TILES][rana.getX()/Impostazioni.SIZE_TILES] == Impostazioni.TRONCO) ||
		   (this.matrix[rana.getY()/Impostazioni.SIZE_TILES][rana.getX()/Impostazioni.SIZE_TILES] == Impostazioni.SAFEZONE) ||
		   (this.matrix[rana.getY()/Impostazioni.SIZE_TILES][rana.getX()/Impostazioni.SIZE_TILES] == Impostazioni.BUCO) ||
		   (this.matrix[rana.getY()/Impostazioni.SIZE_TILES][rana.getX()/Impostazioni.SIZE_TILES] == Impostazioni.TARTARUGHE)
		  )
			return false;
		return true;
	}
	
	public boolean collisioneConBuco() {
		if(this.matrix[rana.getY()/Impostazioni.SIZE_TILES][rana.getX()/Impostazioni.SIZE_TILES] == Impostazioni.BUCO) {
			arrivate.add(new Pair(rana.getY()/Impostazioni.SIZE_TILES,rana.getX()/Impostazioni.SIZE_TILES));
			this.matrix[rana.getY()/Impostazioni.SIZE_TILES][rana.getX()/Impostazioni.SIZE_TILES] = Impostazioni.RANA;
			return true;
		}
		return false;
	}
	

	@Override
	public void run() {
		while(true) {
			this.aggiornaPersonaggiDestra(11);
			this.aggiornaPersonaggiDestra(9);
			this.aggiornaPersonaggiSinistra(10);
			this.aggiornaPersonaggiSinistra(8);
			this.aggiornaPersonaggiDestra(7);
			this.aggiornaPersonaggiSinistra(5);
			this.aggiornaPersonaggiDestra(1);
			this.aggiornaPersonaggiSinistra(3);
			this.aggiornaPersonaggiDestra(2);
			this.aggiornaPersonaggiSinistra(4);
			
			try {
				Thread.sleep(Impostazioni.FPS_GESTORELOGICA);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	
	
	
	
	
	
}
