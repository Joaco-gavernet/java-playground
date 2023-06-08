package prog3.arbolgeneral;

public class TrieTest {

	public static void main(String[] args) {

		Trie diccionario = new Trie(' ');
		diccionario.agregarPalabra("dedo");
		System.out.println(diccionario);
		
		diccionario.agregarPalabra("dejo");
		diccionario.agregarPalabra("tero");
		diccionario.agregarPalabra("tiro");
		System.out.println(diccionario);
	}

}
