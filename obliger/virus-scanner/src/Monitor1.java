import java.util.HashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/** Monitor for å beskytte SubsekvensRegister-objektet mot samtidig tilgang fra flere tråder. */
public class Monitor1 {

  // Instantsvariabler
  private SubsekvensRegister register;
  private Lock lock;

  /** Opprett en monitor */
  public Monitor1() {
    register = new SubsekvensRegister();
    lock = new ReentrantLock(); // Opprett en lock for å beskytte registeret
  }

  /** Legg til en HashMap med subsekvenser i registeret. */
  public void leggTilHashMap(HashMap<String, Subsekvens> hashMap) {
    lock.lock();
    try {
      register.settInnHashMap(hashMap); // Legg til HashMap-en i registeret
    } finally {
      lock.unlock();
    }
  }

  /** Hent ut en HashMap med subsekvenser fra registeret. */
  public HashMap<String, Subsekvens> taUtHashMap() {
    lock.lock();
    try {
      return register.taUtHashMap();
    } finally {
      lock.unlock();
    }
  }

  /** Hent antall HashMaps i registeret. */
  public int antallHashMaps() {
    lock.lock();
    try {
      return register.antallHashMaps();
    } finally {
      lock.unlock();
    }
  }

  /** Les fil med substrenger (én persons blodprøve) og lag og returner hashMap */
  public HashMap<String, Subsekvens> lagHashMap(String filnavn) {
    lock.lock();
    try {
      return register.lagHashMap(filnavn);
    } finally {
      lock.unlock();
    }
  }

  /** Slaa sammen og returner to hashMaps */
  public HashMap<String, Subsekvens> flettHashMap(
      HashMap<String, Subsekvens> hashMap1, HashMap<String, Subsekvens> hashMap2) {
    lock.lock();
    try {
      return register.flettHashMap(hashMap1, hashMap2);
    } finally {
      lock.unlock();
    }
  }
}
