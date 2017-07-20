package mapa;

import java.util.Random;

public class MapaGenerado extends Mapa {
	
	private final Random aleatorio = new Random();

	public MapaGenerado(final int ancho, final int largo) {
		super(ancho, largo);
	}
	
	protected void generarMapa() {
		for (int y = 0; y < alto; y++) {
			for (int x = 0; x < ancho; x++) {
				// 							de 0 a 2
				cuadros[x + y * ancho] = aleatorio.nextInt(3);
			}
		}
	}
}
