package prog3.pilagenerica;
import prog3.listagenerica.*;

public class PilaGenericaImplementada extends PilaGenerica<Character> {

	private ListaGenericaEnlazada<Character> datos = new ListaGenericaEnlazada<Character>();
	
	@Override
	public boolean apilar(Character elem) {
		this.datos.agregarFinal(elem);
		return true;
	}

	@Override
	public Character desapilar() {
		Character result = this.tope();
		this.eliminarUltimo();
		return result;
	}
	
	private boolean eliminarUltimo() {
		int index = this.datos.tamanio() - 1;
		this.datos.eliminarEn(index);
		return true;
	}

	@Override
	public Character tope() {
		int index = this.datos.tamanio() - 1;
		Character result = this.datos.elemento(index);
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
