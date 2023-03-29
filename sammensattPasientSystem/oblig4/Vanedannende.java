// Klasse Vanedannende
public class Vanedannende extends Legemiddel {

  public final int styrke;

  // Konstruktoer
  public Vanedannende(String navn, int pris, double virkestoff, int styrke) {
    super(navn, pris, virkestoff);
    this.styrke = styrke;
  }

  @Override
  // Returner info
  public String toString() {
    return "Navn: "
        + navn
        + ", pris: "
        + pris
        + ", virkestoff: "
        + virkestoff
        + ", ID: "
        + id
        + ", Styrke: "
        + styrke;
  }
}
