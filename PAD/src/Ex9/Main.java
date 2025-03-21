package Ex9;

import java.util.Random;

public class Main {

	public static void main(String[] args) {
		 Random random = new Random();
	     int quantidadePares = random.nextInt(10) + 1; // Quantidade aleatória de números pares (1 a 10)
	     int quantidadeImpares = random.nextInt(10) + 1; // Quantidade aleatória de números ímpares (1 a 10)

	     System.out.println("Quantidade de números pares a gerar: " + quantidadePares);
	     System.out.println("Quantidade de números ímpares a gerar: " + quantidadeImpares);

	     Thread threadPar = new Thread(new GeradorNumeros(true, quantidadePares));
	     Thread threadImpar = new Thread(new GeradorNumeros(false, quantidadeImpares));

	     threadPar.start();
	     threadImpar.start();

	     // Aguarda as threads terminarem
	     try {
	         threadPar.join();
	         threadImpar.join();
	     } catch (InterruptedException e) {
	         System.out.println("Thread principal interrompida.");
	     }

	     System.out.println("Programa encerrado.");

	}

}


