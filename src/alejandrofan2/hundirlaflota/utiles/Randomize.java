package alejandrofan2.hundirlaflota.utiles;

public class Randomize {

	public static int[] puntoAleatorio(int tamañoMapa) {
		int[] posicion = new int[2];
		tamañoMapa = tamañoMapa - 1;
		posicion[0] = (int) (1 + Math.random() * (tamañoMapa - 1 + 1));
		posicion[1] = (int) (1 + Math.random() * (tamañoMapa - 1 + 1));
		return posicion;

	}
}
