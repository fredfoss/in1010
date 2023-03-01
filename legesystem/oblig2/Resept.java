abstract public class Resept {

    public final Legemiddel legemiddel;
    public final Lege utskrivendeLege;
    public final int pasientId;
    public int reit;
    public final int id;
    public static int nesteId = 0;

    public Resept(Legemiddel legemiddel, Lege utskrivendeLege, int pasientId, int reit) {
        this.legemiddel = legemiddel;
        this.utskrivendeLege = utskrivendeLege;
        this.pasientId = pasientId;
        this.reit = reit;
        id = nesteId;
        nesteId++;
    }

    public int hentId() {
        return id;
    }

    public Legemiddel hentLegemiddel() {
        return legemiddel;
    }

    public Lege hentLege() {
        return utskrivendeLege;
    }

    public int hentPasientId() {
        return pasientId;
    }

    public int hentReit() {
        return reit;
    }

    public boolean bruk() {
        if (reit > 0) {
            reit--;
            return true;
        }

        else {
            return false;
        }
    }

    abstract public String farge();

    abstract public int prisAaBetale();

    public String toString() {
        return "Legemiddel: " + legemiddel + ", utskrivende lege: " + utskrivendeLege
        + ", pasient ID: " + pasientId + ", reit: " + reit + ", farge: " + farge()
        + ", pris aa betale: " + prisAaBetale();
    }
}
