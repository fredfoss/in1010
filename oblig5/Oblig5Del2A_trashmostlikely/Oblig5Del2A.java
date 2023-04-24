import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/** Testprogram: finn subsekvensen med flest forekomster blant alle filer i oppgitt mappe */
public class Oblig5Del2A {

  /** Kjør programmet */
  public static void main(String[] args) {
    if (args.length != 1) {
      System.err.println("Bruk: java Oblig5Del2A <mappe med datafiler>");
      System.exit(1);
    }

    String dataMappe = args[0];
    ArrayList<Thread> tråder = new ArrayList<>();
    Monitor1 monitor = new Monitor1();

    // Les inn alle filene og lag en hashMap for hver
    try (Scanner scanner = new Scanner(new File(dataMappe, "metadata.csv"))) {
      while (scanner.hasNextLine()) {
        String filnavn = scanner.nextLine().trim();
        SubsekvensLeser lesTråd =
            new SubsekvensLeser(monitor, new File(dataMappe, filnavn).getPath());
        Thread tråd = new Thread(lesTråd);
        tråder.add(tråd);
        tråd.start();
      }
    } catch (FileNotFoundException e) {
      e.printStackTrace();
      System.exit(1);
    }

    // Vent på at alle trådene er ferdige
    for (Thread tråd : tråder) {
      try {
        tråd.join();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }

    // Flett hashMap-ene sammen til én
    while (monitor.antallHashMaps() > 1) {
      HashMap<String, Subsekvens> hashMap1 = monitor.taUtHashMap();
      HashMap<String, Subsekvens> hashMap2 = monitor.taUtHashMap();
      HashMap<String, Subsekvens> nyHashMap = SubsekvensRegister.flettHashMap(hashMap1, hashMap2);
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
