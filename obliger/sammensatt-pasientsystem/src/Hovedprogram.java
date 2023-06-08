import java.util.Scanner;

public class Hovedprogram {

  private static Legesystem legesystem = new Legesystem();

  // Main metode
  public static void main(String[] args) {
    String input = null;
    Scanner scan = new Scanner(System.in);

    // Last ned data fra fil
    legesystem.lesFil("legedata.txt");

    while (true) {
      skrivMeny();
      System.out.print("> ");
      input = scan.nextLine();
      switch (input) {
          // Print emnene med flest studenter
        case "1":
          skrivUtOversikt();
          break;

          // Print studentene med flest emner
        case "2":
          leggTilPasient();
          break;

          // Skriv ut alle studenter i et emne
        case "3":
          leggTilLege();
          break;

          // Skriv ut alle emner til en student
        case "4":
          leggTilLegemiddel();
          break;

        case "5":
          leggTilResept();
          break;

        case "6":
          brukResept();
          break;

        case "7":
          statistikk();
          break;

        case "x":
          System.exit(0);

        default:
          throw new RuntimeException("Ugyldig input");
      }
      System.out.println();
    }
  }

  // Skriv meny
  private static void skrivMeny() {
    System.out.println("-----------Hovedmeny-----------");
    System.out.println("    1 -- Skriv ut oversikt");
    System.out.println("    2 -- Legg til pasient");
    System.out.println("    3 -- Legg til lege");
    System.out.println("    4 -- Legg til legemiddel");
    System.out.println("    5 -- Legg til resept");
    System.out.println("    6 -- Bruk resept");
    System.out.println("    7 -- Statistikk");
    System.out.println("    x -- Avslutt");
  }

  // Case 1: skriv ut en oversikt over alt
  private static void skrivUtOversikt() {
    Koe<Pasient> allePasienter = legesystem.hentPasienter();
    Prioritetskoe<Lege> alleLeger = legesystem.hentLeger();
    Koe<Legemiddel> alleLegemidler = legesystem.hentLegemidler();
    Koe<Resept> alleResepter = legesystem.hentResepter();

    System.out.println();

    for (Pasient pasient : allePasienter) {
      System.out.println(pasient.toString());
      System.out.println();
    }

    for (Lege lege : alleLeger) {
      System.out.println(lege.toString());
      System.out.println();
    }

    for (Legemiddel legemiddel : alleLegemidler) {
      System.out.println(legemiddel.toString());
      System.out.println();
    }

    for (Resept resept : alleResepter) {
      System.out.println(resept.toString());
      System.out.println();
    }
  }

  // Case 2: legg til en pasient
  private static void leggTilPasient() {
    Scanner scan = new Scanner(System.in);
    System.out.print("Navn: ");
    String navn = scan.nextLine();

    System.out.print("Foedselsnummer: ");
    String foedselsnummer = scan.nextLine();

    legesystem.leggTilPasient(navn, foedselsnummer);
  }

  // Case 3: legg til en lege
  private static void leggTilLege() {
    Scanner scan = new Scanner(System.in);
    System.out.println("    1 -- Vanlig lege");
    System.out.println("    2 -- Spesialist");
    System.out.println("    x -- Avbryt");
    System.out.print("> ");
    String input = scan.nextLine();

    switch (input) {
      case "1":
        // Hvis vanlig lege
        System.out.print("Navn: ");
        String navnLege = scan.nextLine();
        legesystem.leggTilLege(navnLege, "0");
        break;

      case "2":
        // Hvis spesialist
        System.out.print("Navn: ");
        String navnSpesialist = scan.nextLine();
        System.out.print("Kontroll ID: ");
        String kontrollId = scan.nextLine();
        legesystem.leggTilLege(navnSpesialist, kontrollId);
        break;

      case "x":
        break;

      default:
        throw new RuntimeException("Ugyldig input");
    }
  }

