package entes.criaturas;

import graficos.Pantalla;
import graficos.Sprite;
import control.Teclado;

public class Jugador extends Criatura {

	private Teclado teclado;

	private int animacion;

	public Jugador(Teclado teclado, Sprite sprite) {
		this.teclado = teclado;
		this.sprite = sprite;
	}

	public Jugador(Teclado teclado, int posicionX, int posicionY, Sprite sprite) {
		this.teclado = teclado;
		this.x = posicionX;
		this.y = posicionY;
		this.sprite = sprite;
	}

	public void actualizar() {
		int desplazamientoX = 0;
		int desplazamientoY = 0;
		if (animacion < 32767) {
			animacion++;
		} else {
			animacion = 0;
		}

		if (teclado.arriba) {
			desplazamientoY--;
		}

		if (teclado.abajo) {
			desplazamientoY++;
		}

		if (teclado.izquierda) {
			desplazamientoX--;
		}

		if (teclado.derecha) {
			desplazamientoX++;
		}

		if (desplazamientoX != 0 || desplazamientoY != 0) {
			mover(desplazamientoX, desplazamientoY);
			enMovimiento = true;
		} else {
			enMovimiento = false;
		}

		if (direccion == 'n') {
			this.sprite = Sprite.ARRIBA0;
			if (enMovimiento) {
				if (animacion % 30 > 15) {
					sprite = Sprite.ARRIBA1;
				} else {
					sprite = Sprite.ARRIBA2;
				}
			}
		}

		if (direccion == 's') {
			this.sprite = Sprite.ABAJO0;
			if (enMovimiento) {
				if (animacion % 30 > 15) {
					sprite = Sprite.ABAJO1;
				} else {
					sprite = Sprite.ABAJO2;
				}
			}
		}

		if (direccion == 'o') {
			this.sprite = Sprite.IZQUIERDA0;
			if (enMovimiento) {
				if (animacion % 30 > 15) {
					sprite = Sprite.IZQUIERDA1;
				} else {
					sprite = Sprite.IZQUIERDA2;
				}
			}
		}

		if (direccion == 'e') {
			this.sprite = Sprite.DERECHA0;
			if (enMovimiento) {
				if (animacion % 30 > 15) {
					sprite = Sprite.DERECHA1;
				} else {
					sprite = Sprite.DERECHA2;
				}
			}
		}

	}

	public void mostrar(Pantalla pantalla) {
		pantalla.mostrarJugador(x, y, this);
	}
}
