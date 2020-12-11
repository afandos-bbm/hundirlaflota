package alejandrofan2.hundirlaflota.principal;

public class MecanicasJuego {

	private static int nIntentos = 50;
	private static int tamañoMapa = 10;
	private static int[] ejeX;
	private static char[] ejeY;
	private static char[][] MapaJugador;
	private static char[][] MapaContrincante;

	public MecanicasJuego() {
		MapaJugador = crearmapa(tamañoMapa);
		MapaContrincante = crearmapa(tamañoMapa);

	}

	public static char[][] crearmapa(int tamaño) {
		char[][] m = new char[tamaño][tamaño];
		ejeX = new int[tamaño];
		ejeY = new char[tamaño];
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
}