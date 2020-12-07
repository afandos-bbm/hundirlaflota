package alejandrofan2.hundirlaflota.principal;

import java.awt.*;
import javax.swing.*;

public class Frame extends JFrame{
	private static final long serialVersionUID = -2394093190969580525L;
	
	Pantalla juego = new Pantalla();
	
	public Frame() {
		 this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);       
	     this.setSize(815, 640);
	     this.add(juego);
	     this.setVisible(true);
	}
}
