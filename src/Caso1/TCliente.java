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
//		System.out.println("ClienteIniciado: "+ id + "/" +cMensajes);

	}

	public void run(){
		// EL FOR ES SOLO PARA QUE MANDE MAS DE UN MENSAJE ND MAS
		for(int i = 0; i < cMensajes; i++){
			mensaje = new Mensaje(id + i);
			System.out.println("se envio el mensaje numero  " + mensaje.getMensaje());
			while(buff.enviarMensaje(mensaje)) yield();
			mensaje.recibido();
			System.out.println("Terminado : "+ mensaje.getMensaje());
		}	
	}
}