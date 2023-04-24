public class CafeHovedprogram {
  public static void main(String[] args) {
    Cafe cafe = new Cafe();
    Thread barista = new Thread(new Barista(cafe, 0));
    Thread kunde = new Thread(new Kunde(cafe, 1));

    barista.start();
    kunde.start();

    try {
      barista.join();
      // kunde.join();
    } catch (InterruptedException e) {
      System.out.println("Avbrutt");
    }
    // Etter join() - trådene er ferdig, main fortsetter

    // Barista er ferdig
    System.out.println("Barista ferdig");

    // Stenger cafeen - alle kunde som venter "må gå", signaliseres å fortsette
    cafe.steng();

    System.out.println("\nCafeen er stengt");
  }
}
