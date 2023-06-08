import java.util.ArrayList;
import java.util.List;

public class Hovedprogram {
  public static void main(String[] args) {
    List<Thread> traader = new ArrayList<>();

    for (int i = 0; i < 5; i++) {
      Thread traad = new Thread(new HeiTraad(i));
      traader.add(traad);
      traad.start();
    }

    for (Thread traad : traader) {
      try {
        traad.join(); // Vent til tråden er ferdig
      } catch (InterruptedException e) {
        System.out.println("Ble avbrutt");
      }
    }
    // Her har alle trådene blitt ferdige -> fortsetter main

    System.out.println("Trådene er ferdige!");
  }
}
