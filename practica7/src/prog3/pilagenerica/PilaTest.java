package prog3.pilagenerica;

public class PilaTest {

	public static void main(String[] args) {
		PilaGenericaImplementada<Character> pila = new PilaGenericaImplementada<Character>();
		
		
		pila.apilar('a');
		pila.apilar('b');
		pila.apilar('c');
		pila.apilar('d');
		pila.apilar('e');
		
		System.out.println(pila);
		
		pila.desapilar();
		pila.desapilar();
		pila.desapilar();
		pila.desapilar();
		
		System.out.println(pila.tope());
		
		
	}

}
