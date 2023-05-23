public class Cliente implements Runnable {
    
    private Semaphore sedie;

    public Cliente(Semaphore sedie) {
        this.sedie = sedie;
    }

    @Override
    public void run() {
        try {
            if (sedie.tryAcquire()) {
                System.out.println("Un cliente si è seduto sulla sedia.");                              // Si siede sulla sedia
                Thread.sleep(new Random().nextInt(5000) + 1000);                                        // Attende un tempo casuale per il ritratto
                sedie.release();                                                                        // Rilascia la sedia
                System.out.println("Il cliente ha terminato il ritratto e ha lasciato la sedia.");
            } else {
                System.out.println("Un cliente ha rinunciato a farsi fare il ritratto.");               // Rinuncia a farsi fare il ritratto
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}