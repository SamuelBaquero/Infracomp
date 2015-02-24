package Caso1;

public class Mensaje {

	private boolean recibido;
	
	private String mensaje;

	public Mensaje(String mensaje) {
		this.mensaje = mensaje;
		recibido = false;
	}

	public String getMensaje() {
		return mensaje;
	}
	
	public boolean responder(){
		return recibido;
	}

	public void recibir() {
		recibido = !recibido;
	}
	
	public boolean recibido(){
		return recibido;
	}
}
