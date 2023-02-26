abstract public class Legemiddel {

    public final String navn;
    protected int pris; // Usikker om den skal ha public
    public final double virkestoff;
    public final static int id;

    public Legemiddel(String navn, int pris, double virkestoff) {
        this.navn = navn;
        this.pris = pris;
        this.virkestoff = virkestoff;
        id++;

    }

}
