package prog3.grafos.util.parcial5;

import prog3.grafos.*;
import prog3.listagenerica.*;
import prog3.grafos.util.*;

public class EjemploBanco {
  public static void main(String args[]) {
    Grafo<Persona> g = new GrafoImplListAdy<Persona>();

    Vertice<Persona> marcos = new VerticeImplListAdy<Persona>(new Persona(false, "Marcos"));
    Vertice<Persona> juan = new VerticeImplListAdy<Persona>(new Persona(false, "Juan"));
    Vertice<Persona> raul = new VerticeImplListAdy<Persona>(new Persona(true, "Raul"));
    Vertice<Persona> amalia = new VerticeImplListAdy<Persona>(new Persona(true, "Amalia"));
    Vertice<Persona> marta = new VerticeImplListAdy<Persona>(new Persona(true, "Marta"));

    // agregar vertices al grafo ///////////////////////////
    g.agregarVertice(marcos);
    g.agregarVertice(juan);
    g.agregarVertice(raul);
    g.agregarVertice(amalia);
    g.agregarVertice(marta);

    // conectar vertices en el grafo //////////////////////////
    g.conectar(marcos, juan);
    g.conectar(marcos, raul);
    g.conectar(raul, amalia);
    g.conectar(raul, marta);

    // implementacion de Banco.resolver() //////////////////////////
    Banco b = new Banco();
    ListaGenerica<String> l = b.resolver(g, marcos.dato(), 2);
    // imprimo resultado //////////////////////////////
    l.comenzar();
    while (!l.fin()) {
      System.out.println(l.proximo());
    }

  }
}
