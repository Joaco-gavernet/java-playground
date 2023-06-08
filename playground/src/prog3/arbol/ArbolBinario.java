package prog3.arbol;

import prog3.listagenerica.*;

public class ArbolBinario<T> {
	private T dato;
	private ArbolBinario<T> hijoIzquierdo;
	private ArbolBinario<T> hijoDerecho;

	public ArbolBinario() {
		super();
	}

	public ArbolBinario(T dato) {
		this.dato = dato;
	}

	/*
	 * getters y setters
	 * 
	 */
	public T getDato() {
		return dato;
	}

	public void setDato(T dato) {
		this.dato = dato;
	}

	public ArbolBinario<T> getHijoIzquierdo() {
		return this.hijoIzquierdo;
	}

	public ArbolBinario<T> getHijoDerecho() {
		return this.hijoDerecho;

	}

	public void agregarHijoIzquierdo(ArbolBinario<T> hijo) {
		this.hijoIzquierdo = hijo;
	}

	public void agregarHijoDerecho(ArbolBinario<T> hijo) {
		this.hijoDerecho = hijo;
	}

	public void eliminarHijoIzquierdo() {
		this.hijoIzquierdo = null;
	}

	public void eliminarHijoDerecho() {
		this.hijoDerecho = null;
	}

	public boolean esVacio() {
		return this.getDato() == null && !this.tieneHijoIzquierdo() && !this.tieneHijoDerecho();
	}

	public boolean esHoja() {
		return (!this.tieneHijoIzquierdo() && !this.tieneHijoDerecho());

	}

	@Override
	public String toString() {
		return this.getDato().toString();
	}

	public boolean tieneHijoIzquierdo() {
		return this.hijoIzquierdo != null;
	}

	public boolean tieneHijoDerecho() {
		return this.hijoDerecho != null;
	}

	public boolean esLleno() {
		boolean result = true;

		if (this.tieneHijoIzquierdo() && this.tieneHijoDerecho()) {
			if ((this.getHijoIzquierdo().esLleno()) && (this.getHijoDerecho().esLleno())) {
				result = true;
			} else {
				result = false;
			}
		} else if (!this.esHoja())
			result = false;

		return result;
	}

	boolean esCompleto() {

		return false;
	}

	// imprime el arbol en preorden
	public void printPreorden() {
		System.out.print(" -> " + this.dato);

		if (this.tieneHijoIzquierdo()) {
			this.getHijoIzquierdo().printPreorden();
		}

		if (this.tieneHijoDerecho()) {
			this.getHijoDerecho().printPreorden();
		}
	}

	// imprime el arbol en postorden
	public void printInorden() {
		if (this.tieneHijoIzquierdo()) {
			this.getHijoIzquierdo().printPreorden();
		}

		System.out.print(" -> " + this.dato);

		if (this.tieneHijoDerecho()) {
			this.getHijoDerecho().printPreorden();
		}
	}

	// imprime el arbol en postorden
	public void printPostorden() {
		if (this.tieneHijoIzquierdo()) {
			this.getHijoIzquierdo().printPreorden();
		}

		if (this.tieneHijoDerecho()) {
			this.getHijoDerecho().printPreorden();
		}

		System.out.print(" -> " + this.dato);
	}

	// public ListaGenerica<T> recorridoPorNiveles() {
	// ListaGenerica<T> result = new ListaGenericaEnlazada<T>();
	// ColaGenericaImplementada<ArbolBinario<Integer>> cola = new
	// ColaGenericaImplementada<ArbolBinario<Integer>>();
	//
	// ArbolBinario<Integer> arbol_aux;
	// cola.encolar(this);
	//
	// while (!cola.esVacia()) {
	// arbol_aux = cola.desencolar();
	// result.agregarFinal(arbol_aux);
	//
	// if (arbol_aux.tieneHijoIzquierdo()) {
	// cola.encolar(arbol_aux.getHijoIzquierdo());
	// }
	//
	// if (arbol_aux.tieneHijoDerecho()) {
	// cola.encolar(arbol_aux.getHijoDerecho());
	// }
	// }
	//
	// return result;
	// }

	public ListaGenerica<T> frontera() {
		ListaGenerica<T> l = new ListaGenericaEnlazada<T>();

		if (this.tieneHijoIzquierdo()) {
			ListaGenerica<T> izq = this.getHijoIzquierdo().frontera();
			for (int i = 0; i < izq.tamanio(); i++)
				l.agregarFinal(izq.elemento(i));
		}

		if (this.tieneHijoDerecho()) {
			ListaGenerica<T> der = this.getHijoDerecho().frontera();
			for (int j = 0; j < der.tamanio(); j++)
				l.agregarFinal(der.elemento(j));
		}

		if (this.esHoja()) {
			l.agregarFinal(dato);
		}

		return l;
	}

	public int contarHojas() {
		int result = 0;

		if (this.tieneHijoIzquierdo()) {
			result += this.getHijoIzquierdo().contarHojas();
		}

		if (this.tieneHijoDerecho()) {
			result += this.getHijoDerecho().contarHojas();
		}

		if (this.esHoja()) {
			return 1;
		}

		return result;
	}

}
