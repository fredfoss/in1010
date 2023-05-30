/**
 * Klassen kan ta vare paa en subsekvens (en String) og et antall (som angir antall forekomster av
 * denne subsekvensen hos flere personer)
 */
public class Subsekvens {

  // Instansvariabler
  public final String subsekvens;
  private int antall;

  public Subsekvens(String subsekvens, int antall) {
    this.subsekvens = subsekvens;
    this.antall = antall;
  }

  public int getAntall() {
    return antall;
  }

  public void setAntall(int nyAntall) {
    antall = nyAntall;
  }

  public void oekAntall() {
    antall++;
  }

  @Override
  public String toString() {
    return "(" + subsekvens + "," + antall + ")";
  }
}
