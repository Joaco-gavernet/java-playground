package prog3.grafos.utiles.ejercicio9;

import prog3.grafos.Arista;
import prog3.grafos.Grafo;
import prog3.grafos.Vertice;
import prog3.listagenerica.ListaGenerica;
import prog3.listagenerica.ListaGenericaEnlazada;

public class GuiaDeTurismo {
  public ListaGenerica<String> caminoConMenorNrodeViajes(Grafo<String> grafo, String origen, String destino) {
    Resultado result = new Resultado();

    if (grafo != null && !grafo.esVacio()) {
      // busco origen para comenzar el recorrido
      ListaGenerica<Vertice<String>> listaDeVertices = grafo.listaDeVertices();
      listaDeVertices.comenzar();
      Vertice<String> vActual = listaDeVertices.proximo();
      while (!listaDeVertices.fin() && vActual.dato().equals(origen) == false) {
        vActual = listaDeVertices.proximo();
      }

      // si se encontro el origen, se busca el destino
      if (vActual.dato().equals(origen)) {
        boolean[] visitados = new boolean[grafo.listaDeVertices().tamanio()];
        ListaGenerica<String> recorrido = new ListaGenericaEnlazada<String>();
        dfsCaminoConMenorNrodeViajes(grafo, visitados, vActual, destino, recorrido, 2000, result);
      }
    }

    return result.getRecorrido();
  }

  private void dfsCaminoConMenorNrodeViajes(
      Grafo<String> grafo,
      boolean[] visitados,
      Vertice<String> vActual,
      String destino,
      ListaGenerica<String> recorrido,
      int cuelloDeBotella,
      Resultado result) {
    // PROLOGO /////////////////////////////////////////////////
    visitados[vActual.posicion()] = true;
    recorrido.agregarFinal(vActual.dato());

    // CUERPO /////////////////////////////////////////////////
    if (vActual.dato().equals(destino) == true) { // se encuentra destino
      if (cuelloDeBotella > result.getCuelloDeBotella()) {
        result.setCuelloDeBotella(cuelloDeBotella);
        result.setRecorrido(recorrido.clonar());
      }
    } else {
      ListaGenerica<Arista<String>> listaDeAdyacencia = grafo.listaDeAdyacentes(vActual);
      listaDeAdyacencia.comenzar();
      int aux;
      while (!listaDeAdyacencia.fin()) {
        Arista<String> aristaActual = listaDeAdyacencia.proximo();
        aux = (aristaActual.peso() < cuelloDeBotella) ? aristaActual.peso() : cuelloDeBotella;

        Vertice<String> vSiguiente = aristaActual.verticeDestino();
        if (visitados[vSiguiente.posicion()] == false) {
          dfsCaminoConMenorNrodeViajes(grafo, visitados, vSiguiente, destino, recorrido, aux, result);
        }
      }
    }

    // EPILOGO /////////////////////////////////////////////////
    visitados[vActual.posicion()] = false;
    recorrido.eliminarEn(recorrido.tamanio() - 1); // elimina ultimo elemento en el recorrido
  }

}
