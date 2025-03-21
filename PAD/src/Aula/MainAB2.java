package Aula;

public class MainAB2 {

	public static void main(String[] args) {
		AltaPrioridade2 a = new AltaPrioridade2();
		BaixaPrioridade2 b = new BaixaPrioridade2();
		System.out.println("Iniciando threads...");
		b.start();
		a.start();
		Thread.currentThread();
		Thread.yield();
		System.out.println("Main Finalizado");
	}

}
