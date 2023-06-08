// Klasse MilResept
public class MilResept extends HvitResept {

    // Konstruktoer
    public MilResept(Legemiddel legemiddel, Lege utskrivendeLege, int pasientId) {
        super(legemiddel, utskrivendeLege, pasientId, 3);
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
