package entes.criaturas;

import entes.Ente;
import graficos.Sprite;

public class Criatura extends Ente {

	protected Sprite sprite;
	protected char direccion = 'n';
	protected boolean enMovimiento = false;

	public void actualizar() {

	}

	public void mostrar() {

	}

	public void mover(int desplazamientoX, int desplazamientoY) {
		if (desplazamientoX > 0) {
			direccion = 'e';
		}

		if (desplazamientoX < 0) {
			direccion = 'o';
		}

		if (desplazamientoY > 0) {
			direccion = 's';
		}

		if (desplazamientoY < 0) {
			direccion = 'n';
		}

		if (!estaEliminado()) {
			if (!enColision(desplazamientoX, 0)) {
				modificarX(desplazamientoX);
			}
			if (!enColision(0, desplazamientoY)) {
				modificarY(desplazamientoY);
			}

		}
	}

	private boolean enColision(int desplazamientoX, int desplazamientoY) {
		boolean colision = false;

		int posicionX = x + desplazamientoX;
		int posicionY = y + desplazamientoY;

		int margenIzquierdo = -6;
		int margenDerecho = 18;
		int margenSuperior = -4;
		int margenInferior = 31;

		int bordeIzquierdo = (posicionX + margenDerecho) / sprite.obtenLado();
		int bordeDerecho = (posicionX + margenDerecho + margenIzquierdo) / sprite.obtenLado();
		int bordeSuperior = (posicionY + margenInferior) / sprite.obtenLado();
		int bordeInferior = (posicionY + margenInferior + margenSuperior) / sprite.obtenLado();

		if (mapa.getCuadroCatalogo(bordeIzquierdo + bordeSuperior * mapa.getAncho()).esSolido()) {
			colision = true;
		}

		if (mapa.getCuadroCatalogo(bordeIzquierdo + bordeInferior * mapa.getAncho()).esSolido()) {
			colision = true;
		}

		if (mapa.getCuadroCatalogo(bordeDerecho + bordeSuperior * mapa.getAncho()).esSolido()) {
			colision = true;
		}

		if (mapa.getCuadroCatalogo(bordeDerecho + bordeInferior * mapa.getAncho()).esSolido()) {
			colision = true;
		}
		return colision;
	}

	public Sprite getSprite() {
		return this.sprite;
	}
}
