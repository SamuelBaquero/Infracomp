package Caso1;

public class Mensaje {

	private boolean recibido;
	
	private int mensaje;

	public Mensaje(int i) {
		this.mensaje = i;
		recibido = false;
	}

	public int getMensaje() {
		return mensaje;
	}
	
	public synchronized void responder(){
		System.out.println("time to wake up");
		notify();
	}

	public void recibir() {
		mensaje = mensaje + 5;
		recibido = true;
	}
	
	public synchronized void recibido(){
		try {
			System.out.println("me voy a dormir zzzz");
			wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
