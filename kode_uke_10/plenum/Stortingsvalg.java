import java.util.concurrent.CountDownLatch;

public class Stortingsvalg {
  public static final int ANTALL_URNER = 4;
  public static final int ANTALL_STEMMER_PER_URNE = 10;

  public static final int ANTALL_STEMMETELLERE = 5;
  public static final int ANTALL_STEMMER_PER_TELLER =
      ANTALL_URNER * ANTALL_STEMMER_PER_URNE / ANTALL_STEMMETELLERE;

  public static void main(String[] args) throws InterruptedException {
    Stemmesystem stemmesystem = new Stemmesystem();
    MonitorStemmesystem monitor = new MonitorStemmesystem(stemmesystem);

    Thread[] stemmetellere = new Thread[ANTALL_STEMMETELLERE];

    System.out.println("\nStortingsvalget er i gang!\n");

    for (int i = 0; i < ANTALL_STEMMETELLERE; i++) {
      stemmetellere[i] = new Thread(new Stemmeteller(monitor, i, ANTALL_STEMMER_PER_TELLER));
      stemmetellere[i].start();
    }

    CountDownLatch antallUrner = new CountDownLatch(ANTALL_URNER);

    Thread blindern =
        new Thread(new Valglokale(monitor, "Blindern", antallUrner, ANTALL_STEMMER_PER_URNE));
    Thread nydalen =
        new Thread(new Valglokale(monitor, "Nydalen", antallUrner, ANTALL_STEMMER_PER_URNE));

    blindern.start();
    nydalen.start();

    for (Thread stemmeteller : stemmetellere) {
      stemmeteller.join();
    } // venter på at stemmetellerne er ferdige

    System.out.println("\nStortingsvalget er over!\n");
  }
}
