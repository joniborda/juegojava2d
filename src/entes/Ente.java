package entes;

import mapa.Mapa;

public class Ente {

	protected int x;
	protected int y;

	private boolean eliminado = false;

	protected Mapa mapa;

	public void actualizar() {

	}

	public void mostrar() {

	}

	public void eliminar() {
		eliminado = true;
	}

	public int getX() {
		return x;
	}

	public void modificarX(int desplazamientoX) {
		x += desplazamientoX;
	}

	public int getY() {
		return y;
	}

	public void modificarY(int desplazamientoY) {
		y += desplazamientoY;
	}

	public void setX(int x) {
		this.x = x;
	}

	public boolean estaEliminado() {
		return eliminado;
	}

}
