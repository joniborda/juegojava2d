/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficos;

import mapa.cuadro.Cuadro;

/**
 * 
 * @author Joni
 */
public class Pantalla {
	private final int ancho;
	private final int alto;

	public final int[] pixeles;

	private int diferenciaX;
	private int diferenciaY;

	public Pantalla(final int ancho, final int alto) {
		this.ancho = ancho;
		this.alto = alto;

		pixeles = new int[ancho * alto];
	}

	public void limpiar() {
		for (int i = 0; i < pixeles.length; i++) {
			pixeles[i] = 0;
		}
	}

	public void mostrarCuadro(int compensacionX, int compensacionY,
			Cuadro cuadro) {
		
		compensacionX -= diferenciaX;
		compensacionY -= diferenciaY;
		
		for (int y = 0; y < cuadro.sprite.LADO; y++) {
			int posicionY = y + compensacionY;
			for (int x = 0; x < cuadro.sprite.LADO; x++) {
				int posicionX = x + compensacionX;
				if (posicionX < -cuadro.sprite.LADO || posicionX >= ancho || posicionY < 0
						|| posicionY >= alto) {
					break;
				}

				if (posicionX < 0) {
					posicionX = 0;
				}
				pixeles[posicionX + posicionY * ancho] = cuadro.sprite.pixeles[x
						+ y * cuadro.sprite.LADO];
			}
		}
	}
	
	public void setDiferencia(final int diferenciaX, final int diferenciaY) {
		this.diferenciaX = diferenciaX;
		this.diferenciaY = diferenciaY;
	}
	
	public int obtenAncho() {
		return this.ancho;
	}
	public int obtenAlto() {
		return this.alto;
	}
}
