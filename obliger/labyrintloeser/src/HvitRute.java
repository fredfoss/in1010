import java.util.ArrayList;

public class HvitRute extends Rute {

  // protected boolean besoekt = false;

  /** Konstruktoer */
  public HvitRute(Labyrint labyrint, int rad, int kolonne) {
    super(labyrint, rad, kolonne);
  }

  /** Finn-metoden */
  @Override
  public void finn(Rute fra, ArrayList<Rute> sti) {
    ArrayList<Rute> nySti = new ArrayList<>(sti);
    nySti.add(this);

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
    if (foersteRute) {
      return "\033[1;32m"
          + "x"
          + "\033[0m";
    } else if (iRaskestVei) {
      return "\033[0;32m"
          + "x"
          + "\033[0m";
    } else {
      return ".";
    }
  }
}
