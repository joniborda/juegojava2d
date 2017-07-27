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

		int velocidadMovimiento = 1;

		if (animacion < 32767) {
			animacion++;
		} else {
			animacion = 0;
		}

		if (teclado.correr) {
			velocidadMovimiento = 3;
		} else {
			velocidadMovimiento = 1;
		}

		if (teclado.arriba) {
			desplazamientoY -= velocidadMovimiento;
		}

		if (teclado.abajo) {
			desplazamientoY += velocidadMovimiento;
		}

		if (teclado.izquierda) {
			desplazamientoX -= velocidadMovimiento;
		}

		if (teclado.derecha) {
			desplazamientoX += velocidadMovimiento;
		}

		if (desplazamientoX != 0 || desplazamientoY != 0) {
			mover(desplazamientoX, desplazamientoY);
			enMovimiento = true;
		} else {
			enMovimiento = false;
		}

		int resto = animacion % 40;

		if (direccion == 'n') {
			this.sprite = Sprite.ARRIBA0;
			if (enMovimiento) {
				if (resto > 15) {
					sprite = Sprite.ARRIBA1;
				} else {
					sprite = Sprite.ARRIBA2;
				}
			}
		}

		if (direccion == 's') {
			this.sprite = Sprite.ABAJO0;
			if (enMovimiento) {
				if (resto > 15) {
					sprite = Sprite.ABAJO1;
				} else {
					sprite = Sprite.ABAJO2;
				}
			}
		}

		if (direccion == 'o') {
			this.sprite = Sprite.IZQUIERDA0;
			if (enMovimiento) {
				if (resto > 10 && resto <= 20) {
					sprite = Sprite.IZQUIERDA1; // izquierda
				} else if (resto > 20 && resto <= 30) {
					sprite = Sprite.IZQUIERDA0; // juntos
				} else if (resto > 30) {
					sprite = Sprite.IZQUIERDA2; // derecha
				} else {
					sprite = Sprite.IZQUIERDA0; // juntos
				}
			}
		}

		if (direccion == 'e') {
			this.sprite = Sprite.DERECHA0;
			if (enMovimiento) {
				if (resto > 10 && resto <= 20) {
					sprite = Sprite.DERECHA1; // izquierda
				} else if (resto > 20 && resto <= 30) {
					sprite = Sprite.DERECHA0; // juntos
				} else if (resto > 30) {
					sprite = Sprite.DERECHA2; // derecha
				} else {
					sprite = Sprite.DERECHA0; // juntos
				}
			}
		}

	}

	public void mostrar(Pantalla pantalla) {
		pantalla.mostrarJugador(x, y, this);
	}
}
