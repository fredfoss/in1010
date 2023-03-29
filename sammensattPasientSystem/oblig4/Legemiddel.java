// Klasse Legemiddel
public abstract class Legemiddel {

  public final String navn;
  public int pris; // Usikker om den skal ha public
  public final double virkestoff;
  public final int id;
  public static int nesteId = 0;

  // Konstruktoer
  public Legemiddel(String navn, int pris, double virkestoff) {
    this.navn = navn;
    this.pris = pris;
    this.virkestoff = virkestoff;
    id = nesteId;
    nesteId++;
  }

  // Returner navn
  public String hentNavn() {
    return navn;
  }

  // Returner pris
  public int hentPris() {
    return pris;
  }

  // Sett ny pris
  public void settNyPris(int pris) {
    this.pris = pris;
  }

  // Returner info
  public String toString() {
    return "Navn: " + navn + ", pris: " + pris + ", virkestoff: " + virkestoff + ", ID: " + id;
  }
}
