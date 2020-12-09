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
	public static int ratonX = 0;
	public static int ratonY = 0;

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
			System.out.println("Has presionado play");
		}
		if (e.getSource() == GestorPantalla.getBotonSalir()) {
			if (JOptionPane.showConfirmDialog(null, "¿Seguro que deseas cerrar el juego?", "Hundir la Flota", 0,
					0) == 0) {
				System.exit(0);
			}
		}
		if (e.getSource() == GestorPantalla.getBotonLvl1()) {
			System.out.println("Has presionado lvl1");
			if (HundirLaFlota.getLvlAcual() != 1) {
				HundirLaFlota.setLvlAcual((short)1);
			}
		}
		if (e.getSource() == GestorPantalla.getBotonLvl2()) {
			System.out.println("Has presionado lvl2");
			if (HundirLaFlota.getLvlAcual() != 2) {
				HundirLaFlota.setLvlAcual((short)3);
			}
		}
		if (e.getSource() == GestorPantalla.getBotonLvl3()) {
			System.out.println("Has presionado lvl3");
			if (HundirLaFlota.getLvlAcual() != 3) {
				HundirLaFlota.setLvlAcual((short)3);
			}
		}

		System.out.println("X: " + ratonX + " | Y: " + ratonY);
	}

	// Getter de la variable Click que nos indica si el click ha sido pulsado.
	public boolean getClick() {
		return click;
	}

	// metodo que restartea la variable click despues de ser pulsada
	public boolean restartClick() {
		if (click) {
			click = false;
		}
		return click;
	}
}
