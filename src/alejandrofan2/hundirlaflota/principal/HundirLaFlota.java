package alejandrofan2.hundirlaflota.principal;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import alejandrofan2.hundirlaflota.utiles.Transformer;

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
	
	//Constantes para el uso de colores en la consola.
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_RESET = "\u001B[0m";

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

	// Metodo main. Ejecuta el hilo logico del programa.
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		@SuppressWarnings("unused")
		HundirLaFlota juego = new HundirLaFlota();
		Scanner teclado = new Scanner(System.in);
		int[] posicionAtaque = new int[2];
		char[][] mapa = MecanicasJuego.crearMapa(MecanicasJuego.getTamañoMapa());
		pantalla.iniciar();
		Boolean checkMapa = false;
		//Para jugar de forma no grafica debes seleccionar el nivel y darle a jugar desde el JFrame debido a que el codigo original esta
		// pensado para jugar con GUI y no sin ella.
		System.out.println(ANSI_YELLOW + "[" + NOMBRE + "] Debes selecionar el nivel desde la GUI. (Temporalmente)" + ANSI_RESET);
		while (isRunning) { //Se ejecuta cuando se inicia el segundo thread.
			if (isPlaying()) { //Se ejecuta cuando le das a el boton de jugar.
				if (!checkMapa) {
					mapa = MecanicasJuego.crearMapa(MecanicasJuego.getTamañoMapa());
					checkMapa = true;
				}
				MecanicasJuego.imprimirMapaConsola(mapa);
				//Estos dos Scanners no estan controlados los fallos debido a que son temporales
				System.out.print("\nIntroduce la fila y columna(A1,B2,C3...): ");
				String coords = teclado.nextLine();
				if (Transformer.letraanum((String) coords.subSequence(0, 1)) - 1 >= MecanicasJuego.getTamañoMapa() || Integer.parseInt((String) coords.subSequence(1, 2)) - 1 >= MecanicasJuego.getTamañoMapa() || (coords.subSequence(1, 2).toString().matches("[0-9]"))) {     
					System.out.println(ANSI_YELLOW + "[" + NOMBRE + "] Debes colocar el formato correcto o no salirte del mapa. (A1,B2,C3...)" + ANSI_RESET);
					continue;
				}
				posicionAtaque[0] = Transformer.letraanum((String) coords.subSequence(0, 1)) - 1;
				if (coords.length() < 3)
					posicionAtaque[1] = Integer.parseInt((String) coords.subSequence(1, 2)) - 1;
				else
					posicionAtaque[1] = Integer.parseInt((String) coords.subSequence(1, 3)) - 1;
				MecanicasJuego.atacar(mapa, posicionAtaque);
				if (MecanicasJuego.getVidasBarcos() == 0) {
					System.out.println(ANSI_GREEN + "\n[" + NOMBRE + "] Has ganado, pulsa cualquier tecla para salir." + ANSI_RESET);
					isPlaying = false;
					isRunning = false;
					System.exit(0);
				}
				if (MecanicasJuego.getnIntentos() == 0) {
					System.out.println("\n[" + NOMBRE + "] Has perdido, saliendo.");
					isPlaying = false;
					isRunning = false;
					System.exit(0);
				if (MecanicasJuego.getnIntentos() == 5) {
					System.out.println("\n[" + NOMBRE + "] Te quedan 5 disparos.\n");					
	}}}}}

			/* Getters & Setters */

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