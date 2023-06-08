package prog3.arbol.binario.util;
import prog3.arbol.*;
import prog3.listagenerica.ListaGenericaEnlazada;

public class AdivinanzaTest {

	public static void main(String[] args) {
		
		ArbolBinario<String> arbol0 = new ArbolBinario<String>("Ladra?");
		arbol0.agregarHijoIzquierdo(new ArbolBinario<String>("Es un perro"));
		arbol0.agregarHijoDerecho(new ArbolBinario<String>("Es un gato"));

		ArbolBinario<String> arbol1 = new ArbolBinario<String>("Se mueve?");
		arbol1.agregarHijoIzquierdo(arbol0);
		arbol1.agregarHijoDerecho(new ArbolBinario<String>("Es una mesa"));
		
		ArbolBinario<String> arbol2 = new ArbolBinario<String>("Tiene 4 patas?");
		arbol2.agregarHijoIzquierdo(arbol1);
		arbol2.agregarHijoDerecho(new ArbolBinario<String>("Tiene alguna pata?"));
		
		// ejemplo 1
		Adivinanza ejemplo = new Adivinanza();
//		ListaGenericaEnlazada<String> result;
//		result = ejemplo.secuenciaConMasPreguntas(arbol2);
//		System.out.println(result);
		
		// ejemplo 2
//		System.out.println("printPreorden: ");
//		arbol2.printPreorden();
		ListaGenericaEnlazada<ListaGenericaEnlazada<String>> result2;
		System.out.println("\nprobando: ");
		result2 = ejemplo.secuenciaConMasPreguntasVersion2(arbol2);
		
		result2.comenzar();
		System.out.println("size: " + result2.tamanio());
		
		while (!result2.fin()) {	
			System.out.println(result2.proximo());
		}
		
	}

}
