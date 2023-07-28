// Klasse Rutenett
public class Rutenett {
  int antRader;
  int antKolonner;
  Celle[][] rutene;

  // Konstruktor
  public Rutenett(int antRader, int antKolonner) {
    this.antRader = antRader;
    this.antKolonner = antKolonner;
    rutene = new Celle[antRader][antKolonner];
  }

  // Lager celle og legger til i rutenettet
  public void lagCelle(int rad, int kolonne) {
    Celle celle = new Celle();

    // 1/3 sjanse for at cellen lever
    if (Math.random() <= 0.333) {
      celle.settLevende();
    }

    rutene[rad][kolonne] = celle;
  }

  // Legg til tilfeldige celler i rutenettet
  public void fyllMedTilfeldigeCeller() {
    for (int i = 0; i < antRader; i++) {
      for (int j = 0; j < antKolonner; j++) {
        lagCelle(i, j);
      }
    }
  }

  // Returner en celle hvis koordinatene gitt finnes
  public Celle hentCelle(int rad, int kolonne) {
    if ((rad > -1 && rad < antRader) &&
        (kolonne > -1 && kolonne < antKolonner)) {
      Celle celle = rutene[rad][kolonne];
      return celle;
    } else {
      return null;
    }
  }

  // Skriver ut rutenettet til terminal
  public void tegnRutenett() {

    for (int i = 0; i < antRader; i++) {
      System.out.print("+---");
    }

    System.out.println("+");
    for (int i = 0; i < antRader; i++) {
      System.out.print("| ");
      for (int j = 0; j < antKolonner; j++) {
        Celle myBroCelle = rutene[i][j];
        System.out.print(myBroCelle.hentStatusTegn());
        System.out.print(" | ");
      }

      System.out.println();
      for (int k = 0; k < antRader; k++) {
        System.out.print("+---");
      }

      System.out.println("+");
    }
  }

  // Sett alle naboene til en celle
  public void settNaboer(int rad, int kolonne) {
    Celle celle = rutene[rad][kolonne];
    for (int i = -1; i < 2; i++) {
      for (int j = -1; j < 2; j++) {
        if (i != 0 || j != 0) {
          Celle nabocelle = hentCelle(rad + i, kolonne + j);
          if (nabocelle != null) {
            celle.leggTilNabo(nabocelle);
          }
        }
      }
    }
  }

  // Setter alle naboer til alle celler
  public void kobleAlleCeller() {
    for (int i = 0; i < antRader; i++) {
      for (int j = 0; j < antKolonner; j++) {
        settNaboer(i, j);
      }
    }
  }

  // Returner antall levende celler
  public int antallLevende() {
    int antLevendeCeller = 0;
    for (int i = 0; i < antRader; i++) {
      for (int j = 0; j < antKolonner; j++) {
        Celle celle = rutene[i][j];
        if (celle.erLevende()) {
          antLevendeCeller++;
        }
      }
    }

    return antLevendeCeller;
  }
}
