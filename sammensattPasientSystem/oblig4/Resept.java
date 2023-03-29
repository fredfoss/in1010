// Klasse resept
public abstract class Resept {

  public final Legemiddel legemiddel;
  public final Lege utskrivendeLege;
  public final Pasient pasient;
  public int reit;
  public final int id;
  public static int nesteId = 0;

  // Konstruktoer
  public Resept(Legemiddel legemiddel, Lege utskrivendeLege, Pasient pasient, int reit) {
    this.legemiddel = legemiddel;
    this.utskrivendeLege = utskrivendeLege;
    this.pasient = pasient;
    this.reit = reit;
    id = nesteId;
    nesteId++;
  }

  // Returner id
  public int hentId() {
    return id;
  }

  // Returner legemiddel
  public Legemiddel hentLegemiddel() {
    return legemiddel;
  }

  // Returner utskrivende lege
  public Lege hentLege() {
    return utskrivendeLege;
  }

  // Returner pasient ID
  public int hentPasientId() {
    return pasient.hentId();
  }

  // Returner reit
  public int hentReit() {
    return reit;
  }

  // Bruk resept
  public boolean bruk() {
    if (reit > 0) {
      reit--;
      return true;
    } else {
      return false;
    }
  }

  // Returner farge
  public abstract String farge();

  // Returner pris aa betale for legemiddel med reseptet
  public abstract int prisAaBetale();

  // Returner info
  public String toString() {
    return "Legemiddel: "
        + legemiddel
        + ", utskrivende lege: "
        + utskrivendeLege
        + ", pasient ID: "
        + hentPasientId()
        + ", reit: "
        + reit
        + ", farge: "
        + farge()
        + ", pris aa betale: "
        + prisAaBetale();
  }
}
