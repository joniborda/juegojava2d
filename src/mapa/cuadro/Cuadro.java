package mapa.cuadro;

import graficos.Pantalla;
import graficos.Sprite;

public abstract class Cuadro {

	public int x;
	public int y;
	public Sprite sprite;
	
	// Coleccion de cuadros
	public static final Cuadro ASFALTO = new CuadroAsfalto(Sprite.ASFALTO);
	
	public Cuadro(final Sprite sprite) {
		this.sprite = sprite;
	}
	
	public void mostrar(final int x, final int y, Pantalla pantalla) {
		
	}
	
	public boolean solido() {
		return false;
	}
}
