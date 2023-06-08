import java.util.Scanner;

// Klasse GameOfLife
public class GameOfLife {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.println("Antall rader:");
    int antRader = scanner.nextInt();

    System.out.println("Antall kolonner");
    int antKolonner = scanner.nextInt();

    Verden verden = new Verden(antRader, antKolonner);
    verden.tegn();

    boolean fortsette = true;
    while (fortsette) {
      System.out.println("Fortsette? ['enter'/n]:");
      String input = scanner.nextLine();

      if (input == "") {
        verden.oppdatering();
        verden.tegn();
      } else {
        fortsette = false;
      }
    }
  }
}
