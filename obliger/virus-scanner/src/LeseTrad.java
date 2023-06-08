import java.util.HashMap;

/** En tråd som leser en fil og legger subsekvensene inn i en Monitor1-objekt. */
public class LeseTrad implements Runnable {

  // Instansvariabler
  String filnavn;
  Monitor1 monitor;

  /** Opprett trad */
  public LeseTrad(String filnavn, Monitor1 monitor) {
    this.filnavn = filnavn;
    this.monitor = monitor;
  }

  /** Leser filen og legger subsekvensene inn i Monitor1-objektet. */
  public void run() {
    HashMap<String, Subsekvens> hashMap = monitor.lagHashMap(filnavn);
    monitor.leggTilHashMap(hashMap);
  }
}
