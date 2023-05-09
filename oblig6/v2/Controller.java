/** Controller */
public class Controller {

  View view;
  Verden verden; // TODO: Model extends Verden

  Controller() {
    view = new View(this);
    verden = new Verden();
  }

  // Start game
  void startGame() {}

  // Stop game
  void exitGame() {
    System.exit(0);
  }

  //
  void userChoice() {}
}
public View getView() {
	return view;
}

public int getTidsIntervall() {
	return tidsIntervall;
}


