import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Cafe {
  // Vår "Monitor" -> objekt som håndterer felles data
  private int antallKaffe = 0;
  public boolean erStengt = false;

  private Lock laas = new ReentrantLock();
  // Condition : kø for trader før de kan fortsette (betingelse)
  private Condition ikkeTomt = laas.newCondition();

  public void lagKaffe(int baristaId) {
    // antallKaffe felles data -> kritisk region
    laas.lock();
    try {
      System.out.println("Barista " + baristaId + " - Lager kaffe");
      antallKaffe++;
      ikkeTomt.signal(); // Om en tråd venter pga tomt -> tråden kan fortsette
    } finally {
      laas.unlock();
    }
  }

  public void drikkKaffe(int kundeId) throws InterruptedException {
    laas.lock();
    try {
      while (antallKaffe == 0 && !erStengt) {
        ikkeTomt.await(); // kunde-tråden må vente på kaffe (signal)
      }
      if (!erStengt) { // skriver ikke ut dersom cafeen er stengt
        System.out.println("Kunde " + kundeId + " - Drikker kaffe");
        antallKaffe--;
      }
    } finally {
      laas.unlock();
    }
  }

  public void steng() {
    laas.lock();
    try {
      erStengt = true;
      ikkeTomt.signalAll(); // lar alle som venter fortsette
    } finally {
      laas.unlock();
    }
  }
}
