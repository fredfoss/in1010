import java.util.ArrayList;

public class SortRute extends Rute {

  /** Konstruktoer */
  public SortRute(Labyrint labyrint, int rad, int kolonne) {
    super(labyrint, rad, kolonne);
  }

  /** Finn-metoden */
  @Override
  public void finn(Rute fra, ArrayList<Rute> sti) {
    if (fra == null) {
      System.out.println("\033[0;31mOps!\033[0m Kan ikke starte i sort rute.");
    }
  }

  @Override
  public String toString() {
    return "\033[38;5;242m" + "#" + "\033[0m";
  }
}
