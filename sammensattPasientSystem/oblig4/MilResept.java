// Klasse MilResept
public class MilResept extends HvitResept {

  // Konstruktoer
  public MilResept(Legemiddel legemiddel, Lege utskrivendeLege, Pasient pasient) {
    super(legemiddel, utskrivendeLege, pasient, 3);
  }

  // Returner farge paa resept
  public String farge() {
    return "hvit";
  }

  // Returner pris paa resept
  public int prisAaBetale() {
    return 0;
  }
}
