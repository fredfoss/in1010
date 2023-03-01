abstract public class Legemiddel {

    public final String navn;
    public int pris; // Usikker om den skal ha public
    public final double virkestoff;
    public final int id;
    public static int nesteId = 0;

    public Legemiddel(String navn, int pris, double virkestoff) {
        this.navn = navn;
        this.pris = pris;
        this.virkestoff = virkestoff;
        id = nesteId;
        nesteId++;
    }

    public int hentPris() {
        return pris;
    }

    public void settNyPris(int pris) {
        this.pris = pris;
    }

    public String toString() {
        return "Navn: " + navn + ", pris: " + pris + ", virkestoff: " + virkestoff + ", ID: " + id;
    }

}
