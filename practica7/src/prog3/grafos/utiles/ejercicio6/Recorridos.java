package prog3.grafos.utiles.ejercicio6;

import prog3.colagenerica.ColaGenericaImplementada;
import prog3.grafos.Arista;
import prog3.grafos.Grafo;
import prog3.grafos.Vertice;
import prog3.listagenerica.ListaGenerica;
import prog3.listagenerica.ListaGenericaEnlazada;

public class Recorridos<T> {

	public ListaGenerica<Vertice<T>> dfs(Grafo<T> grafo) {
		ListaGenerica<Vertice<T>> resultado = new ListaGenericaEnlazada<Vertice<T>>();

		if (!grafo.esVacio()) {
			boolean[] visitados = new boolean[grafo.listaDeVertices().tamanio()];
			ListaGenerica<Vertice<T>> listaDeVertices = grafo.listaDeVertices();
			listaDeVertices.comenzar();

			while (!listaDeVertices.fin()) {
				Vertice<T> vInicial = listaDeVertices.proximo();
				if (!visitados[vInicial.posicion()]) {
					dfs(vInicial, visitados, resultado, grafo);
				}
			}
		}

		return resultado;
	}

	private void dfs(Vertice<T> vActual, boolean[] visitados, ListaGenerica<Vertice<T>> resultado, Grafo<T> grafo) {
		visitados[vActual.posicion()] = true;
		resultado.agregarFinal(vActual);
		ListaGenerica<Arista<T>> listaDeAdyacentes = grafo.listaDeAdyacentes(vActual);
		listaDeAdyacentes.comenzar();
		while (!listaDeAdyacentes.fin()) {
			Vertice<T> vSiguiente = listaDeAdyacentes.proximo().verticeDestino();
			if (!visitados[vSiguiente.posicion()]) {
				dfs(vSiguiente, visitados, resultado, grafo);
			}
		}
	}

	public ListaGenerica<T> bfs(Grafo<T> grafo) {
		ListaGenerica<T> resultado = new ListaGenericaEnlazada<T>();
		if (!grafo.esVacio()) {
			boolean[] visitados = new boolean[grafo.listaDeVertices().tamanio()]; // declaro vector visitados en tamanio de la
																																						// lista
			ListaGenerica<Vertice<T>> listaDeVertices = grafo.listaDeVertices(); // obtengo adyacentes
			listaDeVertices.comenzar(); // recorro lista
			while (!listaDeVertices.fin()) {
				Vertice<T> vInicial = listaDeVertices.proximo();
				if (!visitados[vInicial.posicion()]) {
					bfs(vInicial, visitados, resultado, grafo);
				}

			}
		}

		return resultado;
	}

	private void bfs(Vertice<T> vInicial, boolean[] visitados, ListaGenerica<T> resultado, Grafo<T> grafo) {
		ColaGenericaImplementada<Vertice<T>> cola = new ColaGenericaImplementada<Vertice<T>>();
		cola.encolar(vInicial);
		visitados[vInicial.posicion()] = true;
		while (!cola.esVacia()) {
			Vertice<T> vActual = cola.desencolar();
			resultado.agregarFinal(vActual.dato());
			ListaGenerica<Arista<T>> listaDeAdyacentes = grafo.listaDeAdyacentes(vActual);
			listaDeAdyacentes.comenzar();
			while (!listaDeAdyacentes.fin()) {
				Vertice<T> vSiguiente = listaDeAdyacentes.proximo().verticeDestino();
				if (!visitados[vSiguiente.posicion()]) {
					visitados[vSiguiente.posicion()] = true;
					cola.encolar(vSiguiente);
				}

			}
		}
	}

}
