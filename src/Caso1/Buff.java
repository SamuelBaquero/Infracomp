package Caso1;

import java.util.ArrayList;

public class Buff {
	private ArrayList<Mensaje> buff;
	private int n;
	private boolean hayMensajes;
	
	public static void main(String[] arg){
		Buff buff = new Buff(20);
		for(int i = 0; i < 10; i++){
			TCliente cliente = new TCliente(buff);
			TServidor servidor = new TServidor(buff);
			cliente.start();
			servidor.start();
		}
	}
	
	public Buff(int n){
		buff= new ArrayList<>();
		this.n = n;
		hayMensajes = false;
	}
	
	public synchronized boolean enviarMensaje(Mensaje msj){
		while(buff.size() == n){
			return false;
		}
		hayMensajes = true;
		buff.add(msj);
		n++;
		notifyAll();
		try {
			//aqui donde esta dormido? 
			int x = buff.size();
			buff.get(x).wait();
		} 
		catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}
	
	public synchronized Mensaje recibirMensaje(){
		while(!hayMensajes){
			try {
				wait();
			} 
			catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		Mensaje actual = buff.get(0);	
		buff.remove(0);
		n--;
		return actual;
	}
}
