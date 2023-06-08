// Klasse HvitResept
public class HvitResept extends Resept {

  // Konstruktoer
  public HvitResept(Legemiddel legemiddel, Lege utskrivendeLege, Pasient pasient, int reit) {
    super(legemiddel, utskrivendeLege, pasient, reit);
  }

  // Returner farge
  public String farge() {
    return "hvit";
  }

  // Returner pris å betale for legemiddel med reseptet
  public int prisAaBetale() {
    return legemiddel.hentPris();
  }
}
