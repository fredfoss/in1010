import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public class Controller {
  private static Verden verden;
  private static View view;
  private static Timer timer;

  // Starter spillet
  public static void startSpill() {
    verden = new Verden(20, 20);
    view = new View(verden.rutenett);

    // Oppdaterer rutenettet hvert 1000ms
    timer =
        new Timer(
            1000,
            new ActionListener() {
              public void actionPerformed(ActionEvent evt) {
                verden.oppdatering();
                view.repaint();
              }
            });
    timer.start();
  }

  // Stopper spillet
  public static void stopSpill() {
    timer.stop();
  }
}
