package mapa;

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
	public void mostrar(final int compensacionX, final int compensacionY, final Pantalla pantalla) {
		int o = compensacionX >> 5, // /32
			e = (compensacionX + pantalla.obtenAncho()) >> 5,
			n = compensacionY >> 5,
			s = (compensacionY + pantalla.obtenAlto()) >> 5;
		
		
	}
}
