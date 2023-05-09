import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;

// Klasse View
public class View extends JPanel {
  Verden verden;
  int ruteStorrelse = 10;

  // Konstruktor
  public View(Verden verden) {
    this.verden = verden;
    setPreferredSize(
        new Dimension(verden.antKolonner * ruteStorrelse, verden.antRader * ruteStorrelse));
  }

  // Tegner rutenettet
  public void paintComponent(Graphics g) {
    super.paintComponent(g);

    for (int i = 0; i < verden.antRader; i++) {
      for (int j = 0; j < verden.antKolonner; j++) {
        Celle celle = verden.rutenett.hentCelle(i, j);
        if (celle.erLevende()) {
          g.setColor(Color.BLACK);
        } else {
          g.setColor(Color.WHITE);
        }
        g.fillRect(j * ruteStorrelse, i * ruteStorrelse, ruteStorrelse, ruteStorrelse);
      }
    }
  }

  // Oppdaterer rutenettet
  public void oppdater() {
    repaint();
  }
}
