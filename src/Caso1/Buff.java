package Caso1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


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
		BufferedReader read;
		try {
			read = new BufferedReader(new FileReader("./Data/Input"));
			read.readLine();
			buff = new Buff(Integer.parseInt(read.readLine()));
			read.readLine();
			String r = read.readLine();
			while(!r.equals("Servidores")){
				String[] dat = r.split(" ");
				TCliente client = new TCliente(buff, Integer.parseInt(dat[0]), Integer.parseInt(dat[1]));
				client.start();
				r = read.readLine();
			}
			int s = Integer.parseInt(read.readLine());
			for (int i = 0; i < s; i++) {
				TServidor servidor = new TServidor(buff);
				servidor.start();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//		for(int i = 0; i < 10; i++){
		//			TCliente cliente = new TCliente(buff);
		//			TServidor servidor = new TServidor(buff);
		//			cliente.start();
		//			System.out.println("Cliente Started "+i);
		//			servidor.start();
		//			System.out.println("Servidor Started "+i);
		//		}
	}


	public Buff(int n){
		buff= new Mensaje[n];
		this.n = 0;
	}

	public synchronized boolean enviarMensaje(Mensaje msj){
		if(n<buff.length){
			//AQUI HAY UN ERROR.
			System.out.println("Ne:"+n);
			buff[n] = msj;
			n++;
			System.out.println("Envio de: " + msj.getMensaje());
			notifyAll();
			return true;
		}
		return false;
	}

	public synchronized Mensaje recibirMensaje(){
		while(n < 0){
			try {
				System.out.println("Im waiting.....");
				wait();
			}
			catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		synchronized(this){
			n--;
			Mensaje actual = buff[n];
			System.out.println("Nr: "+ n + actual.recibido());
			actual.recibir();
			return actual;
		}
	}
}
