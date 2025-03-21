package Ex10;

public class Main {

	public static void main(String[] args) {
		  // Adiciona pacientes à fila
        for (int i = 1; i <= 10; i++) {
            ProntoSocorro.adicionarPaciente("Paciente " + i);
        }

        // Cria os médicos
        Medico medico1 = new Medico("Dr. Silva");
        Medico medico2 = new Medico("Dra. Costa");

        // Inicia o atendimento
        medico1.start();
        medico2.start();

        // Aguarda os médicos terminarem o atendimento
        try {
            medico1.join();
            medico2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Todos os pacientes foram atendidos.");
    }
}


