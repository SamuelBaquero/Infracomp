package Caso1;

public class Mensaje {
	
	private int mensaje;

	public Mensaje(int i) {
		this.mensaje = i;
	}

	public int getMensaje() {
		return mensaje;
	}
	
	public synchronized void responder(int n){
		mensaje += n;
		notify();
	}
	
	public synchronized void recibido(){
		try {
			wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
