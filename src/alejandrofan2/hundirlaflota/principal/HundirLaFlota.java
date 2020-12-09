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

public class HundirLaFlota extends JFrame {
	private static final long serialVersionUID = 7241792861214941869L;

	public static final int ANCHO = 800;
	public static final int ALTO = 600;
	private static final String NOMBRE = "HUNDIR LA FLOTA (Singleplayer)";
	private static final String RUTA_ICONO = "res/images/icono.png";

	private static volatile boolean isRunning = false;
	private static short lvlAcual = 1;

	private static  GestorPantalla pantalla = new GestorPantalla();
	
	private static JFrame ventana;
	private static Image icono;


	// Constructor de la clase HundirLaFlota.
	private HundirLaFlota() {
		icono = new ImageIcon(RUTA_ICONO).getImage();
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
		pantalla.iniciar();
	}

	public static boolean getRunning() {
		return isRunning;
	}
	
	public static void setRunning(boolean isRunning) {
		HundirLaFlota.isRunning = isRunning;
	}

	public static short getLvlAcual() {
		return lvlAcual;
	}

	public static void setLvlAcual(short lvlAcual) {
		HundirLaFlota.lvlAcual = lvlAcual;
	}
}
