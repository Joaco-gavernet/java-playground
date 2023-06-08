package prog3.colagenerica;

public abstract class ColaGenerica<T> {
	
	public abstract boolean encolar(T elem);
	public abstract T desencolar();
	public abstract T tope();
	public abstract boolean esVacia();
	
}
