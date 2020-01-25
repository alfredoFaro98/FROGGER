package logicAlternative;

import it.unical.mat.embasp.languages.Id;
import it.unical.mat.embasp.languages.Param;

@Id("aiutante")
public class Aiutante extends Elemento {

	@Param(0)
	protected int x;
	
	@Param(1)
	protected int y;
	
	public Aiutante() {}
	
	public Aiutante(int x, int y) {
		super(x, y);
	}
}
