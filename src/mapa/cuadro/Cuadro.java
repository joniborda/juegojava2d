package mapa.cuadro;

import graficos.Pantalla;
import graficos.Sprite;

public abstract class Cuadro {

	public int x;
	public int y;
	public Sprite sprite;
	
	// Coleccion de cuadros
	public static final Cuadro VACIO = new CuadroVacio(Sprite.VACIO);
	
	public static final Cuadro ASFALTO = new CuadroAsfalto(Sprite.ASFALTO);
	
	public Cuadro(final Sprite sprite) {
		this.sprite = sprite;
	}
	
	public void mostrar(final int x, final int y, Pantalla pantalla) {
		pantalla.mostrarCuadro(x << 5, y << 5, this);
	}
	
	public boolean solido() {
		return false;
	}
}
