package prog3.grafos.util.parcial4;

import prog3.grafos.Vertice;
import prog3.grafos.Arista;
import prog3.grafos.Grafo;
import prog3.listagenerica.ListaGenerica;
import prog3.listagenerica.ListaGenericaEnlazada;
import prog3.grafos.VerticeImplListAdy;
import prog3.listaenteros.ListaDeEnteros;
import prog3.grafos.GrafoImplListAdy;

public class EjemploParcial {
  public static void main(String args[]) {
    Grafo<C> grafo = new GrafoImplListAdy<C>();

    // create vertices
    Vertice<C> suipacha = new VerticeImplListAdy<>(new C("Suipacha", 3));
    Vertice<C> carlosKeen = new VerticeImplListAdy<>(new C("Carlos Keen", 2));
    Vertice<C> moreno = new VerticeImplListAdy<>(new C("Moreno", 2));
    Vertice<C> quilmes = new VerticeImplListAdy<>(new C("Quilmes", 3));
    Vertice<C> abasto = new VerticeImplListAdy<>(new C("Abasto", 3));
    Vertice<C> laPlata = new VerticeImplListAdy<>(new C("La Plata", 1));
    Vertice<C> pinamar = new VerticeImplListAdy<>(new C("Pinamar", 0));
    Vertice<C> navarro = new VerticeImplListAdy<>(new C("Navarro", 1));
    Vertice<C> canuelas = new VerticeImplListAdy<>(new C("Canuelas", 2));
    Vertice<C> lobos = new VerticeImplListAdy<>(new C("Lobos", 1));
    Vertice<C> saladillo = new VerticeImplListAdy<>(new C("Saladillo", 2));

    // add vertices to graph
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

    // add connections to graph
    grafo.conectar(suipacha, carlosKeen, 2);
    grafo.conectar(suipacha, navarro, 2);
    grafo.conectar(carlosKeen, moreno, 2);
    grafo.conectar(moreno, quilmes, 2);
    grafo.conectar(moreno, abasto, 3);
    grafo.conectar(quilmes, laPlata, 2);
    grafo.conectar(abasto, laPlata, 2);
    grafo.conectar(laPlata, pinamar, 2);
    grafo.conectar(navarro, canuelas, 2);
    grafo.conectar(navarro, lobos, 4);
    grafo.conectar(navarro, saladillo, 2);
    grafo.conectar(canuelas, abasto, 2);

    // make it a digraph
    grafo.conectar(carlosKeen, suipacha, 2);
    grafo.conectar(navarro, suipacha, 2);
    grafo.conectar(moreno, carlosKeen, 2);
    grafo.conectar(quilmes, moreno, 2);
    grafo.conectar(abasto, moreno, 3);
    grafo.conectar(laPlata, quilmes, 2);
    grafo.conectar(laPlata, abasto, 2);
    grafo.conectar(pinamar, laPlata, 2);
    grafo.conectar(canuelas, navarro, 2);
    grafo.conectar(lobos, navarro, 4);
    grafo.conectar(saladillo, navarro, 2);
    grafo.conectar(abasto, canuelas, 2);

    for (int i = 0; i < grafo.listaDeVertices().tamanio(); i++) {
      Vertice<C> v = grafo.listaDeVertices().elemento(i);
      System.out.print(v.dato().getC() + " (" + v.dato().getD() + ") -> ");
      ListaGenerica<Arista<C>> ady = grafo.listaDeAdyacentes(v);
      ady.comenzar();
      while (!ady.fin()) {
        Arista<C> a = ady.proximo();
        Vertice<C> destino = a.verticeDestino();
        System.out.print("[" + destino.dato().getC() + " (" + destino.dato().getD() + "), " + a.peso() + "]");
        System.out.print("; ");
      }
      System.out.println();
    }

    Parcial p = new Parcial();
    // implemento metodo p.resolver()
    int resultado = p.resolver(grafo, "La Plata", "Suipacha", 2);
    System.out.println("Resultado: " + resultado);
  }
}
