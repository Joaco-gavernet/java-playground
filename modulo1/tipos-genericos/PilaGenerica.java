package prog3.pilagenerica;

public abstract class PilaGenerica<T> {

	public abstract boolean apilar(T elem);

	public abstract T desapilar();

	public abstract T tope();

	public abstract boolean esVacia();

}
