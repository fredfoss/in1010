import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Hovedklassen for Oblig5Del2A. Leser inn subsekvenser fra filer, fletter dem sammen og finner den
 * mest frekvente subsekvensen.
 */
public class Oblig5Del2A {

  public static void main(String[] args) {
    if (args.length != 1) {
      System.err.println("Bruk: java Oblig5Del1 <mappe med datafiler>");
      System.exit(1);
    }

    // Variabler
    String dataMappe = args[0];
    ArrayList<Thread> trader = new ArrayList<>();
    Monitor monitor = new Monitor(); // Opprett et Monitor-objekt

    // Start en trad for hver fil
    try (Scanner scanner = new Scanner(new File(dataMappe, "metadata.csv"))) {
      while (scanner.hasNextLine()) {
        String filnavn = scanner.nextLine().trim();
        LeseTrad leseTrad = new LeseTrad(new File(dataMappe, filnavn).getPath(), monitor);
        Thread trad = new Thread(leseTrad);
        trad.start();
        trader.add(trad);
      }
    } catch (FileNotFoundException e) {
      e.printStackTrace();
      System.exit(1);
    }

    // Vent på at alle trådene er ferdige
    for (Thread trad : trader) {
      try {
        trad.join();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }

    // Flett hashMap-ene sammen til én
    while (monitor.antallHashMaps() > 1) {
      HashMap<String, Subsekvens> hashMap1 = monitor.taUtHashMap();
      HashMap<String, Subsekvens> hashMap2 = monitor.taUtHashMap();
      HashMap<String, Subsekvens> nyHashMap = monitor.flettHashMap(hashMap1, hashMap2);
      monitor.leggTilHashMap(nyHashMap);
    }

    // Finn subsekvensen med flest forekomster
    HashMap<String, Subsekvens> sisteHashMap = monitor.taUtHashMap();
    Subsekvens mestFrekvente = null;
    for (Subsekvens subsekvens : sisteHashMap.values()) {
      if (mestFrekvente == null || subsekvens.getAntall() > mestFrekvente.getAntall()) {
        mestFrekvente = subsekvens;
      }
    }

    System.out.println("Mest frekvente subsekvens: " + mestFrekvente);
  }
}
