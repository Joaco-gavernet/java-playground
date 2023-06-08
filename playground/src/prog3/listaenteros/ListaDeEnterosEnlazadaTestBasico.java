package prog3.listaenteros;
import java.util.Random;

public class ListaDeEnterosEnlazadaTestBasico {

	public static void main(String[] args) {
		ListaDeEnterosEnlazada desordenada = new ListaDeEnterosEnlazada();
		ListaDeEnterosEnlazada ordenada;
		Random rand = new Random();
		
		for (int k = 0; k < 10; k++) { // cargo lista random
			desordenada.agregarFinal(rand.nextInt(100));
		}

		desordenada.comenzar();
		System.out.println("\n\nLista desordenada: ");
		imprimir(desordenada);
		
		System.out.println("\n\nLista ordenada: ");
		ordenada = desordenada.ordenar();
		imprimir(ordenada);
	}
	
	public static void imprimir (ListaDeEnteros l) {
		while (!l.fin()) System.out.print(l.proximo() + " ");
	}
	
	public static void imprimirRecursivo (ListaDeEnteros l) {
		int aux;
		
		if (!l.fin()) { // base case implicito
			aux = l.proximo();
			imprimirRecursivo(l);
			System.out.print(aux + ' ');
		}
	}

}
