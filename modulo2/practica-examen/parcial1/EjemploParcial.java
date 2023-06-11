package prog3.grafos.util;

import prog3.grafos.Arista;
import prog3.grafos.Grafo;
import prog3.grafos.GrafoImplListAdy;
import prog3.grafos.Vertice;
import prog3.grafos.VerticeImplListAdy;
import prog3.listagenerica.ListaGenerica;
import prog3.grafos.util.C;

public class EjemploParcial {

  public static void main(String args[]) {
    Grafo<C> grafo = new GrafoImplListAdy<C>();

    // create vertices /////////////////////////////////
    Vertice<C> suipacha = new VerticeImplListAdy<C>(new C("Suipacha", 5));
    Vertice<C> carlosKeen = new VerticeImplListAdy<C>(new C("Carlos Keen", 3));
    Vertice<C> moreno = new VerticeImplListAdy<C>(new C("Moreno", 2));
    Vertice<C> quilmes = new VerticeImplListAdy<C>(new C("Quilmes", 2));
    Vertice<C> abasto = new VerticeImplListAdy<C>(new C("Abasto", 2));
    Vertice<C> laPlata = new VerticeImplListAdy<C>(new C("La Plata", 2));
    Vertice<C> pinamar = new VerticeImplListAdy<C>(new C("Pinamar", 3));
    Vertice<C> navarro = new VerticeImplListAdy<C>(new C("Navarro", 4));
    Vertice<C> canuelas = new VerticeImplListAdy<C>(new C("Canuelas", 3));
    Vertice<C> lobos = new VerticeImplListAdy<C>(new C("Lobos", 3));
    Vertice<C> saladillo = new VerticeImplListAdy<C>(new C("Saladillo", 4));

    // add vertices to graph /////////////////////////////////
    grafo.agregarVertice(suipacha);
    grafo.agregarVertice(carlosKeen);
    grafo.agregarVertice(moreno);
    grafo.agregarVertice(quilmes);
    grafo.agregarVertice(abasto);
    grafo.agregarVertice(laPlata);
    grafo.agregarVertice(pinamar);
    grafo.agregarVertice(navarro);
    grafo.agregarVertice(canuelas);
    grafo.agregarVertice(lobos);
    grafo.agregarVertice(saladillo);

    // add connections to graph /////////////////////////////////
    grafo.conectar(suipacha, carlosKeen);
    grafo.conectar(suipacha, navarro);
    grafo.conectar(carlosKeen, moreno);
    grafo.conectar(moreno, quilmes);
    grafo.conectar(moreno, abasto);
    grafo.conectar(quilmes, laPlata);
    grafo.conectar(abasto, laPlata);
    grafo.conectar(laPlata, pinamar);
    grafo.conectar(navarro, canuelas);
    grafo.conectar(navarro, lobos);
    grafo.conectar(navarro, saladillo);
    grafo.conectar(canuelas, abasto);

    // make it a digraph /////////////////////////////////
    grafo.conectar(carlosKeen, suipacha);
    grafo.conectar(navarro, suipacha);
    grafo.conectar(moreno, carlosKeen);
    grafo.conectar(quilmes, moreno);
    grafo.conectar(abasto, moreno);
    grafo.conectar(laPlata, quilmes);
    grafo.conectar(laPlata, abasto);
    grafo.conectar(pinamar, laPlata);
    grafo.conectar(canuelas, navarro);
    grafo.conectar(lobos, navarro);
    grafo.conectar(saladillo, navarro);
    grafo.conectar(abasto, canuelas);

    // Imprimir grafo /////////////////////////////////
    // for (int i = 0; i < grafo.listaDeVertices().tamanio(); i++) {
    // Vertice<C> v = grafo.listaDeVertices().elemento(i);
    // System.out.print(v.dato().getCity() + " (" + v.dato().getFase() + ") -> ");
    // ListaGenerica<Arista<C>> ady = grafo.listaDeAdyacentes(v);
    // ady.comenzar();
    // while (!ady.fin()) {
    // Arista<C> a = ady.proximo();
    // Vertice<C> destino = a.verticeDestino();
    // System.out.print("[" + destino.dato().getCity() + " (" +
    // destino.dato().getFase() + ")]");
    // System.out.print("; ");
    // }
    // System.out.println();
    // }

    // implementacion de Parcial.resolver() /////////////////////////////////
    System.out.println("Resultado: ");
    Parcial p = new Parcial();
    ListaGenerica<String> lista = p.resolver(grafo, "La Plata", "Carlos Keen");
    lista.comenzar();
    while (!lista.fin()) {
      System.out.println(lista.proximo());
    }

  }

}
