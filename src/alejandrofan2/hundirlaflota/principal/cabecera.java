package alejandrofan2.hundirlaflota.principal;

import java.awt.FlowLayout;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class cabecera extends JPanel{
	 
	JPanel cabecera = new JPanel();

	public JPanel cabecera() {
		 ImageIcon logo = new ImageIcon(alejandrofan2.hundirlaflota.principal.principal.rutaLogo);
		 JLabel logof = new JLabel(" ");
		 cabecera.setLayout(new FlowLayout());
		 logof.setIcon(logo);
		 logof.setSize(400, 50);
		 logof.setVisible(true);
		 cabecera.add(logof);
		 return cabecera;
	}
	


}
