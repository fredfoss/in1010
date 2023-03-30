public class Hovedprogram {

  private static Legesystem legesystem = new Legesystem();

  // Main metode
  public static void main(String[] args) {
    String input = null;
    Scanner scan = new Scanner(System.in);

    // Last ned data fra fil
    legesystem.lesFil("legedata.txt");

    skrivMeny();
    System.out.print("Hovedmeny: ");
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
        statistikk();
        break;

      case "q":
        System.exit(0);
    }
    System.out.println();
  }

  // Skriv meny
  private static void skrivMeny() {
    System.out.println("Operasjoner:");
    System.out.println("    1 -- Skriv ut oversikt");
    System.out.println("    2 -- Legg til pasient");
    System.out.println("    3 -- Legg til lege");
    System.out.println("    4 -- Legg til legemiddel");
    System.out.println("    5 -- Legg til resept");
    System.out.println("    6 -- Statistikk");
    System.out.println("    q -- Avslutt");
  }

  // Case 1: skriv ut en oversikt over alt
  private static void skrivUtOversikt() {}

  // Case 2: legg til en pasient
  private static void leggTilPasient() {}

  // Case 3: legg til en lege
  private static void leggTilLege() {}

  // Case 4: legg til et legemiddel
  private static void leggTilLegemiddel() {}

  // Case 5: legg til et resept
  private static void leggTilResept() {}

  // Case 6: skriv ut forskjellige former for statistikk
  private static void statistikk() {}
}
