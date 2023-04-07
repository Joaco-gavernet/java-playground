package Practica2B;

public class PruebaRetorno2 {
	public static void main(String[] args) {
		int[] example = {0, 1, 2, 3, 4};
		String result = procesarArreglo(example);
		

		System.out.println(result);
	}
	
	static String procesarArreglo (int[] arr) {
		int max = 0;
		int min = 2147483647;
		int total = 0;
		
		for (int i : arr) {
			if (i > max) max = i;
			if (i < min) min = i;
			total += i;
		}
		
		return "Maximo: " + max + "\n Minimo: " + min + "\n Avarege: " + total / arr.length;
	}

}
