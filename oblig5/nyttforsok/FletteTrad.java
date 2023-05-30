/**
 * En tråd som går i løkke og for hvert gjennomløp henter ut to HashMap-er fra
 * et monitor-objekt av klassen Monitor2, slår HashMap-ene sammen og legger
 * resultatet tilbake i monitoren.
 */
public class FletteTrad implements Runnable {

  Monitor monitor;

  public FletteTrad(Monitor monitor) { this.monitor = monitor; }

  public void run() {

    antallHashIgjen = monitor.antallHashMaps();

    try {
      while (antallHashIgjen > 1) {
      }
    }
  }
}
