package Caso1;

public class TCliente extends Thread {
	
	private Mensaje mensaje;
	private Buff buff;
	
	public TCliente(Buff buff) {
		this.buff = buff;
		// TODO Auto-generated constructor stub
	}
	
	public void run(){
		// EL FOR ES SOLO PARA QUE MANDE MAS DE UN MENSAJE ND MAS
		for(int i = 0; i < 10; i++){
			while(!buff.enviarMensaje(crearMensaje())) yield();
		}		
	}
	
	public Mensaje crearMensaje(){
		return new Mensaje("YOLO");
	}

}
