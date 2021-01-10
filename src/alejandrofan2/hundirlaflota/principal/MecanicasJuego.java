package alejandrofan2.hundirlaflota.principal;

public class MecanicasJuego {

	private static int vidasBarcos = 0;

	private static int nIntentos = 50;
	private static int tamañoMapa = 10;
	private static int[] ejeX;
	private static char[] ejeY = new char[]{65,66,67,68,69,70,71,72,73,74,75,76,77,78,79,80,81,82,83,84,85,86,87,88,89,90};

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
		

	}
	
	public static char[][] crearMapa(int tamaño) {
		char[][] m = new char[tamaño][tamaño];
		ejeX = new int[tamaño];
		int cont = 1;
		char cont2 = 65;
		for (int i = 0; i < ejeX.length; i++) {
			ejeX[i] = cont++;
		}
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m.length; j++) {
				m[i][j] = 45;
			}
		}
		GestorBarcos.insertarBarcos(m, GestorBarcos.getnLanchas(), GestorBarcos.getnBuques(), GestorBarcos.getnAcorazado(),GestorBarcos.getnPortaaviones());
		return m;
	}
	
	public static void imprimirMapaConsola(char[][] mapa) {
		System.out.print(" ");
		for (int i = 0; i < mapa.length; i++) {
			System.out.print("  " + ejeX[i]);
		}
		System.out.println("");
		for (int i = 0; i < mapa.length; i++) {
			System.out.print(ejeY[i] + "  ");
			for (int j = 0; j < mapa.length; j++) {
				System.out.print(mapa[i][j] + "  ");
			}
			System.out.println("");
		}
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