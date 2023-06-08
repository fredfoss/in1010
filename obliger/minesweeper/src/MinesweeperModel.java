import java.util.Random;

public class MinesweeperModel {
  private int rader, kolonner;
  private int[][] rutenett;
  private int antallBomber = 0;

  public MinesweeperModel(int antRader, int antKolonner) {
    rader = antRader;
    kolonner = antKolonner;

    rutenett = new int[rader][kolonner];
  }

  public int[][] hentRutenett() {
    return rutenett;
  }

  public int antallBomber() {
    return antallBomber;
  }

  public void lagRutenett() {
    Random rand = new Random();
    for (int rad = 0; rad < rader; rad++) {
      for (int kol = 0; kol < kolonner; kol++) {
        int verdi = rand.nextInt(9);
        rutenett[rad][kol] = verdi;

        if (verdi == 0) antallBomber++;
      }
    }
  }
}
