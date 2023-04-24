import java.util.Scanner;

class Klokke {
  public static void main(String[] args) {
    Scanner minInn = new Scanner(System.in);
    Runnable kjor = new KlokkeKjorer();
    Thread traden = new Thread(kjor);
    System.out.println(" Stoppeklokke ");
    System.out.println(" Tast CR for å stoppe og starte");
    minInn.nextLine();
    traden.start();
    minInn.nextLine();
    traden.interrupt();
    System.out.println(" Takk for naa ");
  }
}
