package Atividade2_Ex4;

class Contador implements Runnable {
    private String nome;
    private int limite;
    
    public Contador(String nome, int limite) {
        this.nome = nome;
        this.limite = limite;
    }
    
    @Override
    public void run() {
        System.out.println(nome + " iniciado com prioridade: " + Thread.currentThread().getPriority());
        
        for (int i = 1; i <= limite; i++) {
            System.out.println(nome + ": " + i);
            
            try {
                // Comportamento normal de pausa entre contagens
                Thread.sleep(1000);
                
                // Comportamento aleatório para gerar pausa em um dos contadores
                if (Math.random() < 0.3) { // 30% de chance de entrar em pausa
                    System.out.println(nome + " entrando em pausa aleatória...");
                    Thread.sleep(1000); // Pausa adicional de 1 segundos
                    System.out.println(nome + " retomando contagem após pausa.");
                }
                
            } catch (InterruptedException e) {
                System.out.println(nome + " foi interrompido.");
                return;
            }
        }
        
        System.out.println(nome + " finalizado.");
    }
}


