package logicAlternative;

import config.Impostazioni;
import it.unical.mat.embasp.languages.Id;
import it.unical.mat.embasp.languages.Param;

@Id("ostacolo")
public class Elemento {
	
	protected int width;
	protected int height;
	
	@Param(0)
	protected int x;
	
	@Param(1)
	protected int y;
	
	public Elemento() {}
	
	public Elemento(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	
	public Elemento(int width, int height, int x, int y) {
		super();
		this.width = width;
		this.height = height;
		this.x = x;
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	public int getRow() {
		return y/Impostazioni.SIZE_TILES;
	}
	
	public int getColumn() {
		return x/Impostazioni.SIZE_TILES;
	}
}
