/**
 * Klassen Subsekvens kan ta vare på en subsekvens (en String) og et antall (et heltall som angir
 * antall forekomster av denne subsekvensen hos flere personer)
 */
public class Subsekvens {

  public final String subsekvens;
  private int antall;

  /** Opprett subsekvens */
  public Subsekvens(String subsekvens, int antall) {
    this.subsekvens = subsekvens;
    this.antall = antall;
  }

  /** Returner antall forekomster av subsekvensen. */
  public int getAntall() {
    return antall;
  }

  /** Legg til forekomster */
  public void leggTilAntall(int antall) {
    this.antall += antall;
  }

  @Override
  public String toString() {
    return "(" + subsekvens + "," + antall + ")";
  }
}
