import java.util.ArrayList;

public class HvitRute extends Rute {

  /** Konstruktoer */
  public HvitRute(Labyrint labyrint, int rad, int kolonne) {
    super(labyrint, rad, kolonne);
  }

  /** Finn-metoden */
  @Override
  public void finn(Rute fra, ArrayList<Tuppel> sti) {
    ArrayList<Tuppel> nySti = new ArrayList<>(sti);
    Tuppel nyTuppel = new Tuppel(rad, kolonne);
    nySti.add(nyTuppel);

    besoekt = true;
    Rute[] naboer = {nord, syd, vest, oest};

    for (Rute nabo : naboer) {
      if (fra == null) {
        nabo.finn(this, nySti);
      } else {
        if (nabo != null && nabo != fra && !nabo.getBesoekt()) {
          nabo.finn(this, nySti);
        }
      }
    }
  }

  @Override
  public String toString() {
    return ".";
  }
}
