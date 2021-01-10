package alejandrofan2.hundirlaflota.principal;

public class MecanicasJuego {

	private static int vidasBarcos = 0;

	private static int nIntentos = 50;
	private static int tamañoMapa = 10;
	private static int[] ejeX;
	private static char[] ejeY;
	private static char[][] MapaJugador;
	private static char[][] MapaContrincante;

	public MecanicasJuego() {
		MapaJugador = crearmapa(tamañoMapa);
		MapaContrincante = crearmapa(tamañoMapa);

<<<<<<< Updated upstream
=======
	public static void atacar(char[][] mapa, int[] posicionAtaque) {
		int posicionAtaqueX = posicionAtaque[0];
		int posicionAtaqueY = posicionAtaque[1];
		
		if (mapa[posicionAtaqueX][posicionAtaqueY] != 45) {
			switch (mapa[posicionAtaqueX][posicionAtaqueY]) {
			case 65:
				//Ya has disparado ahi
				nIntentos--;
				break;
			case 76:
				//Lancha
				nIntentos--;
				vidasBarcos--;
				mapa[posicionAtaqueX][posicionAtaqueY] = 65;
				break;
			case 66:
				//Buque
				nIntentos--;
				vidasBarcos--;
				mapa[posicionAtaqueX][posicionAtaqueY] = 65;
				break;
			case 90:
				//Acorazado
				nIntentos--;
				vidasBarcos--;
				mapa[posicionAtaqueX][posicionAtaqueY] = 65;
				break;
			case 80:
				//Portaaviones
				nIntentos--;
				vidasBarcos--;
				mapa[posicionAtaqueX][posicionAtaqueY] = 65;
				break;
			default:
				//Fallo
				System.out.println("[" + HundirLaFlota.NOMBRE + "] Fallo en el sistema, saltando turno... (Sistema de ataque)");
				break;
			}
		} else {
			// Agua
			nIntentos--;
			mapa[posicionAtaqueX][posicionAtaqueY] = 65;
		}
		

>>>>>>> Stashed changes
	}

	public static char[][] crearmapa(int tamaño) {
		char[][] m = new char[tamaño][tamaño];
		ejeX = new int[tamaño];
<<<<<<< Updated upstream
		ejeY = new char[tamaño];
=======
		int cont = 1;
		char cont2 = 65;
		for (int i = 0; i < ejeX.length; i++) {
			ejeX[i] = cont++;
		}
>>>>>>> Stashed changes
		for (int i = 0; i < m.length; i++) {
			int cont = 65;
			ejeX[i] = i;
			ejeY[i] = (char) cont;
			cont++;
			for (int j = 0; j < m.length; j++) {
				m[i][j] = 45;
				}
			}
		Barcos.insertarBarcos(m, Barcos.getnLanchas(), Barcos.getnBuques(), Barcos.getnAcorazado(),
				Barcos.getnPortaaviones());
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m.length; j++) {
				System.out.print(m[i][j] + "  ");
			}
			System.out.println(ejeY + " | ");
		}
		return m;
	}

	public static int getnIntentos() {
		return nIntentos;
	}

	public static void setnIntentos(int nIntentos) {
		MecanicasJuego.nIntentos = nIntentos;
	}

	public static int getTamañoMapa() {
		return tamañoMapa;
	}

	public static void setTamañoMapa(int tamañoMapa) {
		MecanicasJuego.tamañoMapa = tamañoMapa;
	}

	public static int getVidasBarcos() {
		return vidasBarcos;
	}

	public static void setVidasBarcos(int vidasBarcos) {
		MecanicasJuego.vidasBarcos = vidasBarcos;
	}
}