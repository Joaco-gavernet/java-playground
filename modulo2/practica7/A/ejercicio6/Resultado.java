package prog3.grafos.utiles.ejercicio6;

import prog3.listagenerica.ListaGenerica;
import prog3.listagenerica.ListaGenericaEnlazada;

public class Resultado<T> {
  private ListaGenerica<T> lista;
  private int peso;
  private int recargas;

  public Resultado() {
    lista = new ListaGenericaEnlazada<T>();
    peso = 0;
    recargas = 10000000; // inicializo en un numero grande para realizar comparaciones
  }

  public ListaGenerica<T> getLista() {
    return lista;
  }

  public void setLista(ListaGenerica<T> lista) {
    this.lista = lista;
  }

  public int getPeso() {
    return peso;
  }

  public void setPeso(int peso) {
    this.peso = peso;
  }

  public int getRecargas() {
    return recargas;
  }

  public void setRecargas(int recargas) {
    this.recargas = recargas;
  }
}
