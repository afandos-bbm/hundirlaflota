package alejandrofan2.hundirlaflota.principal;

public class MecanicasJuego {

	private static int nIntentos = 50;
	private static int tamañoMapa = 10;
	private static int[] ejeX;
	private static char[] ejeY;
	private static char[][] MapaJugador;
	private static char[][] MapaContrincante;

	public MecanicasJuego() {
		MapaJugador = crearMapa(tamañoMapa);
		MapaContrincante = crearMapa(tamañoMapa);

	}

	public static void atacar(char[][] mapa, int[] posicionAtaque) {
		int posicionAtaqueX = posicionAtaque[0];
		int posicionAtaqueY = posicionAtaque[1];
		if (mapa[posicionAtaqueX][posicionAtaqueY] != 45) {
			switch (mapa[posicionAtaqueX][posicionAtaqueY]) {
			case 65: //ya has atacado aqui
				
				break;
			case 76: //Lancha
				
				break;
			case 66: //buque
				
				break;
			case 90: //Acorazado
				
				break;
			case 80: //Portaaviones
				
				break;
			default: //Fallo
				break;
			}
		} else {
			//agua
		}
	}
	
	public static char[][] crearMapa(int tamaño) {
		char[][] m = new char[tamaño][tamaño];
		ejeX = new int[tamaño];
		ejeY = new char[tamaño];
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m.length; j++) {
				m[i][j] = 45;
			}
		}
		GestorBarcos.insertarBarcos(m, GestorBarcos.getnLanchas(), GestorBarcos.getnBuques(), GestorBarcos.getnAcorazado(),GestorBarcos.getnPortaaviones());
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
}