package Ex10;

import java.util.LinkedList;
import java.util.Queue;

public class ProntoSocorro {
    private static Queue<String> filaPacientes = new LinkedList<>();

    // Método para adicionar pacientes à fila
    public static void adicionarPaciente(String paciente) {
        filaPacientes.add(paciente);
    }

    // Método para obter o próximo paciente da fila (sincronizado)
    public static synchronized String proximoPaciente() {
        return filaPacientes.poll();
    }
}