  // Case 4: legg til et legemiddel
  private static void leggTilLegemiddel() {
    Scanner scan = new Scanner(System.in);
    System.out.println("    1 -- Vanlig");
    System.out.println("    2 -- Narkotisk");
    System.out.println("    3 -- Vanedannende");
    System.out.println("    x -- Avbryt");
    System.out.print("> ");
    String input = scan.nextLine();

    switch (input) {
      case "1":
        // Hvis vanlig legemiddel
        System.out.print("Navn: ");
        String navnVanlig = scan.nextLine();
        System.out.print("Pris: ");
        int prisVanlig = (int) Math.round(Double.parseDouble(scan.nextLine()));
        System.out.print("Virkestoff: ");
        double virkestoffVanlig = Double.parseDouble(scan.nextLine());
        legesystem.leggTilLegemiddel(navnVanlig, "vanlig", prisVanlig, virkestoffVanlig, 0);
        break;

      case "2":
        // Hvis narkotisk legemiddel
        System.out.print("Navn: ");
        String navnNar = scan.nextLine();
        System.out.print("Pris: ");
        int prisNar = (int) Math.round(Double.parseDouble(scan.nextLine()));
        System.out.print("Virkestoff: ");
        double virkestoffNar = Double.parseDouble(scan.nextLine());
        System.out.print("Styrke: ");
        int styrkeNar = (int) Math.round(Double.parseDouble(scan.nextLine()));
        legesystem.leggTilLegemiddel(navnNar, "narkotisk", prisNar, virkestoffNar, styrkeNar);
        break;

      case "3":
        // Hvis vanedannende legemiddel
        System.out.print("Navn: ");
        String navnVane = scan.nextLine();
        System.out.print("Pris: ");
        int prisVane = (int) Math.round(Double.parseDouble(scan.nextLine()));
        System.out.print("Virkestoff: ");
        double virkestoffVane = Double.parseDouble(scan.nextLine());
        System.out.print("Styrke: ");
        int styrkeVane = (int) Math.round(Double.parseDouble(scan.nextLine()));
        legesystem.leggTilLegemiddel(
            navnVane, "vanedannende", prisVane, virkestoffVane, styrkeVane);
        break;

      case "x":
        break;

      default:
        throw new RuntimeException("Ugyldig input");
    }
  }

  // Case 5: legg til et resept
  private static void leggTilResept() {
    Scanner scan = new Scanner(System.in);

    int legemiddelId = 0;
    String legeNavn = " ";
    int pasientId = 0;
    String type = " ";
    int reit = 0;

    System.out.println("    1 -- Hvit resept");
    System.out.println("    2 -- P resept");
    System.out.println("    3 -- Militaer resept");
    System.out.println("    4 -- Blaa resept");
    System.out.println("    x -- Avbryt");
    System.out.print("> ");
    String input = scan.nextLine();

    switch (input) {
      case "1":
        // Hvis hvit resept
        type = "hvit";
        System.out.print("Legemiddel ID: ");
        legemiddelId = Integer.parseInt(scan.nextLine());
        System.out.print("Navn paa lege: ");
        legeNavn = scan.nextLine();
        System.out.print("Pasient ID: ");
        pasientId = Integer.parseInt(scan.nextLine());
        System.out.print("Reit: ");
        reit = Integer.parseInt(scan.nextLine());
        break;

      case "2":
        // Hvis p resept
        type = "p";
        System.out.print("Legemiddel ID: ");
        legemiddelId = Integer.parseInt(scan.nextLine());
        System.out.print("Navn paa lege: ");
        legeNavn = scan.nextLine();
        System.out.print("Pasient ID: ");
        pasientId = Integer.parseInt(scan.nextLine());
        System.out.print("Reit: ");
        reit = Integer.parseInt(scan.nextLine());
        break;

      case "3":
        // Hvis militær resept
        type = "militaer";
        System.out.print("Legemiddel ID: ");
        legemiddelId = Integer.parseInt(scan.nextLine());
        System.out.print("Navn paa lege: ");
        legeNavn = scan.nextLine();
        System.out.print("Pasient ID: ");
        pasientId = Integer.parseInt(scan.nextLine());
        reit = 0;
        break;

      case "4":
        // Hvis blå resept
        type = "blaa";
        System.out.print("Legemiddel ID: ");
        legemiddelId = Integer.parseInt(scan.nextLine());
        System.out.print("Navn paa lege: ");
        legeNavn = scan.nextLine();
        System.out.print("Pasient ID: ");
        pasientId = Integer.parseInt(scan.nextLine());
        System.out.print("Reit: ");
        reit = Integer.parseInt(scan.nextLine());
        break;

      case "x":
        break;

      default:
        throw new RuntimeException("Ugyldig input");
    }
    legesystem.leggTilResept(legemiddelId, legeNavn, pasientId, type, reit);
  }

