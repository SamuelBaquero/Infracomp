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
	
	public boolean responder(){
		return recibido;
	}

	public void recibir() {
		mensaje = mensaje;
		recibido = true;
	}
	
	public boolean recibido(){
		return recibido;
	}
}
