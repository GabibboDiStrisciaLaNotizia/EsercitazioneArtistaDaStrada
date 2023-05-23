public class Artista implements Runnable {
    
    private Semaphore sedie;
    private Random random;

    public Artista(Semaphore sedie) {
        this.sedie = sedie;
        this.random = new Random();
    }

    @Override
    public void run() {
        try {
            while (true) {
                sedie.acquire();                                                                        // Attende che una sedia si liberi
                System.out.println("L'artista sta eseguendo un ritratto...");                           // Esegue il ritratto
                int tempoEsecuzione = random.nextInt(5000) + 1000;                                      // Tempo casuale per eseguire il ritratto
                Thread.sleep(tempoEsecuzione);
                sedie.release();                                                                        // Rilascia la sedia
                System.out.println("L'artista ha terminato un ritratto.");
                Thread.sleep(random.nextInt(3000) + 1000);                                              // Attende un breve periodo prima di accettare un altro cliente
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}