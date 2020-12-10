package alejandrofan2.hundirlaflota.principal;

public class MecanicasJuego {

	private static int nIntentos = 50;
	private static int tamañoMapa = 11;
	private static char[][] MapaJugador;
	private static char[][] MapaContrincante;

	public MecanicasJuego() {
		MapaJugador = crearmapa(tamañoMapa);
		MapaContrincante = crearmapa(tamañoMapa);

	}

	public static char[][] crearmapa(int tamaño) {
		char[][] m = new char[tamaño][tamaño];
		int cont = -1;
		int cont2 = 0;
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m.length; j++) {
				m[i][j] = 45;
				if (i == 0) {
					m[i][j] = (char) (65 + cont);
					cont++;
				} else if (j == 0) {
					if (cont2 < 10) {
						m[i][j] = (char) (48 + cont2);
					} else if (cont2 >= 10 && cont2 < 20) {
						m[i][j] = (char) (29 + cont2);
					}
					cont2++;
				}
			}
		}
		Barcos.insertarBarcos(m, Barcos.getnLanchas(), Barcos.getnBuques(), Barcos.getnAcorazado(),
				Barcos.getnPortaaviones());
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m.length; j++) {
				System.out.print(m[i][j] + "  ");
			}
			System.out.println("");
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
