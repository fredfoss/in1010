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
        + "\nPris: "
        + pris
        + "\nType: "
        + type
        + "\nVirkestoff "
        + virkestoff
        + "\nStyrke: "
        + styrke;
  }
}
