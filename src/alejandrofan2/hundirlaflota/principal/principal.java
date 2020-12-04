package alejandrofan2.hundirlaflota.principal;

import java.awt.BorderLayout;

import javax.swing.JFrame;
 	
public class principal extends JFrame {
	
	static menu menu = new menu();
	
	static String rutaLogo = "/home/alefer/Documentos/logo.png";
    static JFrame juego = new JFrame("Hundir la flota (Singleplayer)");
	int posicionesMapa[][] = new int[25][25];

	public static void main(String[] args) {
		panel();
	}

	
	public static void panel() {
		 menu menu = new menu();
		 cabecera cabecera = new cabecera();
	     juego.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);       
	     juego.setSize(800, 600);
	     juego.setLayout(new BorderLayout());
	     juego.add(menu.menu(), BorderLayout.EAST);
	     juego.add(cabecera.cabecera(), BorderLayout.NORTH);
	     juego.setVisible(true);
	}

}
