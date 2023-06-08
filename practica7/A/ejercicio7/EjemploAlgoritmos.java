package prog3.grafos.utiles.ejercicio7;

import prog3.grafos.Grafo;
import prog3.grafos.GrafoImplListAdy;
import prog3.grafos.Vertice;
import prog3.grafos.VerticeImplListAdy;

public class EjemploAlgoritmos {
  public static void main(String[] args) {
    // pruebo la clase Algoritmos.java con un digrafo
    Grafo<Integer> grafo = new GrafoImplListAdy<Integer>();

    Vertice<Integer> v1 = new VerticeImplListAdy<Integer>(1);
    Vertice<Integer> v2 = new VerticeImplListAdy<Integer>(2);
    Vertice<Integer> v3 = new VerticeImplListAdy<Integer>(3);
    Vertice<Integer> v4 = new VerticeImplListAdy<Integer>(4);
    Vertice<Integer> v5 = new VerticeImplListAdy<Integer>(5);
    Vertice<Integer> v6 = new VerticeImplListAdy<Integer>(6);
    Vertice<Integer> v7 = new VerticeImplListAdy<Integer>(7);

    grafo.agregarVertice(v1);
    grafo.agregarVertice(v2);
    grafo.agregarVertice(v3);
    grafo.agregarVertice(v4);
    grafo.agregarVertice(v5);
    grafo.agregarVertice(v6);
    grafo.agregarVertice(v7);

    grafo.conectar(v1, v2);
    grafo.conectar(v1, v5);
    grafo.conectar(v1, v7);
    grafo.conectar(v2, v3);
    grafo.conectar(v3, v4);
    grafo.conectar(v5, v1);
    grafo.conectar(v6, v5);
    grafo.conectar(v7, v6);

    Algoritmos<Integer> algoritmos = new Algoritmos<Integer>();

    // pruebo el metodo algoritmos.subgrafoCuadrado() //////////////////////////
    boolean result = algoritmos.subgrafoCuadrado(grafo);
    System.out.println("Subgrafo cuadrado: " + result);

    // pruebo el metodo algoritmos.subgrafoCuadrado() //////////////////////////
    int gradoMax = algoritmos.getGrado(grafo);
    System.out.println("Grado maximo del grafo: " + gradoMax);

    // pruebo el metodo algoritmos.tieneCiclo() //////////////////////////
    boolean tieneCiclo = algoritmos.tieneCiclo(grafo);
    System.out.println("Tiene ciclo: " + tieneCiclo);

  }
}
