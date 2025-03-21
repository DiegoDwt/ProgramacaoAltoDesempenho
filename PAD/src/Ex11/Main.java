package Ex11;

public class Main {

	public static void main(String[] args) {
		  System.out.println("Foi iniciada a construção do Carro.");

	        // Cria as threads para cada parte do carro
	        ParteCarro motor = new ParteCarro("Motor");
	        ParteCarro rodas = new ParteCarro("Rodas");
	        ParteCarro carroceria = new ParteCarro("Carroceria");
	        ParteCarro bancos = new ParteCarro("Bancos");
	        ParteCarro sistemaEletrico = new ParteCarro("Sistema Elétrico");

	        // Inicia as threads
	        motor.start();
	        rodas.start();
	        carroceria.start();
	        bancos.start();
	        sistemaEletrico.start();

	        // Aguarda todas as threads terminarem
	        try {
	            motor.join();
	            rodas.join();
	            carroceria.join();
	            bancos.join();
	            sistemaEletrico.join();
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }

	        // Informa que a construção do carro foi finalizada
	        System.out.println("A construção do carro foi finalizada.");
	    }

	}


