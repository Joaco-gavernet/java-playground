package prog3.arbolgeneral;
import prog3.listagenerica.*;

public class EmpresaTest {

	public static void main(String[] args) {

		////// CREO ARBOL DE ESTRUCTURA DE UN COLEGIO //////////////
//		0	 		   ___Bilos___
//			 		  /			  \
//		1  	     Lucas  			Dario
//		       /   |   \			/ 	\
//		2  Zuri  Dutru  Chaca	Priore  Sille
		
		Empleado Zuri = new Empleado("Zuri", 2, 2);
		Empleado Dutru = new Empleado("Dutru", 3, 2);
		Empleado Chaca = new Empleado("Chaca", 0, 2);
		
		ListaGenericaEnlazada<ArbolGeneral<Empleado>> profes_fisica = new ListaGenericaEnlazada<ArbolGeneral<Empleado>>();
		profes_fisica.agregarFinal(new ArbolGeneral<Empleado>(Zuri));
		profes_fisica.agregarFinal(new ArbolGeneral<Empleado>(Dutru));
		profes_fisica.agregarFinal(new ArbolGeneral<Empleado>(Chaca));
		
		Empleado Lucas = new Empleado("Lucas", 3, 1);
		Empresa Fisica = new Empresa(Lucas, profes_fisica);

		
		Empleado Priore = new Empleado("Priore", 8, 2);
		Empleado Sille = new Empleado("Sille", 6, 2);
		
		ListaGenericaEnlazada<ArbolGeneral<Empleado>> profes_ingles = new ListaGenericaEnlazada<ArbolGeneral<Empleado>>();
		profes_ingles.agregarFinal(new ArbolGeneral<Empleado>(Priore));
		profes_ingles.agregarFinal(new ArbolGeneral<Empleado>(Sille));
		
		Empleado Dario = new Empleado("Dario", 3, 1);
		Empresa Ingles = new Empresa(Dario, profes_ingles);
		
		Empleado Bilos = new Empleado("Bilos", 3, 0);
		Empresa Bosque = new Empresa(Bilos);
		Bosque.agregarHijo(Fisica);
		Bosque.agregarHijo(Ingles);
		
		//////////////////////////////
		System.out.println("empresa en preorden: " + Bosque.preOrden());
		System.out.println("empleados por categoria 1: " + Bosque.empleadosPorCategoria(1));
		System.out.println("categoria con mas empleados: " + Bosque.categoriaConMasEmpleados());
		System.out.println("total de empleados: " + Bosque.cantidadTotalDeEmpleados());
		Bosque.reemplazarPresidente();
		System.out.println("preorden despues de reemplazar presidente: " + Bosque.preOrden());
	}
}
