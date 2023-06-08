package prog3.listaenteros;

public class TestOrdenamiento {

	public static void main(String[] args) {
		ListaDeEnterosEnlazada l = new ListaDeEnterosEnlazada();
		ListaDeEnterosEnlazada m = new ListaDeEnterosEnlazada();
		ListaDeEnterosEnlazada result = new ListaDeEnterosEnlazada();

		// Random rand = new Random();

		// for (int k = 0; k < 3; k++) { // cargo l random
		// l.agregarFinal(rand.nextInt(100));
		// }
		//
		// for (int k = 0; k < 7; k++) { // cargo m random
		// m.agregarFinal(rand.nextInt(50));
		// }

		l.agregarFinal(1);
		l.agregarFinal(3);
		l.agregarFinal(7);
		l.agregarFinal(8);

		m.agregarFinal(4);
		m.agregarFinal(5);
		m.agregarFinal(6);

		System.out.println("Lista L: ");
		imprimir(l);
		System.out.println("\nLista M: ");
		imprimir(m);

		System.out.println("\nLista Result: ");
		result = l.combinarOrdenado(m);
		imprimir(result);
	}

	public static void imprimir(ListaDeEnteros l) {
		while (!l.fin())
			System.out.print(l.proximo() + " ");
	}

	public static void imprimirRecursivo(ListaDeEnteros l) {
		int aux;

		if (!l.fin()) { // base case implicito
			aux = l.proximo();
			imprimirRecursivo(l);
			System.out.print(aux);
			System.out.print(' ');
		}
	}

}
