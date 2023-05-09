public class GameOfLifeController {
  private GameOfLifeModel model;
  private GameOfLifeView view;

  public GameOfLifeController() {
    model = new GameOfLifeModel(10, 10);
    view = new GameOfLifeView(model);
  }

  public static void main(String[] args) {
    GameOfLifeController controller = new GameOfLifeController();
  }
}
