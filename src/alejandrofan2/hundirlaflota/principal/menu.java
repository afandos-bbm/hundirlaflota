package alejandrofan2.hundirlaflota.principal;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class menu extends JPanel {

	alejandrofan2.hundirlaflota.principal.principal principal = new principal();
	
	public JPanel menu() {
		 JPanel menu = new JPanel();
		 JButton boton;
		 menu.setLayout(new BoxLayout(menu, BoxLayout.PAGE_AXIS));
		 boton = new JButton("Iniciar Juego");
		 boton.setMaximumSize(new Dimension(300, 50));
		 boton.setMinimumSize(new Dimension(300, 50));
		 boton.setAlignmentX(CENTER_ALIGNMENT);
		 menu.add(boton);
		 boton = new JButton("Selecionar nivel de dificultad");
		 boton.setMaximumSize(new Dimension(300, 50));
		 boton.setMinimumSize(new Dimension(300, 50));
		 boton.setAlignmentX(CENTER_ALIGNMENT);
		 menu.add(boton);
		return menu;
	}
}
