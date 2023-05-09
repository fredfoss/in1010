public class GameOfLifeModel {
  private Rutenett rutenett;

  public GameOfLifeModel(int antRader, int antKolonner) {
    rutenett = new Rutenett(antRader, antKolonner);
    rutenett.fyllMedTilfeldigeCeller();
    rutenett.kobleAlleCeller();
  }

  public void endreCelleStatus(int rad, int kolonne) {
    Celle celle = rutenett.hentCelle(rad, kolonne);
    if (celle.erLevende()) {
      celle.settDoed();
    } else {
      celle.settLevende();
    }
  }

  public void oppdaterRutenett() {
    for (int i = 0; i < rutenett.antRader; i++) {
      for (int j = 0; j < rutenett.antKolonner; j++) {
        Celle celle = rutenett.hentCelle(i, j);
        celle.tellLevendeNaboer();
      }
    }

    for (int i = 0; i < rutenett.antRader; i++) {
      for (int j = 0; j < rutenett.antKolonner; j++) {
        Celle celle = rutenett.hentCelle(i, j);
        celle.oppdaterStatus();
      }
    }
  }

  public Celle[][] getRutenett() {
    return rutenett.rutene;
  }

  public int getAntallLevende() {
    return rutenett.antallLevende();
  }
}
