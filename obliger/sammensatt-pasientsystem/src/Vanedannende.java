// Klasse Vanedannende
public class Vanedannende extends Legemiddel {

  public final int styrke;

  // Konstruktoer
  public Vanedannende(String navn, int pris, double virkestoff, int styrke) {
    super(navn, pris, virkestoff);
    type = "Vanedannende";
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
