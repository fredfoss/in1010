public class PResept extends HvitResept {

    public PResept(Legemiddel legemiddel, Lege utskrivendeLege, int pasientId, int reit) {
        super(legemiddel, utskrivendeLege, pasientId, reit);
    }

    public String farge() {
        return "hvit";
    }

    public int prisAaBetale() {
        if (legemiddel.hentPris() > 108) {
            return legemiddel.hentPris() - 108;
        }
        else {
            return 0;
        }
    }
}

