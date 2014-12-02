package david;

import java.util.Random;

public class Cuenta {
	
	private int saldo;
	volatile private boolean canOperation;
	private Random random;
	
	public Cuenta(){
		saldo = 40;
		canOperation = true;
		random = new Random();
	}
	
	public void operacion() throws InterruptedException{
		while(!canOperation()){
			Thread.sleep(10);
		}
		int cantidad;
		cantidad = random.nextInt(5) + 5;
		if(haveSaldo(cantidad)){
			System.out.println("SE VA A RETIRAR SALDO (ACTUAL ES: "+getSaldo()+")");
			lessSaldo(cantidad);
			System.out.println(Thread.currentThread().getName()+" retira => "+cantidad+" ACTUAL "+getSaldo());
		}else{
			System.out.println(Thread.currentThread().getName()+" intenta retirar "+cantidad+" No puede retirar dinero, no hay saldo ("+getSaldo()+")");
		}
	}
	
	synchronized private boolean canOperation(){
		canOperation = (!canOperation)? true : false;
		return canOperation;
	}
	
	private int getSaldo(){
		return saldo;
	}
	
	private void lessSaldo(int resta){
		saldo -= resta;
	}
	
	private boolean haveSaldo(int cantidad){
		return (saldo >= cantidad)? true : false;
	}

}
