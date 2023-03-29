// Klasse PResept
public class PResept extends HvitResept {

  // Konstruktoer
  public PResept(Legemiddel legemiddel, Lege utskrivendeLege, Pasient pasient, int reit) {
    super(legemiddel, utskrivendeLege, pasient, reit);
  }

  // Returner farge paa resept
  public String farge() {
    return "hvit";
  }

  // Returner pris aa betale for legemiddel med resept
  public int prisAaBetale() {
    if (legemiddel.hentPris() > 108) {
      return legemiddel.hentPris() - 108;
    } else {
      return 0;
    }
  }
}
