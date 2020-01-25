package logicAlternative;

import it.unical.mat.embasp.languages.Id;
import it.unical.mat.embasp.languages.Param;

@Id("buco")
public class Buco extends Elemento {

	@Param(0)
	protected int x;
	
	@Param(1)
	protected int y;
	
	public Buco() {}
	
	public Buco(int x, int y) {
		super(x, y);
	}
}
