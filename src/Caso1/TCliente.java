package Caso1;

public class TCliente extends Thread {

	private Mensaje mensaje;
	private int id;
	private int cMensajes;
	private Buff buff;

	public TCliente(Buff buff2, int nid, int nMensajes) {
		this.buff = buff2;
		this.id = nid;
		this.cMensajes = nMensajes;
	}

	public void run(){
		for(int i = 0; i < cMensajes; i++){
			mensaje = new Mensaje(id + i);
			while(!buff.enviarMensaje(mensaje)) yield();
			mensaje.recibido();
			System.out.println("Terminado : "+ mensaje.getMensaje());
		}
	}
}