public class HvitRute extends Rute {

  /** Konstruktoer */
  public HvitRute(Labyrint labyrint, int rad, int kolonne) {
    super(labyrint, rad, kolonne);
  }

  /** Finn-metoden */
  @Override
  public void finn(Rute fra) {
    Rute[] naboer = {nord, syd, vest, oest};

    for (Rute nabo : naboer) {
      if (fra != null) {
        if (nabo != null && nabo != fra) {
          nabo.finn(this);
        }
      } else {
        nabo.finn(this);
      }
    }
  }

  @Override
  public String toString() {
    return ".";
  }
}
