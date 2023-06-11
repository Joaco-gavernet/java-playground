package prog3.grafos.util;

import prog3.grafos.Grafo;
import prog3.grafos.GrafoImplListAdy;
import prog3.grafos.Vertice;
import prog3.grafos.VerticeImplListAdy;
import prog3.listagenerica.ListaGenerica;
import prog3.grafos.util.OrdenTopologico;

public class EjemploOrdenTopologico {
  public static void main(String args[]) {
    Grafo<String> grafo = new GrafoImplListAdy<String>();

    // Add vertices
    Vertice<String> boxer = new VerticeImplListAdy<String>("boxer");
    Vertice<String> zapatos = new VerticeImplListAdy<String>("zapatos");
    Vertice<String> pantalones = new VerticeImplListAdy<String>("pantalones");
    Vertice<String> medias = new VerticeImplListAdy<String>("medias");
    Vertice<String> reloj = new VerticeImplListAdy<String>("reloj");
    Vertice<String> camisa = new VerticeImplListAdy<String>("camisa");
    Vertice<String> corbata = new VerticeImplListAdy<String>("corbata");
    Vertice<String> saco = new VerticeImplListAdy<String>("saco");
    Vertice<String> cinturon = new VerticeImplListAdy<String>("cinturon");

    grafo.agregarVertice(boxer);
    grafo.agregarVertice(zapatos);
    grafo.agregarVertice(pantalones);
    grafo.agregarVertice(medias);
    grafo.agregarVertice(reloj);
    grafo.agregarVertice(camisa);
    grafo.agregarVertice(corbata);
    grafo.agregarVertice(saco);
    grafo.agregarVertice(cinturon);

    // Connect vertices
    grafo.conectar(boxer, zapatos);
    grafo.conectar(boxer, pantalones);
    grafo.conectar(pantalones, zapatos);
    grafo.conectar(pantalones, cinturon);
    grafo.conectar(medias, zapatos);
    grafo.conectar(camisa, corbata);
    grafo.conectar(camisa, cinturon);
    grafo.conectar(cinturon, corbata);
    grafo.conectar(corbata, saco);

    // // Print the graph
    // ListaGenerica<Vertice<String>> vertices = grafo.listaDeVertices();
    // vertices.comenzar();
    // while (!vertices.fin()) {
    // Vertice<String> vertice = vertices.proximo();
    // ListaGenerica<Arista<String>> adyacentes = grafo.listaDeAdyacentes(vertice);
    // adyacentes.comenzar();
    // while (!adyacentes.fin()) {
    // Arista<String> arista = adyacentes.proximo();
    // System.out.println(vertice.dato() + " -> " + arista.verticeDestino().dato());
    // }
    // }

    OrdenTopologico<String> ordenar = new OrdenTopologico<String>();
    ListaGenerica<Vertice<String>> result = ordenar.ordenTopologico(grafo);
    System.out.println("Resultado del sort topologico: ");
    result.comenzar();
    while (!result.fin()) {
      System.out.println(result.proximo().dato());
    }
  }
}
