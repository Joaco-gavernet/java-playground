package prog3.arbolgeneral;

public class RedDeAguaPotableTest {
	
	public static void main (String[] args) {
		
		////////////// ARBOL DE EJEMPLO ///////////
		/// NIVEL 2 /////
		RedDeAguaPotable red2a = new RedDeAguaPotable(83);
		RedDeAguaPotable red2b = new RedDeAguaPotable(83);
		RedDeAguaPotable red2c = new RedDeAguaPotable(83);
		
		/// NIVEL 1 /////
		RedDeAguaPotable red1a = new RedDeAguaPotable(250);
		RedDeAguaPotable red1b = new RedDeAguaPotable(250);
		red1b.agregarHijo(red2a);
		red1b.agregarHijo(red2b);
		red1b.agregarHijo(red2c);
		RedDeAguaPotable red1c = new RedDeAguaPotable(250);
		RedDeAguaPotable red1d = new RedDeAguaPotable(250);
		
		RedDeAguaPotable apsa = new RedDeAguaPotable(1000);
		apsa.agregarHijo(red1a);
		apsa.agregarHijo(red1b);
		apsa.agregarHijo(red1c);
		apsa.agregarHijo(red1d);
		///////////////////////////////////////////
		
		System.out.println("minimo caudal en hojas: " + apsa.minimoCaudal());
		
	}
}
