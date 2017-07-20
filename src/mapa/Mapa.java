package mapa;

import mapa.cuadro.Cuadro;
import graficos.Pantalla;

public abstract class Mapa {

	protected int ancho;
	protected int alto;

	protected int[] cuadros;

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

	public void cargarMapa(final String ruta) {

	}

	public void actualizar() {

	}

	// temporal
	public void mostrar(final int compensacionX, final int compensacionY,
			final Pantalla pantalla) {

		pantalla.setDiferencia(compensacionX, compensacionY);
		
		int o = compensacionX >> 5, // /32 corre el bit cinco lugares a la
									// derecha
		e = (compensacionX + pantalla.obtenAncho()) >> 5, n = compensacionY >> 5, s = (compensacionY + pantalla
				.obtenAlto()) >> 5;

		for (int y = n; y < s; y++) {
			for (int x = o; x < e; x++) {
				obtenCuadro(x, y).mostrar(x, y, pantalla);
			}
		}
	}

	public Cuadro obtenCuadro(final int x, final int y) {
		switch (cuadros[x + y * ancho]) {
		case 0:
			return Cuadro.ASFALTO;
		default:
			return Cuadro.VACIO;
		}
	}
}
