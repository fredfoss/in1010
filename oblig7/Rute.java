/** Rute klasse */
public abstract class Rute {

  // Instansvariabler
  private int rad;
  private int kolonne;
  private Labyrint labyrint;
  private Rute nord;
  private Rute syd;
  private Rute vest;
  private Rute oest;

  // Konstruktoer
  public Rute(int rad, int kolonne, Labyrint labyrint, Rute nord, Rute syd, Rute vest, Rute oest) {
    this.rad = rad;
    this.kolonne = kolonne;
    this.labyrint = labyrint;
    this.nord = nord;
    this.syd = syd;
    this.vest = vest;
    this.oest = oest;
  }

  /** Finn-metode */
  public void finn(Rute fra) {}
}
