import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/** Testprogram: finn subsekvensen med flest forekomster blant alle filer i oppgitt mappe */
public class Oblig5Del1 {

  /** Kjør programmet */
  public static void main(String[] args) {
    if (args.length != 1) {
      System.err.println("Bruk: java Oblig5Del1 <mappe med datafiler>");
      System.exit(1);
    }

    String dataMappe = args[0];
    ArrayList<HashMap<String, Subsekvens>> hashMapListe = new ArrayList<>();

    // Les inn alle filene og lag en hashMap for hver
    try (Scanner scanner = new Scanner(new File(dataMappe, "metadata.csv"))) {
      while (scanner.hasNextLine()) {
        String filnavn = scanner.nextLine().trim();
        HashMap<String, Subsekvens> hashMap =
            SubsekvensRegister.lesFil(new File(dataMappe, filnavn).getPath());
        hashMapListe.add(hashMap);
      }
    } catch (FileNotFoundException e) {
      e.printStackTrace();
      System.exit(1);
    }

    // Flett hashMap-ene sammen til én
    while (hashMapListe.size() > 1) {
      HashMap<String, Subsekvens> hashMap1 = hashMapListe.remove(0);
      HashMap<String, Subsekvens> hashMap2 = hashMapListe.remove(0);
      HashMap<String, Subsekvens> nyHashMap = SubsekvensRegister.flettHashMap(hashMap1, hashMap2);
      hashMapListe.add(nyHashMap);
    }

    // Finn subsekvensen med flest forekomster
    HashMap<String, Subsekvens> sisteHashMap = hashMapListe.get(0);
    Subsekvens mestFrekvente = null;
    for (Subsekvens subsekvens : sisteHashMap.values()) {
      if (mestFrekvente == null || subsekvens.getAntall() > mestFrekvente.getAntall()) {
        mestFrekvente = subsekvens;
      }
    }

    System.out.println("Mest frekvente subsekvens: " + mestFrekvente);
  }
}
