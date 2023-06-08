class IndeksertListe<E> extends Lenkeliste<E> {

  // Sett inn element paa indeks x i listen
  public void leggTil(int pos, E x) {
    if (pos < 0 || pos > stoerrelse()) {
        throw new UgyldigListeindeks(pos);
    }
    Node ny = new Node(x);

    // Hvis indeks er null (starten av listen)
    if (pos == 0) {
      leggTilPaaStart(x);
    }

    // Hvis indeks er bakerst i listen
    else if (pos == stoerrelse()) {
      leggTil(x);
    }

    // Ellers
    else {
      Node n = start;
      for (int i=0; i<pos-1; i++) {
        n = n.neste;
      }
      ny.neste = n.neste;
      n.neste = ny;
      iBruk++;
    }
  }

  // Erstatt element paa indeks pos med x
  public void sett(int pos, E x) {
    if (pos < 0 || pos >= stoerrelse()) {
        throw new UgyldigListeindeks(pos);
    }
    Node n = start;
    for (int i = 0; i < pos; i++) {
      n = n.neste;
    }
    n.data = x;
  }

  // Returner element paa indeks pos (ikke fjern element)
  public E hent(int pos) {
    if (pos < 0 || pos >= stoerrelse()) {
        throw new UgyldigListeindeks(pos);
    }
    Node n = start;
    for (int i = 0; i < pos; i++) {
      n = n.neste;
    }
    return n.data;

  }

  // Returner element paa indeks pos (fjern element)
  public E fjern(int pos) {
    if (pos < 0 || pos >= stoerrelse()) {
        throw new UgyldigListeindeks(pos);
    }
    E svar;

    // Hvis fjerning av forste element
    if (pos == 0) {
      svar = start.data;
      start = start.neste;
    }

    // Hvis fjerning av siste element
    else if (pos == stoerrelse() - 1) {
      Node n = start;
      while (n.neste != slutt) {
        n = n.neste;
      }
      svar = slutt.data;
      slutt = n;
      slutt.neste = null;
    }

    // Ellers
    else {
      Node n = start;
      for (int i = 0; i < pos; i++) {
        n = n.neste;
      }
      svar = n.neste.data;
      n.neste = n.neste.neste;
    }

    iBruk--;
    return svar;
  }
}
