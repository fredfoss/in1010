public class Barista implements Runnable {
  private Cafe cafe;
  private int id;
  private int antallLagd = 0;

  public Barista(Cafe c, int minId) {
    cafe = c;
    id = minId;
  }

  @Override
  public void run() {
    while (antallLagd < 3) { // lager 3 kaffer
      try {
        cafe.lagKaffe(id);
        antallLagd++;
        Thread.sleep(1000); // "sover", venter så fortsete
      } catch (InterruptedException e) {
        System.out.println(e);
      }
    }
    System.out.println("Barista " + id + " - Ferdig!");
  }
}
