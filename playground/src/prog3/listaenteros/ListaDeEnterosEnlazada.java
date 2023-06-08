package prog3.listaenteros;

/**
 * La clase ListaDeEnterosEnlazada es una ListaDeEnteros, donde los elementos de
 * la lista (nodos) referencian al siguiente elemento (nodo), por este motivo,
 * la ListaDeEnterosEnlazada no tiene límite en la cantidad de elementos que se
 * pueden almacenar.
 * */
public class ListaDeEnterosEnlazada extends ListaDeEnteros {
	/* primer nodo de la lista, si la lista esta vacia, inicio es null */
	private NodoEntero inicio;

	/*
	 * nodo actual que se va actualizando a medida que recorremos la lista, si
	 * la lista esta vacia, actual es null
	 */
	private NodoEntero actual;

	/* ultimo nodo de la lista, si la lista esta vacia, fin es null */
	private NodoEntero fin;

	/* cantidad de nodos en la lista */
	private int tamanio;

	@Override
	public void comenzar() {
		actual = inicio;
	}

	@Override
	public Integer proximo() {
		Integer elem = this.actual.getDato();
		this.actual = this.actual.getSiguiente();
		return elem;
	}

	@Override
	public boolean fin() {
		return (this.actual == null);
	}

	@Override
	public Integer elemento(int pos) {
		if (pos < 0 || pos > this.tamanio() - 1) // no es posicion valida
			return null;
		NodoEntero n = this.inicio;
		while (pos-- > 0)
			n = n.getSiguiente();
		return n.getDato();
	}

	@Override
	public boolean agregarEn(Integer elem, int pos) {
		if (pos < 0 || pos > this.tamanio()) // posicion no valida
			return false;
		this.tamanio++;
		NodoEntero aux = new NodoEntero();
		aux.setDato(elem);
		if (pos == 0) { // inserta al principio
			aux.setSiguiente(inicio);
			this.inicio = aux;
		} else {
			NodoEntero n = this.inicio;
			NodoEntero ant = null;
			int posActual = 0;
			while (!(n == null) && (posActual < pos)) {
				ant = n;
				n = n.getSiguiente();
				posActual++;
			}
			aux.setSiguiente(n);
			ant.setSiguiente(aux);

			if (aux.getSiguiente() == null)
				this.fin = aux;
		}
		return true;
	}

	@Override
	public boolean agregarInicio(Integer elem) {
		NodoEntero aux = new NodoEntero();
		aux.setDato(elem);

		if (this.inicio == null) {
			this.inicio = aux;
			this.actual = aux;
			this.fin = aux;
		} else {
			aux.setSiguiente(this.inicio);
			this.inicio = aux;
		}
		this.tamanio++;
		return true;
	}

	@Override
	public boolean agregarFinal(Integer elem) {
		NodoEntero aux = new NodoEntero();
		aux.setDato(elem);
		if (this.inicio == null) {
			this.inicio = aux;
			this.actual = aux;
			this.fin = aux;
		} else {
			fin.setSiguiente(aux);
			fin = aux;
		}
		tamanio++;
		return true;
	}

	@Override
	public boolean eliminar(Integer elem) {
		NodoEntero n = this.inicio;
		NodoEntero ant = null;
		while ((n != null) && (!n.getDato().equals(elem))) {
			ant = n;
			n = n.getSiguiente();
		}
		if (n == null)
			return false;
		else {
			if (ant == null)
				this.inicio = this.inicio.getSiguiente();
			else
				ant.setSiguiente(n.getSiguiente());
			this.tamanio--;

			return true;
		}
	}

	@Override
	public boolean eliminarEn(int pos) {
		if (pos < 0 || pos > this.tamanio() - 1) // posicion no valida
			return false;
		this.tamanio--;
		if (pos == 0) {
			this.inicio = this.inicio.getSiguiente();
			return true;
		}
		NodoEntero n = this.inicio;
		NodoEntero ant = null;
		while (!(n == null) && (pos > 0)) {
			pos--;
			ant = n;
			n = n.getSiguiente();
		}
		ant.setSiguiente(n.getSiguiente());
		if (ant.getSiguiente() == null)
			this.fin = ant;
		return true;
	}

	@Override
	public boolean incluye(Integer elem) {
		NodoEntero n = this.inicio;
		while (!(n == null) && !(n.getDato().equals(elem)))
			n = n.getSiguiente();
		return !(n == null);
	}

	@Override
	public String toString() {
		String str = "";
		NodoEntero n = this.inicio;
		while (n != null) {
			str = str + n.getDato() + " -> ";
			n = n.getSiguiente();
		}
		if (str.length() > 1)
			str = str.substring(0, str.length() - 4);
		return str;
	}

	@Override
	public int tamanio() {
		return this.tamanio;
	}

	@Override
	public boolean esVacia() {
		return this.tamanio() == 0;
	}
	
	public ListaDeEnterosEnlazada ordenar() {
		ListaDeEnterosEnlazada result = new ListaDeEnterosEnlazada();
		this.comenzar();
		result.comenzar();
		int size = this.tamanio();
		int[] arr = new int[size];
		
		for (int j = 0; j < size; j++) arr[j] = 0;
		
		while ((result.esVacia()) || (result.tamanio() < size)) {
			int men = Integer.MAX_VALUE;
			int menId = 0;
			int i = 0;
			
			while (i < size) {
				if ((this.elemento(i) < men) && (arr[i] == 0)) 
				{
					men = this.elemento(i);
					menId = i;
				}
				i++;
			}
			
			result.agregarFinal(men);
			arr[menId] = 1;
		}
		
		return result;
	}
	
	public ListaDeEnterosEnlazada combinarOrdenado (ListaDeEnterosEnlazada listaParam) {
		ListaDeEnterosEnlazada listaResult = new ListaDeEnterosEnlazada();	
		
		this.comenzar();
		listaParam.comenzar(); // 4 5 6
		listaResult.comenzar(); // 1 3 7 8
		
		int a = listaParam.proximo();
		int b = this.proximo();
		
		while (!this.fin() && !listaParam.fin()) {
			if (a < b) {
				listaResult.agregarFinal(a);
				a = listaParam.proximo();
			} else {
				listaResult.agregarFinal(b);
				b = this.proximo();
			}
		}
		
		while (!this.fin()) {
			listaResult.agregarFinal(a);				
			a = this.proximo();
		}
		
		while (!listaParam.fin()) {
			listaResult.agregarFinal(b);				
			b = listaParam.proximo();
		}
		
		if (a < b) { // checks the last case of both lists (necessary because the .proximo() implementation
			listaResult.agregarFinal(a);
			listaResult.agregarFinal(b);
		} else {
			listaResult.agregarFinal(b);
			listaResult.agregarFinal(a);			
		}
		
		System.out.println("result: " + listaResult.toString());
		return listaResult;
	}
}
