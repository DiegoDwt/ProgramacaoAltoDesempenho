package Exercicio;

public class Main {

	public static void main(String[] args) {
		 int X = 5; // Quantidade de números
	     int A = 10; // Valor mínimo
	     int B = 20; // Valor máximo

	     Thread thread = new Thread(new GeradorNumerosAleatorios(X, A, B));
	     thread.start();
	}
}
