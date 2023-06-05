package prog3.grafos.ejercicio6;

import prog3.grafos.Arista;
import prog3.grafos.Grafo;
import prog3.grafos.GrafoImplListAdy;
import prog3.grafos.Vertice;
import prog3.listagenerica.ListaGenerica;
import prog3.listagenerica.ListaGenericaEnlazada;
import prog3.grafos.ejercicio6.Resultado;

public class Mapa {
	private static Grafo<String> grafo;

	public Mapa() {
		grafo = new GrafoImplListAdy<String>();
		System.out.println("Mapa creado");
	}

	public void setGrafo(Grafo<String> grafo) {
		Mapa.grafo = grafo;
	}

	public ListaGenerica<String> devolverCamino(String ciudad1, String ciudad2) {
		ListaGenerica<String> resultado = new ListaGenericaEnlazada<String>();

		if (grafo != null && !grafo.esVacio()) {
			boolean[] visitados = new boolean[grafo.listaDeVertices().tamanio()];
			ListaGenerica<Vertice<String>> listaDeVertices = grafo.listaDeVertices();
			listaDeVertices.comenzar();
			Vertice<String> vInicial = listaDeVertices.proximo();

			while (!listaDeVertices.fin() && !vInicial.dato().equals(ciudad1)) {
				vInicial = listaDeVertices.proximo();
			}

			if (vInicial.dato().equals(ciudad1)) {
				dfs(vInicial, visitados, resultado, grafo, ciudad2);
			}
		}

		return resultado;
	}

	public ListaGenerica<String> devolverCaminoExceptuando(String ciudad1, String ciudad2,
			ListaGenerica<String> ciudadesExceptuadas) {
		ListaGenerica<String> resultado = new ListaGenericaEnlazada<String>();

		if (grafo != null && !grafo.esVacio()) {
			boolean[] visitados = new boolean[grafo.listaDeVertices().tamanio()];
			// marco ciudades exceptuadas como visitadas
			ciudadesExceptuadas.comenzar();

			while (!ciudadesExceptuadas.fin()) { // recorro lista de ciudades visitadas
				String ciudad = ciudadesExceptuadas.proximo();
				ListaGenerica<Vertice<String>> listaDeVertices = grafo.listaDeVertices();
				listaDeVertices.comenzar();
				Vertice<String> vInicial = listaDeVertices.proximo();

				while (!listaDeVertices.fin() && !vInicial.dato().equals(ciudad)) {
					vInicial = listaDeVertices.proximo();
				}

				if (vInicial.dato().equals(ciudad)) { // si encontre la ciudad la marco como visitada
					visitados[vInicial.posicion()] = true;
				}
			}

			ListaGenerica<Vertice<String>> listaDeVertices = grafo.listaDeVertices();
			listaDeVertices.comenzar();
			Vertice<String> vInicial = listaDeVertices.proximo();

			while (!listaDeVertices.fin() && !vInicial.dato().equals(ciudad1)) {
				vInicial = listaDeVertices.proximo();
			}

			if (vInicial.dato().equals(ciudad1)) {
				dfs(vInicial, visitados, resultado, grafo, ciudad2);
			}
		}

		return resultado;
	}

	private static void dfs(Vertice<String> vActual, boolean[] visitados, ListaGenerica<String> resultado,
			Grafo<String> grafo, String ciudad2) {

		visitados[vActual.posicion()] = true;
		resultado.agregarFinal(vActual.dato());

		if (!vActual.dato().equals(ciudad2)) { // si no fue encontrado, se sigue buscando
			ListaGenerica<Arista<String>> listaDeAdyacentes = grafo.listaDeAdyacentes(vActual);
			listaDeAdyacentes.comenzar();

			while (!listaDeAdyacentes.fin()) {
				Vertice<String> vSiguiente = listaDeAdyacentes.proximo().verticeDestino();
				if (!visitados[vSiguiente.posicion()]) {
					dfs(vSiguiente, visitados, resultado, grafo, ciudad2);
				}

				if (!resultado.elemento(resultado.tamanio() - 1).equals(ciudad2)) {
					resultado.eliminarEn(resultado.tamanio() - 1); // si no se encontro, se elimina
				}
			}
		}
	}

