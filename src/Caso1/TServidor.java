package Caso1;

public class TServidor extends Thread{
	
	private Mensaje mensaje;
	private Buff buff;
	
	public TServidor(Buff buff){
		this.buff = buff;
	}
	
	public void run(){
		Mensaje actual = buff.recibirMensaje();
		//no se que hacer aca XD 
		actual.notify();
	}

}
