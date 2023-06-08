import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/** Hovedprogrammet */
public class Labyrintloeser {

  /** Main */
  public static void main(String[] args) {

    // Variabel for labyrint
    File fil;
    Labyrint labyrint;

    // Sjekk om riktig bruk av program
    if (args.length != 1) {
      System.out.println("Bruk: java Labyrintloeser <filnavn>");
      return;
    }

    // Les inn labyrint fra fil
    try {
      fil = new File(args[0]);
      labyrint = new Labyrint(fil);
    } catch (FileNotFoundException e) {
      System.err.println("Filen ble ikke funnet: " + e.getMessage());
      return;
    }

    // Print labyrinten og beskrivelse av programmet
    System.out.println();
    printUsage(labyrint.getAntRader(), labyrint.getAntKolonner(),
               labyrint.getAntHvite(), labyrint.getAntSorte(),
               labyrint.getAntAapninger());
    System.out.println(labyrint);

    // Kommandolokke
    Scanner scanner = new Scanner(System.in);
    while (true) {

      // Ny instans av labyrint
      try {
        labyrint = new Labyrint(fil);
      } catch (FileNotFoundException e) {
        System.err.println("Filen ble ikke funnet: " + e.getMessage());
        return;
      }

      System.out.println("\n\033[1mStartkoordinater:\033[0m");
      System.out.print("> ");
      String input = scanner.nextLine().trim();

      // Avslutter loekken hvis brukeren skriver 'q'
      if (input.equals("q")) {
        break;
      }

      try {
        // Leser brukerinput
        String[] koordinater = input.split(" ");
        int rad = Integer.parseInt(koordinater[0]);
        int kol = Integer.parseInt(koordinater[1]);

        // Raskest utvei
        ArrayList<ArrayList<Rute>> utveier = labyrint.finnUtveiFra(rad, kol);

        ArrayList<Rute> raskestUtvei;
        if (utveier.size() > 0) {
          raskestUtvei = utveier.get(0);
          for (ArrayList<Rute> utvei : utveier) {
            if (utvei.size() < raskestUtvei.size()) {
              raskestUtvei = utvei;
            }
          }

          for (Rute rute : raskestUtvei) {
            rute.setIRaskestVei();
          }

          System.out.println(labyrint);
        }
      } catch (Exception e) {
        System.out.println(
            "\033[0;31mUgyldig input!\033[0m Oppgi startkoordinatene (<rad> <kolonne>), eller 'q'"
            + " for aa avslutte.");
      }
    }
  }

  /** Print forklaring bruke programmet */
  private static void printUsage(int antRader, int antKolonner, int antHvite,
                                 int antSorte, int antAapninger) {
    System.out.println("\033[1mFredrik's labyrintloeser!\033[0m");
    System.out.println("Labyrinten har " + antRader + " rader og " +
                       antKolonner + " kolonner.");
    System.out.println("Det er " + antHvite + " hvite ruter, " + antSorte +
                       " sorte ruter og " + antAapninger +
                       " aapninger i labyrinten.");
    System.out.println(
        "For aa finne raskeste vei ut, oppgi startkoordinater (<rad> <kolonne>) og trykk enter.");
    System.out.println("For aa avslutte, skriv 'q' og trykk enter.");
  }
}
