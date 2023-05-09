// Klasse Hovedprogram
public class Hovedprogram {
  public static void main(String[] args) {
    int antRader = 50;
    int antKolonner = 50;
    Verden verden = new Verden(antRader, antKolonner);
    View view = new View(verden);
    Controller controller = new Controller(verden, view);
  }
}
