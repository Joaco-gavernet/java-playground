package prog3.arbolgeneral;
import prog3.listagenerica.*;

public class ArbolGeneralTest {

	public static void main(String[] args) {
		
//		arbol general ag
//		    2
//		   /
//		  4
//		 /
//		5
		
		ListaGenericaEnlazada<ArbolGeneral<Integer>> nietos = new ListaGenericaEnlazada<ArbolGeneral<Integer>>();
		nietos.agregarFinal(new ArbolGeneral<Integer>(5));		
		ListaGenericaEnlazada<ArbolGeneral<Integer>> hijos = new ListaGenericaEnlazada<ArbolGeneral<Integer>>();
		hijos.agregarFinal(new ArbolGeneral<Integer>(4, nietos));
		
		ArbolGeneral<Integer> ag = new ArbolGeneral<Integer>(2, hijos);
		System.out.println("altura " + ag.altura());
		System.out.println("include 4? " + ag.include(4));
		System.out.println("nivel del 4? " + ag.nivel(4));
		System.out.println("ancho " + ag.ancho());
		ag.preOrden();
	}

}
