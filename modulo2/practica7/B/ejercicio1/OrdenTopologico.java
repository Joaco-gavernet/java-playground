package prog3.grafos.util;

import prog3.listagenerica.ListaGenerica;
import prog3.listagenerica.ListaGenericaEnlazada;
import prog3.pilagenerica.PilaGenerica;
import prog3.pilagenerica.PilaGenericaImplementada;
import prog3.grafos.Vertice;
import prog3.grafos.Grafo;
import prog3.grafos.Arista;

public class OrdenTopologico<T> {

  public ListaGenerica<Vertice<T>> ordenTopologico(Grafo<T> grafo) {
    ListaGenerica<Vertice<T>> resultado = new ListaGenericaEnlazada<Vertice<T>>();

    if (grafo != null && !grafo.esVacio()) {
      ListaGenerica<Vertice<T>> vertices = grafo.listaDeVertices();
      int vectorDeGrados[] = new int[vertices.tamanio()];

      // construccion del vectorDeGrados
      vertices.comenzar();
      while (!vertices.fin()) {
        Vertice<T> actual = vertices.proximo();
        ListaGenerica<Arista<T>> ady = grafo.listaDeAdyacentes(actual);

        ady.comenzar();
        while (!ady.fin()) {
          int i = ady.proximo().verticeDestino().posicion();
          vectorDeGrados[i]++; // se incrementa el grado_in del vertice de llegada
        }
      }

      PilaGenerica<Vertice<T>> pila = new PilaGenericaImplementada<Vertice<T>>();
      for (int i = 0; i < vertices.tamanio(); i++) {
        if (vectorDeGrados[i] == 0)
          pila.apilar(vertices.elemento(i)); // se apilan los elementos que empiezan con grado_in == 0
      }

      while (!pila.esVacia()) {
        Vertice<T> actual = pila.desapilar();
        resultado.agregarFinal(actual);
        ListaGenerica<Arista<T>> ady = grafo.listaDeAdyacentes(actual);
        ady.comenzar();
        while (!ady.fin()) {
          int i = ady.proximo().verticeDestino().posicion();
          vectorDeGrados[i]--; // se decrementa el grado_in del vertice de llegada
          if (vectorDeGrados[i] == 0)
            pila.apilar(grafo.listaDeVertices().elemento(i));
        }
      }

      System.out.println(pila);
    }

    return resultado;
  }

}
