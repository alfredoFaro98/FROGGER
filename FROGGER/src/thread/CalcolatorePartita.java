package thread;

import config.Impostazioni;
import it.unical.mat.embasp.base.InputProgram;
import it.unical.mat.embasp.base.Output;
import it.unical.mat.embasp.languages.asp.ASPInputProgram;
import it.unical.mat.embasp.languages.asp.ASPMapper;
import it.unical.mat.embasp.languages.asp.AnswerSet;
import it.unical.mat.embasp.languages.asp.AnswerSets;
import it.unical.mat.embasp.platforms.desktop.DesktopHandler;
import it.unical.mat.embasp.specializations.dlv2.desktop.DLV2DesktopService;
import logic.GestoreLogica;
import logicAlternative.Aiutante;
import logicAlternative.Buco;
import logicAlternative.Destra;
import logicAlternative.Elemento;
import logicAlternative.Giu;
import logicAlternative.Personaggio;
import logicAlternative.Sinistra;
import logicAlternative.Su;
import main.Main;

public class CalcolatorePartita implements Runnable{

	GestoreLogica g;
	InputProgram facts;
	
	public CalcolatorePartita(GestoreLogica g) {
		this.g = g;
		Main.handler = new DesktopHandler(new DLV2DesktopService("../FROGGER/lib/dlv2-windows-64bit-nopython"));
		facts= new ASPInputProgram();
		InputProgram encoding= new ASPInputProgram();
		encoding.addFilesPath(Main.encodingResource);
		Main.handler.addProgram(encoding);
	}
	
	@Override
	public void run() {
		
		try {
			ASPMapper.getInstance().registerClass(Su.class);
			ASPMapper.getInstance().registerClass(Giu.class);
			ASPMapper.getInstance().registerClass(Sinistra.class);
			ASPMapper.getInstance().registerClass(Destra.class);
			ASPMapper.getInstance().registerClass(Personaggio.class);
			ASPMapper.getInstance().registerClass(Elemento.class);
			ASPMapper.getInstance().registerClass(Aiutante.class);
			ASPMapper.getInstance().registerClass(Buco.class);

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		while(this.g.inGioco) {
			
			facts.clearAll();
			facts.clearFilesPaths();
			facts.clearPrograms();
			
			if(g.collisioneConNemico())
			{
				this.g.vite--;
				this.g.rana.setX(Impostazioni.SIZE_TILES*4);
				this.g.rana.setY(Impostazioni.SIZE_TILES*12);
				if(this.g.vite == 0)
					this.g.inGioco = false;
			}
			if(g.collisioneConBuco() && g.inGioco)
			{
				if(this.g.arrivate.size() == Impostazioni.OBIETTIVO) {
					this.g.vinto = true;
					this.g.inGioco = false;
				}
				else 
					this.g.rana.setX(Impostazioni.SIZE_TILES*4);
					this.g.rana.setY(Impostazioni.SIZE_TILES*12);
				
			}
			try {
				Thread.sleep(Impostazioni.FPS_CALCOLATORE_PARTITA);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			int frogRow = this.g.rana.getRow();
			try {
				
				facts.addObjectInput(new Personaggio(frogRow, this.g.rana.getColumn()));
				
				//passo come fatti tutti gli elementi che si trovano nella stessa riga 
				//della rana e in quella superiore
				int valRowPrecPrec = 0;
				int valRowPrec = 0;
				int valRowCorr = 0;
				int valRowSup = 0;
				for(int j=0; j<Impostazioni.COLS; j++) {
					
					if(frogRow>1)
					 valRowPrecPrec = this.g.matrix[frogRow-2][j];
					
					valRowPrec = this.g.matrix[frogRow-1][j];
					valRowCorr = this.g.matrix[frogRow][j];
					
					if(frogRow < 12)
						valRowSup = this.g.matrix[frogRow+1][j];
					
					if(valRowPrec == Impostazioni.AUTO)
						facts.addObjectInput(new Elemento(frogRow-1, j));
					
					if(valRowCorr == Impostazioni.AUTO)
						facts.addObjectInput(new Elemento(frogRow, j));
					
					if(valRowPrec == Impostazioni.TARTARUGHE || valRowPrec == Impostazioni.TRONCO)  
						facts.addObjectInput(new Aiutante(frogRow-1, j));
						
					if(j>1 && (valRowPrecPrec == Impostazioni.TARTARUGHE || valRowPrecPrec == Impostazioni.TRONCO))  
						facts.addObjectInput(new Aiutante(frogRow-2, j));
					
					if(valRowSup == Impostazioni.TARTARUGHE || valRowSup == Impostazioni.TRONCO)  
						facts.addObjectInput(new Aiutante(frogRow+1, j));
					
					if(valRowCorr == Impostazioni.TARTARUGHE || valRowCorr == Impostazioni.TRONCO) 
						facts.addObjectInput(new Aiutante(frogRow, j));
					
					if(frogRow <= 6) {
						if(this.g.matrix[0][j] == Impostazioni.BUCO) 
							facts.addObjectInput(new Buco(0,j)); 
					}
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
			
			Main.handler.addProgram(facts);
			
			Output o = Main.handler.startSync();
			
			AnswerSets answers = (AnswerSets) o;
			for(AnswerSet a:answers.getAnswersets()){
				
				try {
					for(Object obj:a.getAtoms()){
						if(obj instanceof Su) {
							this.g.rana.goUp();
						}
						
						if(obj instanceof Giu) {
							this.g.rana.goDown();
						}
						
						if(obj instanceof Destra) {
							this.g.rana.goRight();
						}
						
						if(obj instanceof Sinistra) {
							this.g.rana.goLeft();
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				} 
				
			}
			
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
