import java.util.HashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/** En monitor for å beskytte SubsekvensRegister-objektet mot samtidig tilgang fra flere tråder. */
public class Monitor1 {
  private SubsekvensRegister register;
  private Lock lock;

  public Monitor1() {
    register = new SubsekvensRegister();
    lock = new ReentrantLock(); // Opprett en lock for å beskytte registeret
  }

  /** Legger til en HashMap med subsekvenser i registeret. */
  public void leggTilHashMap(HashMap<String, Subsekvens> hashMap) {
    lock.lock();
    try {
      register.leggTilHashMap(hashMap); // Legg til HashMap-en i registeret
    } finally {
      lock.unlock();
    }
  }

  /** Henter ut en HashMap med subsekvenser fra registeret. */
  public HashMap<String, Subsekvens> taUtHashMap() {
    lock.lock();
    try {
      return register.taUtHashMap();
    } finally {
      lock.unlock();
    }
  }

  /** Henter antall HashMap-er i registeret. */
  public int antallHashMaps() {
    lock.lock();
    try {
      return register.antallHashMaps();
    } finally {
      lock.unlock();
    }
  }
}
