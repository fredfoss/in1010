// Klasse Spesialist
public class Spesialist extends Lege implements Godkjenningsfritak {

    String kontrollkode;

    // Konstruktoer
    public Spesialist(String navn, String kontrollkode) {
        super(navn);
    }

    // Returner kontrollkode
    public String hentKontrollkode() {
        return kontrollkode;
    }
}
