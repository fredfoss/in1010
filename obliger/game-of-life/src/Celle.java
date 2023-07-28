// Klasse Celle
public class Celle {
  boolean levende;
  Celle[] naboer = new Celle[8];
  int antNaboer = 0;
  int antLevendeNaboer = 0;

  // Konstruktor
  public Celle() { levende = false; }

  // Sett status til død
  public void settDoed() { levende = false; }

  // Sett status til død
  public void settLevende() { levende = true; }

  // Sjekk om celle lever
  public boolean erLevende() { return levende; }

  // Hent status-tegn
  public char hentStatusTegn() {
    if (levende) {
      return 'O';
    } else {
      return '.';
    }
  }

  // Legg til nabocelle
  public void leggTilNabo(Celle celle) {
    boolean lagtTil = false;
    for (int i = 0; i < 8; i++) {
      if (!lagtTil && naboer[i] == null) {
        naboer[i] = celle;
        antNaboer++;
        lagtTil = true;
      }
    }
  }

  // Tell antall levende naboceller
  public void tellLevendeNaboer() {
    int teller = 0;
    for (Celle i : naboer) {
      if (i != null) {
        if (i.erLevende()) {
          teller++;
        }
      }
    }
    antLevendeNaboer = teller;
  }

  // Oppdater cellens status
  public void oppdaterStatus() {
    if (antLevendeNaboer == 3) {
      levende = true;
    } else if (antLevendeNaboer != 2) {
      levende = false;
    }
  }
}
