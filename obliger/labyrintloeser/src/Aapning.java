import java.util.ArrayList;

public class Aapning extends HvitRute {

  /** Konstruktoer */
  public Aapning(Labyrint labyrint, int rad, int kolonne) {
    super(labyrint, rad, kolonne);
  }

  /** Finn-metoden */
  @Override
  public void finn(Rute fra, ArrayList<Rute> sti) {
    ArrayList<Rute> nySti = new ArrayList<>(sti);
    nySti.add(this);
    labyrint.addUtvei(nySti);
  }
}
