/** En klasse som representerer en subsekvens og antall ganger den forekommer. */
public class Subsekvens {
  private String sekvens;
  private int antall;

  public Subsekvens(String sekvens, int antall) {
    this.sekvens = sekvens;
    this.antall = antall;
  }

  /** Henter subsekvensen. */
  public String getSekvens() {
    return sekvens;
  }

  /** Henter antall forekomster av subsekvensen. */
  public int getAntall() {
    return antall;
  }

  /** Øker antall forekomster av subsekvensen med én. */
  public void oekAntall() {
    antall++;
  }

  /** Returnerer en strengrepresentasjon av subsekvensen og antall forekomster. */
  public String toString() {
    return "(" + sekvens + "," + antall + ")";
  }
}
