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

public class GestorPantalla extends JPanel {
	private static final long serialVersionUID = 7656685126706339194L;

	private static final String rutaFondo = "res/images/mapa.png";

	private static final String rutaPlay = "res/images/play.png";
	private static final String rutaSalir = "res/images/salir.png";

	private static JLabel botonPlay;
	private static JLabel botonSalir;

	private ControlRaton raton;

	ImageIcon imgPlay;
	ImageIcon imgSalir;
	Image imgFondo;
	Dimension size;

	// Constructor de la clade GestorPantalla.
	public GestorPantalla() {
		Insets insets = this.getInsets();
		this.setPreferredSize(new Dimension(HundirLaFlota.ANCHO, HundirLaFlota.ALTO));
		this.setLayout(null);
		imgFondo = new ImageIcon(rutaFondo).getImage();
		imgPlay = new ImageIcon(rutaPlay);
		imgSalir = new ImageIcon(rutaSalir);
		botonPlay = new JLabel();
		botonSalir = new JLabel();
		if (imgPlay != null) {
			getBotonPlay().setIcon(imgPlay);
			getBotonPlay().setText("");
		} else {
			getBotonPlay().setText("Error");
		}
		if (imgSalir != null) {
			botonSalir.setIcon(imgSalir);
			botonSalir.setText("");
		} else {
			botonSalir.setText("Error");
		}
		size = botonSalir.getPreferredSize();
		botonSalir.setBounds(612 + insets.left, 503 + insets.top, size.width, size.height);
		botonSalir.setVisible(true);
		size = getBotonPlay().getPreferredSize();
		getBotonPlay().setBounds(612 + insets.left, 432 + insets.top, size.width, size.height);
		getBotonPlay().setVisible(true);
		this.add(getBotonPlay());
		this.add(botonSalir);
		raton = new ControlRaton();
		botonPlay.addMouseListener(raton);
		botonSalir.addMouseListener(raton);

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

	// Getter del boton play que usamos para comprobar si se ha clickado en el.
	public static JLabel getBotonPlay() {
		return botonPlay;
	}

	// Getter del boton salir que usamos para comprobar si se ha clickado en el.
	public static JLabel getBotonSalir() {
		return botonSalir;
	}
}
