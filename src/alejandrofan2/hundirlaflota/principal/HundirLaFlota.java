package alejandrofan2.hundirlaflota.principal;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;
import java.util.Scanner;

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
	public static final String NOMBRE = "HUNDIR LA FLOTA (Singleplayer)";
	private static final String RUTA_ICONO = "res/images/icono.png";

	private static volatile Boolean isRunning = false;
	private static volatile Boolean isPlaying = false;
	private static Short lvlAcual = 1;
	private static Boolean nivelpersonalizado = false;

	private static GestorPantalla pantalla = new GestorPantalla();

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
		@SuppressWarnings("unused")
		HundirLaFlota juego = new HundirLaFlota();
		int[] posicionAtaque = new int[2];
		char[][] mapa = MecanicasJuego.crearMapa(MecanicasJuego.getTamañoMapa());
		pantalla.iniciar();
		Boolean checkMapa = false;
		while (isRunning) { //Se ejecuta cuando se inicia el segundo thread
			if (isPlaying()) { //Se ejecuta cuando le das a el boton de jugar.

				if (checkMapa == false) {
					mapa = MecanicasJuego.crearMapa(MecanicasJuego.getTamañoMapa());
					checkMapa = true;
				}
				MecanicasJuego.imprimirMapaConsola(mapa);
				Scanner teclado = new Scanner(System.in);
				posicionAtaque[0] = teclado.nextInt() -1;
				posicionAtaque[1] = teclado.nextInt() -1;
				MecanicasJuego.atacar(mapa, posicionAtaque);
				MecanicasJuego.imprimirMapaConsola(mapa);
				if (MecanicasJuego.getVidasBarcos() == 0) {
					System.out.println("[" + NOMBRE + "] Has ganado, saliendo.");
					isPlaying = false;
					isRunning = false;
					System.exit(0);
				}
				if (MecanicasJuego.getnIntentos() == 0) {
					System.out.println("[" + NOMBRE + "] Has perdido, saliendo.");
					isPlaying = false;
					isRunning = false;
					System.exit(0);
				}
			}
		}
	}

	public static Boolean getIsRunning() {
		return isRunning;
	}

	public static void setIsRunning(Boolean isRunning) {
		HundirLaFlota.isRunning = isRunning;
	}

	public static Boolean getIsPlaying() {
		return isPlaying;
	}

	public static void setIsPlaying(Boolean isPlaying) {
		HundirLaFlota.isPlaying = isPlaying;
	}

	public static boolean getRunning() {
		return isRunning;
	}

	public static void setRunning(boolean isRunning) {
		HundirLaFlota.isRunning = isRunning;
	}

	public static boolean isPlaying() {
		return isPlaying;
	}

	public static void setPlaying(boolean isPlaying) {
		HundirLaFlota.isPlaying = isPlaying;
	}

	public static short getLvlAcual() {
		return lvlAcual;
	}

	public static void setLvlAcual(short lvlAcual) {
		HundirLaFlota.lvlAcual = lvlAcual;
	}

	public static Boolean getNivelpersonalizado() {
		return nivelpersonalizado;
	}

	public static void setNivelpersonalizado(Boolean nivelpersonalizado) {
		HundirLaFlota.nivelpersonalizado = nivelpersonalizado;
	}

}
