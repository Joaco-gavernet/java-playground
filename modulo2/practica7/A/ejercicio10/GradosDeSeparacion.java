package prog3.grafos.utiles.ejercicio10;

import prog3.grafos.Grafo;
import prog3.grafos.Vertice;
import prog3.listagenerica.ListaGenerica;
import prog3.colagenerica.ColaGenericaImplementada;
import prog3.grafos.Arista;

public class GradosDeSeparacion {
  public int maximoGradoDeSeparacion(Grafo<String> grafo) {
    int max = 0;

    if (grafo != null && !grafo.esVacio()) {
      ListaGenerica<Vertice<String>> listaDeVertices = grafo.listaDeVertices();
      listaDeVertices.comenzar();

      while (!listaDeVertices.fin()) {
        boolean[] visitados = new boolean[listaDeVertices.tamanio()]; // reset visitados para cada bfs
        Vertice<String> vActual = listaDeVertices.proximo();
        int aux;
        if (visitados[vActual.posicion()] == false) {
          aux = bfsMaximoGradoDeSeparacion(grafo, visitados, vActual);
          max = (aux > max) ? aux : max; // update
        }
      }
    }

    return max;
  }

  private int bfsMaximoGradoDeSeparacion(Grafo<String> grafo, boolean[] visitados, Vertice<String> vActual) {
    int result = -1;
    ListaGenerica<Arista<String>> listaDeAdyacencia;
    ColaGenericaImplementada<Vertice<String>> q = new ColaGenericaImplementada<Vertice<String>>();

    q.encolar(vActual);
    q.encolar(null);
    visitados[vActual.posicion()] = true;

    while (!q.esVacia()) {
      Vertice<String> v = q.desencolar();
      if (v == null) {
        result++;
        if (q.esVacia() == false)
          q.encolar(null);
      } else {
        listaDeAdyacencia = grafo.listaDeAdyacentes(v);
        listaDeAdyacencia.comenzar();

        while (!listaDeAdyacencia.fin()) {
          Vertice<String> vSiguiente = listaDeAdyacencia.proximo().verticeDestino();
          if (visitados[vSiguiente.posicion()] == false) {
            q.encolar(vSiguiente);
            visitados[vSiguiente.posicion()] = true;
          }
        }
      }
    }

    return result;
  }

}
