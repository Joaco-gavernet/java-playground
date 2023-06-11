package prog3.grafos.util.parcial5;

import prog3.listagenerica.*;
import prog3.colagenerica.ColaGenerica;
import prog3.colagenerica.ColaGenericaImplementada;
import prog3.grafos.*;
import prog3.grafos.util.*;

public class Banco {
  public ListaGenerica<String> resolver(Grafo<Persona> g, Persona empleado, int grado) {
    ListaGenerica<String> l = new ListaGenericaEnlazada<String>();

    if (g != null && !g.esVacio()) {
      ListaGenerica<Vertice<Persona>> vertices = g.listaDeVertices();
      Vertice<Persona> vOrigen = null;
      vertices.comenzar();
      while (!vertices.fin() && vOrigen == null) {
        Vertice<Persona> aux = vertices.proximo();
        if (aux.dato().equals(empleado))
          vOrigen = aux;
      }
      if (vOrigen != null) {
        boolean visitados[] = new boolean[g.listaDeVertices().tamanio()];
        bfs(g, visitados, vOrigen, grado, l);
      }
    }

    return l;
  }

  private void bfs(Grafo<Persona> g, boolean visitados[], Vertice<Persona> v, int grado, ListaGenerica<String> l) {
    ColaGenericaImplementada<Vertice<Persona>> cola = new ColaGenericaImplementada<Vertice<Persona>>();
    cola.encolar(v);
    cola.encolar(null);
    visitados[v.posicion()] = true;

    while (!cola.esVacia() && l.tamanio() <= 40 && grado > 0) {
      Vertice<Persona> act = cola.desencolar();
      if (act == null) {
        if (!cola.esVacia())
          cola.encolar(null);
        grado--;
      } else {
        ListaGenerica<Arista<Persona>> ady = g.listaDeAdyacentes(act);
        ady.comenzar();
        while (!ady.fin()) {
          Vertice<Persona> nuevo = ady.proximo().verticeDestino();
          if (nuevo.dato().esJubilado() && visitados[nuevo.posicion()] == false) {
            l.agregarFinal(nuevo.dato().nombre());
            cola.encolar(nuevo);
            visitados[nuevo.posicion()] = true;
          }
        }
      }
    }
  }

}
