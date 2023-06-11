package prog3.grafos.util.parcial5;

public class Persona {
  private boolean jubilado;
  private String nombre;

  public Persona(boolean j, String n) {
    this.jubilado = j;
    this.nombre = n;
  }

  public boolean esJubilado() {
    return this.jubilado;
  }

  public String nombre() {
    return this.nombre;
  }
}