import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * En enkel beholder som kan ta vare paa mange av HashMapene som subsekvensene lagres i, av typen
 * HashMap<String,Subsekvens>
 */
public class SubsekvensRegister {

  private ArrayList<HashMap<String, Subsekvens>> hashBeholder;

  /** Opprett en beholder */
  public SubsekvensRegister() {
    hashBeholder = new ArrayList<>();
  }

  /** Legg en hashMap (alle subsekvensene til én person) til i beholder */
  public void settInnHashMap(HashMap<String, Subsekvens> hashMap) {
    hashBeholder.add(hashMap);
  }

  /** Returner og fjern hashMap fra beholder */
  public HashMap<String, Subsekvens> taUtHashMap() {
    if (hashBeholder.isEmpty()) {
      return null;
    }
    return hashBeholder.remove(0);
  }

  /** Returner antall hashMaps i beholder */
  public int antallHashMaps() {
    return hashBeholder.size();
  }

  /** Les fil med substrenger (én persons blodprøve) og lag og returner hashMap */
  public static HashMap<String, Subsekvens> lagHashMap(String filnavn) {

    HashMap<String, Subsekvens> hashMap = new HashMap<>();

    try {
      Scanner scanner = new Scanner(new File(filnavn));
      while (scanner.hasNextLine()) {
        String linje = scanner.nextLine();
        if (linje.length() < 3) {
          System.err.println("Linje for kort: " + linje);
          System.exit(1);
        }
        for (int i = 0; i <= linje.length() - 3; i++) {
          String subsekvens = linje.substring(i, i + 3);
          if (!hashMap.containsKey(subsekvens)) {
            hashMap.put(subsekvens, new Subsekvens(subsekvens, 1));
          }
        }
      }
    } catch (FileNotFoundException e) {
      System.err.println("Filen ble ikke funnet: " + e.getMessage());
      System.exit(1);
    }
    return hashMap;
  }

  /** Slaa sammen og returner to hashMaps */
  public static HashMap<String, Subsekvens> flettHashMap(
      HashMap<String, Subsekvens> hashMap1, HashMap<String, Subsekvens> hashMap2) {

    HashMap<String, Subsekvens> nyHashMap = new HashMap<>();

    // Itererer gjennom subsekvensene i hashMap1, og legger til i ny hashMap
    for (String subsekvens : hashMap1.keySet()) {
      Subsekvens ss1 = hashMap1.get(subsekvens);
      Subsekvens ss2 = hashMap2.get(subsekvens);

      if (ss2 == null) {
        nyHashMap.put(subsekvens, new Subsekvens(subsekvens, ss1.getAntall()));
      } else {
        nyHashMap.put(subsekvens, new Subsekvens(subsekvens, ss1.getAntall() + ss2.getAntall()));
      }
    }

    // Itererer gjennom subsekvensene i hashMap2, og legger de resterende hashMapene til i nyHashMap
    for (String subsekvens : hashMap2.keySet()) {
      if (!hashMap1.containsKey(subsekvens)) {
        Subsekvens ss2 = hashMap2.get(subsekvens);
        nyHashMap.put(subsekvens, new Subsekvens(subsekvens, ss2.getAntall()));
      }
    }
    return nyHashMap;
  }
}
