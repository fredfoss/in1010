public class Prioritetskoe<E extends Comparable<E>> extends Lenkeliste<E> {

  @Override
  public void leggTil(E x) {
    Node ny = new Node(x);

    // Hvis listen er tom eller x er minst av elementene i listen
    if (stoerrelse() == 0 || x.compareTo(start.data) <= 0) {
      leggTilPaaStart(x);
    }

    // Hvis x større eller lik det største i listen
    else if (x.compareTo(slutt.data) >= 0) {
      super.leggTil(x);
    }

    // Ellers
    else {
      Node naaverende = start;
      Node forrige = null;

      // Finn riktig posisjon for nytt element
      while (naaverende != null && x.compareTo(naaverende.data) > 0) {
        forrige = naaverende;
        naaverende = naaverende.neste;
      }

      // Sett inn nytt element
      forrige.neste = ny;
      ny.neste = naaverende;
      iBruk++;
    }
  }
}