  // Case 6: bruk resept
  private static void brukResept() {
    Scanner scan = new Scanner(System.in);

    // Skriv ut alle pasientene og la brukeren velge en
    Koe<Pasient> allePasienter = legesystem.hentPasienter();
    System.out.println("\nPasient:");
    int i = 1;
    for (Pasient pasient : allePasienter) {
      System.out.println(
          "    "
              + i
              + " --  "
              + pasient.hentNavn()
              + " (fnr "
              + pasient.hentFoedselsnummer()
              + ")");
      i++;
    }
    System.out.print("> ");
    int valgtPasientIndex = Integer.parseInt(scan.nextLine());
    Pasient valgtPasient = null;
    i = 1;
    for (Pasient pasient : allePasienter) {
      if (i == valgtPasientIndex) {
        valgtPasient = pasient;
        break;
      }
      i++;
    }
    System.out.println(
        "Valgt pasient: "
            + valgtPasient.hentNavn()
            + " (fnr "
            + valgtPasient.hentFoedselsnummer()
            + ").");

    // Skriv ut alle reseptene til valgt pasient og la brukeren velge en
    Koe<Resept> pasientResepter = valgtPasient.hentResepter();
    System.out.println("\nResept:");
    if (pasientResepter.stoerrelse() == 0) {
      System.out.println("Ingen resepter funnet for valgt pasient.");
      return;
    }
    i = 1;
    for (Resept resept : pasientResepter) {
      System.out.println(
          "    "
              + i
              + " -- "
              + resept.hentLegemiddel().hentNavn()
              + " ("
              + resept.hentReit()
              + " reit)");
      i++;
    }
    System.out.print("> ");
    int valgtReseptIndex = Integer.parseInt(scan.nextLine());
    Resept valgtResept = null;
    i = 1;
    for (Resept resept : pasientResepter) {
      if (i == valgtReseptIndex) {
        valgtResept = resept;
        break;
      }
      i++;
    }

    // Bruk resept og oppdater antall gjenværende reit
    if (valgtResept.bruk()) {
      System.out.println(
          "Brukte resept på "
              + valgtResept.hentLegemiddel().hentNavn()
              + ". Antall gjenværende reit: "
              + valgtResept.hentReit());
    } else {
      System.out.println(
          "Kunne ikke bruke resept på " + valgtResept.hentLegemiddel().hentNavn() + ".");
    }
  }

  // Case 7: skriv ut forskjellige former for statistikk
  private static void statistikk() {
    Scanner scan = new Scanner(System.in);

    Koe<Pasient> allePasienter = legesystem.hentPasienter();
    Prioritetskoe<Lege> alleLeger = legesystem.hentLeger();
    Koe<Legemiddel> alleLegemidler = legesystem.hentLegemidler();
    Koe<Resept> alleResepter = legesystem.hentResepter();

    int count = 0;

    boolean legeHarNarkRes = false;
    String legeInfo = "";

    boolean pasHarNarkRes = false;
    String pasientInfo = "";

    System.out.println("    1 -- Antall utskrevne vanedannende resepter");
    System.out.println("    2 -- Antall utskrevne narkotiske resepter");
    System.out.println("    3 -- Statistikk om mulig misbruk av narkotika");
    System.out.println("    x -- Avbryt");
    System.out.print("> ");
    String input = scan.nextLine();

    switch (input) {
      case "1":
        // Totalt antall utskrevne resepter på vanedannende legemidler
        for (Resept resept : alleResepter) {
          if (resept.hentLegemiddel() instanceof Vanedannende) {
            count++;
          }
        }
        System.out.println();
        System.out.println(count);
        break;

      case "2":
        // Totalt antall utskrevne resepter på narkotiske legemidler
        for (Resept resept : alleResepter) {
          if (resept.hentLegemiddel() instanceof Narkotisk) {
            count++;
          }
        }
        System.out.println();
        System.out.println(count);

        break;

      case "3":
        // Statistikk om mulig misbruk av narkotika
        System.out.println("    1 -- Leger med utskrevne narkotiske resepter");
        System.out.println("    2 -- Pasienter med resept på narkotiske legemidler");
        System.out.println("    x -- Avbryt");
        System.out.print("> ");
        String input2 = scan.nextLine();

        switch (input2) {
          case "1":
            // List opp navnene på alle leger som har skrevet ut minst én resept på narkotiske
            // legemidler, og antallet slike resepter per lege
            for (Lege lege : alleLeger) {
              count = 0;
              legeHarNarkRes = false;
              for (Resept resept : lege.hentUtskrevneResepter()) {
                if (resept.hentLegemiddel() instanceof Narkotisk) {
                  legeHarNarkRes = true;
                  count++;
                }
              }
              if (legeHarNarkRes) {
                legeInfo = lege.hentNavn() + ", " + count;
                System.out.println(legeInfo);
              }
            }
            break;

          case "2":
            // List opp navnene på alle pasienter som har minst én gyldig resept på narkotiske
            // legemidler
            for (Pasient pasient : allePasienter) {
              count = 0;
              pasHarNarkRes = false;
              for (Resept resept : pasient.hentResepter()) {
                if (resept.hentLegemiddel() instanceof Narkotisk) {
                  pasHarNarkRes = true;
                  count++;
                }
              }
              if (pasHarNarkRes) {
                pasientInfo = pasient.hentNavn() + ", " + count;
                System.out.println(pasientInfo);
              }
            }
            break;

          case "x":
            // Avbryt
            break;

          default:
            // Ugyldig input
            throw new RuntimeException("Ugyldig input");
        }
    }
  }
}
