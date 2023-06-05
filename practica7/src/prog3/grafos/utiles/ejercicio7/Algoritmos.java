package prog3.grafos.utiles.ejercicio7;

import prog3.listagenerica.ListaGenerica;
import prog3.grafos.Vertice;
import prog3.grafos.Arista;
import prog3.grafos.Grafo;

import java.util.Arrays;

public class Algoritmos<T> {
  public boolean subgrafoCuadrado(Grafo<T> grafo) {
    boolean result = false;

    if (grafo != null && !grafo.esVacio()) {
      ListaGenerica<Vertice<T>> listaDeVertices = grafo.listaDeVertices();

      listaDeVertices.comenzar();
      while (!listaDeVertices.fin() && result == false) { // dfs en cada vertice para considerar todos los casos
        boolean[] visitados = new boolean[listaDeVertices.tamanio()]; // reseteo en false el arreglo de visitados
        Vertice<T> vActual = listaDeVertices.proximo();
        result = dfsSubgrafoCuadrado(grafo, visitados, vActual, 4, vActual.posicion());
      }
    }

    return result;
  }

  private boolean dfsSubgrafoCuadrado(
      Grafo<T> grafo,
      boolean[] visitados,
      Vertice<T> vActual,
      int aristasPorRecorrer,
      int posicionDestino) {
    // PROLOGO /////////////////////////////////////////////////
    visitados[vActual.posicion()] = true;
    aristasPorRecorrer--;
    boolean result = false;

    // CUERPO /////////////////////////////////////////////////
    if (aristasPorRecorrer >= 0) { // se revisa si supera el limite de aristas antes de procesar
      ListaGenerica<Arista<T>> listaDeAdyacentes = grafo.listaDeAdyacentes(vActual);
      listaDeAdyacentes.comenzar();

      while (!listaDeAdyacentes.fin() && result == false) {
        Vertice<T> vSiguiente = listaDeAdyacentes.proximo().verticeDestino();

        // interesa saber la posicion del siguiente vertice
        if (aristasPorRecorrer == 0 && vSiguiente.posicion() == posicionDestino) {
          result = true;
        } else if (visitados[vSiguiente.posicion()] == false) {
          result = dfsSubgrafoCuadrado(grafo, visitados, vSiguiente, aristasPorRecorrer, posicionDestino);
        }
      }
    }

    // EPILOGO /////////////////////////////////////////////////
    visitados[vActual.posicion()] = false;
    aristasPorRecorrer++;
    return result;
  }

  public int getGrado(Grafo<T> grafo) {
    int result = 0;

    if (grafo != null && !grafo.esVacio()) {
      ListaGenerica<Vertice<T>> listaDeVertices = grafo.listaDeVertices();
      int[] grados = new int[listaDeVertices.tamanio()];

      listaDeVertices.comenzar();
      while (!listaDeVertices.fin()) { // se inicializa el arreglo de grados segun adyacencia
        Vertice<T> vActual = listaDeVertices.proximo();
        grados[vActual.posicion()] += grafo.listaDeAdyacentes(vActual).tamanio();

        ListaGenerica<Arista<T>> listaDeAdyacentes = grafo.listaDeAdyacentes(vActual);

        listaDeAdyacentes.comenzar();
        while (!listaDeAdyacentes.fin()) {
          Vertice<T> vSiguiente = listaDeAdyacentes.proximo().verticeDestino();
          grados[vSiguiente.posicion()]++;
        }
      }

      Arrays.sort(grados); // se ordena el arreglo de grados
      result = grados[grados.length - 1]; // se devuelve el mayor
    }

    return result;
  }

  public boolean tieneCiclo(Grafo<T> grafo) {
    boolean result = false;

    if (grafo != null && !grafo.esVacio()) {
      ListaGenerica<Vertice<T>> listaDeVertices = grafo.listaDeVertices();

      listaDeVertices.comenzar();
      while (!listaDeVertices.fin() && result == false) {
        boolean[] visitados = new boolean[listaDeVertices.tamanio()];
        Vertice<T> vActual = listaDeVertices.proximo();
        result = dfsTieneCiclo(grafo, visitados, vActual, vActual.posicion());
      }
    }

    return result;
  }

  private boolean dfsTieneCiclo(
      Grafo<T> grafo,
      boolean[] visitados,
      Vertice<T> vActual,
      int posicionDestino) {
    boolean result = false;
    visitados[vActual.posicion()] = true;

    ListaGenerica<Arista<T>> listaDeAdyacencia = grafo.listaDeAdyacentes(vActual);

    listaDeAdyacencia.comenzar();
    while (!listaDeAdyacencia.fin() && result == false) {
      Vertice<T> vSiguiente = listaDeAdyacencia.proximo().verticeDestino();
      if (vSiguiente.posicion() == posicionDestino) {
        result = true;
      } else if (visitados[vSiguiente.posicion()] == false) {
        result = dfsTieneCiclo(grafo, visitados, vSiguiente, posicionDestino);
      }
    }

    visitados[vActual.posicion()] = false;
    return result;
  }

}
