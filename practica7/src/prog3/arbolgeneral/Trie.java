package prog3.arbolgeneral;

import prog3.listagenerica.ListaGenerica;

public class Trie extends ArbolGeneral<Character>{

	public Trie(Character dato) {
		super(dato);
	}
	
	public Trie(Character dato, ListaGenerica<ArbolGeneral<Character>> hijos) {
		super(dato, hijos);
	}
	
	public void agregarPalabra(String palabra) {
		
		if (this.tieneHijos()) {
			ListaGenerica<ArbolGeneral<Character>> hijos = this.getHijos();
			boolean esta = false;
			int i = 0;
			int result = Integer.MAX_VALUE;
			Trie comparar = null;
			
			hijos.comenzar();
			while ((!hijos.fin()) && (!esta) && (result != 0)) {
				comparar = (Trie) hijos.proximo();
				result = Character.compare(comparar.getDato(), palabra.charAt(0));
				
				if (result < 0) i++;
				else if (result == 0) esta = true;
			}
			
			if (esta) {
				comparar.agregarPalabra(palabra.substring(1));
			} else {
				Trie nuevo = new Trie(palabra.charAt(0));
				nuevo.agregarPalabra(palabra.substring(1));
				hijos.agregarEn(nuevo, i);
			}
			
			
		} else if (palabra.length() > 0) {
			Trie nuevo = new Trie(palabra.charAt(0));
			nuevo.agregarPalabra(palabra.substring(1));
			this.agregarHijo(nuevo);
		}
	}

	@Override
	public String toString() {
		return super.getDato() + " " + super.getHijos() + " ";
	}
	
}
