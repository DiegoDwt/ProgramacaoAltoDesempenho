package Ex9;

public class GeradorNumeros implements Runnable {
    private final boolean gerarPares;
    private final int quantidade;
    private static final Object lock = new Object();
    private static boolean vezDaThreadPar = true;
    private static boolean threadParFinalizada = false;
    private static boolean threadImparFinalizada = false;

    public GeradorNumeros(boolean gerarPares, int quantidade) {
        this.gerarPares = gerarPares;
        this.quantidade = quantidade;
    }

    @Override
    public void run() {
        int contador = 0;
        while (contador < quantidade) {
            synchronized (lock) {
                // Verifica se é a vez da thread atual
                while ((gerarPares && !vezDaThreadPar) || (!gerarPares && vezDaThreadPar)) {
                    // Se a outra thread já terminou, sai do loop
                    if ((gerarPares && threadImparFinalizada) || (!gerarPares && threadParFinalizada)) {
                        break;
                    }
                    try {
                        lock.wait(); // Espera a sua vez
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        System.out.println("Thread interrompida.");
                        return;
                    }
                }

                // Se a thread já gerou todos os números, sai do loop
                if (contador >= quantidade) {
                    break;
                }

                // Gera o número par ou ímpar
                if (gerarPares) {
                    System.out.println("Thread Par: " + (contador * 2));
                } else {
                    System.out.println("Thread Ímpar: " + (contador * 2 + 1));
                }

                contador++; // Incrementa o contador de números gerados
                vezDaThreadPar = !vezDaThreadPar; // Passa a vez para a outra thread
                lock.notifyAll(); // Notifica a outra thread
            }
        }

        // Marca a thread como finalizada
        synchronized (lock) {
            if (gerarPares) {
                threadParFinalizada = true;
            } else {
                threadImparFinalizada = true;
            }
            lock.notifyAll(); // Notifica a outra thread para evitar deadlock
        }
    }
}


