package prog3.grafos.utiles.ejercicio9;

import prog3.listagenerica.ListaGenerica;
import prog3.listagenerica.ListaGenericaEnlazada;

public class Resultado {
  private int cuelloDeBotella;
  private int nroDeViajes;
  private ListaGenerica<String> recorrido;

  public Resultado() {
    this.cuelloDeBotella = 0;
    this.nroDeViajes = Integer.MAX_VALUE;
    this.recorrido = new ListaGenericaEnlazada<String>();
  }

  public int getCuelloDeBotella() {
    return this.cuelloDeBotella;
  }

  public int getNroDeViajes() {
    return this.nroDeViajes;
  }

  public ListaGenerica<String> getRecorrido() {
    return this.recorrido;
  }

  public void setCuelloDeBotella(int cuelloDeBotella) {
    this.cuelloDeBotella = cuelloDeBotella;
  }

  public void setNroDeViajes(int nroDeViajes) {
    this.nroDeViajes = nroDeViajes;
  }

  public void setRecorrido(ListaGenerica<String> recorrido) {
    this.recorrido = recorrido;
  }
}
