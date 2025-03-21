package Aula;

public class BaixaPrioridade2 extends Thread {
	public void run() {
		setPriority(1);
		for(int x = 0; x < 10; x++) {
			System.out.println("Baixa Prioridade...");
			try {
				sleep(100);
			} catch (InterruptedException e) {
				System.exit(0);
			}
		}

	}
	
}