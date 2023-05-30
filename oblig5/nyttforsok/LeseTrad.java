import java.util.HashMap;

/** En tråd som leser en fil og legger subsekvensene inn i et Monitor-objekt. */
public class LeseTrad implements Runnable {

  // Instansvariabler
  String filnavn;
  Monitor monitor;

  /** Opprett trad */
  public LeseTrad(String filnavn, Monitor monitor) {
    this.filnavn = filnavn;
    this.monitor = monitor;
  }

  /** Leser filen og legger subsekvensene inn i Monitor-objektet. */
  public void run() {
    HashMap<String, Subsekvens> hashMap = monitor.lagHashMap(filnavn);
    monitor.leggTilHashMap(hashMap);
  }
}
