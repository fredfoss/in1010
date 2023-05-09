import java.util.Scanner;

public class GameOfLife {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.println("Antall rader:");
    int antRader = scanner.nextInt();

    System.out.println("Antall kolonner");
    int antKolonner = scanner.nextInt();

    Rutenett rutenett = new Rutenett(antRader, antKolonner);
    rutenett.fyllMedTilfeldigeCeller();
    rutenett.kobleAlleCeller();

    GameOfLifeGUI gui = new GameOfLifeGUI(rutenett);
    Verden verden = new Verden(antRader, antKolonner);
    GameOfLifeController controller = new GameOfLifeController(verden, gui);

    controller.start();
  }
}
