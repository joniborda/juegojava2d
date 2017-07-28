/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juego;

import entes.criaturas.Jugador;
import graficos.Pantalla;
import graficos.Sprite;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import javax.swing.JFrame;

import mapa.Mapa;
import mapa.MapaCargado;
import control.Teclado;

/**
 * 
 * @author Joni
 */
public class Juego extends Canvas implements Runnable {

	private static final String NOMBRE = "juego";

	private static final int ANCHO = 800;
	private static final int ALTO = 600;
	private static int aps = 0;
	private static int fps = 0;

	private static String CONTADOR_APS = "";
	private static String CONTADOR_FPS = "";

	private static volatile boolean enFuncionamiento = false;

	private static Thread thread;
	private static JFrame ventana;
	private static Teclado teclado;
	private static Pantalla pantalla;
	private static Mapa mapa;
	private static Jugador jugador;
	// imagen en blanco
	private static BufferedImage imagen = new BufferedImage(ANCHO, ALTO, BufferedImage.TYPE_INT_RGB);

	private static int[] pixeles = ((DataBufferInt) imagen.getRaster().getDataBuffer()).getData();

	public Juego() {
		setPreferredSize(new Dimension(ANCHO, ALTO));

		pantalla = new Pantalla(ANCHO, ALTO);
		// mapa = new MapaGenerado(ANCHO, ALTO);
		mapa = new MapaCargado("/mapas/mapa_desierto.png");

		teclado = new Teclado();
		addKeyListener(teclado);

		jugador = new Jugador(mapa, teclado, 225, 255, Sprite.ABAJO0);
		ventana = new JFrame(NOMBRE);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setResizable(false);
		ventana.setLayout(new BorderLayout());
		ventana.add(this, BorderLayout.CENTER);
		ventana.setUndecorated(true);
		ventana.pack();
		ventana.setLocationRelativeTo(null);
		ventana.setVisible(true);

	}

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String[] args) {
		Juego juego = new Juego();
		juego.iniciar();
	}

	private synchronized void iniciar() {
		enFuncionamiento = true;
		thread = new Thread(this, "graficos");
		thread.start();
	}

	private synchronized void detener() {
		enFuncionamiento = true;
		try {
			thread.join();
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}
	}

	private void actualizar() {
		teclado.actualizar();

		jugador.actualizar();
		/*
		 * if (teclado.arriba) { y--; } if (teclado.abajo) { y++; } if
		 * (teclado.izquierda) { x--; } if (teclado.derecha) { x++; }
		 */

		if (teclado.salir) {
			System.exit(0);
		}
		aps++;
	}

	private void mostrar() {
		BufferStrategy estrategia = getBufferStrategy();

		if (estrategia == null) {
			// carga tres buffer antes de mostrar
			createBufferStrategy(3);
			return;
		}
		// pantalla.limpiar();

		mapa.mostrar(jugador.getX() - pantalla.obtenAncho() / 2 + jugador.getSprite().obtenLado() / 2, jugador.getY()
				- pantalla.obtenAlto() / 2 + jugador.getSprite().obtenLado() / 2, pantalla);
		jugador.mostrar(pantalla);

		System.arraycopy(pantalla.pixeles, 0, pixeles, 0, pixeles.length);

		Graphics g = estrategia.getDrawGraphics();

		g.drawImage(imagen, 0, 0, getWidth(), getHeight(), null);
		g.setColor(Color.red);
		g.drawString(CONTADOR_APS, 10, 20);
		g.drawString(CONTADOR_FPS, 10, 35);
		g.drawString("x:" + jugador.getX(), 10, 50);
		g.drawString("y:" + jugador.getY(), 10, 65);

		g.dispose();

		estrategia.show();
		fps++;
	}

	@Override
	public void run() {
		final int NS_POR_SEGUNDO = 1000000000;
		// final byte APS_OBJETIVO = 64;
		final double NS_POR_ACTUALIZACION = NS_POR_SEGUNDO >> 6;
		long referenciaActualizacion = System.nanoTime();
		long referenciaContador = System.nanoTime();
		double tiempoTranscurrido;
		double delta = 0;

		requestFocus();

		while (enFuncionamiento) {
			final long inicioBucle = System.nanoTime();

			tiempoTranscurrido = inicioBucle - referenciaActualizacion;
			referenciaActualizacion = inicioBucle;

			delta += tiempoTranscurrido / NS_POR_ACTUALIZACION;

			while (delta >= 1) {
				actualizar();
				delta--;
			}

			mostrar();

			if (System.nanoTime() - referenciaContador > NS_POR_SEGUNDO) {
				CONTADOR_APS = "APS: " + aps;
				CONTADOR_FPS = "FPS: " + fps;
				aps = 0;
				fps = 0;
				referenciaContador = System.nanoTime();
			}
		}
	}
}