	public ListaGenerica<String> caminoMasCorto(String ciudad1, String ciudad2) {
		Resultado<String> resultado = new Resultado<String>();
		ListaGenerica<String> camino = new ListaGenericaEnlazada<String>();

		if (grafo != null && !grafo.esVacio()) {
			boolean[] visitados = new boolean[grafo.listaDeVertices().tamanio()];
			ListaGenerica<Vertice<String>> listaDeVertices = grafo.listaDeVertices();
			listaDeVertices.comenzar();
			Vertice<String> vInicial = listaDeVertices.proximo();

			while (!listaDeVertices.fin() && !vInicial.dato().equals(ciudad1)) {
				vInicial = listaDeVertices.proximo();
			}

			if (vInicial.dato().equals(ciudad1)) {
				dfsPesado(vInicial, visitados, camino, grafo, ciudad2, 0, resultado);
			}
		}
		return resultado.getLista();
	}

	private static void dfsPesado(
			Vertice<String> vActual,
			boolean[] visitados,
			ListaGenerica<String> caminoActual,
			Grafo<String> grafo,
			String ciudadDestino,
			int peso,
			Resultado<String> resultado) {

		// PROLOGO /////////////////////////////////////////////
		visitados[vActual.posicion()] = true;
		caminoActual.agregarFinal(vActual.dato());

		// CUERPO /////////////////////////////////////////////
		if (!vActual.dato().equals(ciudadDestino)) { // si no fue encontrado, se sigue buscando
			ListaGenerica<Arista<String>> listaDeAdyacentes = grafo.listaDeAdyacentes(vActual);
			listaDeAdyacentes.comenzar();

			while (!listaDeAdyacentes.fin()) {
				Arista<String> arista = listaDeAdyacentes.proximo();
				Vertice<String> vSiguiente = arista.verticeDestino();
				if (!visitados[vSiguiente.posicion()]) {
					dfsPesado(vSiguiente, visitados, caminoActual, grafo, ciudadDestino, peso + arista.peso(), resultado);
				}
			}
		} else if (resultado.getPeso() == 0 || peso < resultado.getPeso()) { // si lo encontro, compara con otros recorridos
			resultado.setPeso(peso);
			resultado.setLista(caminoActual.clonar(caminoActual));
		}

		// EPILOGO ////////////////////////////////////////////
		caminoActual.eliminarEn(caminoActual.tamanio() - 1);
		visitados[vActual.posicion()] = false;
	}

	public ListaGenerica<String> caminoSinCargarCombustible(String ciudad1, String ciudad2, int combustible) {
		ListaGenerica<String> camino = new ListaGenericaEnlazada<String>();

		if (grafo != null && !grafo.esVacio()) {
			boolean[] visitados = new boolean[grafo.listaDeVertices().tamanio()];
			ListaGenerica<Vertice<String>> listaDeVertices = grafo.listaDeVertices();
			listaDeVertices.comenzar();
			Vertice<String> vInicial = listaDeVertices.proximo();

			while (!listaDeVertices.fin() && !vInicial.dato().equals(ciudad1)) {
				vInicial = listaDeVertices.proximo();
			}

			if (vInicial.dato().equals(ciudad1)) {
				dfsPesadoYParametro(vInicial, visitados, camino, grafo, ciudad2, 0, camino, combustible);
			}
		}

		return camino;
	}

