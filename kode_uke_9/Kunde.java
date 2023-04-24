public class Kunde implements Runnable {
  private Cafe cafe;
  private int id;
  private int antallDrukket = 0;

  public Kunde(Cafe c, int minId) {
    cafe = c;
    id = minId;
  }

  @Override
  public void run() {
    while (antallDrukket < 10) { // drikker 2 kaffer
      try {
        if (cafe.erStengt) break;
        cafe.drikkKaffe(id);
        antallDrukket++;
        Thread.sleep(500); // "sover", venter så fortsete
      } catch (InterruptedException e) {
        System.out.println(e);
      }
    }
    System.out.println("Kunde " + id + " - Ferdig!");
  }
}
