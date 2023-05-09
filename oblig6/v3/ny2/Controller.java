import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Klasse Controller
public class Controller {
  private Verden verden;
  private View view;
  private Timer timer;

  // Konstruktor
  public Controller(Verden verden, View view) {
    this.verden = verden;
    this.view = view;
    view.setVisible(true);
    view.setStartStoppTekst("Start");
    view.oppdaterRutenett();
  }

  // Metode for å håndtere klikk på en celle
  public void celleKlikket(int rad, int kolonne) {
    Celle celle = verden.rutenett.hentCelle(rad, kolonne);
    celle.setLevende(!celle.erLevende());
    view.oppdaterRutenett();
  }

  // Metode for å starte/stoppet spillet
  public void startStoppSpill() {
    if (timer == null) {
      timer =
          new Timer(
              100,
              new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                  verden.oppdatering();
                  view.oppdaterRutenett();
                }
              });
      timer.start();
      view.setStartStoppTekst("Stopp");
    } else {
      timer.stop();
      timer = null;
      view.setStartStoppTekst("Start");
    }
  }

  // Metode for å avslutte programmet
  public void avsluttSpill() {
    System.exit(0);
  }
}
