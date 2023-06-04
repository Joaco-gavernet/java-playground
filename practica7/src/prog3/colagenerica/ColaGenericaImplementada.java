package prog3.colagenerica;
import prog3.listagenerica.*;

public class ColaGenericaImplementada<T> extends ColaGenerica<T> {

	private ListaGenericaEnlazada<T> cola = new ListaGenericaEnlazada<T>();

	@Override
	public boolean encolar(T elem) {
		this.cola.agregarInicio(elem);
		return true;
	}

	@Override
	public T desencolar() {
		T result = this.tope();
		this.eliminarUltimo();
		return result;
	}
	
	private boolean eliminarUltimo() {
		int index = this.cola.tamanio() - 1;
		this.cola.eliminarEn(index);
		return true;
	}

	@Override
	public T tope() {
		int index = this.cola.tamanio() - 1;
		T result = this.cola.elemento(index);
		return result;
	}

	@Override
	public boolean esVacia() {
		if (this.cola.esVacia()) return true;
		return false;
	}

	@Override
	public String toString() {
		return "PilaGenericaImplementada [datos=" + cola + "]";
	}
	
}
