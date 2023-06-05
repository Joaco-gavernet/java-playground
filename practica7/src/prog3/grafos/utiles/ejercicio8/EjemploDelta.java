package prog3.grafos.utiles.ejercicio8;

import prog3.grafos.Grafo;
import prog3.grafos.GrafoImplListAdy;
import prog3.grafos.Vertice;
import prog3.grafos.VerticeImplListAdy;
import prog3.grafos.utiles.ejercicio8.Delta;

public class EjemploDelta {
  public static void main(String args[]) {
    // pruebo la clase Delta.java
    Grafo<String> grafo = new GrafoImplListAdy<String>();

    Vertice<String> vA = new VerticeImplListAdy<String>("A");
    Vertice<String> vB = new VerticeImplListAdy<String>("B");
    Vertice<String> vC = new VerticeImplListAdy<String>("C");
    Vertice<String> vD = new VerticeImplListAdy<String>("D");
    Vertice<String> vE = new VerticeImplListAdy<String>("E");
    Vertice<String> vF = new VerticeImplListAdy<String>("F");
    Vertice<String> vG = new VerticeImplListAdy<String>("G");

    grafo.agregarVertice(vA);
    grafo.agregarVertice(vB);
    grafo.agregarVertice(vC);
    grafo.agregarVertice(vD);
    grafo.agregarVertice(vE);
    grafo.agregarVertice(vF);
    grafo.agregarVertice(vG);

    grafo.conectar(vA, vB);
    grafo.conectar(vA, vC);
    grafo.conectar(vA, vE);
    grafo.conectar(vC, vD);
    grafo.conectar(vC, vD);
    grafo.conectar(vE, vF);
    grafo.conectar(vE, vG);
    grafo.conectar(vF, vG);

    grafo.conectar(vB, vA);
    grafo.conectar(vC, vA);
    grafo.conectar(vE, vA);
    grafo.conectar(vD, vC);
    grafo.conectar(vD, vC);
    grafo.conectar(vF, vE);
    grafo.conectar(vG, vE);
    grafo.conectar(vG, vF);

    Delta delta = new Delta();

    // pruebo el metodo delta.maxIslasDistintas() //////////////////////////
    int maxIslasDistintas = delta.maxIslasDistintas(grafo);
    System.out.println("Maxima cantidad de islas distintas con unico boleto: " +
        maxIslasDistintas);

    // pruebo el metodo delta.caminoMasCorto() //////////////////////////
    RutaMinima caminoMasCorto = delta.caminoMasCorto(grafo, "B", "D");
    System.out.println(
        "Camino mas corto: " + caminoMasCorto.getRecorrido() + " con " + caminoMasCorto.getBoletos() + " boletos.");

  }
}
