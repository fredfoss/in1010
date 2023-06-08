public class HeiTraad implements Runnable {
  private int id;

  public HeiTraad(int id) {
    this.id = id;
  }

  @Override
  public void run() {
    System.out.println("Traad " + id + " - Hei!");
  }
}
