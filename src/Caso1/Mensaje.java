package Caso1;

public class Mensaje {
	
	private int mensaje;

	public Mensaje(int i) {
		this.mensaje = i;
	}

	public int getMensaje() {
		return mensaje;
	}
	
	public synchronized void responder(){
//		System.out.println("time to wake up");
//		System.out.println("el mensaje antes de responder es: " + mensaje);
		mensaje += 5;
//		System.out.println("el mensaje respondido es: " +  mensaje);
		notify();
	}
	
	public synchronized void recibido(){
		try {
//			System.out.println("me voy a dormir zzzz");
			wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
