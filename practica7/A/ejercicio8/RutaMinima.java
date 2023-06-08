package prog3.grafos.utiles.ejercicio8;

import prog3.listagenerica.ListaGenerica;
import prog3.listagenerica.ListaGenericaEnlazada;

public class RutaMinima {
  private int boletos;
  private ListaGenerica<String> recorrido;

  public RutaMinima() {
    this.boletos = 0;
    this.recorrido = new ListaGenericaEnlazada<String>();
  }

  public RutaMinima(int boletos, ListaGenerica<String> recorrido) {
    this.boletos = boletos;
    this.recorrido = recorrido;
  }

  // geters y seters /////////////////////////////////////////////////
  public int getBoletos() {
    return boletos;
  }

  public void setBoletos(int boletos) {
    this.boletos = boletos;
  }

  public ListaGenerica<String> getRecorrido() {
    return recorrido;
  }

  public void setRecorrido(ListaGenerica<String> recorrido) {
    this.recorrido = recorrido;
  }

}
