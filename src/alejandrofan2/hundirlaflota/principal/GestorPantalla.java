package alejandrofan2.hundirlaflota.principal;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import alejandrofan2.hundirlaflota.utiles.ControlRaton;

/*
 * Esta es la clase que se encarga de poner todos los objetos,
 * botones y demas cosas en la pantalla.
 */

public class GestorPantalla extends JPanel implements Runnable {
	private static final long serialVersionUID = 7656685126706339194L;

	private static final String RUTA_FONDO = "res/images/mapa.png";

	private static final String RUTA_PLAY = "res/images/play.png";
	private static final String RUTA_SALIR = "res/images/salir.png";
	private static final String RUTA_LVL1_ROJO = "res/images/salir.png";
	private static final String RUTA_LVL1_VERDE = "res/images/play.png";
	private static final String RUTA_LVL2_ROJO = "res/images/salir.png";
	private static final String RUTA_LVL2_VERDE = "res/images/play.png";
	private static final String RUTA_LVL3_ROJO = "res/images/salir.png";
	private static final String RUTA_LVL3_VERDE = "res/images/play.png";

	private static JLabel botonPlay;
	private static JLabel botonSalir;
	private static JLabel botonLvl1;
	private static JLabel botonLvl2;
	private static JLabel botonLvl3;

	private static ControlRaton raton;

	private static ImageIcon imgPlay;
	private static ImageIcon imgSalir;
	private static ImageIcon imgLvl1;
	private static ImageIcon imgLvl2;
	private static ImageIcon imgLvl3;
	
	private static Image imgFondo;
	private static Dimension size;
	private static Insets insets;
	private static Thread thread;

	// Constructor de la clase GestorPantalla.
	public GestorPantalla() {
		insets = this.getInsets();
		this.setPreferredSize(new Dimension(HundirLaFlota.ANCHO, HundirLaFlota.ALTO));
		this.setLayout(null);
		
		imgFondo = new ImageIcon(RUTA_FONDO).getImage();
		imgPlay = new ImageIcon(RUTA_PLAY);
		imgSalir = new ImageIcon(RUTA_SALIR);
		imgLvl1 = new ImageIcon(RUTA_LVL1_VERDE);
		imgLvl2 = new ImageIcon(RUTA_LVL2_ROJO);
		imgLvl3 = new ImageIcon(RUTA_LVL3_ROJO);

		botonPlay = new JLabel();
		botonSalir = new JLabel();
		botonLvl1 = new JLabel();
		botonLvl2 = new JLabel();
		botonLvl3 = new JLabel();
		
		botonPlay.setIcon(imgPlay);
		botonPlay.setText("");
		botonSalir.setIcon(imgSalir);
		botonSalir.setText("");
		botonLvl1.setIcon(imgLvl1);
		botonLvl1.setText("");
		botonLvl2.setIcon(imgLvl2);
		botonLvl2.setText("");
		botonLvl3.setIcon(imgLvl3);
		botonLvl3.setText("");
		
		size = botonSalir.getPreferredSize();
		botonSalir.setBounds(612 + insets.left, 503 + insets.top, size.width, size.height);
		botonSalir.setVisible(true);
		size = botonPlay.getPreferredSize();
		botonPlay.setBounds(612 + insets.left, 432 + insets.top, size.width, size.height);
		botonPlay.setVisible(true);
		size = botonLvl1.getPreferredSize();
		botonLvl1.setBounds(312 + insets.left, 162 + insets.top, size.width, size.height);
		botonLvl1.setVisible(true);
		size = botonLvl2.getPreferredSize();
		botonLvl2.setBounds(312 + insets.left, 262 + insets.top, size.width, size.height);
		botonLvl2.setVisible(true);
		size = botonLvl3.getPreferredSize();
		botonLvl3.setBounds(312 + insets.left, 432 + insets.top, size.width, size.height);
		botonLvl3.setVisible(true);
		
		this.add(botonPlay);
		this.add(botonSalir);
		this.add(botonLvl1);
		this.add(botonLvl2);
		this.add(botonLvl3);
		raton = new ControlRaton();
		botonPlay.addMouseListener(raton);
		botonSalir.addMouseListener(raton);
		botonLvl1.addMouseListener(raton);
		botonLvl2.addMouseListener(raton);
		botonLvl3.addMouseListener(raton);
		
		switch (HundirLaFlota.getLvlAcual()) {
		case 1:
			imgLvl1 = new ImageIcon(RUTA_LVL1_VERDE);
			imgLvl2 = new ImageIcon(RUTA_LVL2_ROJO);
			imgLvl3 = new ImageIcon(RUTA_LVL3_ROJO);
			botonLvl1.setIcon(imgLvl1);
			botonLvl2.setIcon(imgLvl2);
			botonLvl3.setIcon(imgLvl3);
			break;
		case 2:
			imgLvl1 = new ImageIcon(RUTA_LVL1_ROJO);
			imgLvl2 = new ImageIcon(RUTA_LVL2_VERDE);
			imgLvl3 = new ImageIcon(RUTA_LVL3_ROJO);
			botonLvl1.setIcon(imgLvl1);
			botonLvl2.setIcon(imgLvl2);
			botonLvl3.setIcon(imgLvl3);
			break;
		case 3:
			imgLvl1 = new ImageIcon(RUTA_LVL1_ROJO);
			imgLvl2 = new ImageIcon(RUTA_LVL2_ROJO);
			imgLvl3 = new ImageIcon(RUTA_LVL3_VERDE);
			botonLvl1.setIcon(imgLvl1);
			botonLvl2.setIcon(imgLvl2);
			botonLvl3.setIcon(imgLvl3);
			break;
		default:
			imgLvl1 = new ImageIcon(RUTA_LVL1_VERDE);
			imgLvl2 = new ImageIcon(RUTA_LVL2_ROJO);
			imgLvl3 = new ImageIcon(RUTA_LVL3_ROJO);
			botonLvl1.setIcon(imgLvl1);
			botonLvl2.setIcon(imgLvl2);
			botonLvl3.setIcon(imgLvl3);
			break;
		}
		repaint();

	}

	// Metodo abstracto de la clase JPanel el cual usamos para dibujar en la
	// pantalla.
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		this.setBackground(Color.BLACK);
		Graphics2D g2D = (Graphics2D) g;

		// Fondo
		g2D.drawImage(imgFondo, 0, 0, this);

	}
	// Metodo que ejecuta el segundo thread de procesamiento.
	public void run() {
		System.out.println("El segundo thread se esta ejecutando.");
		while (HundirLaFlota.getRunning()) {
			repaint();
		}
	}

	// Metodo que inicia el thread.
	public synchronized void iniciar() {
		HundirLaFlota.setRunning(true);

		thread = new Thread(this, "Graficos");
		thread.start();
	}

	// Metodo que detiene el thread.true
	private synchronized void detener() {
		HundirLaFlota.setRunning(false);

		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	// Getter del boton play que usamos para comprobar si se ha clickado en el.
	public static JLabel getBotonPlay() {
		return botonPlay;
	}

	// Getter del boton salir que usamos para comprobar si se ha clickado en el.
	public static JLabel getBotonSalir() {
		return botonSalir;
	}
	
	public static JLabel getBotonLvl1() {
		return botonLvl1;
	}

	public static JLabel getBotonLvl2() {
		return botonLvl2;
	}

	public static JLabel getBotonLvl3() {
		return botonLvl3;
	}
}
