package controller;

import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadLocalRandom;

public class ControllerThread extends Thread{
	private int pessoaCorredor;
	private int velocidade;
	private Semaphore semaforo;
	private int corredor = 200;
	
	public ControllerThread(int pessoaCorredor, Semaphore semaforo) {
		this.pessoaCorredor = pessoaCorredor;
		this.semaforo = semaforo;
	}
	
	public void run() {
		pessoaAndando();
		try {
			semaforo.acquire();
		}
		catch(InterruptedException e) {
			e.printStackTrace();
		}
		finally{
			semaforo.release();
		}
	}
	
	public void pessoaAndando() {
		int percorrido = 0;
		int tempo = 100;
		int crono = 0;
		while(percorrido<corredor) {
			velocidade = ThreadLocalRandom.current().nextInt(4, 7);
			percorrido += velocidade;
			crono += tempo;
			try {
				sleep(tempo);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("A pessoa no corredor " +pessoaCorredor+" andou " + percorrido+ " metros em "+crono/100+" segundos.");
		}
		cruzaPorta();
	}
	
	public void cruzaPorta() {
		System.out.println("A pessoa "+pessoaCorredor+" cruzou a porta");
		atravessa();
	}
		
	public void atravessa() {
		int tempo = ThreadLocalRandom.current().nextInt(1, 3)*1000;
		try {
			Thread.sleep(tempo);
		}
		catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
}
