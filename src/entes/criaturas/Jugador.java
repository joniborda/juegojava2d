package entes.criaturas;

import graficos.Pantalla;
import graficos.Sprite;
import mapa.Mapa;
import control.Teclado;

public class Jugador extends Criatura {

	private Teclado teclado;

	private int animacion;

	public Jugador(Mapa mapa, Teclado teclado, Sprite sprite) {
		this.teclado = teclado;
		this.sprite = sprite;
		this.mapa = mapa;

	}

	public Jugador(Mapa mapa, Teclado teclado, int posicionX, int posicionY, Sprite sprite) {
		this(mapa, teclado, sprite);
		this.x = posicionX;
		this.y = posicionY;
	}

	public void actualizar() {
		int desplazamientoX = 0;
		int desplazamientoY = 0;

		int velocidadMovimiento = 1;
		int tiempo_arriba = 0;
		int tiempo_caminar = 0;

		if (animacion < 32767) {
			animacion++;
		} else {
			animacion = 0;
		}

		if (teclado.correr) {
			tiempo_arriba = 20;
			tiempo_caminar = 20;
			velocidadMovimiento = 3;
		} else {
			tiempo_arriba = 30;
			tiempo_caminar = 40;
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

		int resto = animacion % tiempo_arriba;
		if (direccion == 'n') {
			this.sprite = Sprite.ARRIBA0;
			if (enMovimiento) {
				if (resto > tiempo_arriba / 2) {
					sprite = Sprite.ARRIBA1;
				} else {
					sprite = Sprite.ARRIBA2;
				}
			}
		}

		if (direccion == 's') {
			this.sprite = Sprite.ABAJO0;
			if (enMovimiento) {
				if (resto > tiempo_arriba / 2) {
					sprite = Sprite.ABAJO1;
				} else {
					sprite = Sprite.ABAJO2;
				}
			}
		}

		resto = animacion % tiempo_caminar;
		if (direccion == 'o') {
			this.sprite = Sprite.IZQUIERDA0;
			if (enMovimiento) {
				if (resto > tiempo_caminar / 4 && resto <= tiempo_caminar / 2) {
					sprite = Sprite.IZQUIERDA1; // izquierda
				} else if (resto > tiempo_caminar / 2 && resto <= tiempo_caminar / 4 * 3) {
					sprite = Sprite.IZQUIERDA2; // juntos
				} else if (resto > tiempo_caminar / 4 * 3) {
					sprite = Sprite.IZQUIERDA1; // derecha
				} else {
					sprite = Sprite.IZQUIERDA3; // juntos
				}
			}
		}

		if (direccion == 'e') {
			this.sprite = Sprite.DERECHA0;
			if (enMovimiento) {
				if (resto > tiempo_caminar / 4 && resto <= tiempo_caminar / 2) {
					sprite = Sprite.DERECHA1; // juntos
				} else if (resto > tiempo_caminar / 2 && resto <= tiempo_caminar / 4 * 3) {
					sprite = Sprite.DERECHA2; // adelante
				} else if (resto > tiempo_caminar / 4 * 3) {
					sprite = Sprite.DERECHA1; // atras
				} else {
					sprite = Sprite.DERECHA3; // juntos
				}
			}
		}

	}

	public void mostrar(Pantalla pantalla) {
		pantalla.mostrarJugador(x, y, this);
	}
}
