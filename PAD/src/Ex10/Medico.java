package Ex10;

import java.util.Random;

public class Medico extends Thread {
    private String nome;

    public Medico(String nome) {
        this.nome = nome;
    }

    @Override
    public void run() {
        while (true) {
            String paciente = ProntoSocorro.proximoPaciente();
            if (paciente == null) {
                break; // Se não houver mais pacientes, encerra o atendimento
            }
            System.out.println(nome + " está atendendo o " + paciente);

            // Gera um tempo de atendimento entre 5 e 30 minutos (apenas para exibição)
            int tempoAtendimentoMinutos = new Random().nextInt(26) + 5; // Entre 5 e 30 minutos

            // Simula o tempo de atendimento (sem pausar a execução)
            System.out.println(nome + " terminou de atender o " + paciente + " em " + tempoAtendimentoMinutos + " minutos");
        }
    }
}



