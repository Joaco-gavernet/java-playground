package prog3.pilagenerica;
import prog3.listagenerica.*;

public class PilaGenericaImplementada<T> extends PilaGenerica<T> {

	private ListaGenericaEnlazada<T> datos = new ListaGenericaEnlazada<T>();
	
	@Override
	public boolean apilar(T elem) {
		this.datos.agregarFinal(elem);
		return true;
	}

	@Override
	public T desapilar() {
		T result = this.tope();
		this.eliminarUltimo();
		return result;
	}
	
	private boolean eliminarUltimo() {
		int index = this.datos.tamanio() - 1;
		this.datos.eliminarEn(index);
		return true;
	}

	@Override
	public T tope() {
		int index = this.datos.tamanio() - 1;
		T result = this.datos.elemento(index);
		return result;
	}

	@Override
	public boolean esVacia() {
		if (this.datos.esVacia()) return true;
		return false;
	}

	@Override
	public String toString() {
		return "PilaGenericaImplementada [datos=" + datos + "]";
	}
	
}
