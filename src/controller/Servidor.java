package controller;

import java.util.concurrent.Semaphore;

public class Servidor extends Thread{
	private int id;
	private Semaphore semaforo;
	
	public Servidor(int id, Semaphore semaforo) {
		this.id = id;
		this.semaforo = semaforo;
	}

	@Override
	public void run() {
			calculo(id);
			try {
				semaforo.acquire();
					transacao(id);
					
			} catch (InterruptedException e) {
				e.printStackTrace();
				
			}finally {
				semaforo.release();
			}
	}
	
	private void transacao(int id) {
		int tempo;
		try {
			if(id % 3 == 1) {
				tempo = 1000;
				for (int i = 0; i < 2; i++) {
					sleep(tempo);
					System.out.println("# "+id+" fazendo Transação de BD ");
				}
			}else{
				tempo = 1500;
				for (int i = 0; i < 3; i++) {
					sleep(tempo);
					System.out.println("# "+id+" fazendo Transação de BD ");
				}
			}System.out.println("# "+id+" terminou a transação.");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	private void calculo(int id) {
		int tempo;
			try {
				if (id % 3 == 1) {
					tempo = (int)((Math.random()*801)+200);
					for (int i = 0; i < 2; i++) {
						sleep(tempo);
						System.out.println("# "+id+" fazendo cálculo ");
					}
				}else if(id % 3 == 2){
					tempo = (int)((Math.random()*1001)+500);
					for (int i = 0; i < 3; i++) {
						sleep(tempo);
						System.out.println("# "+id+" fazendo cálculo ");
					}			
				} else {
					tempo = (int)((Math.random()*1001)+1000);
					for (int i = 0; i < 3; i++) {
						sleep(tempo);
						System.out.println("# "+id+" terminou o cálculo.");
					}
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
	}
	
}
