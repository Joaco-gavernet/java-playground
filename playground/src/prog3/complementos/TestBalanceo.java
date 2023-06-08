package prog3.complementos;
import prog3.pilagenerica.*;

public class TestBalanceo {

	public static void main(String[] args) {
		String word = new String();
		word = "{()[eeeeeee(]}";
		System.out.println("result: " + balanceado(word));
		
		word = "{()[eeeeeee()]}";
		System.out.println("result: " + balanceado(word));

	}
	
	static boolean balanceado(String input) {
		
		PilaGenericaImplementada<Character> pila = new PilaGenericaImplementada<Character>();
		int i = 0;
		
		while (i < input.length()) {
			Character instance = input.charAt(i);
			
			if ((instance == '[') || (instance == '{') || (instance == '(')) {
				pila.apilar(instance);
			} else if ((instance == ']') || (instance == '}') || (instance == ')')) {
				if (pila.esVacia()) return false;
				if ((instance == ']') && (pila.tope() != '[')) return false;
				if ((instance == '}') && (pila.tope() != '{')) return false;
				if ((instance == ')') && (pila.tope() != '(')) return false;
				pila.desapilar();
			}
			i++;
		}
		
		return true;
	}

}
