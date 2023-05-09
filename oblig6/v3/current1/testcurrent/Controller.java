// Klasse Controller
public class Controller {
  private Verden verden;
  private View view;

  // Konstruktor
  public Controller(int antRader, int antKolonner, int tidsintervall) {
    verden = new Verden(antRader, antKolonner);
    view = new View(verden, tidsintervall);
    view.setVisible(true);
  }
}
