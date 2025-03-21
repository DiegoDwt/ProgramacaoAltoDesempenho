package Ex11;

class ParteCarro extends Thread {
    private String nomeParte;

    public ParteCarro(String nomeParte) {
        this.nomeParte = nomeParte;
    }

    @Override
    public void run() {
        // Simula o tempo de construção da parte (entre 1 e 5 segundos)
        try {
            int tempoConstrucao = (int) (Math.random() * 5000) + 1000; // Entre 1 e 5 segundos
            Thread.sleep(tempoConstrucao);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Informa que a parte foi construída
        System.out.println(nomeParte + " foi construída.");
    }
}



