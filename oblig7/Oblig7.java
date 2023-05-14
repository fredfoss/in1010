import java.io.File;
import java.io.FileNotFoundException;

/** Hovedprogram */
public class Oblig7 {

  /** Konstruktoer */
  public static void main(String[] args) {

    // Variabler
    File fil;
    Labyrint labyrint;

    // Leser inn fil
    try {
      fil = new File(args[0]);

    } catch (FileNotFoundException e) {
      System.out.println("Fant ikke filen!");
    }
  }
}
