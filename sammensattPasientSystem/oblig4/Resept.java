// Klasse resept
abstract public class Resept {

    public final Legemiddel legemiddel;
    public final Lege utskrivendeLege;
    public final int pasientId;
    public int reit;
    public final int id;
    public static int nesteId = 0;

    // Konstruktoer
    public Resept(Legemiddel legemiddel, Lege utskrivendeLege, int pasientId, int reit) {
        this.legemiddel = legemiddel;
        this.utskrivendeLege = utskrivendeLege;
        this.pasientId = pasientId;
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
        return pasientId;
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
        }

        else {
            return false;
        }
    }

    // Returner farge
    abstract public String farge();

    // Returner pris aa betale for legemiddel med reseptet
    abstract public int prisAaBetale();

    // Returner info
    public String toString() {
        return "Legemiddel: " + legemiddel + ", utskrivende lege: " + utskrivendeLege
        + ", pasient ID: " + pasientId + ", reit: " + reit + ", farge: " + farge()
        + ", pris aa betale: " + prisAaBetale();
    }
}
