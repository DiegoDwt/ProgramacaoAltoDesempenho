package Atividade2_Ex5;

public class Main {

    public static void main(String[] args) {

        CaldeiraSimulacao caldeira = new CaldeiraSimulacao();

        // Thread para ligar a caldeira (baixa prioridade)
        Thread ligarThread = new Thread(() -> {
            Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
            caldeira.ligarCaldeira();
        });

        // Thread para alimentar a caldeira (baixa prioridade)
        Thread alimentarThread = new Thread(() -> {
            Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
            // Imprimir a temperatura atual antes de alimentar
            System.out.println("Temperatura atual antes de alimentar: " + caldeira.getTemperatura() + "°C");
            caldeira.alimentarCaldeira();
        });

        // Thread para limpar a caldeira (baixa prioridade, somente com caldeira desligada)
        Thread limparThread = new Thread(() -> {
            Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
            // Limpar a caldeira somente quando estiver desligada
            caldeira.limparCaldeira();
        });

        // Thread para desligar a caldeira (alta prioridade)
        Thread desligarThread = new Thread(() -> {
            Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
            caldeira.desligarCaldeira();
        });

        // Executando as threads
        ligarThread.start();
        try {
            ligarThread.join(); // Espera a thread de ligar terminar
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Agora, podemos alimentar a caldeira
        alimentarThread.start();
        try {
            alimentarThread.join(); // Espera a thread de alimentar terminar
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Desligando a caldeira
        desligarThread.start();
        try {
            desligarThread.join(); // Espera a thread de desligar terminar
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        // Executando a thread para limpar a caldeira antes de alimentar (somente se a caldeira estiver desligada)
        limparThread.start();
        try {
            limparThread.join(); // Espera a thread de limpar terminar
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
