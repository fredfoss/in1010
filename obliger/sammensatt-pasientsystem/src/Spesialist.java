// Klasse Spesialist
public class Spesialist extends Lege implements Godkjenningsfritak {

  String kontrollkode;

  // Konstruktoer
  public Spesialist(String navn, String kontrollkode) {
    super(navn);
    this.kontrollkode = kontrollkode;
  }

  public String hentKontrollkode() {
    return kontrollkode;
  }

  public String ToString() {
    return "Lege: "
        + hentNavn()
        + "\nResepter: "
        + utskrevneResepter.stoerrelse()
        + "\nKontrollkode: "
        + kontrollkode;
  }
}
