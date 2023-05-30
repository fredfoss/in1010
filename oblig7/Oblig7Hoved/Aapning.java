public class Aapning extends HvitRute {

  /** Konstruktoer */
  public Aapning(Labyrint labyrint, int rad, int kolonne) {
    super(labyrint, rad, kolonne);
  }

  /** Finn-metoden */
  @Override
  public void finn(Rute fra) {
    System.out.println("(" + rad + "," + kolonne + ")");
  }
}
