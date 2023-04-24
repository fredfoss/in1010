import java.util.concurrent.CountDownLatch;

public class Valglokale implements Runnable {
  private Parti[] partier = Parti.values();

  private MonitorStemmesystem monitor;

  private String sted;
  private CountDownLatch antallUrner;
  private int antallStemmerPerUrne;

  public Valglokale(
      MonitorStemmesystem monitor,
      String sted,
      CountDownLatch antallUrner,
      int antallStemmerPerUrne) {
    this.monitor = monitor;
    this.sted = sted;
    this.antallUrner = antallUrner;
    this.antallStemmerPerUrne = antallStemmerPerUrne;
  }

  private Parti tilfeldigParti() {
    int tilfeldigIndeks = (int) Math.round(Math.random() * (partier.length - 1));
    return partier[tilfeldigIndeks];
  }

  @Override
  public void run() {
    while (antallUrner.getCount() > 0) {
      antallUrner.countDown();

      for (int i = 0; i < antallStemmerPerUrne; i++) {
        monitor.leggTilStemme(tilfeldigParti());
      }

      System.out.println(sted + " la til " + antallStemmerPerUrne + " stemmer");
    }
  }
}
