class KlokkeKjorer implements Runnable {
  public void run() {
    int klokke = 0;
    try {
      while (true) {
        Thread.sleep(1000);
        System.out.println(klokke);
        klokke++;
      }
    } catch (InterruptedException i) {
      System.out.println(" Klokka er ferdig");
    }
  }
}
