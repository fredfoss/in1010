// Klasse HvitResept
public class HvitResept extends Resept {
    
    // Konstruktoer
    public HvitResept(Legemiddel legemiddel, Lege utskrivendeLege, int pasientId, int reit) {
        super(legemiddel, utskrivendeLege, pasientId, reit);
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
