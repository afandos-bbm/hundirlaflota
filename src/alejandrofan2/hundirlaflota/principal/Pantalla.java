package alejandrofan2.hundirlaflota.principal;

import java.awt.*;
import javax.swing.*;

public class Pantalla extends JPanel {
	private static final long serialVersionUID = -3360598366287380175L;
	
	String rutaFondo = "res/images/mapa.png";
	Image img;
	
	public Pantalla() {
		this.setPreferredSize(new Dimension(800,600));
		img = new ImageIcon(rutaFondo).getImage();
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		this.setBackground(Color.BLACK);
		
		Graphics2D g2D = (Graphics2D) g;
		g2D.drawImage(img, 0, 0, null);
	}
}
