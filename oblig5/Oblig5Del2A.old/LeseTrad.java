import java.util.HashMap;

/** En tråd som leser en fil og legger subsekvensene inn i en Monitor1-objekt. */
public class LeseTrad implements Runnable {
  private String filnavn;
  private Monitor1 monitor;

  public LeseTrad(String filnavn, Monitor1 monitor) {
    this.filnavn = filnavn;
    this.monitor = monitor;
  }

  /** Leser filen og legger subsekvensene inn i Monitor1-objektet. */
  public void run() {
    HashMap<String, Subsekvens> hashMap =
        SubsekvensRegister.lesFil(filnavn); // Les filen og opprett en HashMap
    monitor.leggTilHashMap(hashMap); // Legg HashMap-en til i Monitor1-objektet
  }
}
