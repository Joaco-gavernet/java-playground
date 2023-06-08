package prog3.grafos.utiles.ejercicio8;

import prog3.grafos.Arista;
import prog3.grafos.Grafo;
import prog3.listagenerica.ListaGenerica;
import prog3.listagenerica.ListaGenericaEnlazada;
import prog3.grafos.Vertice;

public class Delta {
  public int maxIslasDistintas(Grafo<String> grafo) {
    int result = 0;

    if (grafo != null && !grafo.esVacio()) {
      boolean[] visitados = new boolean[grafo.listaDeVertices().tamanio()];
      result = dfsMaxIslasDistintas(grafo, visitados, grafo.vertice(0));
    }

    return result;
  }

  private int dfsMaxIslasDistintas(
      Grafo<String> grafo,
      boolean[] visitados,
      Vertice<String> vActual) {
    int max = 0;

    // CUERPO /////////////////////////////////////////////////
    if (visitados[vActual.posicion()] == false) {
      visitados[vActual.posicion()] = true;
      int aux;

      ListaGenerica<Arista<String>> listaDeAdyacencia = grafo.listaDeAdyacentes(vActual);
      listaDeAdyacencia.comenzar();
      while (!listaDeAdyacencia.fin()) {
        Vertice<String> vSiguiente = listaDeAdyacencia.proximo().verticeDestino();
        aux = dfsMaxIslasDistintas(grafo, visitados, vSiguiente);
        max = (aux > max) ? aux : max;
      }

      max++; // se cuenta la isla actual si aun no fue visitada
      visitados[vActual.posicion()] = false;
    }

    return max;
  }

  public RutaMinima caminoMasCorto(Grafo<String> grafo, String islaO, String islaD) {
    RutaMinima result = new RutaMinima();

    if (grafo != null && !grafo.esVacio()) {
      // busco islaO para comenzar el recorrido
      ListaGenerica<Vertice<String>> listaDeVertices = grafo.listaDeVertices();
      listaDeVertices.comenzar();
      Vertice<String> vActual = listaDeVertices.proximo();
      while (!listaDeVertices.fin() && vActual.dato().equals(islaO) == false) {
        vActual = listaDeVertices.proximo();
      }

      // si se encontro islaO, se busca islaD
      if (vActual.dato().equals(islaO)) {
        boolean[] visitados = new boolean[grafo.listaDeVertices().tamanio()];
        ListaGenerica<String> recorrido = new ListaGenericaEnlazada<String>();
        dfsCaminoMasCorto(grafo, visitados, vActual, islaD, recorrido, 0, result);
      }
    }

    return result;
  }

  private void dfsCaminoMasCorto(
      Grafo<String> grafo,
      boolean[] visitados,
      Vertice<String> vActual,
      String islaD,
      ListaGenerica<String> recorrido,
      int boletos,
      RutaMinima result) {
    // PROLOGO /////////////////////////////////////////////////
    visitados[vActual.posicion()] = true;
    recorrido.agregarFinal(vActual.dato());

    // CUERPO /////////////////////////////////////////////////
    if (vActual.dato().equals(islaD) == true) { // se encuentra isla destino
      if (recorrido.tamanio() > result.getRecorrido().tamanio()) {
        result.setBoletos(boletos);
        result.setRecorrido(recorrido.clonar());
      }
    } else {
      ListaGenerica<Arista<String>> listaDeAdyacencia = grafo.listaDeAdyacentes(vActual);
      listaDeAdyacencia.comenzar();
      while (!listaDeAdyacencia.fin()) {
        Vertice<String> vSiguiente = listaDeAdyacencia.proximo().verticeDestino();
        int boletoExtra = (vSiguiente.posicion() == 0) ? 1 : 0; // considero boleto extra al pasar por el origen
        if (visitados[vSiguiente.posicion()] == false) {
          dfsCaminoMasCorto(grafo, visitados, vSiguiente, islaD, recorrido, boletos + boletoExtra, result);
        }
      }
    }

    // EPILOGO /////////////////////////////////////////////////
    visitados[vActual.posicion()] = false;
    recorrido.eliminarEn(recorrido.tamanio() - 1); // elimina ultimo elemento en el recorrido
  }

}
