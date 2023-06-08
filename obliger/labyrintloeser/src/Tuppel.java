/** Klassen Tuppel */
public class Tuppel {

  // Instansvariabler
  int r;
  int k;

  public Tuppel(int rad, int kolonne) {
    r = rad;
    k = kolonne;
  }

  @Override
  public String toString() {
    return "(" + r + "," + k + ")";
  }
}
