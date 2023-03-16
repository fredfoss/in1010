public class Stabel<E> extends Lenkeliste<E> {
  // Legg til nytt element forrerst i listen
  @Override
  public void leggTil(E x) {
    Node ny = new Node(x);
    // Hvis liste ikke er tom
    if (stoerrelse() > 0) {
      ny.neste = start;
      start = ny;
    }
    // Hvis liste tom
    else {
      start = ny;
      slutt = ny;
    }
    iBruk++;
  }
}
