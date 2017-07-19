/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juego;

import graficos.Pantalla;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBuffer;
import java.awt.image.DataBufferInt;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFrame;

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
    
    private static volatile boolean enFuncionamiento = false;
    
    private static Thread thread;
    private static JFrame ventana;
    private static Teclado teclado;
    private static Pantalla pantalla;
    
    // imagen en blanco
    private static BufferedImage imagen = new BufferedImage(ANCHO, ALTO, BufferedImage.TYPE_INT_RGB);
    
    private static int[] pixeles = ((DataBufferInt) imagen .getRaster().getDataBuffer()).getData();
    
    private static int x = 0;
    private static int y = 0;
    
    public Juego() {
        setPreferredSize(new Dimension(ANCHO, ALTO));
        
        pantalla = new Pantalla(ANCHO, ALTO);
        
        teclado = new Teclado();
        addKeyListener(teclado);
        
        ventana  = new JFrame(NOMBRE);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setResizable(false);
        ventana.setLayout(new BorderLayout());
        ventana.add(this, BorderLayout.CENTER);
        ventana.pack();
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
        
    }
    
    /**
     * @param args the command line arguments
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
    	
    	if (teclado.arriba) {
    		System.out.println("arriba");
    	}
    	if (teclado.abajo) {
    		System.out.println("abajo");
    	}
    	if (teclado.izquierda) {
    		System.out.println("izquierda");
    	}
    	if (teclado.derecha) {
    		System.out.println("derecha");
    	}
        aps++;
    }
    
    private void mostrar() {
    	BufferStrategy estrategia = getBufferStrategy();
    	
    	if (estrategia == null) {
    		createBufferStrategy(3);
    		return;
    	}
    	
        fps++;
    }
    @Override
    public void run() {
        final int NS_POR_SEGUNDO = 100000000;
        final byte APS_OBJETIVO = 60;
        final double NS_POR_ACTUALIZACION = NS_POR_SEGUNDO / APS_OBJETIVO;
        long referenciaActualizacion  = System.nanoTime();
        long referenciaContador = System.nanoTime();
        double tiempoTranscurrido;
        double delta = 0;
        
        requestFocus();
        
        while(enFuncionamiento) {
            final long inicioBucle = System.nanoTime();
            tiempoTranscurrido = inicioBucle - referenciaActualizacion;
            referenciaActualizacion = inicioBucle;
            delta += tiempoTranscurrido / NS_POR_ACTUALIZACION;
            
            while(delta >= 1) {
                actualizar();
                delta--;
            }
            
            mostrar();
            
            if (System.nanoTime() - referenciaContador > NS_POR_SEGUNDO) {
                ventana.setTitle(NOMBRE + " || APS: " + aps + " || FPS: " + fps );
                aps = 0;
                fps = 0;
                referenciaContador = System.nanoTime();
            }
        }
    }
}
