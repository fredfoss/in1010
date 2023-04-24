import java.util.HashMap;

/** Leser en fil og legger til en ny hashMap i Monitor1 */
public class SubsekvensLeser implements Runnable {

  private Monitor1 monitor;
  private String filnavn;

  /** Opprett en SubsekvensLeser */
  public SubsekvensLeser(Monitor1 monitor, String filnavn) {
    this.monitor = monitor;
    this.filnavn = filnavn;
  }

  @Override
  public void run() {
    HashMap<String, Subsekvens> hashMap = SubsekvensRegister.lesFil(filnavn);
    monitor.leggTilHashMap(hashMap);
  }
}
