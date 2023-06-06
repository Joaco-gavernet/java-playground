package prog3.grafos.utiles.ejercicio9;

import prog3.grafos.Grafo;
import prog3.grafos.GrafoImplListAdy;
import prog3.grafos.Vertice;
import prog3.grafos.VerticeImplListAdy;
import prog3.listagenerica.ListaGenerica;

public class EjemploGuiaDeTurismo {
  public static void main(String args[]) {
    // create an undirected graph with the given structure
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

    grafo.conectar(vA, vB, 30);
    grafo.conectar(vA, vC, 15);
    grafo.conectar(vA, vD, 10);
    grafo.conectar(vB, vD, 25);
    grafo.conectar(vB, vE, 60);
    grafo.conectar(vC, vD, 40);
    grafo.conectar(vC, vF, 20);
    grafo.conectar(vD, vG, 35);
    grafo.conectar(vE, vG, 20);
    grafo.conectar(vF, vG, 30);

    // add the reverse connections with the same weights
    grafo.conectar(vB, vA, 30);
    grafo.conectar(vC, vA, 15);
    grafo.conectar(vD, vA, 10);
    grafo.conectar(vD, vB, 25);
    grafo.conectar(vE, vB, 60);
    grafo.conectar(vD, vC, 40);
    grafo.conectar(vF, vC, 20);
    grafo.conectar(vG, vD, 35);
    grafo.conectar(vG, vE, 20);
    grafo.conectar(vG, vF, 30);

    // create a new instance of the GuiaDeTurismo class
    GuiaDeTurismo guia = new GuiaDeTurismo();

    // prueba del metodo guia.caminoConMenorNrodeViajes() //////////////////////////
    ListaGenerica<String> caminoConMenorNrodeViajes = guia.caminoConMenorNrodeViajes(grafo, "A", "G");
    System.out.println("Maxima cantidad de islas distintas con unico boleto: " +
        caminoConMenorNrodeViajes);

  }
}
