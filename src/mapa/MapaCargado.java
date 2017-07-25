package mapa;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import mapa.cuadro.Cuadro;

public class MapaCargado extends Mapa {

	private int[] pixeles;

	public MapaCargado(String ruta) {
		super(ruta);
	}

	protected void cargarMapa(String ruta) {
		try {
			BufferedImage imagen = ImageIO.read(MapaCargado.class
					.getResource(ruta));

			ancho = imagen.getWidth();
			alto = imagen.getHeight();

			cuadrosCatalogo = new Cuadro[ancho * alto];
			pixeles = new int[ancho * alto];

			imagen.getRGB(0, 0, ancho, alto, pixeles, 0, ancho);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	protected void generarMapa() {
		for (int i = 0; i < pixeles.length; i++) {
			switch (pixeles[i]) {
			// se le agrega ff para que sea opaco
			case 0xff000000:
				cuadrosCatalogo[i] = Cuadro.ASFALTO;
				continue;
			case 0xfffee28d:
				cuadrosCatalogo[i] = Cuadro.ARENA;
				continue;
			case 0xfffecc34:
				cuadrosCatalogo[i] = Cuadro.BORDE_CARRETERA;
				continue;
			case 0xffd1d1d1:
				cuadrosCatalogo[i] = Cuadro.CENTRO_CARRETERA;
				continue;
			case 0xff9e9e9e:
				cuadrosCatalogo[i] = Cuadro.ESQUINA_CARRETERA;
				continue;
			case 0xffc8752b:
				cuadrosCatalogo[i] = Cuadro.OXIDO;
				continue;
			case 0xff6c6c6c:
				cuadrosCatalogo[i] = Cuadro.PARED_PIEDRA;
				continue;
			case 0xff806c5f:
				cuadrosCatalogo[i] = Cuadro.PARED_PIEDRA_CARRETERA;
				continue;
			case 0xff4b3425:
				cuadrosCatalogo[i] = Cuadro.PARED_PIEDRA_INFERIOR;
				continue;
			case 0xff98745c:
				cuadrosCatalogo[i] = Cuadro.PUERTA_INFERIOR;
				continue;
			case 0xffb38364:
				cuadrosCatalogo[i] = Cuadro.PUERTA_INTERMEDIA_IZQUIERDA;
				continue;
			case 0xff98281a:
				cuadrosCatalogo[i] = Cuadro.PUERTA_SUPERIOR_CENTRAL;
				continue;
			case 0xffa14c41:
				cuadrosCatalogo[i] = Cuadro.PUERTA_SUPERIOR_IZQUIERDA;
				continue;
			default:
				cuadrosCatalogo[i] = Cuadro.VACIO;
				continue;
			}
		}
	}
}
