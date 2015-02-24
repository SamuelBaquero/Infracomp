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
			Mensaje aEnviar = crearMensaje(i);
			while(buff.enviarMensaje(aEnviar)) yield();
			while(aEnviar.recibido()){
				try {
					System.out.println("Me too.....");
					aEnviar.wait();
					System.out.println("Now im up!!!!.....");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println("Recibido : "+aEnviar.getMensaje());
		}	
	}

	public Mensaje crearMensaje(int i){
		return new Mensaje("YOLO " + i);
	}

}
