public class Spesialist extends Lege implements Godkjenningsfritak {

    String kontrollkode;

    public Spesialist(String navn, String kontrollkode) {
        super(navn);
    }

    public String hentKontrollkode() {
        return kontrollkode;
    }
}
