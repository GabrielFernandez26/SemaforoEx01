package view;

import java.util.concurrent.Semaphore;

import controller.Servidor;

public class Main {

	public static void main(String[] args) {
		int permissoes = 1;
		Semaphore semaforo = new Semaphore(permissoes);
		for (int id = 0; id <= 21; id++) {
			Thread t = new Servidor(id, semaforo);
			t.start();
		}
	}

}
