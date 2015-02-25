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
		// EL FOR ES SOLO PARA QUE MANDE MAS DE UN MENSAJE ND MAS
		System.out.println("ClienteIniciado: "+ id + "/" +cMensajes);
		for(int i = 0; i < cMensajes; i++){
			Mensaje aEnviar = new Mensaje(id+i);
			synchronized(this){while(buff.enviarMensaje(aEnviar)) yield();}
			synchronized(this){
			while(aEnviar.recibido()){
				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println("Terminado : "+aEnviar.getMensaje());
			}
		}	
	}
}
