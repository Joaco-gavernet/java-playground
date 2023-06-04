package prog3.arbolgeneral;
import prog3.colagenerica.*;
import prog3.listagenerica.ListaGenerica;
import prog3.listagenerica.ListaGenericaEnlazada;

public class ArbolGeneral<T> {

	private T dato;

	private ListaGenerica<ArbolGeneral<T>> hijos = new ListaGenericaEnlazada<ArbolGeneral<T>>();

	public T getDato() {
		return dato;
	}

	public void setDato(T dato) {
		this.dato = dato;
	}

	public void setHijos(ListaGenerica<ArbolGeneral<T>> hijos) {
		this.hijos = hijos;
	}

	public ArbolGeneral(T dato) {
		this.dato = dato;
		this.hijos = new ListaGenericaEnlazada<ArbolGeneral<T>>();
	}

	public ArbolGeneral(T dato, ListaGenerica<ArbolGeneral<T>> hijos) {
		this(dato);
		this.hijos = hijos;
	}

	public ListaGenerica<ArbolGeneral<T>> getHijos() {
		return this.hijos;
	}

	public void agregarHijo(ArbolGeneral<T> unHijo) {
		this.getHijos().agregarFinal(unHijo);
	}

	public boolean esHoja() {
		return !this.tieneHijos();
	}
	
	public boolean tieneHijos() {
		return this.hijos != null && !this.hijos.esVacia();
	}
	
	public boolean esVacio() {
		return this.dato == null && !this.tieneHijos();
	}
	
	public void eliminarHijo(ArbolGeneral<T> hijo) {
		if (this.tieneHijos()) {
			ListaGenerica<ArbolGeneral<T>> hijos = this.getHijos();
			if (hijos.incluye(hijo)) 
				hijos.eliminar(hijo);
		}
	}
	
	//////////////// MODIFICACIONES ///////////////////
	
	public Integer altura() {
		Integer result = 0;
		Integer aux = 0;
		
		if (!this.esVacio() || !this.esHoja()) { // no es un arbol vacio o no tiene hijos
			ListaGenerica<ArbolGeneral<T>> hijos;
			
			hijos = this.getHijos();
			hijos.comenzar();
			
			while (!hijos.fin()) {
				aux = hijos.proximo().altura() + 1;
				result = (aux > result) ? aux : result;
			}
			
		}
		
		return result;
	}

	public Boolean include(T dato) {
		Boolean result = false;
		
		if (this.getDato() == dato) {
			result = true;
		} else if (this.tieneHijos()) {
			ListaGenerica<ArbolGeneral<T>> hijos = this.getHijos();
			hijos.comenzar();
			while (!hijos.fin()) result = hijos.proximo().include(dato);
		} 
		
		return result;
	}
	
	public Integer nivel(T dato) {
		int nivel = 0;

		if ((this.getDato() != dato) && (this.tieneHijos())) {
			ListaGenerica<ArbolGeneral<T>> hijos = this.getHijos();
			hijos.comenzar();
			while (!hijos.fin()) nivel = hijos.proximo().nivel(dato) + 1;
		} 
		
		return nivel;
	}

	public Integer ancho() {
		ColaGenericaImplementada<ArbolGeneral<T>> cola = new ColaGenericaImplementada<ArbolGeneral<T>>();
		ListaGenerica<ArbolGeneral<T>> hijos;
		ArbolGeneral<T> aux;
			
		Integer max = 1;
		Integer cant = 0;
		
		if (!this.esHoja()) {
			cola.encolar(this);
			cola.encolar(null);
			
			while (!cola.esVacia()) {
				aux = cola.desencolar();
				
				if (aux == null) {
					max = (cant > max) ? cant : max;
					if (!cola.esVacia()) cola.encolar(null);
					cant = 0;
				} else if (aux.tieneHijos()) {
					hijos = aux.getHijos();
					
					hijos.comenzar();
					while (!hijos.fin()) {
						cola.encolar(hijos.proximo());
						cant++;
					}
					
				}
			}
		}
		
		return max;
	}
	
	public ListaGenericaEnlazada<T> preOrden() {
		ListaGenericaEnlazada<T> lis = new ListaGenericaEnlazada<T>();
		this.preOrden(lis);
		return lis;
	}

	private void preOrden(ListaGenerica<T> l) {
		l.agregarFinal(this.getDato());
		
		if (this.tieneHijos()) {
			ListaGenerica<ArbolGeneral<T>> hijos = this.getHijos();
			hijos.comenzar();
			
			while(!hijos.fin()) (hijos.proximo()).preOrden(l);
		}
	}
}







