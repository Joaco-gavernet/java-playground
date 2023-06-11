package prog3.grafos.utiles.ejercicio10;

import prog3.grafos.Grafo;
import prog3.grafos.GrafoImplListAdy;
import prog3.grafos.Vertice;
import prog3.grafos.VerticeImplListAdy;

public class EjemploGradosDeSeparacion {
  public static void main(String args[]) {
    // create an undirected graph with the given structure
    Grafo<String> grafo = new GrafoImplListAdy<String>();

    Vertice<String> vA = new VerticeImplListAdy<String>("A");
    Vertice<String> vB = new VerticeImplListAdy<String>("B");
    Vertice<String> vC = new VerticeImplListAdy<String>("C");
    Vertice<String> vD = new VerticeImplListAdy<String>("D");

    grafo.agregarVertice(vA);
    grafo.agregarVertice(vB);
    grafo.agregarVertice(vC);
    grafo.agregarVertice(vD);

    grafo.conectar(vA, vB);
    grafo.conectar(vA, vC);
    grafo.conectar(vB, vC);
    grafo.conectar(vC, vD);

    // add the reverse connections
    grafo.conectar(vB, vA);
    grafo.conectar(vC, vA);
    grafo.conectar(vC, vB);
    grafo.conectar(vD, vC);

    // create a new instance of the GuiaDeTurismo class
    GradosDeSeparacion relaciones = new GradosDeSeparacion();

    // prueba del metodo relaciones.gradosDeSeparacion() //////////////////////////
    int maximoGradoDeSeparacion = relaciones.maximoGradoDeSeparacion(grafo);
    System.out.println("Maximo grado de separacion: " +
        maximoGradoDeSeparacion);
  }
}
