package prog3.listagenerica;

import java.util.Random;

public class TestListaGenericaInvertir {

	public static void main(String[] args) {
		Random rand = new Random();
		ListaGenericaEnlazada<Integer> first = new ListaGenericaEnlazada<Integer>();

		for (int i = 0; i < 4; i++) {
			int num = rand.nextInt(100);
			first.agregarFinal(num);
		}

		System.out.println("Normal: " + first);

		first = first.invertir();

		System.out.println("\nInverted: " + first);

	}

}
