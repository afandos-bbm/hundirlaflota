package alejandrofan2.hundirlaflota.principal;

import alejandrofan2.hundirlaflota.utiles.Randomize;

public class GestorBarcos {

	private static int nLanchas = 5;
	private static int nBuques = 3;
	private static int nAcorazado = 1;
	private static int nPortaaviones = 1;
	public static int nTotal = 10;

	private static void insertarLancha(char[][] mapa) { // 1
		int posicionLancha[] = Randomize.puntoAleatorio(MecanicasJuego.getTamañoMapa());
		int posCreacionX = posicionLancha[0];
		int posCreacionY = posicionLancha[1];
		boolean check = false;
		while (!check) {
			try {
				if (mapa[posCreacionX][posCreacionY] == 45) {
						int i = 1;
						String nombre = "Lancha"+i;
						Barco lancha = new Barco(nombre, 1, posicionLancha);
						HundirLaFlota.barcos.add(lancha);
						mapa[posCreacionX][posCreacionY] = 76;
						i++;
						check = true;
				} else {
					int nuevaPosicion[] = Randomize.puntoAleatorio(MecanicasJuego.getTamañoMapa());
					posCreacionX = nuevaPosicion[0];
					posCreacionY = nuevaPosicion[1];
				}
			} catch (Exception e) {
				int nuevaPosicion[] = Randomize.puntoAleatorio(MecanicasJuego.getTamañoMapa());
				posCreacionX = nuevaPosicion[0];
				posCreacionY = nuevaPosicion[1];
				System.out.println("[" + HundirLaFlota.NOMBRE + "] " + e + " | Lancha");
				check = false;
			}
		}
	}

	private static void insertarBuque(char[][] mapa) { // 3 en horizontal
			int posicionBuque[] = Randomize.puntoAleatorio(MecanicasJuego.getTamañoMapa());
			int posCreacionX = posicionBuque[0];
			int posCreacionY = posicionBuque[1];
			boolean check = false;
			while (!check) {
				try {
					if (mapa[posCreacionX][posCreacionY] == 45 && mapa[posCreacionX][posCreacionY + 1] == 45 && mapa[posCreacionX][posCreacionY + 2] == 45) {
							int i = 1;
							String nombre = "Buque"+i;
							Barco buque = new Barco(nombre, 2, posicionBuque);
							HundirLaFlota.barcos.add(buque);
							mapa[posCreacionX][posCreacionY] = 66;
							mapa[posCreacionX][posCreacionY + 1] = 66;
							mapa[posCreacionX][posCreacionY + 2] = 66;
							i++;
							check = true;
					} else {
						int nuevaPosicion[] = Randomize.puntoAleatorio(MecanicasJuego.getTamañoMapa());
						posCreacionX = nuevaPosicion[0];
						posCreacionY = nuevaPosicion[1];
					}
				} catch (Exception e) {
					int nuevaPosicion[] = Randomize.puntoAleatorio(MecanicasJuego.getTamañoMapa());
					posCreacionX = nuevaPosicion[0];
					posCreacionY = nuevaPosicion[1];
					System.out.println("[" + HundirLaFlota.NOMBRE + "] " + e + " | Buque");
					check = false;
				}
			}
	}

	private static void insertarAcorazado(char[][] mapa) { // 4 en horizontal
		int posicionAcorazado[] = Randomize.puntoAleatorio(MecanicasJuego.getTamañoMapa());
		int posCreacionX = posicionAcorazado[0];
		int posCreacionY = posicionAcorazado[1];
		boolean check = false;
		while (!check) {
			try {
				if (mapa[posCreacionX][posCreacionY] == 45 && mapa[posCreacionX][posCreacionY + 1] == 45 && mapa[posCreacionX][posCreacionY + 2] == 45 && mapa[posCreacionX][posCreacionY + 3] == 45 && mapa[posCreacionX][posCreacionY + 4] == 45) {
						int i = 1;
						String nombre = "Acorazado"+i;
						Barco acorazado = new Barco(nombre, 3, posicionAcorazado);
						HundirLaFlota.barcos.add(acorazado);
						mapa[posCreacionX][posCreacionY] = 90;
						mapa[posCreacionX][posCreacionY + 1] = 90;
						mapa[posCreacionX][posCreacionY + 2] = 90;
						mapa[posCreacionX][posCreacionY + 3] = 90;
						i++;
						check = true;
				} else {
					int nuevaPosicion[] = Randomize.puntoAleatorio(MecanicasJuego.getTamañoMapa());
					posCreacionX = nuevaPosicion[0];
					posCreacionY = nuevaPosicion[1];
				}
			} catch (Exception e) {
				int nuevaPosicion[] = Randomize.puntoAleatorio(MecanicasJuego.getTamañoMapa());
				posCreacionX = nuevaPosicion[0];
				posCreacionY = nuevaPosicion[1];
				System.out.println("[" + HundirLaFlota.NOMBRE + "] " + e + " | Acorazado");
				check = false;
			}
		}
	}

