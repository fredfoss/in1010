import java.awt.*;
import java.awt.event.*;
import javax.swing.Timer;

public class GameOfLifeController {

  private final Verden verden;
  private final GameOfLifeGUI gui;
  private Timer timer;

  public GameOfLifeController(Verden verden, GameOfLifeGUI gui) {
    this.verden = verden;
    this.gui = gui;

    // Oppsett av timer for oppdatering av spillet
    timer =
        new Timer(
            2000,
            new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent e) {
                verden.oppdatering();
                gui.oppdater();
              }
            });
  }

  public void start() {
    timer.start();
  }

  public void stop() {
    timer.stop();
  }

  public void reset() {
    // Reset spillet
  }
}
