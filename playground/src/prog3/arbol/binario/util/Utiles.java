package prog3.arbol.binario.util;

import prog3.arbol.*;
import prog3.listagenerica.ListaGenericaEnlazada;
import prog3.colagenerica.*;

public class Utiles {

	public static void main(String[] args) {
		// arbol 1
		ArbolBinario<Integer> arbolBinarioA = new ArbolBinario<Integer>(1);
		ArbolBinario<Integer> hijoIzquierdoB = new ArbolBinario<Integer>(2);
		hijoIzquierdoB.agregarHijoIzquierdo(new ArbolBinario<Integer>(3));
		hijoIzquierdoB.agregarHijoDerecho(new ArbolBinario<Integer>(4));
		ArbolBinario<Integer> hijoDerechoB = new ArbolBinario<Integer>(6);
		hijoDerechoB.agregarHijoIzquierdo(new ArbolBinario<Integer>(7));
		hijoDerechoB.agregarHijoDerecho(new ArbolBinario<Integer>(8));
		arbolBinarioA.agregarHijoIzquierdo(hijoIzquierdoB);
		arbolBinarioA.agregarHijoDerecho(hijoDerechoB);
		// fin arbol 1

		// arbol 2
		// 7
		// / \
		// 1 3
		// / / \
		// 4 2 1

		ArbolBinario<Integer> arbolBinario1 = new ArbolBinario<Integer>(1);
		arbolBinario1.agregarHijoIzquierdo(new ArbolBinario<Integer>(4));

		ArbolBinario<Integer> arbolBinario3 = new ArbolBinario<Integer>(3);
		arbolBinario3.agregarHijoIzquierdo(new ArbolBinario<Integer>(2));
		arbolBinario3.agregarHijoDerecho(new ArbolBinario<Integer>(1));

		ArbolBinario<Integer> arbolBinario7 = new ArbolBinario<Integer>(7);
		arbolBinario7.agregarHijoIzquierdo(arbolBinario1);
		arbolBinario7.agregarHijoDerecho(arbolBinario3);
		// fin arbol 2

		arbolBinario7.printPreorden();
		System.out.println("\nmaxima suma vertical: " + sumaMaximaVertical(arbolBinarioA));
		System.out.println("\nmaxima suma horizontal: " + sumaMaximaHorizontal(arbolBinario7));
		System.out.println("\ntrayectoria pesada: " + trayectoriaPesada(arbolBinario7));

	}

	private static ListaGenericaEnlazada<Integer> trayectoriaPesadaRecursivo(ArbolBinario<Integer> ab,
			ListaGenericaEnlazada<Integer> result, int nivel, int accumulador) {
		nivel++;
		accumulador += (nivel * ab.getDato());

		if (ab.esHoja()) {
			result.agregarFinal(accumulador);
		} else {
			if (ab.tieneHijoIzquierdo()) {
				result = trayectoriaPesadaRecursivo(ab.getHijoIzquierdo(), result, nivel, accumulador);
			}

			if (ab.tieneHijoDerecho()) {
				result = trayectoriaPesadaRecursivo(ab.getHijoDerecho(), result, nivel, accumulador);
			}
		}

		return result;

	}

	private static ListaGenericaEnlazada<Integer> trayectoriaPesada(ArbolBinario<Integer> ab) {

		ListaGenericaEnlazada<Integer> result = new ListaGenericaEnlazada<Integer>();
		trayectoriaPesadaRecursivo(ab, result, -1, 0);

		return result;
	}

	private static int sumaMaximaHorizontal(ArbolBinario<Integer> arbol) {
		ColaGenericaImplementada<ArbolBinario<Integer>> cola = new ColaGenericaImplementada<ArbolBinario<Integer>>();
		ArbolBinario<Integer> arbol_aux;

		int sumaParcial = 0;
		int sumaMax = 0;

		cola.encolar(arbol);
		cola.encolar(null);

		while (!cola.esVacia()) {
			arbol_aux = cola.desencolar();

			if (arbol_aux == null) {
				if (!cola.esVacia()) {
					cola.encolar(null);
				}
				if (sumaParcial > sumaMax) {
					sumaMax = sumaParcial;
				}
				sumaParcial = 0;
			} else {
				if (arbol_aux.tieneHijoIzquierdo()) {
					cola.encolar(arbol_aux.getHijoIzquierdo());
				}
				if (arbol_aux.tieneHijoDerecho()) {
					cola.encolar(arbol_aux.getHijoDerecho());
				}
				sumaParcial += arbol_aux.getDato();
			}
		}

		return sumaMax;
	}

	private static int sumaMaximaVertical(ArbolBinario<Integer> arbol) {
		int result = arbol.getDato();
		int aux1 = 0;
		int aux2 = 0;

		if (arbol.tieneHijoIzquierdo()) {
			aux1 = sumaMaximaVertical(arbol.getHijoIzquierdo());
		}

		if (arbol.tieneHijoDerecho()) {
			aux2 = sumaMaximaVertical(arbol.getHijoDerecho());
		}

		result += (aux1 > aux2) ? aux1 : aux2;

		return result;
	}

}
