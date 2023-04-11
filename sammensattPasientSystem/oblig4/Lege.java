// Klasse lege
public class Lege implements Comparable<Lege> {

  public final String navn;
  protected IndeksertListe<Resept> utskrevneResepter = new IndeksertListe<>();

  // Konstrukoer
  public Lege(String navn) {
    this.navn = navn;
  }

  public String hentNavn() {
    return navn;
  }

  // Opprett hvit resept
  public HvitResept skrivHvitResept(Legemiddel legemiddel, Pasient pasient, int reit)
      throws UlovligUtskrift {
    // Sjekk om narkotisk
    if (legemiddel instanceof Narkotisk) {
      throw new UlovligUtskrift(this, legemiddel);
    }

    HvitResept nyResept = new HvitResept(legemiddel, this, pasient, reit);
    utskrevneResepter.leggTil(nyResept);
    pasient.leggTilResept(nyResept);
    return nyResept;
  }

  // Opprett militærresept
  public MilResept skrivMilResept(Legemiddel legemiddel, Pasient pasient) throws UlovligUtskrift {
    // Skjekk om narkotisk
    if (legemiddel instanceof Narkotisk) {
      throw new UlovligUtskrift(this, legemiddel);
    }

    MilResept nyResept = new MilResept(legemiddel, this, pasient);
    utskrevneResepter.leggTil(nyResept);
    pasient.leggTilResept(nyResept);
    return nyResept;
  }

  // Opprett p-resept
  public PResept skrivPResept(Legemiddel legemiddel, Pasient pasient, int reit)
      throws UlovligUtskrift {
    // Sjekk om narkotisk
    if (legemiddel instanceof Narkotisk) {
      throw new UlovligUtskrift(this, legemiddel);
    }

    PResept nyResept = new PResept(legemiddel, this, pasient, reit);
    utskrevneResepter.leggTil(nyResept);
    pasient.leggTilResept(nyResept);
    return nyResept;
  }

  // Opprett blå resept
  public BlaaResept skrivBlaaResept(Legemiddel legemiddel, Pasient pasient, int reit)
      throws UlovligUtskrift {
    // Sjekk om narkotisk
    if (legemiddel instanceof Narkotisk) {
      if ((this instanceof Spesialist) == false) {
        throw new UlovligUtskrift(this, legemiddel);
      }
    }

    BlaaResept nyResept = new BlaaResept(legemiddel, this, pasient, reit);
    utskrevneResepter.leggTil(nyResept);
    pasient.leggTilResept(nyResept);
    return nyResept;
  }

  // Sorter etter navn
  public int compareTo(Lege lege) {
    return navn.compareTo(lege.hentNavn());
  }

  // Returner liste over utskrevne resepter av lege
  public IndeksertListe<Resept> hentUtskrevneResepter() {
    return utskrevneResepter;
  }

  // Returner info
  public String toString() {
    return "Lege: " + hentNavn() + "\nResepter: " + utskrevneResepter.stoerrelse();
  }
}
