package prog3.util;
import prog3.listaenteros.ListaDeEnteros;
import prog3.listaenteros.ListaDeEnterosEnlazada;

public class UtilitariosLista {

	public static void main(String[] args) {
		
		ListaDeEnterosEnlazada ejemplo = new ListaDeEnterosEnlazada(); // 6 8 4 2
		ListaDeEnterosEnlazada resultado = new ListaDeEnterosEnlazada(); // 2 4 6 8
		
		ejemplo.agregarFinal(6);
		ejemplo.agregarFinal(8);
		ejemplo.agregarFinal(4);
		ejemplo.agregarFinal(2);
		
		System.out.println("Inicial: ");
		imprimir(ejemplo);
		
		resultado = mergeSort(ejemplo);
		System.out.println("Resultado: ");
		imprimir(resultado);
		
	}
	
	static ListaDeEnterosEnlazada mergeSort (ListaDeEnterosEnlazada l) {
		ListaDeEnterosEnlazada result = new ListaDeEnterosEnlazada();
		
		for (int i = 0; i < l.tamanio(); i++) result.agregarFinal(l.elemento(i));
		
		result = recursive(result);
		return result;
	}
	
	static ListaDeEnterosEnlazada recursive (ListaDeEnterosEnlazada result) {
		result.tamanio();
		if (result.tamanio() > 1) {
			ListaDeEnterosEnlazada second = new ListaDeEnterosEnlazada();
			int limit = (result.tamanio() / 2) + (result.tamanio() % 2);

			for (int i = limit; i < result.tamanio(); i++) { // create second list
				second.agregarFinal(result.elemento(i));
			}
			for (int i = limit; i <= result.tamanio(); i++) { // clean result list
				result.eliminarEn(limit);
			}

			result = recursive(result);
			second = recursive(second);
			
			return result.combinarOrdenado(second);
		}
		
		return result;
	}
	
	public static void imprimir (ListaDeEnteros l) {
		while (!l.fin()) System.out.print(l.proximo() + " ");
		System.out.println("");
	}

}
