package mapa.cuadro;

import graficos.Pantalla;
import graficos.Sprite;

public class Cuadro {

	public int x;
	public int y;
	public Sprite sprite;

	private boolean solido;

	public static final int LADO = 32;

	// Coleccion de cuadros
	public static final Cuadro VACIO = new Cuadro(Sprite.VACIO, true);
	public static final Cuadro ASFALTO = new Cuadro(Sprite.ASFALTO);
	public static final Cuadro ARENA = new Cuadro(Sprite.ARENA, true);
	public static final Cuadro BORDE_CARRETERA = new Cuadro(Sprite.BORDE_CARRETERA, true);
	public static final Cuadro BORDE_CARRETERA_DERECHA = new Cuadro(Sprite.BORDE_CARRETERA_DERECHA, true);
	public static final Cuadro BORDE_CARRETERA_ABAJO = new Cuadro(Sprite.BORDE_CARRETERA_ABAJO, true);
	public static final Cuadro BORDE_CARRETERA_ARRIBA = new Cuadro(Sprite.BORDE_CARRETERA_ARRIBA, true);
	public static final Cuadro CENTRO_CARRETERA_H = new Cuadro(Sprite.CENTRO_CARRETERA_H);
	public static final Cuadro CENTRO_CARRETERA_V = new Cuadro(Sprite.CENTRO_CARRETERA_V);
	public static final Cuadro ESQUINA_CARRETERA_NO = new Cuadro(Sprite.ESQUINA_CARRETERA_NO);
	public static final Cuadro ESQUINA_CARRETERA_NE = new Cuadro(Sprite.ESQUINA_CARRETERA_NE);
	public static final Cuadro ESQUINA_CARRETERA_SE = new Cuadro(Sprite.ESQUINA_CARRETERA_SE);
	public static final Cuadro ESQUINA_CARRETERA_SO = new Cuadro(Sprite.ESQUINA_CARRETERA_SO);
	public static final Cuadro PARED_PIEDRA = new Cuadro(Sprite.PARED_PIEDRA, true);
	public static final Cuadro PARED_PIEDRA_INFERIOR = new Cuadro(Sprite.PARED_PIEDRA_INFERIOR, true);
	public static final Cuadro PARED_PIEDRA_CARRETERA_IZQUIERDA = new Cuadro(Sprite.PARED_PIEDRA_CARRETERA_IZQUIERDA,
			true);
	public static final Cuadro PARED_PIEDRA_CARRETERA_DERECHA = new Cuadro(Sprite.PARED_PIEDRA_CARRETERA_DERECHA, true);
	public static final Cuadro PUERTA_SUPERIOR_IZQUIERDA = new Cuadro(Sprite.PUERTA_SUPERIOR_IZQUIERDA);
	public static final Cuadro PUERTA_SUPERIOR_DERECHA = new Cuadro(Sprite.PUERTA_SUPERIOR_DERECHA);
	public static final Cuadro PUERTA_INTERMEDIA_IZQUIERDA = new Cuadro(Sprite.PUERTA_INTERMEDIA_IZQUIERDA);
	public static final Cuadro PUERTA_INTERMEDIA_DERECHA = new Cuadro(Sprite.PUERTA_INTERMEDIA_DERECHA);
	public static final Cuadro PUERTA_INFERIOR = new Cuadro(Sprite.PUERTA_INFERIOR);
	public static final Cuadro OXIDO = new Cuadro(Sprite.OXIDO);
	public static final Cuadro PUERTA_SUPERIOR_CENTRAL = new Cuadro(Sprite.PUERTA_SUPERIOR_CENTRAL);

	public Cuadro(final Sprite sprite) {
		this.sprite = sprite;
		this.solido = false;
	}

	public Cuadro(final Sprite sprite, boolean solido) {
		this.sprite = sprite;
		this.solido = solido;
	}

	public void mostrar(final int x, final int y, Pantalla pantalla) {
		pantalla.mostrarCuadro(x << 5, y << 5, this);
	}

	public boolean esSolido() {
		return solido;
	}
}
