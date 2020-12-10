package alejandrofan2.hundirlaflota.principal;

import alejandrofan2.hundirlaflota.utiles.Randomize;

public class Barcos {

	private static int nLanchas = 5;
	private static int nBuques = 3;
	private static int nAcorazado = 1;
	private static int nPortaaviones = 1;
	private static int nIntentos = 50;

	private static void insertarLancha(char[][] mapa) {
		int posicionLancha[] = Randomize.puntoAleatorio(MecanicasJuego.getTamañoMapa());
		mapa[posicionLancha[0]][posicionLancha[1]] = 76;
	}

	private static void insertarBuque(char[][] mapa) { // 3 en horizontal
		int posicionLancha[] = Randomize.puntoAleatorio(MecanicasJuego.getTamañoMapa());
		int posCreacionX = posicionLancha[0];
		int posCreacionY = posicionLancha[1];

		if (posCreacionY < mapa.length - 2 && posCreacionY >= 1) {
			mapa[posCreacionX][posCreacionY] = 66;
			mapa[posCreacionX][posCreacionY + 1] = 66;
			mapa[posCreacionX][posCreacionY + 2] = 66;
		} else if (posCreacionY == mapa.length - 2) {
			mapa[posCreacionX][posCreacionY] = 66;
			mapa[posCreacionX][posCreacionY - 1] = 66;
			mapa[posCreacionX][posCreacionY + 1] = 66;
		} else if (posCreacionY == mapa.length - 1) {
			mapa[posCreacionX][posCreacionY] = 66;
			mapa[posCreacionX][posCreacionY - 1] = 66;
			mapa[posCreacionX][posCreacionY - 2] = 66;
		}
	}

	private static void insertarAcorazado(char[][] mapa) { // 4 en horizontal
		int posicionLancha[] = Randomize.puntoAleatorio(MecanicasJuego.getTamañoMapa());
		int posCreacionX = posicionLancha[0];
		int posCreacionY = posicionLancha[1];

		System.out.println(posCreacionX + " " + posCreacionY + " | " + mapa.length);
		if (posCreacionY < mapa.length - 3 && posCreacionY >= 1) {
			mapa[posCreacionX][posCreacionY] = 90;
			mapa[posCreacionX][posCreacionY + 1] = 90;
			mapa[posCreacionX][posCreacionY + 2] = 90;
			mapa[posCreacionX][posCreacionY + 3] = 90;
		} else if (posCreacionY == mapa.length - 3) {
			mapa[posCreacionX][posCreacionY] = 90;
			mapa[posCreacionX][posCreacionY - 1] = 90;
			mapa[posCreacionX][posCreacionY + 1] = 90;
			mapa[posCreacionX][posCreacionY + 2] = 90;
		} else if (posCreacionY == mapa.length - 2) {
			mapa[posCreacionX][posCreacionY] = 90;
			mapa[posCreacionX][posCreacionY + 1] = 90;
			mapa[posCreacionX][posCreacionY - 1] = 90;
			mapa[posCreacionX][posCreacionY - 2] = 90;
		} else if (posCreacionY == mapa.length - 1) {
			mapa[posCreacionX][posCreacionY] = 90;
			mapa[posCreacionX][posCreacionY - 1] = 90;
			mapa[posCreacionX][posCreacionY - 2] = 90;
			mapa[posCreacionX][posCreacionY - 3] = 90;
		}
	}

	private static void insertarPortaviones(char[][] mapa) { // 5 en vertical
		int posicionLancha[] = Randomize.puntoAleatorio(MecanicasJuego.getTamañoMapa());
		int posCreacionX = posicionLancha[0];
		int posCreacionY = posicionLancha[1];

		System.out.println(posCreacionX + " " + posCreacionY + " | " + mapa.length);
		if (posCreacionX < mapa.length - 4 && posCreacionX >= 1) {
			mapa[posCreacionX][posCreacionY] = 80;
			mapa[posCreacionX + 1][posCreacionY] = 80;
			mapa[posCreacionX + 2][posCreacionY] = 80;
			mapa[posCreacionX + 3][posCreacionY] = 80;
			mapa[posCreacionX + 4][posCreacionY] = 80;
		} else if (posCreacionX == mapa.length - 4) {
			mapa[posCreacionX][posCreacionY] = 80;
			mapa[posCreacionX - 1][posCreacionY] = 80;
			mapa[posCreacionX + 3][posCreacionY] = 80;
			mapa[posCreacionX + 1][posCreacionY] = 80;
			mapa[posCreacionX + 2][posCreacionY] = 80;
		} else if (posCreacionX == mapa.length - 3) {
			mapa[posCreacionX][posCreacionY] = 80;
			mapa[posCreacionX - 1][posCreacionY] = 80;
			mapa[posCreacionX - 2][posCreacionY] = 80;
			mapa[posCreacionX + 1][posCreacionY] = 80;
			mapa[posCreacionX + 2][posCreacionY] = 80;
		} else if (posCreacionX == mapa.length - 2) {
			mapa[posCreacionX][posCreacionY] = 80;
			mapa[posCreacionX - 1][posCreacionY] = 0;
			mapa[posCreacionX - 2][posCreacionY] = 80;
			mapa[posCreacionX - 3][posCreacionY] = 80;
			mapa[posCreacionX + 1][posCreacionY] = 80;
		} else if (posCreacionX == mapa.length - 1) {
			mapa[posCreacionX][posCreacionY] = 80;
			mapa[posCreacionX - 1][posCreacionY] = 80;
			mapa[posCreacionX - 2][posCreacionY] = 80;
			mapa[posCreacionX - 3][posCreacionY] = 80;
			mapa[posCreacionX - 4][posCreacionY] = 80;

		}
	}

	public static void insertarBarcos(char[][] mapa, int nLanchas, int nBuques, int nAcorazados, int nPortaaviones) {
		for (int i = 0; i < nLanchas; i++) {
			insertarLancha(mapa);
		}
		for (int i = 0; i < nBuques; i++) {
			insertarBuque(mapa);
		}
		for (int i = 0; i < nAcorazados; i++) {
			insertarAcorazado(mapa);
		}
		for (int i = 0; i < nPortaaviones; i++) {
			insertarPortaviones(mapa);
		}
	}

	public static int getnLanchas() {
		return nLanchas;
	}

	public static void setnLanchas(int nLanchas) {
		Barcos.nLanchas = nLanchas;
	}

	public static int getnBuques() {
		return nBuques;
	}

	public static void setnBuques(int nBuques) {
		Barcos.nBuques = nBuques;
	}

	public static int getnAcorazado() {
		return nAcorazado;
	}

	public static void setnAcorazado(int nAcorazado) {
		Barcos.nAcorazado = nAcorazado;
	}

	public static int getnPortaaviones() {
		return nPortaaviones;
	}

	public static void setnPortaaviones(int nPortaaviones) {
		Barcos.nPortaaviones = nPortaaviones;
	}
}
