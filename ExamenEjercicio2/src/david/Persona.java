package david;

public class Persona implements Runnable{
	
	Cuenta cuenta;
	
	public Persona(Cuenta cuenta){
		this.cuenta = cuenta;
	}
	
	public void run(){
		for (int i = 0; i < 5; i++) {
			try {
				cuenta.operacion();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
