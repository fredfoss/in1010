abstract class Lenkeliste<E> implements Liste<E> {

  // Antall elementer i listen
  protected int iBruk = 0;

  // Enkeltlenket liste med start og slutt
  protected class Node {
    Node neste = null;
    E data;
    Node(E x) {
      data = x;
    }
  }
  protected Node start = null;
  protected Node slutt = null;
  
  // Returner antall elementer i listen
  public int stoerrelse() {
    return iBruk;
  }

  // Legg til nytt element bakerst i listen
  public void leggTil(E x) {
    Node ny = new Node(x);
    
    // Hvis listen ikke er tom
    if (stoerrelse() != 0) {
      slutt.neste = ny;
      slutt = ny;
      iBruk++;
    }

    // Hvis listen er tom
    else {
      start = ny;
      slutt = ny;
      iBruk++;
    }
  }

  // Returner første element i listen (ikke fjern)
  public E hent() {
    if (stoerrelse() == 0) {
        throw new UgyldigListeindeks(-1);
    }
    E svar = null;
    if (start != null) {
      svar = start.data;
    }
    return svar;
  }

  // Fjern og returner første element i listen
  public E fjern() {
    if (stoerrelse() == 0) {
        throw new UgyldigListeindeks(-1);
    }
    E svar = null;
    if (start != null) {
      svar = start.data;
      start = start.neste;
      iBruk--;
    }
    return svar;
  }

  // Sett inn element paa starten
  public void leggTilPaaStart(E x) {
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

  // Returner string med alle elementene i listen
  public String toString() {
    String s = "[";
    Node current = start;
    while (current != null) {
      s += current.data;
      if (current.neste != null) {
        s += ", ";
      }
      current = current.neste;
    }
    s += "]";
    return s;
  }
}
