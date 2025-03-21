package Atividade2_Ex4;

public class ContadorComPrioridades {

	public static void main(String[] args) {
		System.out.println("Iniciando o programa principal...");
        
        // Criando os contadores
        Contador contadorPrioridadeAlta = new Contador("Contador Alta Prioridade", 10);
        Contador contadorPrioridadeBaixa = new Contador("Contador Baixa Prioridade", 10);
        
        // Criando as threads e definindo suas prioridades
        Thread threadAlta = new Thread(contadorPrioridadeAlta);
        Thread threadBaixa = new Thread(contadorPrioridadeBaixa);
        
        threadAlta.setPriority(Thread.MAX_PRIORITY);  // Prioridade alta (10)
        threadBaixa.setPriority(Thread.MIN_PRIORITY); // Prioridade baixa (1)
        
        System.out.println("Iniciando contadores...");
        
        // Iniciando as threads
        threadAlta.start();
        threadBaixa.start();
        
        try {
            // Aguarda a finalização das duas threads para continuar
            threadAlta.join();
            threadBaixa.join();
        } catch (InterruptedException e) {
            System.out.println("Thread principal interrompida.");
        }
        
        System.out.println("Programa principal finalizado.");
    }

}


