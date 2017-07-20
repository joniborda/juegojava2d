package mapa;

import graficos.Pantalla;

public abstract class Mapa {

	private int ancho;
	private int alto;

	private int[] cuadros;

	public Mapa(final int ancho, final int alto) {
		this.ancho = ancho;
		this.alto = alto;

		this.cuadros = new int[ancho * alto];
		generarMapa();
	}
	
	public Mapa(String ruta) {
		cargarMapa(ruta);
	}

	public void generarMapa() {

	}
	
	public void cargarMapa(final String ruta) {
		
	}
	
	public void actualizar() {
		
	}
	
	public void mostrar(final int compensacionX, final int compensacionY, final Pantalla pantalla) {
		
	}
}
