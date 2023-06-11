package Practica2B;

public class PruebaRetorno {
	public static void main(String[] args) {
		
		int[] example = {0, 1, 2, 3, 4};
		Database db = new Database();
		
		Database result = procesarArreglo(example, db);
		
		System.out.println(result);
	}
	
	static Database procesarArreglo (int[] arr, Database db) {
		int max = 0;
		int min = 2147483647;
		int total = 0;
		
		for (int i : arr) {
			if (i > max) max = i;
			if (i < min) min = i;
			total += i;
		}
		
		db.setX(max);
		db.setY(min);
		db.setZ(total / arr.length);
		
		return db;
	}

}
