public class MinesweeperController {
  private MinesweeperModel model;
  private MinesweeperView view;

  private int antallPoeng = 0;
  public boolean erFerdig = false;

  public MinesweeperController(int antRader, int antKolonner) {
    model = new MinesweeperModel(antRader, antKolonner); // håndterer data
    model.lagRutenett();

    view = new MinesweeperView(this, antRader, antKolonner); // GUI, det visuelle
  }

  public int hentAntallPoeng() {
    return antallPoeng;
  }

  public void leggTilPoeng(int poeng) {
    antallPoeng += poeng;
    view.oppdaterPoeng();
  }

  public int antallBomber() {
    return model.antallBomber();
  }

  public int[][] hentRutenett() {
    return model.hentRutenett();
  }
}
