package alejandrofan2.hundirlaflota.utiles;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;

import alejandrofan2.hundirlaflota.principal.GestorPantalla;
import alejandrofan2.hundirlaflota.principal.HundirLaFlota;

/*
 * Esta clase se encarga de gestionar el raton y todas sus interaciones, 
 * se extiende a MouseAdapter para tener ya los metodos abstractos
 * MouseListener, MouseMotionListener, MouseWheelListener directamente.
 */

public class ControlRaton extends MouseAdapter {

	private boolean click;
	private static int ratonX = 0;
	private static int ratonY = 0;

	// Constructor de la clase ControlRaton.
	public ControlRaton() {
		click = false;
	}

	// Metodo abstracto que se ejecuta cuando se hace un click completo.
	@Override
	public void mouseClicked(MouseEvent e) {
		ratonX = e.getX();
		ratonY = e.getY();
		
		if (!click) {
			click = true;
		}
		if (e.getSource() == GestorPantalla.getBotonPlay()) {
			HundirLaFlota.setIsPlaying(true);
			System.out.println("[" + HundirLaFlota.NOMBRE + "] -------------------------------------------------");
			System.out.println("[" + HundirLaFlota.NOMBRE + "] El juego ha empezado. Suerte! Nivel de juego: " + HundirLaFlota.getLvlAcual());
			System.out.println("[" + HundirLaFlota.NOMBRE + "] -------------------------------------------------");
			}
		if (e.getSource() == GestorPantalla.getBotonSalir()) {
			if (JOptionPane.showConfirmDialog(null, "¿Seguro que deseas cerrar el juego?", "Hundir la Flota", 0,
					0) == 0) {
				System.exit(0);
			}
		}
		if (e.getSource() == GestorPantalla.getBotonLvl1()) {
			if (HundirLaFlota.getLvlAcual() != 1) {
				HundirLaFlota.setLvlAcual((short)1);
			}
		}
		if (e.getSource() == GestorPantalla.getBotonLvl2()) {
			if (HundirLaFlota.getLvlAcual() != 2) {
				HundirLaFlota.setLvlAcual((short)2);
			}
		}
		if (e.getSource() == GestorPantalla.getBotonLvl3()) {
			if (HundirLaFlota.getLvlAcual() != 3) {
				HundirLaFlota.setLvlAcual((short)3);
	}}}

	//Metodo que restartea la variable click despues de ser pulsada.
	public boolean restartClick() {
		if (click) {
			click = false;
		}
		return click;
	}
	
			/* Getters & Setters */

	public boolean getClick() {
		return click;
	}
	
	public static int getRatonX() {
		return ratonX;
	}

	public static int getRatonY() {
		return ratonY;
	}
}
