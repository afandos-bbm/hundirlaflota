package alejandrofan2.hundirlaflota.principal;

import java.util.ArrayList;

public class Barco {
	
	private static short tipoBarco = 0; // 0 Nulo | 1 Lancha | 2 Buque | 3 Acorazado | 4 Portaaviones
	private static short vidaBarco = 0; //Numero de casillas que ocupa
	private static String nombreBarco;
    public ArrayList<Integer> posicionesX=new ArrayList<Integer>();
    public ArrayList<Integer> posicionesY=new ArrayList<Integer>();

	public Barco(String nbarco,int tBarco, int[] posBarco) {
		tipoBarco = (short) tBarco;
		nombreBarco = nbarco;
		switch (tipoBarco) {
		case 1: //Lancha
			posicionesX.add(posBarco[1]);
			posicionesY.add(posBarco[0]);
			vidaBarco = 1;
			System.out.println("tests");
			break;
		case 2: //Buque
			posicionesX.add(posBarco[1]);
			posicionesY.add(posBarco[0]);
			posicionesX.add(posBarco[1] + 1);
			posicionesY.add(posBarco[0]);
			posicionesX.add(posBarco[1] + 2);
			posicionesY.add(posBarco[0]);
			vidaBarco = 3;
			break;
		case 3: //Acorazado
			posicionesX.add(posBarco[1]);
			posicionesY.add(posBarco[0]);
			posicionesX.add(posBarco[1] + 1);
			posicionesY.add(posBarco[0]);
			posicionesX.add(posBarco[1] + 2);
			posicionesY.add(posBarco[0]);
			posicionesX.add(posBarco[1] + 3);
			posicionesY.add(posBarco[0]);
			vidaBarco = 4;
			break;
		case 4: //Portaaviones
			posicionesX.add(posBarco[1]);
			posicionesY.add(posBarco[0]);
			posicionesX.add(posBarco[1]);
			posicionesY.add(posBarco[0] + 1);
			posicionesX.add(posBarco[1]);
			posicionesY.add(posBarco[0] + 2);
			posicionesX.add(posBarco[1]);
			posicionesY.add(posBarco[0] + 3);
			posicionesX.add(posBarco[1]);
			posicionesY.add(posBarco[0] + 4);
			vidaBarco = 5;
			break;
		default:
			System.out.println("[" + HundirLaFlota.NOMBRE + "] [ERROR] El sistema ha fallado, saliendo. (Creador de objeto barco)");
			HundirLaFlota.setPlaying(false);
			HundirLaFlota.setRunning(false);
			System.exit(0);
			break;
		}
	}

	public ArrayList<Integer> getPosicionesX() {
		return posicionesX;
	}

	public ArrayList<Integer> getPosicionesY() {
		return posicionesY;
	}

	public void hitBarco(int[] posicionAtaque) {
		if (vidaBarco > 0) {
			Barco.vidaBarco--;
			System.out.println("["+ HundirLaFlota.NOMBRE + "] " + nombreBarco + "ha sido tocada.");
		} else if (vidaBarco == 0) {
			//hundido
		}
	}
}
