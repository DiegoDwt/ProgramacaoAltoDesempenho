package Aula;

public class AltaPrioridade2 extends Thread {
	public void run() {
		setPriority(10);
		for(int y = 0; y < 10; y++)
			System.out.println("Alta Prioridade...");
		try {
			sleep(100);
		} catch (InterruptedException e) {
			System.exit(0);
		}
	}

}
