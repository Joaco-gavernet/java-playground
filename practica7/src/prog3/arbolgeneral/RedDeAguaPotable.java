package prog3.arbolgeneral;

import prog3.listagenerica.*;

public class RedDeAguaPotable extends ArbolGeneral<Integer> {

	public RedDeAguaPotable(Integer litros) {
		super(litros);
	}

	public RedDeAguaPotable(int i, ListaGenerica<ArbolGeneral<Integer>> nivel) {
		super(i, nivel);
	}

	public int minimoCaudal() { // recorrido postorden
		ListaGenerica<ArbolGeneral<Integer>> hijos = new ListaGenericaEnlazada<ArbolGeneral<Integer>>();
		int minimo = Integer.MAX_VALUE;
		int aux;

		if (this.esHoja()) {
			minimo = this.getDato();
		} else {
			if (this.tieneHijos()) {
				hijos = this.getHijos();
				while (!hijos.fin()) {
					aux = ((RedDeAguaPotable) hijos.proximo()).minimoCaudal();
					minimo = (aux < minimo) ? aux : minimo;
				}
			}
		}

		return minimo;
	}
}
