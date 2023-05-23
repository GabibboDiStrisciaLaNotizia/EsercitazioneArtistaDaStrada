import java.util.Random;
import java.util.concurrent.Semaphore;

public class SimulazioneArtistiDiStrada {
    
    public static void main(String[] args) {
        int numeroSedie = 4;
        Semaphore sedie = new Semaphore(numeroSedie);
        Thread artistaThread = new Thread(new Artista(sedie));
        artistaThread.start();

        int numeroClienti = 10;
        for (int i = 0; i < numeroClienti; i++) {
            Thread clienteThread = new Thread(new Cliente(sedie));
            clienteThread.start();
            try {
                Thread.sleep(new Random().nextInt(2000) + 1000);                                        // Intervallo casuale tra l'arrivo di due clienti
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}