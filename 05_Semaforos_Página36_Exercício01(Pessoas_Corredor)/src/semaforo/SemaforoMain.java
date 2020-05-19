/**
 * 4 pessoas caminham, cada uma em um corredor diferente. Os 4 corredores terminam em uma única porta. Apenas 1 pessoa pode
cruzar a porta, por vez. Considere que cada corredor tem 200m. e cada pessoa anda de 4 a 6 m/s. Cada pessoa leva de 1 a 2 segundos
para abrir e cruzar a porta. Faça uma aplicação em java que simule essa situação.
*/

package semaforo;

import java.util.concurrent.Semaphore;

import controller.ControllerThread;


public class SemaforoMain {
	public static Semaphore semaforo;
	
	public static void main(String[] args) {
		
		int totalPessoas = 4, atravessando = 1;
		semaforo = new Semaphore(atravessando);
		for(int i = 0; i<totalPessoas;i++) {
			Thread atravessar = new ControllerThread(i+1, semaforo);
			atravessar.start();
		}
	}
}
