package Atividade2_Ex5;

import java.util.Random;


public class CaldeiraSimulacao {
    private boolean ligada = false;
    private int temperatura = 0;
    private final Object lock = new Object();  // Objeto para sincronização entre as threads
    
    // Método para ligar a caldeira
    public void ligarCaldeira() {
        synchronized (lock) {
            if (!ligada) {
                ligada = true;
                System.out.println("Caldeira ligada.");
            } else {
                System.out.println("A caldeira já está ligada.");
            }
            temperatura += 60;
        }
    }
    
    // Método para alimentar a caldeira (aumentar a temperatura)
    public void alimentarCaldeira() {
        synchronized (lock) {
            if (ligada) {
                Random rand = new Random();
                int aumento = rand.nextInt(101) + 50; // Temperatura aumenta entre 50 e 150 graus
                temperatura += aumento;
                System.out.println("Temperatura aumentada para: " + temperatura + "°C");
                
                if (temperatura > 1600) {
                    System.out.println("Temperatura acima de 1600°C! Desligando a caldeira...");
                    desligarCaldeira();
                }
            } else {
                System.out.println("A caldeira está desligada. Não é possível alimentar.");
            }
        }
    }
    
    // Método para limpar a caldeira (somente quando desligada)
    public void limparCaldeira() {
        synchronized (lock) {
            if (!ligada) {
                System.out.println("Caldeira limpa.");
            } else {
                System.out.println("Não é possível limpar a caldeira enquanto estiver ligada.");
            }
        }
    }
    
    // Método para desligar a caldeira
    public void desligarCaldeira() {
        synchronized (lock) {
            if (ligada) {
                ligada = false;
                temperatura = 0; // Resetando a temperatura quando desligada
                System.out.println("Caldeira desligada.");
            } else {
                System.out.println("A caldeira já está desligada.");
            }
        }
    }

    // Método para obter a temperatura atual
    public int getTemperatura() {
        return temperatura;
    }
}
