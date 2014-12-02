package david;

public class ExamenEjercicio2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Cuenta cuenta = new Cuenta();
		
		Persona ana = new Persona(cuenta);
		Persona juan = new Persona(cuenta);
		
		Thread t1, t2;
		
		t1 = new Thread(ana, "ana");
		t2 = new Thread(juan, "juan");
		
		t1.start();
		t2.start();

	}

}
