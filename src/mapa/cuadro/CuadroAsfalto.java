package mapa.cuadro;

import graficos.Pantalla;
import graficos.Sprite;

public class CuadroAsfalto extends Cuadro {

	public CuadroAsfalto(Sprite sprite) {
		super(sprite);
	}

	public void mostrar(final int x, final int y, Pantalla pantalla) {
		pantalla.mostrarCuadro(x, y, this);
	}
}
