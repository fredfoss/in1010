public class Stemmeteller implements Runnable {
  private MonitorStemmesystem monitor;

  private int id;
  private int antallStemmer;

  public Stemmeteller(MonitorStemmesystem monitor, int id, int antallStemmer) {
    this.monitor = monitor;
    this.id = id;
    this.antallStemmer = antallStemmer;
  }

  @Override
  public void run() {
    try {
      for (int i = 0; i < antallStemmer; i++) {
        Parti stemme = monitor.taUtStemme();
        System.out.println("Stemmeteller " + id + " talte en stemme til " + stemme);
      }
    } catch (InterruptedException e) {
      System.err.println("Stemmetellingen er avbrutt");
    }
  }
}
