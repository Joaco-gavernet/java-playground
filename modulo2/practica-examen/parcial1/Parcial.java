package prog3.grafos.util;

import prog3.grafos.*;
import prog3.listagenerica.*;
import prog3.grafos.util.C;

public class Parcial {

  public ListaGenerica<String> resolver(Grafo<C> ciudades, String origen, String destino) {
    ListaGenerica<String> l = new ListaGenericaEnlazada<String>();

    if (ciudades != null && !ciudades.esVacio()) {
      ListaGenerica<Vertice<C>> vertices = ciudades.listaDeVertices();
      vertices.comenzar();
      Vertice<C> vOrigen = null;

      while (!vertices.fin()) {
        Vertice<C> aux = vertices.proximo();
        if (aux.dato().getCity().equals(origen))
          vOrigen = aux;
      }

      if (vOrigen != null) {
        ListaGenerica<String> recorrido = new ListaGenericaEnlazada<String>();
        boolean visitados[] = new boolean[ciudades.listaDeVertices().tamanio()];
        dfs(ciudades, visitados, destino, vOrigen, recorrido);
        l = (recorrido.elemento(recorrido.tamanio() - 1).equals(destino)) ? recorrido : l;
      }
    }

    return l;
  }

  private void dfs(Grafo<C> g, boolean[] visitados, String destino, Vertice<C> v, ListaGenerica<String> recorrido) {
    visitados[v.posicion()] = true;
    recorrido.agregarFinal(v.dato().getCity());

    if (!v.dato().getCity().equals(destino)) {
      ListaGenerica<Arista<C>> adyacentes = g.listaDeAdyacentes(v);
      adyacentes.comenzar();
      while (!adyacentes.fin()) {
        Vertice<C> aux = adyacentes.proximo().verticeDestino();
        if (aux.dato().getFase() != 1 && !visitados[aux.posicion()]
            && !recorrido.elemento(recorrido.tamanio() - 1).equals(destino))
          dfs(g, visitados, destino, aux, recorrido);
      }
    }

    if (!recorrido.elemento(recorrido.tamanio() - 1).equals(destino)) {
      recorrido.eliminarEn(recorrido.tamanio() - 1);
    }
    visitados[v.posicion()] = false;
  }

}
