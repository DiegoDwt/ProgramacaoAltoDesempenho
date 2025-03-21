package Exercicio;

import java.util.Random;

public class GeradorNumerosAleatorios implements Runnable {
    private int quantidade;
    private int minimo;
    private int maximo;


	public GeradorNumerosAleatorios(int quantidade, int minimo, int maximo) {
	   this.quantidade = quantidade;
	   this.minimo = minimo;
	   this.maximo = maximo;
	}


	@Override
	public void run() {
	    Random random = new Random();
	    for (int i = 0; i < quantidade; i++) {
	       int numero = random.nextInt(maximo - minimo + 1) + minimo;
	       System.out.println(Thread.currentThread().getName() + " gerou: " + numero);
	    }
	}       
}
    

