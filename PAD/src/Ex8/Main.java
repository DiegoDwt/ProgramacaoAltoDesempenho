package Ex8;

public class Main {

	public static void main(String[] args) {
		  int X = 5; // Quantidade de placas a serem geradas
	        Thread thread = new Thread(new GeradorPlacasMercosul(X));
	        thread.start();

	}

}