	private static void insertarPortaaviones(char[][] mapa) { // 5 en vertical
		int posicionPortaaviones[] = Randomize.puntoAleatorio(MecanicasJuego.getTamañoMapa());
		int posCreacionX = posicionPortaaviones[0];
		int posCreacionY = posicionPortaaviones[1];
		boolean check = false;
		while (!check) {
			try {
				if (mapa[posCreacionX][posCreacionY] == 45 && mapa[posCreacionX + 1][posCreacionY] == 45 && mapa[posCreacionX + 2][posCreacionY] == 45 && mapa[posCreacionX + 3][posCreacionY] == 45 && mapa[posCreacionX + 4][posCreacionY] == 45) {
						int i = 1;
						String nombre = "Portaaviones"+i;
						Barco Portaaviones = new Barco(nombre ,4, posicionPortaaviones);
						HundirLaFlota.barcos.add(Portaaviones);
						mapa[posCreacionX][posCreacionY] = 80;
						mapa[posCreacionX + 1][posCreacionY] = 80;
						mapa[posCreacionX + 2][posCreacionY] = 80;
						mapa[posCreacionX + 3][posCreacionY] = 80;
						mapa[posCreacionX + 4][posCreacionY] = 80;
						i++;
						check = true;
				} else {
					int nuevaPosicion[] = Randomize.puntoAleatorio(MecanicasJuego.getTamañoMapa());
					posCreacionX = nuevaPosicion[0];
					posCreacionY = nuevaPosicion[1];
				}
			} catch (Exception e) {
				int nuevaPosicion[] = Randomize.puntoAleatorio(MecanicasJuego.getTamañoMapa());
				posCreacionX = nuevaPosicion[0];
				posCreacionY = nuevaPosicion[1];
				System.out.println("[" + HundirLaFlota.NOMBRE + "] " + e + " | Portaaviones");
				check = false;
			}
		}
	}

	public static void insertarBarcos(char[][] mapa, int nLanchas, int nBuques, int nAcorazados, int nPortaaviones) {
		for (int i = 0; i < nPortaaviones; i++) {
			insertarPortaaviones(mapa);
		}
		for (int i = 0; i < nAcorazados; i++) {
			insertarAcorazado(mapa);
		}
		for (int i = 0; i < nBuques; i++) {
			insertarBuque(mapa);
		}
		for (int i = 0; i < nLanchas; i++) {
			insertarLancha(mapa);
		}
		nTotal = nLanchas + nBuques + nAcorazados + nPortaaviones;
	}

	public static int getnLanchas() {
		return nLanchas;
	}

	public static void setnLanchas(int nLanchas) {
		GestorBarcos.nLanchas = nLanchas;
	}

	public static int getnBuques() {
		return nBuques;
	}

	public static void setnBuques(int nBuques) {
		GestorBarcos.nBuques = nBuques;
	}

	public static int getnAcorazado() {
		return nAcorazado;
	}

	public static void setnAcorazado(int nAcorazado) {
		GestorBarcos.nAcorazado = nAcorazado;
	}

	public static int getnPortaaviones() {
		return nPortaaviones;
	}

	public static void setnPortaaviones(int nPortaaviones) {
		GestorBarcos.nPortaaviones = nPortaaviones;
	}
}
