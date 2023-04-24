import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MonitorStemmesystem {
  private Lock laas = new ReentrantLock();
  private Condition ikkeTomt = laas.newCondition();

  private Stemmesystem stemmesystem;

  public MonitorStemmesystem(Stemmesystem stemmesystem) {
    this.stemmesystem = stemmesystem;
  }

  public void leggTilStemme(Parti parti) {
    laas.lock();

    try {
      stemmesystem.leggTilStemme(parti);
      ikkeTomt.signalAll();
    } finally {
      laas.unlock();
    }
  }

  public Parti taUtStemme() throws InterruptedException {
    laas.lock();

    try {
      while (tomtForStemmer()) {
        ikkeTomt.await();
      } // passiv venting

      return stemmesystem.taUtStemme();
    } finally {
      laas.unlock();
    }
  }

  public boolean tomtForStemmer() {
    laas.lock();

    try {
      return stemmesystem.tomtForStemmer();
    } finally {
      laas.unlock();
    }
  }
}
