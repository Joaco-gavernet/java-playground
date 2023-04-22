package prog3.arbol.binario.util;

import prog3.arbol.ArbolBinario;
import prog3.listagenerica.ListaGenericaEnlazada;

public class Adivinanza {
	
	public ListaGenericaEnlazada<String> secuenciaConMasPreguntas(ArbolBinario<String> abinario) {
		ListaGenericaEnlazada<String> result = new ListaGenericaEnlazada<String>();
		ListaGenericaEnlazada<String> aux = new ListaGenericaEnlazada<String>();
		
		if (abinario.tieneHijoIzquierdo()) {
			aux = secuenciaConMasPreguntas(abinario.getHijoIzquierdo());
			if (aux.tamanio() > result.tamanio()) result = aux;
		}
		
		if (abinario.tieneHijoDerecho()) {
			aux = secuenciaConMasPreguntas(abinario.getHijoDerecho());
			if (aux.tamanio() > result.tamanio()) result = aux;
		}
		
		result.agregarInicio(abinario.getDato());
		
		return result;
	}
	
	public ListaGenericaEnlazada<ListaGenericaEnlazada<String>> secuenciaConMasPreguntasVersion2(ArbolBinario<String> abinario) {
		// CREO LISTAS DE LISTAS, RESULTADO (PARA RETORNAR) Y AUXILIAR (PARA ANALIZAR SITUACION DEL NODO ACTUAL)
		ListaGenericaEnlazada<ListaGenericaEnlazada<String>> result = new ListaGenericaEnlazada<ListaGenericaEnlazada<String>>();
		ListaGenericaEnlazada<ListaGenericaEnlazada<String>> aux = new ListaGenericaEnlazada<ListaGenericaEnlazada<String>>();
		
		if (abinario.esHoja()) {
			// BASE CASE ///////////////
			ListaGenericaEnlazada<String> nueva = new ListaGenericaEnlazada<String>();
			nueva.agregarFinal(abinario.getDato());
			result.agregarFinal(nueva);
			
		} else {
			// PROCESO HIJO IZQUIERDO ///////////
			if (abinario.tieneHijoIzquierdo()) {
				aux = secuenciaConMasPreguntasVersion2(abinario.getHijoIzquierdo()); // RECURSION RECUPERADA EN VARIABLE aux
				
				// SI EL RESULTADO ES NULO O EL CAMINO ACTUAL ES MAYOR QUE LOS ALMACENADOS EN RESULTADO ENTONCES 
				// VACIO LA LISTA RESULTADO Y AGREGO EL CAMINO ACTUAL COMO NUEVA SOLUCION DE MAYOR TAMANIO
				if ((result.elemento(0) == null) || (aux.elemento(0).tamanio() > result.elemento(0).tamanio())) {
					while (!result.esVacia()) result.eliminarEn(0);
					aux.comenzar();
					while (!aux.fin()) result.agregarFinal(aux.proximo());
				} else if (aux.elemento(0).tamanio() == result.elemento(0).tamanio()) {
					aux.comenzar();
					while (!aux.fin()) result.agregarFinal(aux.proximo());
				}
			}
			
			// PROCESO HIJO DERECHO ////////////
			if (abinario.tieneHijoDerecho()) {
				aux = secuenciaConMasPreguntasVersion2(abinario.getHijoDerecho());
				
				if ((result.elemento(0) == null) || (aux.elemento(0).tamanio() > result.elemento(0).tamanio())) {
					while (!result.esVacia()) result.eliminarEn(0);
					aux.comenzar();
					while (!aux.fin()) result.agregarFinal(aux.proximo());
				} else if (aux.elemento(0).tamanio() == result.elemento(0).tamanio()) {
					aux.comenzar();
					while (!aux.fin()) result.agregarFinal(aux.proximo());
				}
			}
			
			// AGREGO DATO A TODAS LAS LISTAS RESULTADOS ////////////////
			result.comenzar();
			while (!result.fin()) result.proximo().agregarFinal(abinario.getDato());
		}
		
		return result;
		
	}
	
}
