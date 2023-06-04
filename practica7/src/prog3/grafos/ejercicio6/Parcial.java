package prog3.grafos.ejercicio6;

import prog3.grafos.Grafo;
import prog3.grafos.GrafoImplListAdy;
import prog3.grafos.Vertice;
import prog3.grafos.VerticeImplListAdy;
import prog3.listagenerica.ListaGenerica;
import prog3.listagenerica.ListaGenericaEnlazada;

public class Parcial {
  public static void main(String[] args) {
    Grafo<String> grafo = new GrafoImplListAdy<String>();

    Vertice<String> v1 = new VerticeImplListAdy<String>("La Plata");
    Vertice<String> v2 = new VerticeImplListAdy<String>("Gonnet");
    Vertice<String> v3 = new VerticeImplListAdy<String>("City Bell");
    Vertice<String> v4 = new VerticeImplListAdy<String>("Villa Ellisa");
    Vertice<String> v5 = new VerticeImplListAdy<String>("Quilmes");

    grafo.agregarVertice(v1);
    grafo.agregarVertice(v2);
    grafo.agregarVertice(v3);
    grafo.agregarVertice(v4);
    grafo.agregarVertice(v5);

    grafo.conectar(v1, v2, 400);
    grafo.conectar(v1, v3, 300);
    grafo.conectar(v2, v4, 200);
    grafo.conectar(v3, v4, 100);
    grafo.conectar(v4, v5, 800);

    Mapa mapa = new Mapa();
    mapa.setGrafo(grafo);

    // devolverCamino /////////////////////////////////////////////////
    // ListaGenerica<String> camino = mapa.devolverCamino("La Plata", "Villa
    // Ellisa");
    // camino.comenzar();
    // while (!camino.fin()) {
    // System.out.println(camino.proximo());
    // }

    // devolverCaminoExceptuando /////////////////////////////////////////////////
    // ListaGenerica<String> ciudadesExceptuadas = new
    // ListaGenericaEnlazada<String>();
    // ciudadesExceptuadas.agregarFinal("City Bell");
    // ListaGenerica<String> caminoExceptuandoCiudades =
    // mapa.devolverCaminoExceptuando("La Plata", "Villa Ellisa",
    // ciudadesExceptuadas);
    // caminoExceptuandoCiudades.comenzar();
    // while (!caminoExceptuandoCiudades.fin()) {
    // System.out.println(caminoExceptuandoCiudades.proximo());
    // }

    // caminoMasCorto /////////////////////////////////////////////////
    // ListaGenerica<String> caminoMasCorto = mapa.caminoMasCorto("La Plata", "Villa
    // Ellisa");
    // caminoMasCorto.comenzar();
    // while (!caminoMasCorto.fin()) {
    // System.out.println(caminoMasCorto.proximo());
    // }

    // caminoSinCargarCombustible /////////////////////////////////////////////////
    // ListaGenerica<String> caminoSinCargarCombustible =
    // mapa.caminoSinCargarCombustible("La Plata", "Villa Ellisa",500);
    // caminoSinCargarCombustible.comenzar();
    // while (!caminoSinCargarCombustible.fin()) {
    // System.out.println(caminoSinCargarCombustible.proximo());
    // }

    // caminoConMenorCargaDeCombustible/////////////////////////////////////////////////
    ListaGenerica<String> caminoConMenorCargaDeCombustible = mapa.caminoConMenorCargaDeCombustible("La Plata",
        "Villa Ellisa",
        500);
    caminoConMenorCargaDeCombustible.comenzar();
    while (!caminoConMenorCargaDeCombustible.fin()) {
      System.out.println(caminoConMenorCargaDeCombustible.proximo());
    }

  }
}
