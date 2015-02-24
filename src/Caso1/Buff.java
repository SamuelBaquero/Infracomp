package Caso1;


public class Buff {
	/**
	 * Mensajes
	 */
	private Mensaje buff[];
	/**
	 * Cantidad de Mensajes Actuales.
	 */
	private int n;
	
	public static void main(String[] arg){
		Buff buff = new Buff(20);
		for(int i = 0; i < 10; i++){
			TCliente cliente = new TCliente(buff);
			TServidor servidor = new TServidor(buff);
			cliente.start();
			System.out.println("Cliente Started "+i);
			servidor.start();
			System.out.println("Servidor Started "+i);
		}
	}
	
	public Buff(int n){
		buff= new Mensaje[n];
		this.n = 0;
	}
	
	public synchronized boolean enviarMensaje(Mensaje msj){
		if(n==buff.length){
			return false;
		}
		//AQUI HAY UN ERROR.
		System.out.println("Ne:"+n);
		buff[n] = msj;
		n++;
		System.out.println("Envio de: " + msj.getMensaje());
		notifyAll();
		return true;
	}
	
	public synchronized Mensaje recibirMensaje(){
		while(n < 0){
			try {
				System.out.println("Im waiting.....");
				wait();
				System.out.println("I woke up.....");
			}
			catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		Mensaje actual = buff[n];
		n--;
		System.out.println("Nr: "+ n + actual.recibido());
		actual.recibir();
		return actual;
	}
}
