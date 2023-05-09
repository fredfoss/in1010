// Klasse Controller
public class Controller {
  Verden verden;

  // Konstruktor
  public Controller(Verden verden) {
    this.verden = verden;
  }

  // Oppdaterer verden
  public void oppdater() {
    verden.oppdatering();
  }
}