	private static void dfsPesadoYParametro(
			Vertice<String> vActual,
			boolean[] visitados,
			ListaGenerica<String> caminoActual,
			Grafo<String> grafo,
			String ciudadDestino,
			int kilometrosRecorridos,
			ListaGenerica<String> camino,
			int combustible) {

		// PROLOGO /////////////////////////////////////////////
		visitados[vActual.posicion()] = true;
		caminoActual.agregarFinal(vActual.dato());

		// CUERPO /////////////////////////////////////////////
		if (!vActual.dato().equals(ciudadDestino)) {
			ListaGenerica<Arista<String>> listaDeAdyacentes = grafo.listaDeAdyacentes(vActual);
			listaDeAdyacentes.comenzar();

			while (!listaDeAdyacentes.fin() && !caminoActual.elemento(caminoActual.tamanio() - 1).equals(ciudadDestino)) {
				Arista<String> arista = listaDeAdyacentes.proximo();
				if (combustible - arista.peso() > 0) {
					Vertice<String> vSiguiente = arista.verticeDestino();
					if (!visitados[vSiguiente.posicion()]) {
						dfsPesadoYParametro(vSiguiente, visitados, camino, grafo, ciudadDestino,
								kilometrosRecorridos + arista.peso(),
								camino, combustible - arista.peso());
					}
				}
			}
		}

		// EPILOGO ////////////////////////////////////////////
		if (!caminoActual.elemento(caminoActual.tamanio() - 1).equals(ciudadDestino)) {
			caminoActual.eliminarEn(caminoActual.tamanio() - 1);
		}
		visitados[vActual.posicion()] = false;
	}

	public ListaGenerica<String> caminoConMenorCargaDeCombustible(String ciudad1, String ciudad2, int combustible) {
		ListaGenerica<String> camino = new ListaGenericaEnlazada<String>();
		Resultado<String> resultado = new Resultado<String>();

		if (grafo != null && !grafo.esVacio()) {
			boolean[] visitados = new boolean[grafo.listaDeVertices().tamanio()];
			ListaGenerica<Vertice<String>> listaDeVertices = grafo.listaDeVertices();
			listaDeVertices.comenzar();
			Vertice<String> vInicial = listaDeVertices.proximo();

			while (!listaDeVertices.fin() && !vInicial.dato().equals(ciudad1)) {
				vInicial = listaDeVertices.proximo();
			}

			if (vInicial.dato().equals(ciudad1)) {
				dfsCaminoConMenorCargaDeCombustible(vInicial, visitados, grafo, ciudad2, 0, camino, combustible, 0,
						resultado);
			}
		}

		return resultado.getLista();
	}

	private static void dfsCaminoConMenorCargaDeCombustible(
			Vertice<String> vActual,
			boolean[] visitados,
			Grafo<String> grafo,
			String ciudadDestino,
			int kilometrosRecorridos,
			ListaGenerica<String> caminoActual,
			int combustible,
			int recargas,
			Resultado<String> resultado) {

		// PROLOGO /////////////////////////////////////////////
		visitados[vActual.posicion()] = true;
		caminoActual.agregarFinal(vActual.dato());

		// CUERPO /////////////////////////////////////////////
		if (!vActual.dato().equals(ciudadDestino)) {
			ListaGenerica<Arista<String>> listaDeAdyacentes = grafo.listaDeAdyacentes(vActual);
			listaDeAdyacentes.comenzar();

			while (!listaDeAdyacentes.fin() && !caminoActual.elemento(caminoActual.tamanio() - 1).equals(ciudadDestino)) {
				Arista<String> arista = listaDeAdyacentes.proximo();

				int increment = 0;
				if (combustible - arista.peso() < 0) {
					combustible += kilometrosRecorridos; // reseteo el combustible inicial
					kilometrosRecorridos = 0; // reseteo kilometros recorridos desde la ultima parada
					increment = 1; // cuento recarga con racargas + increment
				}
				Vertice<String> vSiguiente = arista.verticeDestino();
				if (!visitados[vSiguiente.posicion()]) {
					dfsCaminoConMenorCargaDeCombustible(vSiguiente, visitados, grafo, ciudadDestino,
							kilometrosRecorridos + arista.peso(),
							caminoActual, combustible - arista.peso(), recargas + increment, resultado);
				}
			}
		} else if (resultado.getRecargas() > recargas) {
			resultado.setRecargas(recargas);
			resultado.setLista(caminoActual.clonar(caminoActual));
		}

		// EPILOGO ////////////////////////////////////////////
		caminoActual.eliminarEn(caminoActual.tamanio() - 1);
		visitados[vActual.posicion()] = false;
	}

}
