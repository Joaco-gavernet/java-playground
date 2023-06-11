public class Parcial {
  public int resolver(Grafo<C> ciudades, String origen, String destino, int maxControles) {
    Resultado r = new Resultado();

    if (ciudades != null && !ciudades.esVacio()) {
      ListaGenerica<Vertice<C>> vtes = ciudades.listaDeVertices();
      Vertice<C> vOrigen = null;
      vtes.comenzar();
      while (!vtes.fin()) {
        Vertice<C> aux = vtes.proximo();
        if (aux.dato().getC().equals(origen)) {
          vOrigen = aux;
        }
      }
      if (vOrigen != null) {
        boolean visitados[] = new boolean[ciudades.listaDeVertices().tamanio()];
        dfs(ciudades, visitados, r, destino, maxControles, vOrigen, 0);
      }
    }

    return r.getD();
  }

  private void dfs(Grafo<C> g, boolean[] visitados, Resultado r, String destino, int maxControles, Vertice<C> v,
      int dias) {
    visitados[v.posicion()] = true;

    if (v.dato().getC().equals(destino)) {
      if (dias > r.getD())
        r.setD(dias);
    } else {
      ListaGenerica<Arista<C>> ady = g.listaDeAdyacentes(v);
      ady.comenzar();
      while (!ady.fin()) {
        Arista<C> a = ady.proximo();
        if (a.dato().getControles() <= maxControles && visitados[a.verticeDestino().posicion()] == false) {
          dfs(g, visitados, r, destino, maxControles, a.verticeDestino(), dias + v.dato().getD());
        }
      }
    }

    visitados[v.posicion()] = false;
  }
}
