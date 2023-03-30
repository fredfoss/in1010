import java.io.File;
import java.util.Scanner;

// Klasse som leser fil og printer ut i terminal
class LesFil {
  public static void main(String[] args) {
    Scanner f = null;
    try {
      f = new Scanner(new File("tall-til-10.txt"));
    } catch (Exception e) {
      System.out.println("Kan ikke lese filen tall-til-10.txt");
      System.exit(1);
    }

    // Les datafilen og skriv ut til terminal
    while (f.hasNextLine()) {
      System.out.println(f.nextLine());
    }
    f.close();
  }
}
