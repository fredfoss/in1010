import javax.swing.JFrame;

// Klasse Main
public class Main {
  public static void main(String[] args) {
    // Oppretter et nytt vindu
    JFrame vindu = new JFrame("Game of Life");
    vindu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // Oppretter en ny verden og viser den i vinduet
    Verden verden = new Verden(50, 50);
    View view = new View(verden);
    vindu.getContentPane().add(view);

    // Viser vinduet
    vindu.pack();
    vindu.setVisible(true);

    // Oppdaterer verden i en evig loop
    while (true) {
      verden.oppdatering();
      view.oppdater();
      try {
        Thread.sleep(100);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}
