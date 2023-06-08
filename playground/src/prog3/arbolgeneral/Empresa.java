package prog3.arbolgeneral;
import prog3.colagenerica.*;
import prog3.listagenerica.ListaGenerica;

public class Empresa extends ArbolGeneral<Empleado> {
	
	public Empresa(Empleado dato) {
		super(dato);
	}
	
	public Empresa(Empleado dato, ListaGenerica<ArbolGeneral<Empleado>> lista) {
		super(dato, lista);
	}

	public int empleadosPorCategoria(int categoria) {
		ColaGenericaImplementada<ArbolGeneral<Empleado>> cola = new ColaGenericaImplementada<ArbolGeneral<Empleado>>();
		ListaGenerica<ArbolGeneral<Empleado>> hijos;
		ArbolGeneral<Empleado> aux;
		
		cola.encolar(this);
		cola.encolar(null);
		
		Integer nivel = 0;
		Integer result = 0;
		
		while (!cola.esVacia()) {
			aux = cola.desencolar();
			
			if (aux == null) {
				if (!cola.esVacia()) cola.encolar(null);
				nivel++;
			} else {
				if (aux.tieneHijos()) {
					hijos = aux.getHijos();
					hijos.comenzar();
					while (!hijos.fin()) {
						cola.encolar(hijos.proximo());
					}					
				}
				if (nivel == categoria) result++;
			}
			
		}
		
		return result;
	}
	
	public int categoriaConMasEmpleados() {
		ColaGenericaImplementada<ArbolGeneral<Empleado>> cola = new ColaGenericaImplementada<ArbolGeneral<Empleado>>();
		ListaGenerica<ArbolGeneral<Empleado>> hijos;
		ArbolGeneral<Empleado> aux;
		
		cola.encolar(this);
		cola.encolar(null);
		
		Integer nivel = 0; // asociado a la categoria
		Integer max = 1; // caso raiz
		Integer nivelMax = nivel; // categoria con maxima cantidad de empleados
		Integer acumulador = 0; // contador por categoria/nivel
		
		while (!cola.esVacia()) {
			aux = cola.desencolar();
			
			if (aux == null) {
				if (!cola.esVacia()) cola.encolar(null);
				nivel++;
				if (acumulador > max) { // actualizacion de maximos
					max = acumulador;
					nivelMax = nivel;
				}
				
				acumulador = 0;
			} else {
				if (aux.tieneHijos()) {
					hijos = aux.getHijos();
					hijos.comenzar();
					while (!hijos.fin()) {
						cola.encolar(hijos.proximo());
						acumulador++;
					}					
				}
			}
		}
		
		return nivelMax;	
	}

	public int cantidadTotalDeEmpleados() {
		ColaGenericaImplementada<ArbolGeneral<Empleado>> cola = new ColaGenericaImplementada<ArbolGeneral<Empleado>>();
		ListaGenerica<ArbolGeneral<Empleado>> hijos;
		ArbolGeneral<Empleado> aux;
		
		cola.encolar(this);
		cola.encolar(null);

		int total = 1;
		
		while (!cola.esVacia()) {
			aux = cola.desencolar();
			
			if (aux == null) {
				if (!cola.esVacia()) cola.encolar(null);
			} else {
				if (aux.tieneHijos()) {
					hijos = aux.getHijos();
					hijos.comenzar();
					while (!hijos.fin()) {
						cola.encolar(hijos.proximo());
						total++;
					}					
				}
			}
			
		}
		
		return total;
	}
	
	public void reemplazarPresidente() {
		ColaGenericaImplementada<Empresa> cola = new ColaGenericaImplementada<Empresa>();
		ListaGenerica<ArbolGeneral<Empleado>> hijos;
		Empresa aux;
		
		cola.encolar(this);
		cola.encolar(null);
		
		Empresa promovido = null;
		Empresa entrevistado;
		
		while (!cola.esVacia()) {
			aux = cola.desencolar();
			
			if (aux == null) {
				if (promovido != null) {
					// swap promovido
					this.getDato().setNombre(promovido.getDato().getNombre());
					this.getDato().setAntiguedad(promovido.getDato().getAntiguedad());
					this.getDato().setCategoria(promovido.getDato().getCategoria());
					// llamado recursivo a reemplazar presidente con empleado promovido
					promovido.reemplazarPresidente();					
				}
				if (!cola.esVacia()) cola.encolar(null);
			} else {
				hijos = aux.getHijos();
				hijos.comenzar();
				
				while (!hijos.fin()) {
					entrevistado = (Empresa) hijos.proximo();
					if (promovido == null) {
						promovido = new Empresa(entrevistado.getDato());
					} 
					else if (entrevistado.getDato().getAntiguedad() > promovido.getDato().getAntiguedad()) {
						promovido.getDato().setNombre(entrevistado.getDato().getNombre());
						promovido.getDato().setAntiguedad(entrevistado.getDato().getAntiguedad());
						promovido.getDato().setCategoria(entrevistado.getDato().getCategoria());
					}
				}
				
			}
			
		}		
	}

}
