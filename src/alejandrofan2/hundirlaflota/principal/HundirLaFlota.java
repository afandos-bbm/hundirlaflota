package alejandrofan2.hundirlaflota.principal;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

/*
 * Esta es la clase principal del juego la cual alberga el metodo main.
 * La clase se extiende a JFrame para poder invocar a una nueva ventana donde
 * se ejecutara el juego. Por otra parte impemetamos Rinnable para poder hacer 
 * uso de el Multitheading el cual nos ventra bien para actualizar de forma
 * continua los graficos de nuestro juego.
 */

public class HundirLaFlota extends JFrame implements Runnable {
	private static final long serialVersionUID = 7241792861214941869L;

	public static final int ANCHO = 800;
	public static final int ALTO = 600;
	private static final String NOMBRE = "HUNDIR LA FLOTA (Singleplayer)";
	private static final String RUTA_ICONO = "res/images/icono.png";

	private static volatile boolean isRunning = false;

	private static JFrame ventana;
	private static Thread thread;

	GestorPantalla pantalla = new GestorPantalla();

	Image icono = new ImageIcon(RUTA_ICONO).getImage();

	// Constructor de la clase HundirLaFlota.
	private HundirLaFlota() {
		this.setPreferredSize(new Dimension(ANCHO, ALTO));
		ventana = new JFrame(NOMBRE);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setIconImage(icono);
		ventana.setResizable(false);
		ventana.setLayout(new BorderLayout());
		ventana.add(pantalla, BorderLayout.CENTER);
		ventana.pack();
		ventana.setLocationRelativeTo(null);
		ventana.setVisible(true);
	}

	// Metodo main.
	public static void main(String[] args) {
		HundirLaFlota juego = new HundirLaFlota();
	}

	// Metodo que ejecuta el segundo thread de procesamiento.
	public void run() {
		System.out.println("El segundo thread se esta ejecutando.");
		while (isRunning) {
		}
	}

	// Metodo que inicia el thread.
	private synchronized void iniciar() {
		isRunning = true;

		thread = new Thread(this, "Graficos");
		thread.start();
	}

	// Metodo que detiene el thread.
	private synchronized void detener() {
		isRunning = false;

		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
