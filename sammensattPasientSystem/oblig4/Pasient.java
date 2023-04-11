public class Pasient {

  private static int nesteId = 0;
  private String navn;
  private String foedselsnummer;
  private int id;

  private Koe<Resept> resepter = new Koe<>();

  public Pasient(String navn, String foedselsnummer) {
    this.navn = navn;
    this.foedselsnummer = foedselsnummer;
    id = nesteId;
    nesteId++;
  }

  public String hentNavn() {
    return navn;
  }

  public String hentFoedselsnummer() {
    return foedselsnummer;
  }

  public int hentId() {
    return id;
  }

  public Koe<Resept> hentResepter() {
    return resepter;
  }

  public void leggTilResept(Resept resept) {
    resepter.leggTil(resept);
  }

  public String toString() {
    return "Pasient "
        + id
        + ": "
        + navn
        + "\nFoedselsnummer: "
        + foedselsnummer
        + "\nAntall resepter: "
        + resepter.stoerrelse();
  }
}
