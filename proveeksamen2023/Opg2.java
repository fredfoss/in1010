class Hund implements Comparable<Hund> {
  String navn;
  Kull mittKull;
  Tidspunkt minFodselstid;
  Hund neste = null;

  Hund(Kull k, String n, Tidspunkt fodt) {
    navn = n;
    mittKull = k;
    minFodselstid = fodt;
  }

  public Hund mor() {
    if (mittKull.mor != null) {
      for (Hund h : mittKull.mor.mittKull) {
        if (h == this) {
          return mittkull.mor;
        }
      }
    }
    return null;
  }

  public Hund far() {
    if (mittKull.far != null) {
      for (Hund h : mittKull.far.mittKull) {
        if (h == this) {
          return mittkull.far;
        }
      }
    }
    return null;
  }

  @Override
  public int compareTo(Hund h) {
    return minFodselstid.compareTo(h.minFodselstid);
  }

  public boolean erHelsosken(Hund h) {
    minFar = far();
    minMor = mor();
    annenFar = h.far();
    annenMor = h.mor();

    return minFar == annenFar && minMor == annenMor;
  }

  public boolean erHalvsosken(Hund h) {
    minFar = far();
    minMor = mor();
    annenFar = h.far();
    annenMor = h.mor();

    return minFar == annenFar || minMor == annenMor;
  }

  public Hund finnEldsteKjenteOpphav() {
    // Oppgave 2d
  }
}

abstract class Kull implements Iterable<Hund> {
  Hund mor;
  Hund far;

  Kull(Hund mor, Hund far) {
    this.mor = mor;
    this.far = far;
  }

  public void skrivUtAlle() {
    for (Hund h : this) {
      System.out.println(" " + h);
    }
  }

  public abstract void settInn(Hund h);

  public abstract Iterator<Hund> iterator();
}
