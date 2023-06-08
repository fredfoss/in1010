// Klasse Narkotisk
public class Narkotisk extends Legemiddel {

  public final int styrke;

  // Konstuktoer
  public Narkotisk(String navn, int pris, double virkestoff, int styrke) {
    super(navn, pris, virkestoff);
    type = "Narkotisk";
    this.styrke = styrke;
  }

  @Override
  // Returner info
  public String toString() {
    return "Legemiddel "
        + id
        + ": "
        + navn
        + "\nType: "
        + type
        + "\nPris: "
        + pris
        + "\nVirkestoff "
        + virkestoff
        + "\nStyrke: "
        + styrke;
  }
}
