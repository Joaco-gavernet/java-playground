package prog3.grafos.util;

import prog3.listagenerica.ListaGenerica;
import prog3.grafos.Vertice;
import prog3.grafos.Arista;
import prog3.grafos.Grafo;

public class Dijkstra<T> {
  public int[] dijkstraSinHeap(Grafo<T> grafo, Vertice<T> vertice) {
    int[] costo = new int[grafo.listaDeVertices().tamanio()];
    boolean[] visitados = new boolean[grafo.listaDeVertices().tamanio()];

    for (int i = 0; i < costo.length; i++)
      costo[i] = 200000; // inicializo con costo infinito
    costo[vertice.posicion()] = 0; // seteo el costo del origen en 0

    int procesados = 0;
    visitados[vertice.posicion()] = true;

    while (procesados < grafo.listaDeVertices().tamanio()) {
      int idx = (procesados == 0) ? vertice.posicion() : -1; // inicializo indice

      if (procesados != 0) {
        // hayo vertice desconocido de menor distancia
        for (int i = 0; i < costo.length; i++) {
          if (visitados[i] == false) { // si aun no fue visitado, analizo su costo
            if (idx == -1)
              idx = i; // me quedo con el primer index que no haya sido visitado para comparar
            else if (costo[idx] > costo[i])
              idx = i; // actualizo el index si encuentro uno con menor costo
          }
        } // al finalizar, obtengo en idx la posicion del proximo vertice a procesar
      }
      System.out.println("idx: " + idx);
      ListaGenerica<Arista<T>> ady = grafo.listaDeAdyacentes(grafo.listaDeVertices().elemento(idx));

      ady.comenzar();
      while (!ady.fin()) {
        Arista<T> arista = ady.proximo();
        Vertice<T> verticeDestino = arista.verticeDestino();
        // actualizo vector con nuevos costos si es necesario
        if ((arista.peso() + costo[idx]) < costo[verticeDestino.posicion()]) {
          costo[verticeDestino.posicion()] = arista.peso() + costo[idx];
        }
      }
      visitados[idx] = true;

      procesados++;
    }

    return costo;
  }
}
