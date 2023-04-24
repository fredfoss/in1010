import java.util.HashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/** En monitor som kan ta vare på mange HashMaps som inneholder subsekvenser */
public class Monitor1 {

  private SubsekvensRegister register;
  private Lock lock;

  /** Opprett en Monitor1 */
  public Monitor1() {
    register = new SubsekvensRegister();
    lock = new ReentrantLock();
  }

  /** Legg en hashMap (alle subsekvensene til én person) til i register */
  public void leggTilHashMap(HashMap<String, Subsekvens> hashMap) {
    lock.lock();
    try {
      register.leggTilHashMap(hashMap);
    } finally {
      lock.unlock();
    }
  }

  /** Returner og fjern hashMap fra register */
  public HashMap<String, Subsekvens> taUtHashMap() {
    lock.lock();
    try {
      return register.taUtHashMap();
    } finally {
      lock.unlock();
    }
  }

  /** Returner antall hashMaps i register */
  public int antallHashMaps() {
    lock.lock();
    try {
      return register.antallHashMaps();
    } finally {
      lock.unlock();
    }
  }
}
