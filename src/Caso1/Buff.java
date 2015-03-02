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
	}

	public Buff(int n){
		buff= new Mensaje[n];
		this.n = 0;
	}

	public synchronized boolean enviarMensaje(Mensaje msj){
		if(n<buff.length){
			buff[n] = msj;
			n++;
			notifyAll();
			return true;
		}
		return false;
	}

	public synchronized Mensaje recibirMensaje(){
		while(n <= 0){
			try {
				wait();
			}
			catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			n--;
			Mensaje actual = buff[n];
			return actual;
	}
}
