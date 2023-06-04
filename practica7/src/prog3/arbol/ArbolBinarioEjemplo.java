package prog3.arbol;
import prog3.listagenerica.ListaGenerica;

public class ArbolBinarioEjemplo {

	public static void main(String[] args) {
		
		// arbol 1
		ArbolBinario<Integer> arbolBinario1=new ArbolBinario<Integer>(1);
		ArbolBinario<Integer> hijoIzquierdoB=new ArbolBinario<Integer>(2);
		hijoIzquierdoB.agregarHijoIzquierdo(new ArbolBinario<Integer>(3));
		hijoIzquierdoB.agregarHijoDerecho(new ArbolBinario<Integer>(4));
		ArbolBinario<Integer> hijoDerechoB=new ArbolBinario<Integer>(6);
		hijoDerechoB.agregarHijoIzquierdo(new ArbolBinario<Integer>(7));
		hijoDerechoB.agregarHijoDerecho(new ArbolBinario<Integer>(8));
		arbolBinario1.agregarHijoIzquierdo(hijoIzquierdoB);
		arbolBinario1.agregarHijoDerecho(hijoDerechoB);
		// fin arbol 1
		
		
		// arbol 2
		ArbolBinario<Character> arbolBinarioD = new ArbolBinario<Character>('D');
		arbolBinarioD.agregarHijoIzquierdo(new ArbolBinario<Character>('F'));

		ArbolBinario<Character> arbolBinarioB = new ArbolBinario<Character>('B');
		arbolBinarioB.agregarHijoIzquierdo(arbolBinarioD);
		arbolBinarioB.agregarHijoDerecho(new ArbolBinario<Character>('E'));
		
		ArbolBinario<Character> arbolBinario2 = new ArbolBinario<Character>('A');
		arbolBinario2.agregarHijoIzquierdo(arbolBinarioB);
		arbolBinario2.agregarHijoDerecho(new ArbolBinario<Character>('C'));
		// fin arbol 2
		
		// Ejemplos
		arbolBinario1.printPreorden();
		System.out.println("\nlleno: " + arbolBinario1.esLleno() + '\n');

		arbolBinario2.printPreorden();
		
		System.out.println("\nhojas: " + arbolBinario2.contarHojas());
		
		ListaGenerica<Character> result = arbolBinario2.frontera();
		System.out.println("\nfrontera: " + result);
		
		System.out.println("lleno: " + arbolBinario2.esLleno());
		
		
		
	}

}
