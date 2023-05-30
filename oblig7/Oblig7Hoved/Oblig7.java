import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/** Hovedprogrammet */
public class Oblig7 {

  /** Konstruktoer */
  public static void main(String[] args) {
    // Variabel for labyrint
    Labyrint labyrint;

    // Sjekk om riktig bruk av program
    if (args.length != 1) {
      System.out.println("Bruk: java Oblig7 <filnavn>");
      return;
    }

    // Les inn labyrint fra fil
    try {
      File fil = new File(args[0]);
      labyrint = new Labyrint(fil);
    } catch (FileNotFoundException e) {
      System.err.println("Filen ble ikke funnet: " + e.getMessage());
      return;
    }

    // Print labyrinten og beskrivelse av programmet
    System.out.println();
    printUsage(
        labyrint.getAntRader(),
        labyrint.getAntKolonner(),
        labyrint.getAntHvite(),
        labyrint.getAntSorte(),
        labyrint.getAntAapninger());
    System.out.println(labyrint);

    // Kommandolokke
    Scanner scanner = new Scanner(System.in);
    while (true) {
      System.out.println("\n\033[1;33mStartkoordinater:\033[0m");
      System.out.print("> ");
      String input = scanner.nextLine().trim();

      // Avslutter løkken hvis brukeren skriver 'q'
      if (input.equals("q")) {
        break;
      }

      try {
        String[] koordinater = input.split(" ");
        int rad = Integer.parseInt(koordinater[0]);
        int kol = Integer.parseInt(koordinater[1]);

        System.out.println("\n\033[1;32mAapninger:\033[0m");
        labyrint.finnUtveiFra(rad, kol);
      } catch (Exception e) {
        System.out.println(
            "\033[0;31mUgyldig input!\033[0m Oppgi startkoordinatene (<rad> <kolonne>), eller 'q'"
                + " for aa avslutte.");
      }
    }
  }

  /** Print forklaring bruke programmet */
  private static void printUsage(
      int antRader, int antKolonner, int antHvite, int antSorte, int antAapninger) {
    System.out.println("\033[1mFredrik's labyrintloeser!\033[0m");
    System.out.println("Labyrinten har " + antRader + " og " + antKolonner + " kolonner.");
    System.out.println(
        "Det er "
            + antHvite
            + " hvite ruter, "
            + antSorte
            + " sorte ruter og "
            + antAapninger
            + " aapninger i labyrinten.");
    System.out.println(
        "For å finne loesninger, oppgi startkoordinater (<rad> <kolonne>) og trykk enter.");
    System.out.println("For å avslutte, skriv 'q' og trykk enter.");
  }
}
