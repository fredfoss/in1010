// Klasse Controller
public class Controller {
  private Verden verden;
  private View view;

  // Konstruktor
  public Controller(Verden verden, View view) {
    this.verden = verden;
    this.view = view;
    view.setVisible(true);
  }
}
