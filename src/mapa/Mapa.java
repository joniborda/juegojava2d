package mapa;

import mapa.cuadro.Cuadro;
import graficos.Pantalla;

public abstract class Mapa {

	protected int ancho;
	protected int alto;

	protected int[] cuadros;
	protected Cuadro[] cuadrosCatalogo;

	public Mapa(final int ancho, final int alto) {
		this.ancho = ancho;
		this.alto = alto;

		this.cuadros = new int[ancho * alto];
		generarMapa();
	}

	public Mapa(String ruta) {
		cargarMapa(ruta);
	}

	protected void generarMapa() {

	}

	protected void cargarMapa(final String ruta) {

	}

	public void actualizar() {

	}

	// temporal
	public void mostrar(final int compensacionX, final int compensacionY,
			final Pantalla pantalla) {

		pantalla.setDiferencia(compensacionX, compensacionY);

		int o = compensacionX >> 5; // /32 corre el bit cinco lugares a la
									// derecha
		int e = (compensacionX + pantalla.obtenAncho() + Cuadro.LADO) >> 5;
		int n = compensacionY >> 5;
		int s = (compensacionY + pantalla.obtenAlto() + Cuadro.LADO) >> 5;

		for (int y = n; y < s; y++) {
			for (int x = o; x < e; x++) {
				obtenCuadro(x, y).mostrar(x, y, pantalla);
			}
		}
	}

	public Cuadro obtenCuadro(final int x, final int y) {
		if (x < 0 || y < 0 || x >= ancho || y >= alto) {
			return Cuadro.VACIO;
		}
		switch (cuadros[x + y * ancho]) {
		case 0:
			return Cuadro.ASFALTO;
		case 1:
			return Cuadro.ARENA;
		default:
			return Cuadro.VACIO;
		}
	}
}
