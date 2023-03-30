import java.io.File;
import java.util.Scanner;

// import java.io.File;
// import java.io.PrintWriter;

public class Legesystem {
  private Koe<Pasient> pasienter = new Koe<>();
  private Prioritetskoe<Lege> leger = new Prioritetskoe<>();
  private Koe<Legemiddel> legemidler = new Koe<>();
  private Koe<Resept> resepter = new Koe<>();

  // Legg til pasient
  public void leggTilPasient(String navn, String foedselsnummer) {
    Pasient nyPasient = new Pasient(navn, foedselsnummer);
    pasienter.leggTil(nyPasient);
  }

  // Legg til lege
  public void leggTilLege(String navn, String kontrollId) {
    // Hvis lege allerede finnes
    for (Lege lege : leger) {
      if (lege.hentNavn().equals(navn)) {
        System.out.println("ERROR: Lege " + lege.hentNavn() + " finnes allerede!");
        return;
      }
    }

    // Hvis vanlig lege
    if (kontrollId.equals("0")) {
      Lege nyLege = new Lege(navn);
      leger.leggTil(nyLege);
    }

    // Hvis spesialist
    else {
      Spesialist nyLege = new Spesialist(navn, kontrollId);
      leger.leggTil(nyLege);
    }
  }

  // Legg til legemiddel
  public void leggTilLegemiddel(String navn, String type, int pris, double virkestoff, int styrke) {
    // Hvis vanlig legemiddel
    if (type.equals("vanlig")) {
      Vanlig nyttLegemiddel = new Vanlig(navn, pris, virkestoff);
      legemidler.leggTil(nyttLegemiddel);
    }

    // Hvis narkotisk legemiddel
    if (type.equals("narkotisk")) {
      Narkotisk nyttLegemiddel = new Narkotisk(navn, pris, virkestoff, styrke);
      legemidler.leggTil(nyttLegemiddel);
    }

    // Hvis vanedannende legemiddel
    if (type.equals("vanedannende")) {
      Vanedannende nyttLegemiddel = new Vanedannende(navn, pris, virkestoff, styrke);
      legemidler.leggTil(nyttLegemiddel);
    }

    // Hvis ugyldig legemiddeltype
    else {
      System.out.println("ERROR: ugyldig legemiddel!");
    }
  }

  // Legg til resept
  public void leggTilResept(
      int legemiddelId, String legeNavn, int pasientId, String type, int reit) {
    // Finn lege
    Lege lege = null;
    for (Lege legenode : leger) {
      if (legenode.equals(legeNavn)) {
        lege = legenode;
        break;
      }
    }

    // Hvis lege ikke finnes
    if (lege == null) {
      System.out.println("ERROR: Lege " + legeNavn + " finnes ikke!");
      return;
    }

    // Finn legemiddel
    Legemiddel legemiddel = null;
    for (Legemiddel legemiddelnode : legemidler) {
      if (legemiddelnode.hentId() == legemiddelId) {
        legemiddel = legemiddelnode;
        break;
      }
    }

    // Hvis legemiddel ikke finnes
    if (legemiddel == null) {
      System.out.println("ERROR: Legemiddel " + legemiddelId + " finnes ikke");
      return;
    }

    // Finn pasient
    Pasient pasient = null;
    for (Pasient pasientnode : pasienter) {
      if (pasientnode.hentId() == pasientId) {
        pasient = pasientnode;
        break;
      }
    }

    // Hvis pasient ikke finnes
    if (pasient == null) {
      System.out.println("ERROR: Pasient " + pasientId + " finnes ikke");
      return;
    }

    // Lag resept
    try {
      Resept resept = null;

      // Hvis hvit resept
      if (type.equals("hvit")) {
        resept = lege.skrivHvitResept(legemiddel, pasient, reit);
      }

      // Hvis blå resept
      else if (type.equals("blaa")) {
        resept = lege.skrivBlaaResept(legemiddel, pasient, reit);
      }

      // Hvis militær resept
      else if (type.equals("militaer")) {
        resept = lege.skrivMilResept(legemiddel, pasient);
      }

      // Hvis p resept
      else if (type.equals("p")) {
        resept = lege.skrivPResept(legemiddel, pasient, reit);
      }

      // Ellers
      else {
        System.out.println("ERROR: Fant ikke resepttype!");
      }
    } catch (UlovligUtskrift e) {
      e.toString();
    }

    // Legger til reseptet
    resepter.leggTil(resept);
  }

  // Les fra fil
  public void lesFil(String filnavn) {
    Scanner fil = null;
    try {
      fil = new Scanner(new File(filnavn));
    } catch (Exception e) {
      System.out.println("ERROR: Kan ikke finne filen " + filnavn + "!");
      return;
    }

    // Les datafil
    String infotype = null;
    while (fil.hasNextLine()) {

      // Nåværende linje
      String linje = fil.nextLine();

      // Finn informasjonstype (pasienter/legemidler/leger/resepter)
      if (linje.charAt(0) == '#') {
        infotype = linje.split(" ")[1].toLowerCase();
        continue;
      }

      // Splitter linje inn i deler (argumenter)
      String[] args = linje.split("\\s*,\\s*");

      // Hvis pasienter
      if (infotype.equals("pasienter")) {
        leggTilPasient(args[0], args[1]);
      }

      // Hvis leger
      else if (infotype.equals("leger")) {
        leggTilLege(args[0], args[1]);
      }

      // Hvis legemidler
      else if (infotype.equals("legemidler")) {
        leggTilLegemiddel(
            args[0],
            args[1],
            (int) Math.round(Double.parseDouble(args[2])),
            Double.parseDouble(args[3]),
            (int) Math.round(Double.parseDouble(args[4])));
      }

      // Hvis resepter
      else if (infotype.equals("resepter")) {
        leggTilResept(
            Integer.parseInt(args[0]),
            args[1],
            Integer.parseInt(args[2]),
            args[3],
            Integer.parseInt(args[4]));
      }
    }
    fil.close();
  }

  // Hent pasienter
  public Koe<Pasient> hentPasienter() {
    return pasienter;
  }

  // Hent leger
  public Prioritetskoe<Lege> hentLeger() {
    return leger;
  }

  // Hent legemidler
  public Koe<Legemiddel> hentLegemidler() {
    return legemidler;
  }
}
