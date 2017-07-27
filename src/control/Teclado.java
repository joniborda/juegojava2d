package control;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Teclado implements KeyListener {

	private final static int numeroTeclas = 120;
	private final boolean[] teclas = new boolean[numeroTeclas];

	public boolean arriba;
	public boolean abajo;
	public boolean derecha;
	public boolean izquierda;

	public boolean correr;

	public boolean salir;

	public void actualizar() {
		arriba = teclas[KeyEvent.VK_W];
		abajo = teclas[KeyEvent.VK_S];
		derecha = teclas[KeyEvent.VK_D];
		izquierda = teclas[KeyEvent.VK_A];

		salir = teclas[KeyEvent.VK_ESCAPE];

		correr = teclas[KeyEvent.VK_SHIFT];
	}

	@Override
	public void keyPressed(KeyEvent e) {
		teclas[e.getKeyCode()] = true;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		teclas[e.getKeyCode()] = false;
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

}
