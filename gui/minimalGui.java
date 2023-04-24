/* Importer klasser */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Mini {
  public static void main(String[] args) {

    /* Angi standard Swing-utseendet */
    try {
      UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
    } catch (Exception e) {
      System.exit(1);
    }

    /* Deklarer vindu (JFrame) og initier stopp-knapp */
    JFrame window = new JFrame("Xxx");
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    /* Opprett tegneplate (JPanel) */
    JPanel panel = new JPanel();
    window.add(panel);

    /* Gjør vindu synlig */
    window.pack();
    window.setLocationRelativeTo(null);
    window.setVisible(true);
  }
}
