// Klasse BlaaResept
public class BlaaResept extends Resept {

    // Konstruktoer
    public BlaaResept(Legemiddel legemiddel, Lege utskrivendeLege, int pasientId, int reit) {
        super(legemiddel, utskrivendeLege, pasientId, reit);
    }

    // Returner farge på resept
    public String farge() {
        return "blaa";
    }

    // Returner pris å betale for legemiddelet med reseptet
    public int prisAaBetale() {
        return (int)Math.round(legemiddel.hentPris() * 0.25);
    }
}
