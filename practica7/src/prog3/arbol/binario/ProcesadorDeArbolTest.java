package prog3.arbol.binario;
import prog3.arbol.ArbolBinario;

public class ProcesadorDeArbolTest {

	public static void main(String[] args) {
		ProcesadorDeArbol p = new ProcesadorDeArbol();
		
		ArbolBinario<Character> m = new ArbolBinario<Character>('m');
		m.agregarHijoDerecho(new ArbolBinario<Character>('p'));
		
		ArbolBinario<Character> o = new ArbolBinario<Character>('o');
		o.agregarHijoIzquierdo(new ArbolBinario<Character>('q'));
		o.agregarHijoDerecho(new ArbolBinario<Character>('z'));
		
		ArbolBinario<Character> c = new ArbolBinario<Character>('c');
		c.agregarHijoIzquierdo(m);
		c.agregarHijoDerecho(o);
		
		ArbolBinario<Character> a = new ArbolBinario<Character>('a');
		a.agregarHijoIzquierdo(c);
		
		p.setA(a);
		System.out.println("example for a: " + p.procesar(2));
	}

}
