public class HvitRute extends Rute {

  // Konstruktoer
  public HvitRute(
      int rad, int kolonne, Labyrint labyrint, Rute nord, Rute syd, Rute vest, Rute oest) {
    super(rad, kolonne, labyrint, nord, syd, vest, oest);
  }

  @Override
  public String toString() {
    return ".";
  }
}
