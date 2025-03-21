package Ex8;

import java.util.Random;

public class GeradorPlacasMercosul implements Runnable {
    private int quantidade;

    public GeradorPlacasMercosul(int quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public void run() {
        Random random = new Random();
        String letrasValidas = "ABCDEFGHJKLMNPRSTUVWXYZ"; // Letras permitidas (exceto I, O, Q)
        for (int i = 0; i < quantidade; i++) {
            StringBuilder placa = new StringBuilder();

            // Gera as três letras iniciais (AAA)
            for (int j = 0; j < 3; j++) {
                placa.append(letrasValidas.charAt(random.nextInt(letrasValidas.length())));
            }

            // Gera o primeiro dígito (1)
            placa.append(random.nextInt(10)); // Dígito entre 0 e 9

            // Gera a letra seguinte (A)
            placa.append(letrasValidas.charAt(random.nextInt(letrasValidas.length())));

            // Gera os dois últimos dígitos (11)
            placa.append(random.nextInt(10)); // Segundo dígito
            placa.append(random.nextInt(10)); // Terceiro dígito

            System.out.println("Placa gerada: " + placa.toString());
        }
    }
    
}