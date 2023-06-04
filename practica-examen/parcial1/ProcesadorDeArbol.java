package prog3.arbol.binario;
import prog3.arbol.ArbolBinario;

public class ProcesadorDeArbol {
	private ArbolBinario<Character> a;
	
	ProcesadorDeArbol () {
	
	}
	
	ProcesadorDeArbol (ArbolBinario<Character>a) {
		this.a = a;
	}
	
	public int procesar(int k) {
		int result = 0;
		
		if (a.esHoja()) return ((k == 0) ? 1 : 0);
		else {
			
			if (!(a.tieneHijoIzquierdo() && a.tieneHijoDerecho())) k--;
			
			if (a.tieneHijoIzquierdo()) {
				ProcesadorDeArbol i = new ProcesadorDeArbol();
				i.setA(a.getHijoIzquierdo());
				result += i.procesar(k);
			}
				
			if (a.tieneHijoDerecho()) {
				ProcesadorDeArbol d = new ProcesadorDeArbol(a.getHijoDerecho());
				result += d.procesar(k);				
			}
		}
				
		return result;
	}


	
	
	
	public ArbolBinario<Character> getA() {
		return a;
	}


	public void setA(ArbolBinario<Character> a) {
		this.a = a;
	}


	@Override
	public String toString() {
		return "ProcesadorDeArbol [a=" + a + "]";
	}
	
}
