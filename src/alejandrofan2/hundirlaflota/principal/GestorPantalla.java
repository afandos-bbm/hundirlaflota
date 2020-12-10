package alejandrofan2.hundirlaflota.principal;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Insets;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

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
	private static final String RUTA_LVL1_ROJO = "res/images/1rojo.png";
	private static final String RUTA_LVL1_VERDE = "res/images/1verde.png";
	private static final String RUTA_LVL2_ROJO = "res/images/2rojo.png";
	private static final String RUTA_LVL2_VERDE = "res/images/2verde.png";
	private static final String RUTA_LVL3_ROJO = "res/images/3rojo.png";
	private static final String RUTA_LVL3_VERDE = "res/images/3verde.png";

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
		botonLvl1.setBounds(575 + insets.left, 370 + insets.top, size.width, size.height);
		botonLvl1.setVisible(true);
		size = botonLvl2.getPreferredSize();
		botonLvl2.setBounds(650 + insets.left, 370 + insets.top, size.width, size.height);
		botonLvl2.setVisible(true);
		size = botonLvl3.getPreferredSize();
		botonLvl3.setBounds(727 + insets.left, 370 + insets.top, size.width, size.height);
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
			if (!HundirLaFlota.isPlaying()) {
				selectorNivel();
			}
		}
	}

	private void selectorNivel() {
		switch (HundirLaFlota.getLvlAcual()) {
		case 1:
			Barcos.setnLanchas(5);
			Barcos.setnBuques(3);
			Barcos.setnAcorazado(1);
			Barcos.setnPortaaviones(1);
			imgLvl1 = new ImageIcon(RUTA_LVL1_VERDE);
			imgLvl2 = new ImageIcon(RUTA_LVL2_ROJO);
			imgLvl3 = new ImageIcon(RUTA_LVL3_ROJO);
			botonLvl1.setIcon(imgLvl1);
			botonLvl2.setIcon(imgLvl2);
			botonLvl3.setIcon(imgLvl3);
			botonLvl1.repaint();
			botonLvl2.repaint();
			botonLvl3.repaint();
			HundirLaFlota.setNivelpersonalizado(false);
			break;

		case 2:
			Barcos.setnLanchas(5);
			Barcos.setnBuques(3);
			Barcos.setnAcorazado(1);
			Barcos.setnPortaaviones(1);
			imgLvl1 = new ImageIcon(RUTA_LVL1_ROJO);
			imgLvl2 = new ImageIcon(RUTA_LVL2_VERDE);
			imgLvl3 = new ImageIcon(RUTA_LVL3_ROJO);
			botonLvl1.setIcon(imgLvl1);
			botonLvl2.setIcon(imgLvl2);
			botonLvl3.setIcon(imgLvl3);
			botonLvl1.repaint();
			botonLvl2.repaint();
			botonLvl3.repaint();
			HundirLaFlota.setNivelpersonalizado(false);
			break;

		case 3:
			JPanel panel = new JPanel();
			JTextField nLanchas = new JTextField(2);
			JTextField nBuques = new JTextField(2);
			JTextField nAcorazados = new JTextField(2);
			JTextField nPortaaviones = new JTextField(2);
			JTextField tamaño = new JTextField(3);
			JTextField nIntentos = new JTextField(2);
			int popup = 2;
			panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
			panel.add(new JLabel("Tamaño del tablero:"));
			panel.add(tamaño);
			panel.add(new JLabel("Numero de lanchas:"));
			panel.add(nLanchas);
			panel.add(new JLabel("Numero de Buques:"));
			panel.add(nBuques);
			panel.add(new JLabel("Numero de Acorazados:"));
			panel.add(nAcorazados);
			panel.add(new JLabel("Numero de Portaaviones:"));
			panel.add(nPortaaviones);
			panel.add(new JLabel("Intentos maximos:"));
			panel.add(nIntentos);

			if (HundirLaFlota.getNivelpersonalizado() == false) {
				popup = JOptionPane.showConfirmDialog(null, panel, "Hundir la flota - Personalizado",
						JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
				if (popup == 2) {
					HundirLaFlota.setLvlAcual((short) 1);
					break;
				} else if (nLanchas.getText().length() == 0 || nBuques.getText().length() == 0
						|| nAcorazados.getText().length() == 0 || nPortaaviones.getText().length() == 0
						|| tamaño.getText().length() == 0 || nIntentos.getText().length() == 0) {
					JOptionPane.showConfirmDialog(null, "Debes introducir todos los valores.",
							"Hundir la flota - ERROR", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
					HundirLaFlota.setLvlAcual((short) 1);
					break;
				}
				if (!(nLanchas.getText().matches("[0-9]+") && nBuques.getText().matches("[0-9]+")
						&& nAcorazados.getText().matches("[0-9]+") && nPortaaviones.getText().matches("[0-9]+")
						&& tamaño.getText().matches("[0-9]+") && nIntentos.getText().matches("[0-9]+"))) {
					JOptionPane.showConfirmDialog(null, "Debes introducir solo numeros enteros.",
							"Hundir la flota - ERROR", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
					HundirLaFlota.setLvlAcual((short) 1);
					break;
				} else {
					Barcos.setnLanchas(Integer.parseInt(nLanchas.getText()));
					Barcos.setnBuques(Integer.parseInt(nBuques.getText()));
					Barcos.setnAcorazado(Integer.parseInt(nAcorazados.getText()));
					Barcos.setnPortaaviones(Integer.parseInt(nPortaaviones.getText()));
					MecanicasJuego.setTamañoMapa(Integer.parseInt(tamaño.getText()) + 1);
					MecanicasJuego.setnIntentos(Integer.parseInt(nIntentos.getText()));
					imgLvl1 = new ImageIcon(RUTA_LVL1_ROJO);
					imgLvl2 = new ImageIcon(RUTA_LVL2_ROJO);
					imgLvl3 = new ImageIcon(RUTA_LVL3_VERDE);
					botonLvl1.setIcon(imgLvl1);
					botonLvl2.setIcon(imgLvl2);
					botonLvl3.setIcon(imgLvl3);
					botonLvl1.repaint();
					botonLvl2.repaint();
					botonLvl3.repaint();
					HundirLaFlota.setNivelpersonalizado(true);
				}
			}
			break;

		default:
			break;
		}

	}

	// Metodo que inicia el thread.
	public synchronized void iniciar() {
		HundirLaFlota.setRunning(true);

		thread = new Thread(this, "Graficos");
		thread.start();
	}

	// Metodo que detiene el thread.true
	public synchronized void detener() {
		HundirLaFlota.setPlaying(false);
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
